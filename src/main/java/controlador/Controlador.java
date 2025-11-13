package controlador;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import componentes.Onda;
import diagnosticos.Diagnostico;
import elem.ECG;

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
		
		// Primera fase: Calculo de componentes + frecuencia		
	    ondas.forEach(kSession::insert);   // Añadimos la evidencia a la base de hehcos
	    
	    kSession.getAgenda().getAgendaGroup("Reglas_Ciclos").setFocus();
	    kSession.fireAllRules();
	    
	    kSession.getAgenda().getAgendaGroup("Reglas_Componentes").setFocus();
	    kSession.fireAllRules();
	     
	    // Segunda fase: Inferir patrones patrologicos
	    kSession.getAgenda().getAgendaGroup("Reglas_Patrones").setFocus();
	    kSession.fireAllRules();

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
