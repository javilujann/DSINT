package elem;

import java.util.List;
import componentes.Onda;

public class ECG {
	
	private List<Ciclo> ciclos;
	private int frecuenciaCardiaca;
	
	

	public ECG(List<Ciclo> ciclos) {
		super();
		this.ciclos = ciclos;
	}

	public List<Ciclo> getCiclos() {
		return ciclos;
	}

	public void setCiclos(List<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}
		

	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	
	public Float getFin() {
		return ciclos.get(ciclos.size() - 1).getOndas().stream().map(Onda::getFin).max(Float::compareTo).get();
	}
	
}
