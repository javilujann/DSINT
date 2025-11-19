package componentes;

import elem.Ciclo;

public class IntervaloQT extends Intervalo {

	public IntervaloQT(float inicio, float fin) {
		super(inicio, fin);
	}

	public IntervaloQT(float inicio, float fin, Ciclo ciclo) {
		super(inicio, fin, ciclo);
	}
}