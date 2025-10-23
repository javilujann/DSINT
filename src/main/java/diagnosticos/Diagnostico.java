package diagnosticos;

import diagnosticos.util.Severidad;
import diagnosticos.util.TipoDiagnostico;
import patrones.PatronPatologico;

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
	
	

}
