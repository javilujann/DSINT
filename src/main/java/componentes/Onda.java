package componentes;
import componentes.util.TipoOnda;

public class Onda extends Componente {
	
	private TipoOnda tipo;
	
	public Onda(float amplitud, float inicio, float fin, TipoOnda tipo) {
		super(amplitud, inicio, fin);
		this.tipo = tipo;
	}

	public TipoOnda getTipo() {
		return tipo;
	}

	public void setTipo(TipoOnda tipo) {
		this.tipo = tipo;
	}

}
