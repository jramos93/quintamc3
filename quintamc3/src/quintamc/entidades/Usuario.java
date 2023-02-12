package quintamc.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usrId")
	private int usrId;

	@Column(name = "usrApellidos")
	private String usrApellidos;

	@Column(name = "usrCelular")
	private String usrCelular;

	@Column(name = "usrCodigoCliente")
	private String usrCodigoCliente;

	@Column(name = "usrCorreoElectronico")
	private String usrCorreoElectronico;

	@Column(name = "usrDireccion")
	private String usrDireccion;

	@Column(name = "usrNit")
	private String usrNit;

	@Column(name = "usrNombre")
	private String usrNombre;

	@Column(name = "usrNumDui")
	private String usrNumDui;

	@Column(name = "usrSexo")
	private String usrSexo;

	@Column(name = "usrTelefono")
	private String usrTelefono;

	@Column(name = "regActivo")
	private long regActivo;
	
	@Column(name = "fecCrea")
	private Date fecCrea;

	public Usuario() {
	}

	public int getUsrId() {
		return this.usrId;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	public String getUsrApellidos() {
		return this.usrApellidos;
	}

	public void setUsrApellidos(String usrApellidos) {
		this.usrApellidos = usrApellidos;
	}

	public String getUsrCelular() {
		return this.usrCelular;
	}

	public void setUsrCelular(String usrCelular) {
		this.usrCelular = usrCelular;
	}

	public String getUsrCodigoCliente() {
		return this.usrCodigoCliente;
	}

	public void setUsrCodigoCliente(String usrCodigoCliente) {
		this.usrCodigoCliente = usrCodigoCliente;
	}

	public String getUsrCorreoElectronico() {
		return this.usrCorreoElectronico;
	}

	public void setUsrCorreoElectronico(String usrCorreoElectronico) {
		this.usrCorreoElectronico = usrCorreoElectronico;
	}

	public String getUsrDireccion() {
		return this.usrDireccion;
	}

	public void setUsrDireccion(String usrDireccion) {
		this.usrDireccion = usrDireccion;
	}

	public String getUsrNit() {
		return this.usrNit;
	}

	public void setUsrNit(String usrNit) {
		this.usrNit = usrNit;
	}

	public String getUsrNombre() {
		return this.usrNombre;
	}

	public void setUsrNombre(String usrNombre) {
		this.usrNombre = usrNombre;
	}

	public String getUsrNumDui() {
		return this.usrNumDui;
	}

	public void setUsrNumDui(String usrNumDui) {
		this.usrNumDui = usrNumDui;
	}

	public String getUsrSexo() {
		return this.usrSexo;
	}

	public void setUsrSexo(String usrSexo) {
		this.usrSexo = usrSexo;
	}

	public String getUsrTelefono() {
		return this.usrTelefono;
	}

	public void setUsrTelefono(String usrTelefono) {
		this.usrTelefono = usrTelefono;
	}

	public long getRegActivo() {
		return regActivo;
	}

	public void setRegActivo(long regActivo) {
		this.regActivo = regActivo;
	}

	public Date getFecCrea() {
		return fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

}