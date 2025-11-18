package diagnosticos;



public class Diagnostico {
	
	private float confianza;
	private PatronPatologico evidencia;
	private TipoDiagnostico tipo;
	

	public Diagnostico(float confianza, PatronPatologico evidencia, TipoDiagnostico tipo) {
		super();
		this.confianza = confianza;
		this.evidencia = evidencia;
		this.tipo = tipo;
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


	public TipoDiagnostico getTipo() {
		return tipo;
	}


	public void setTipo(TipoDiagnostico tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
