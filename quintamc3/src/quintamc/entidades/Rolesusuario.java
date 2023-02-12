package quintamc.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rolesusuarios database table.
 * 
 */
@Entity
@Table(name="rolesusuarios")
@NamedQuery(name="Rolesusuario.findAll", query="SELECT r FROM Rolesusuario r")
public class Rolesusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int roluId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecCrea;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecModi;

	private int regActivo;

	private int roluRolid;

	private int roluUsrid;

	private String usuCrea;

	private String usuModi;

	public Rolesusuario() {
	}

	public int getRoluId() {
		return this.roluId;
	}

	public void setRoluId(int roluId) {
		this.roluId = roluId;
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

	public int getRoluRolid() {
		return this.roluRolid;
	}

	public void setRoluRolid(int roluRolid) {
		this.roluRolid = roluRolid;
	}

	public int getRoluUsrid() {
		return this.roluUsrid;
	}

	public void setRoluUsrid(int roluUsrid) {
		this.roluUsrid = roluUsrid;
	}

	public String getUsuCrea() {
		return this.usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

	public String getUsuModi() {
		return this.usuModi;
	}

	public void setUsuModi(String usuModi) {
		this.usuModi = usuModi;
	}

}