package dsi;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class TestDSIExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // load up the knowledge base
        KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
    	KieSession kSession = kContainer.newKieSession("ksession-rules-dsi");
    	
    	Person p1 = new Person("Toto", 21, 1.75);
    	Person p2 = new Person("Alfredo", 35, 1.80);
    	
    	kSession.insert(p1);
    	kSession.insert(p2);
    	
    	kSession.fireAllRules();

	}

}
