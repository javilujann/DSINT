package patrones;

import componentes.Componente;
import diagnosticos.Diagnostico;

public class PatronPatologico {

	private float confianza;
	private Componente componenteAfectada;
	private Diagnostico sugiereDiagnostico;

	public PatronPatologico(float confianza, Componente componenteAfectada) {
		super();
		this.confianza = confianza;
		this.componenteAfectada = componenteAfectada;
	}

	public Componente getComponenteAfectada() {
		return componenteAfectada;
	}

	public void setComponenteAfectada(Componente componenteAfectada) {
		this.componenteAfectada = componenteAfectada;
	}

	public Diagnostico getSugiereDiagnostico() {
		return sugiereDiagnostico;
	}

	public void setSugiereDiagnostico(Diagnostico sugiereDiagnostico) {
		this.sugiereDiagnostico = sugiereDiagnostico;
	}

	public float getConfianza() {
		return confianza;
	}

	public void setConfianza(float confianza) {
		this.confianza = confianza;
	}

}
