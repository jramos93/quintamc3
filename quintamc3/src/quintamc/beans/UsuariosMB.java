package quintamc.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import quintamc.entidades.Role;
import quintamc.entidades.Rolesusuario;
import quintamc.entidades.Usuario;
import quintamc.sessions.SessionSBSL;
import quintamc.sessions.SessionSBSLLocal;

@ManagedBean
@ViewScoped
public class UsuariosMB {

	private boolean renderPanelNuevoUsuario = false;

	private Usuario usuario;
	private Usuario usuarioSelected;

	private String usuarioId;
	private int rolSeleccionado;

	private List<Usuario> listaUsurios = new ArrayList<Usuario>();
	private List<Role> listaRoles = new ArrayList<Role>();

	@EJB
	private SessionSBSL sesionLocal = new SessionSBSL();

	@PostConstruct
	public void inicio() {
		usuario = new Usuario();
		usuarioSelected = new Usuario();
		cargarListadoUsuarios();
		cargarListadoRolesSistema();

	}

	// CARGA EL LISTADO DE USUARIOS DE LA BASE DE DATOS
	@SuppressWarnings("unchecked")
	private void cargarListadoUsuarios() {
		listaUsurios = new ArrayList<Usuario>();
		listaUsurios = (List<Usuario>) sesionLocal.buscar(Usuario.class, "o.regActivo=1", null);

	}

	@SuppressWarnings("unchecked")
	private void cargarListadoRolesSistema() {
		listaRoles = new ArrayList<Role>();
		listaRoles = (List<Role>) sesionLocal.buscar(Role.class, "o.regActivo=1", null);
	}

	public void mostrarPanelNuevoUsuario() {
		renderPanelNuevoUsuario = true;
	}

	// REGISTRA NUEVO USUARIO
	public void agregarNuevoUsuario() {

		try {
			usuario.setFecCrea(new Date());
			sesionLocal.insertar(Usuario.class, usuario);

			if (validarDatosUsuario()) {
				listaUsurios.add(usuario);
				usuario = new Usuario();
				renderPanelNuevoUsuario = false;
			} else {
				FacesMessage message = new FacesMessage("Uno o mas datos no son validos, favor verificar");
				FacesContext.getCurrentInstance().addMessage("Datos no validos", message);
			}
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("Datos no validos", "Ocurrio un error insertando el registro");
			FacesContext.getCurrentInstance().addMessage("Datos no validos", message);
			e.printStackTrace();
		}

	}

	public void cancelAddUsuario() {

		usuario = new Usuario();
		renderPanelNuevoUsuario = false;
	}

	private boolean validarDatosUsuario() {
		boolean retorno = true;

		return retorno;

	}

	// CARGA LOS ROLES DEL USUARIO SELECCIONADO DEL DATATABLE
	public void cargarRolesUsuario() {
		listaRoles = new ArrayList<Role>();

		System.out.println("VALOR SELECCIONADO: " + usuarioSelected.getUsrId());
	}

	// AGREGA UN ROL AL USUARIO SELECCIONADO
	public void agregarRolUsuario() {
		Rolesusuario nuevorol = new Rolesusuario();

		nuevorol.setFecCrea(new Date());
		nuevorol.setRegActivo(1);
		nuevorol.setRoluRolid(rolSeleccionado);
		nuevorol.setRoluUsrid(usuarioSelected.getUsrId());

		sesionLocal.insertar(Rolesusuario.class, nuevorol);

		FacesMessage message = new FacesMessage("Se anadio el rol indicado");

		FacesContext.getCurrentInstance().addMessage("Rol registrado", message);

	}

	public List<Usuario> getListaUsurios() {
		return listaUsurios;
	}

	public void setListaUsurios(List<Usuario> listaUsurios) {
		this.listaUsurios = listaUsurios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isRenderPanelNuevoUsuario() {
		return renderPanelNuevoUsuario;
	}

	public void setRenderPanelNuevoUsuario(boolean renderPanelNuevoUsuario) {
		this.renderPanelNuevoUsuario = renderPanelNuevoUsuario;
	}

	public Usuario getUsuarioSelected() {
		return usuarioSelected;
	}

	public void setUsuarioSelected(Usuario usuarioSelected) {
		this.usuarioSelected = usuarioSelected;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<Role> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<Role> listaRoles) {
		this.listaRoles = listaRoles;
	}

	public int getRolSeleccionado() {
		return rolSeleccionado;
	}

	public void setRolSeleccionado(int rolSeleccionado) {
		this.rolSeleccionado = rolSeleccionado;
	}

}
