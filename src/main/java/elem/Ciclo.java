package elem;
import java.util.Collection;
import java.util.Optional;
import componentes.*;

public class Ciclo {
	
	//ATRIBUTOS 
	private Collection<Onda> ondas;
   
	private Intervalo intervaloPR;
    private Intervalo intervaloQT;
    public Intervalo intervaloRR;
    
    private ComplejoQRS complejoQRS;

    private Segmento segmentoPR;
    private Segmento segmentoST;
    
    private int indice;
    
    // CONSTRUCTOR
    public Ciclo(Collection<Onda> ondas) {
		super();
		this.ondas = ondas;
	}
	
    
    //GETTERS AND SETTER
    
    public Collection<Onda> getOndas() {
		return ondas;
	}

	public void setOndas(Collection<Onda> ondas) {
		this.ondas = ondas;
	}
	
		//INTERVALOS
	public Intervalo getIntervaloPR() {
		return intervaloPR;
	}

	public void setIntervaloPR(Intervalo intervaloPR) {
		this.intervaloPR = intervaloPR;
	}

	public Intervalo getIntervaloQT() {
		return intervaloQT;
	}

	public void setIntervaloQT(Intervalo intervaloQT) {
		this.intervaloQT = intervaloQT;
	}
	
	public Intervalo getIntervaloRR() {
		return intervaloRR;
	}

	public void setIntervaloRR(Intervalo intervaloRR) {
		this.intervaloRR = intervaloRR;
	}
	
		//SEGMENTO

	public Segmento getSegmentoST() {
		return segmentoST;
	}

	public void setSegmentoST(Segmento segmentoST) {
		this.segmentoST = segmentoST;
	}

	public Segmento getSegmentoPR() {
		return segmentoPR;
	}

	public void setSegmentoPR(Segmento segmentoPR) {
		this.segmentoPR = segmentoPR;
	}
	
		//COMPLEJO
	public ComplejoQRS getComplejoQRS() {
		return complejoQRS;
	}

	public void setComplejoQRS(ComplejoQRS complejoQRS) {
		this.complejoQRS = complejoQRS;
	}
	
	
	// METODOS
	public Optional<Onda> getOnda(OndaTipo tipo){
		return ondas.stream().filter(o -> o.getTipo().equals(tipo)).findAny();
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
}
