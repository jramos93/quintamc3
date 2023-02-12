package quintamc.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the configuraciones database table.
 * 
 */
@Entity
@Table(name = "configuraciones")
@NamedQuery(name = "Configuracione.findAll", query = "SELECT c FROM Configuracione c")
public class Configuracione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cnfId")
	private int cnfId;

	@Column(name = "cnfDescripcion")
	private String cnfDescripcion;

	@Column(name = "cnfValor")
	private String cnfValor;

	@Column(name = "cnfComentario")
	private String cnfComentario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecModi;

	private int regActivo;

	public Configuracione() {
	}

	public int getCnfId() {
		return this.cnfId;
	}

	public void setCnfId(int cnfId) {
		this.cnfId = cnfId;
	}

	public String getCnfDescripcion() {
		return this.cnfDescripcion;
	}

	public void setCnfDescripcion(String cnfDescripcion) {
		this.cnfDescripcion = cnfDescripcion;
	}

	public String getCnfValor() {
		return this.cnfValor;
	}

	public void setCnfValor(String cnfValor) {
		this.cnfValor = cnfValor;
	}

	public Date getFecCrea() {
		return this.fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public Date getFecModi() {
		return this.fecModi;
	}

	public void setFecModi(Date fecModi) {
		this.fecModi = fecModi;
	}

	public int getRegActivo() {
		return this.regActivo;
	}

	public void setRegActivo(int regActivo) {
		this.regActivo = regActivo;
	}

	public String getCnfComentario() {
		return cnfComentario;
	}

	public void setCnfComentario(String cnfComentario) {
		this.cnfComentario = cnfComentario;
	}

}