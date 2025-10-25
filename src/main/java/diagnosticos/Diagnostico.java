package diagnosticos;



public class Diagnostico {
	
	private float confianza;
	private PatronPatologico evidencia;
	private TipoDiagnostico tipo;
	private Severidad severidad;
	

	public Diagnostico(float confianza, PatronPatologico evidencia, TipoDiagnostico tipo, Severidad severidad) {
		super();
		this.confianza = confianza;
		this.evidencia = evidencia;
		this.tipo = tipo;
		this.severidad = severidad;
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


	public Severidad getSeveridad() {
		return severidad;
	}


	public void setSeveridad(Severidad severidad) {
		this.severidad = severidad;
	}

	public TipoDiagnostico getTipo() {
		return tipo;
	}


	public void setTipo(TipoDiagnostico tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
