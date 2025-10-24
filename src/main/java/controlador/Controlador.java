package controlador;

import java.util.Collection;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import diagnosticos.Diagnostico;
import elem.Ciclo;
import elem.ECG;

public enum Controlador {
	INSTANCE;
	
	// load up the knowledge base
    KieServices ks = KieServices.Factory.get();
    KieContainer kContainer = ks.getKieClasspathContainer();
	KieSession kSession = kContainer.newKieSession("ksession-rules");
	
	public List<Diagnostico> generarDiagnostico(List<Ciclo> ciclos){
		
		//Creamos la instancia de ECG
		ECG ecg = new ECG(ciclos);
			    
		// Primera fase: Calculo de componentes + frecuencia
	    kSession.insert(ecg); 			
	    ciclos.forEach(kSession::insert);   // Añadimos la evidencia a la base de hehcos
	    
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
