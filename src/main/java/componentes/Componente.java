package componentes;

import patrones.PatronPatologico;

public abstract class Componente {
	
	private float Amplitud;
	private float inicio;
	private float fin;
	private PatronPatologico patron;
	
	public Componente(float amplitud, float inicio, float fin) {
		super();
		Amplitud = amplitud;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public float getAmplitud() {
		return Amplitud;
	}
	public void setAmplitud(float amplitud) {
		Amplitud = amplitud;
	}
	public float getInicio() {
		return inicio;
	}
	public void setInicio(float inicio) {
		this.inicio = inicio;
	}
	public float getFin() {
		return fin;
	}
	public void setFin(float fin) {
		this.fin = fin;
	}
	public PatronPatologico getPatron() {
		return patron;
	}
	public void setPatron(PatronPatologico patron) {
		this.patron = patron;
	}
	
	

}