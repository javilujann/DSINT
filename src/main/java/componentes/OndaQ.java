package componentes;

import elem.Ciclo;

public class OndaQ extends Onda {

	public OndaQ(float amplitud, float inicio, float fin) {
		super(amplitud, inicio, fin);
	}
	
	public OndaQ(float amplitud, float inicio, float fin, Ciclo ciclo) {
		super(amplitud, inicio, fin, ciclo);
	}
}
