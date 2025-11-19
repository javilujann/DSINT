package componentes;

import elem.Ciclo;

public class OndaR extends Onda {

	public OndaR(float amplitud, float inicio, float fin) {
		super(amplitud, inicio, fin);
	}
	
	public OndaR(float amplitud, float inicio, float fin, Ciclo ciclo) {
		super(amplitud, inicio, fin, ciclo);
	}
}
