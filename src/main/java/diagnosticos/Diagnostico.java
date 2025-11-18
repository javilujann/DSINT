package diagnosticos;

import patrones.PatronPatologico;

public class Diagnostico {

	private float confianza;
	private PatronPatologico evidencia;

	public Diagnostico(float confianza, PatronPatologico evidencia) {
		super();
		this.confianza = confianza;
		this.evidencia = evidencia;
	}

	public float getConfianza() {
		return confianza;
	}

	public void setConfianza(float confianza) {
		this.confianza = confianza;
	}

	public PatronPatologico getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(PatronPatologico evidencia) {
		this.evidencia = evidencia;
	}

}
