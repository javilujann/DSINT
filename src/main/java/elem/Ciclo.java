package elem;
import java.util.Collection;
import componentes.Componente;

public class Ciclo {
	
	private Collection<Componente> componentes;
	
	

	public Ciclo(Collection<Componente> componentes) {
		super();
		this.componentes = componentes;
	}

	public Collection<Componente> getComponentes() {
		return componentes;
	}

	public void setComponentes(Collection<Componente> componentes) {
		this.componentes = componentes;
	}
	
	
	

}
