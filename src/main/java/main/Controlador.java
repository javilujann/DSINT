package main;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import componentes.*;
import diagnosticos.*;
import elem.*;
import patrones.*;

public enum Controlador {
	INSTANCE;
	
	// load up the knowledge base
    KieServices ks = KieServices.Factory.get();
    KieContainer kContainer = ks.getKieClasspathContainer();
	
	
	public List<Diagnostico> generarDiagnostico(List<Onda> ondas){
		
		
		// Creamos una sesion para este ECG
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		
		//Creamos el objeto ECG
		ECG ecg = new ECG();
		kSession.insert(ecg);
		
		// 1. Inicializa el contador global de IDs
		AtomicInteger cycleIdCounter = new AtomicInteger(1);
		kSession.setGlobal("cycleIdCounter", cycleIdCounter);
		
		// Primera fase: Calculo de ciclos + componentes + frecuencia		
	    ondas.forEach(kSession::insert);   // Añadimos la evidencia a la base de hehcos
	    
	    kSession.getAgenda().getAgendaGroup("Reglas_Ciclos").setFocus();
	    kSession.fireAllRules();
	    
	    kSession.getAgenda().getAgendaGroup("Reglas_Componentes").setFocus();
	    kSession.fireAllRules();
	     
// --- FASE 2: Lógica Difusa (Sustituye a Reglas_Patrones) ---
	    
	    // 1. Cargar fichero FCL
	    String filename = "src/main/resources/FuzzyLogic/ecg_analisis.fcl";
	    FIS fis = FIS.load(filename, true);
	    if(fis == null) {
	    	System.err.println("No se pudo cargar el archivo FCL: " + filename);
	    	return null;
	    }
	    FunctionBlock fb = fis.getFunctionBlock("analisis_ecg");

	    // 2. Obtener objetos de la memoria de trabajo de Drools
	    Collection<?> objects = kSession.getObjects();
	    
	    // A. Evaluar Frecuencia Cardiaca (Dato Global del ECG)
	    // Buscamos el objeto ECG actualizado por Drools
	    ECG ecgProcesado = objects.stream()
	    		.filter(o -> o instanceof ECG)
	    		.map(o -> (ECG)o)
	    		.findFirst().orElse(null);
	    
	    if(ecgProcesado != null && ecgProcesado.getFrecuenciaCardiaca() > 0) {
	    	// Ejecutar Fuzzy
	    	fb.setVariable("frecuencia", ecgProcesado.getFrecuenciaCardiaca());
	    	fis.evaluate();
	    	
	    	// Leer salidas e insertar Patrones
	    	double probBradicardia = fb.getVariable("prob_bradicardia").getValue();
	    	if(probBradicardia > 0.1) {
	    		kSession.insert(new FrecuenciaCardiacaBaja((float)probBradicardia, null));
	    	}
	    	
	    	double probTaquicardia = fb.getVariable("prob_taquicardia").getValue();
	    	if(probTaquicardia > 0.1) {
	    		kSession.insert(new FrecuenciaCardiacaAlta((float)probTaquicardia, null));
	    	}
	    }
	    
	    // B. Evaluar Componentes individuales (Iteramos sobre los objetos calculados)
	    
	    // -- Intervalos QT --
	    List<IntervaloQT> listaQT = objects.stream()
	    		.filter(o -> o instanceof IntervaloQT)
	    		.map(o -> (IntervaloQT)o)
	    		.collect(Collectors.toList());
	    
	    for(IntervaloQT qt : listaQT) {
	    	fb.setVariable("duracion_qt", qt.getDuracion());
	    	fis.evaluate();
	    	double prob = fb.getVariable("prob_qt_alargado").getValue();
	    	if(prob > 0.1) {
	    		kSession.insert(new IntervaloQtAlargado((float)prob, qt));
	    	}
	    }
	    
	    // -- Ondas T --
	    List<OndaT> listaT = objects.stream()
	    		.filter(o -> o instanceof OndaT)
	    		.map(o -> (OndaT)o)
	    		.collect(Collectors.toList());
	    
	    for(OndaT t : listaT) {
	    	fb.setVariable("amplitud_onda_t", t.getAmplitud()); // Asumiendo que OndaT tiene getAmplitud()
	    	fis.evaluate();
	    	
	    	if(fb.getVariable("prob_t_muy_aplanada").getValue() > 0.1)
	    		kSession.insert(new OndaTMuyAplanada((float)fb.getVariable("prob_t_muy_aplanada").getValue(), t));
	    		
	    	if(fb.getVariable("prob_t_aplanada").getValue() > 0.1)
	    		kSession.insert(new OndaTAplanada((float)fb.getVariable("prob_t_aplanada").getValue(), t));
	    		
	    	if(fb.getVariable("prob_t_hiperaguda").getValue() > 0.1)
	    		kSession.insert(new OndaTHiperaguda((float)fb.getVariable("prob_t_hiperaguda").getValue(), t));
	    }
	    
	    // -- Complejos QRS --
	    List<ComplejoQRS> listaQRS = objects.stream()
	    		.filter(o -> o instanceof ComplejoQRS)
	    		.map(o -> (ComplejoQRS)o)
	    		.collect(Collectors.toList());
	    
	    for(ComplejoQRS qrs : listaQRS) {
	    	fb.setVariable("duracion_qrs", qrs.getDuracion());
	    	fis.evaluate();
	    	double prob = fb.getVariable("prob_qrs_acortado").getValue();
	    	if(prob > 0.1) {
	    		kSession.insert(new ComplejoQrsAcortado((float)prob, qrs));
	    	}
	    }

	    // Tercera fase: Inferimos diagnosticos
	    kSession.getAgenda().getAgendaGroup("Reglas_Diagnosticos").setFocus();
	    kSession.fireAllRules();

	    // Recuperar resultados y limpiar
	    Collection<?> hechos = kSession.getObjects();
	    List<Diagnostico> diagnosticos = hechos.stream()
	        .filter(Diagnostico.class::isInstance)
	        .map(Diagnostico.class::cast)
	        .toList();
	    
		
	    kSession.dispose();
	    return diagnosticos;
	}
}
