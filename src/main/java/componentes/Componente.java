package componentes;

import diagnosticos.PatronPatologico;

public abstract class Componente {
	
	private float inicio;
	private float fin;
	private float duracion;
	private PatronPatologico patron;
	
	public Componente(float inicio, float fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.duracion = fin - inicio;
	}
	
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float _duracion) {
		duracion = _duracion;
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