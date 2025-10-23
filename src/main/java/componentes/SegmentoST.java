package componentes;

public class SegmentoST extends Componente {
	
	private float elevacion;

	public SegmentoST(float amplitud, float inicio, float fin, float elevacion) {
		super(amplitud, inicio, fin);
		this.elevacion = elevacion;
	}

}
