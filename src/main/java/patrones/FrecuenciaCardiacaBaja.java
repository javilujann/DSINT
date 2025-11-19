package patrones;

import componentes.Componente;

public class FrecuenciaCardiacaBaja extends PatronPatologico {

	public FrecuenciaCardiacaBaja(float confianza, Componente componenteAfectada) {
		super(confianza, componenteAfectada);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public String sacarPorPantalla() {
		String patron = this.getClass().getSimpleName().replaceAll("(?<!^)(?=[A-Z])", " ");
		return patron;
	}


}
