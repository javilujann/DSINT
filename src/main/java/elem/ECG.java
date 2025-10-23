package elem;

import java.util.Collection;

public class ECG {
	
	private Collection<Ciclo> ciclos;
	
	

	public ECG(Collection<Ciclo> ciclos) {
		super();
		this.ciclos = ciclos;
	}

	public Collection<Ciclo> getCiclos() {
		return ciclos;
	}

	public void setCiclos(Collection<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}
	
	

}
