package elem;
import componentes.*;

public class Ciclo {
	
	//ATRIBUTOS 
	private OndaP ondaP;
	private OndaQ ondaQ;
	private OndaR ondaR;
	private OndaS ondaS;
	private OndaT ondaT;
   
	private IntervaloPR intervaloPR;
    private IntervaloQT intervaloQT;
    public IntervaloRR intervaloRR;
    
    private ComplejoQRS complejoQRS;

    private int indice;
    
    // CONSTRUCTOR    
    public Ciclo(int indice) {
		super();
		this.indice = indice;
	}
	
    //GETTERS AND SETTER
    
		//INTERVALOS
	public IntervaloPR getIntervaloPR() {
		return intervaloPR;
	}

	public void setIntervaloPR(IntervaloPR intervaloPR) {
		this.intervaloPR = intervaloPR;
	}

	public IntervaloQT getIntervaloQT() {
		return intervaloQT;
	}

	public void setIntervaloQT(IntervaloQT intervaloQT) {
		this.intervaloQT = intervaloQT;
	}

		
	public IntervaloRR getIntervaloRR() {
		return intervaloRR;
	}

	public void setIntervaloRR(IntervaloRR intervaloRR) {
		this.intervaloRR = intervaloRR;
	}
		
		//COMPLEJO
	public ComplejoQRS getComplejoQRS() {
		return complejoQRS;
	}

	public void setComplejoQRS(ComplejoQRS complejoQRS) {
		this.complejoQRS = complejoQRS;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public OndaP getOndaP() {
		return ondaP;
	}

	public void setOndaP(OndaP ondaP) {
		this.ondaP = ondaP;
	}

	public OndaQ getOndaQ() {
		return ondaQ;
	}

	public void setOndaQ(OndaQ ondaQ) {
		this.ondaQ = ondaQ;
	}

	public OndaR getOndaR() {
		return ondaR;
	}

	public void setOndaR(OndaR ondaR) {
		this.ondaR = ondaR;
	}

	public OndaS getOndaS() {
		return ondaS;
	}

	public void setOndaS(OndaS ondaS) {
		this.ondaS = ondaS;
	}

	public OndaT getOndaT() {
		return ondaT;
	}

	public void setOndaT(OndaT ondaT) {
		this.ondaT = ondaT;
	}
	
}
