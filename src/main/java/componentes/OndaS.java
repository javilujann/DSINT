package componentes;

import elem.Ciclo;

public class OndaS extends Onda {

	public OndaS(float amplitud, float inicio, float fin) {
		super(amplitud, inicio, fin);
	}
	
	public OndaS(float amplitud, float inicio, float fin, Ciclo ciclo) {
		super(amplitud, inicio, fin, ciclo);
	}
}
