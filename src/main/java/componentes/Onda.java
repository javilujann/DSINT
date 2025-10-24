package componentes;


public class Onda extends Componente {
	
	private OndaTipo tipo;
	
	

	public Onda(float amplitud, float inicio, float fin, OndaTipo tipo) {
		super(amplitud, inicio, fin);
		this.tipo = tipo;
	}

	public OndaTipo getTipo() {
		return tipo;
	}

	public void setTipo(OndaTipo tipo) {
		this.tipo = tipo;
	}

}
