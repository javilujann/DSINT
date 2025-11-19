package componentes;

import elem.Ciclo;

public class OndaT extends Onda {
	
	public OndaT(float amplitud, float inicio, float fin) {
		super(amplitud, inicio, fin);
	}
	
	public OndaT(float amplitud, float inicio, float fin, Ciclo ciclo) {
		super(amplitud, inicio, fin, ciclo);
	}
}
