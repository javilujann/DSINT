package elem;

import java.util.Collection;

public class ECG {
	
	private Collection<Ciclo> ciclos;
	private int frecuenciaCardiaca;
	
	

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
		

	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	
	public float getFin() {
		return 0;
	}
	
}
