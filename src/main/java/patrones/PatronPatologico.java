package patrones;

import componentes.Componente;
import diagnosticos.Diagnostico;
import patrones.util.TipoPatron;

public class PatronPatologico {
	
	private float severidad;
	private Componente componenteAfectada;
	private TipoPatron tipo;
	private Diagnostico sugiereDiagnostico;
	
	
	public PatronPatologico(float severidad, Componente componenteAfectada, TipoPatron tipo) {
		super();
		this.severidad = severidad;
		this.componenteAfectada = componenteAfectada;
		this.tipo = tipo;
	}


	public float getSeveridad() {
		return severidad;
	}


	public void setSeveridad(float severidad) {
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
