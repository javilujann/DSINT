package elem;

import java.util.LinkedList;
import java.util.List;

public class ECG {
	
	private List<Ciclo> ciclos;
	private int frecuenciaCardiaca;
	
	

	public ECG() {
		super();
		ciclos = new LinkedList<Ciclo>();
		frecuenciaCardiaca = 0;
	}

	public List<Ciclo> getCiclos() {
		return ciclos;
	}

	public void setCiclos(List<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}
	
	public void addCiclo(Ciclo ciclo) {
		ciclos.add(ciclo);
	}
		

	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	
	
	
}
