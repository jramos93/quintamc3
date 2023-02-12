package quintamc.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EstadosCuentaMB {

	@PostConstruct
	public void inicio() {
		cargarEstadosCuentaUsuario();

	}

	private void cargarEstadosCuentaUsuario() {

	}

}
