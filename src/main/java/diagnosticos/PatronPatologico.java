package diagnosticos;
import componentes.Componente;


public class PatronPatologico {
	
	private float confianza;
	private Componente componenteAfectada;
	private Diagnostico sugiereDiagnostico;
	private TipoPatron tipo;
	
	
	public PatronPatologico(float confianza,Componente componenteAfectada, TipoPatron tipo) {
		super();
		this.confianza = confianza;
		this.componenteAfectada = componenteAfectada;
		this.tipo = tipo;
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


	public TipoPatron getTipo() {
		return tipo;
	}


	public void setTipo(TipoPatron tipo) {
		this.tipo = tipo;
	}

	public float getConfianza() {
		return confianza;
	}

	public void setConfianza(float confianza) {
		this.confianza = confianza;
	}
	
	
	
	
	
	
	
	

}
