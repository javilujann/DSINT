package diagnosticos;
import componentes.Componente;


public class PatronPatologico {
	
	private Severidad severidad;
	private Componente componenteAfectada;
	private TipoPatron tipo;
	private Diagnostico sugiereDiagnostico;
	
	
	public PatronPatologico(Severidad severidad, Componente componenteAfectada, TipoPatron tipo) {
		super();
		this.severidad = severidad;
		this.componenteAfectada = componenteAfectada;
		this.tipo = tipo;
	}


	public Severidad getSeveridad() {
		return severidad;
	}


	public void setSeveridad(Severidad severidad) {
		this.severidad = severidad;
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
	
	
	
	
	
	
	
	

}
