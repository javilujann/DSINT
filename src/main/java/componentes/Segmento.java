package componentes;

public class Segmento extends Componente {
	
	private SegmentoTipo tipo;

	public Segmento(float inicio, float fin, SegmentoTipo tipo) {
		super(inicio, fin);
		this.tipo = tipo;
	}

	public SegmentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(SegmentoTipo tipo) {
		this.tipo = tipo;
	}
	

}
