package componentes;

public class ComplejoQRS extends Componente {
	
	public float EjeElectrico;
	public float anchoQRS;
	
	
	public ComplejoQRS(float amplitud, float inicio, float fin, float ejeElectrico, float anchoQRS) {
		super(amplitud, inicio, fin);
		EjeElectrico = ejeElectrico;
		this.anchoQRS = anchoQRS;
	}


	public float getEjeElectrico() {
		return EjeElectrico;
	}


	public void setEjeElectrico(float ejeElectrico) {
		EjeElectrico = ejeElectrico;
	}


	public float getAnchoQRS() {
		return anchoQRS;
	}


	public void setAnchoQRS(float anchoQRS) {
		this.anchoQRS = anchoQRS;
	}
	
	

	
	
	

}
