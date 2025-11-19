package componentes;

import elem.Ciclo;

public class Intervalo extends Componente {

	public Intervalo(float inicio, float fin) {
		super(inicio, fin);
	}
	
	public Intervalo(float inicio, float fin, Ciclo ciclo) {
        super(inicio, fin, ciclo);
    }


}
