package elem;
import java.util.ArrayList;
import componentes.*;
import java.util.Collection;

import componentes.ComplejoQRS;
import componentes.Componente;
import componentes.IntervaloPR;
import componentes.Onda;

public class Ciclo {
	
	private Collection<Onda> ondas;
	private ComplejoQRS complejo;
	private IntervaloPR intervaloPR;
	private IntervaloQT intervaloQT;
	private IntervaloRR intervaloRR;
	private SegmentoPR segmentoPR;
	private SegmentoST segmentoST;
	
	
	

	public Ciclo(Collection<Onda> ondas) {
		super();
		this.ondas = ondas;
	}

	public Ciclo() {
		// TODO Auto-generated constructor stub
		this.ondas = new ArrayList<Onda>();
	}



	public Collection<Onda> getOndas() {
		return ondas;
	}

	public void setOndas(Collection<Onda> ondas) {
		this.ondas = ondas;
	}

	public ComplejoQRS getComplejo() {
		return complejo;
	}

	public void setComplejo(ComplejoQRS complejo) {
		this.complejo = complejo;
	}

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

	public SegmentoPR getSegmentoPR() {
		return segmentoPR;
	}

	public void setSegmentoPR(SegmentoPR segmentoPR) {
		this.segmentoPR = segmentoPR;
	}

	public SegmentoST getSegmentoST() {
		return segmentoST;
	}

	public void setSegmentoST(SegmentoST segmentoST) {
		this.segmentoST = segmentoST;
	}
	
	
	
	
	

}
