package componentes;

public class Intervalo extends Componente {
	
	private IntervaloTipo tipo;

	public Intervalo(float inicio, float fin, IntervaloTipo tipo) {
		super(inicio, fin);
		this.tipo = tipo;
	}

	public IntervaloTipo getTipo() {
		return tipo;
	}

	public void setTipo(IntervaloTipo tipo) {
		this.tipo = tipo;
	}
	
	

}
