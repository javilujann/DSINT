package componentes;

import elem.Ciclo;

public class Onda extends Componente {
	
	private OndaTipo tipo;
	private float amplitud;
	private Ciclo ciclo;
	
	public Onda(float amplitud, float inicio, float fin, OndaTipo tipo) {
		super(inicio, fin);
		this.amplitud = amplitud;
		this.tipo = tipo;
	}

	public OndaTipo getTipo() {
		return tipo;
	}

	public void setTipo(OndaTipo tipo) {
		this.tipo = tipo;
	}

	public float getAmplitud() {
		return amplitud;
	}

	public void setAmplitud(float amplitud) {
		this.amplitud = amplitud;
	}

	public Ciclo getCiclo() {
		return ciclo;
	}

	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
	
}
