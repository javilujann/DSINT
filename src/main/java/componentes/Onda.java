package componentes;

public class Onda extends Componente {

	private float amplitud;

	public Onda(float amplitud, float inicio, float fin) {
		super(inicio, fin);
		this.amplitud = amplitud;
	}

	public float getAmplitud() {
		return amplitud;
	}

	public void setAmplitud(float amplitud) {
		this.amplitud = amplitud;
	}

}
