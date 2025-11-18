package componentes;

import elem.Ciclo;

public class Onda extends Componente {

	private float amplitud;

	public Onda(float amplitud, float inicio, float fin, Ciclo ciclo) {
		super(inicio, fin, ciclo);
		this.amplitud = amplitud;
	}

	public float getAmplitud() {
		return amplitud;
	}

	public void setAmplitud(float amplitud) {
		this.amplitud = amplitud;
	}

}
