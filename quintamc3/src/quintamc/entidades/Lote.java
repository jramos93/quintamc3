package quintamc.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the lotes database table.
 * 
 */
@Entity
@Table(name = "lotes")
@NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l")
public class Lote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "loteId")
	private int loteId;

	@Column(name = "loteCulataRecta")
	private String loteCulataRecta;

	@Column(name = "loteEstado")
	private String loteEstado;

	@Column(name = "loteMetrosCuadrados")
	private float loteMetrosCuadrados;

	@Column(name = "loteNorte")
	private String loteNorte;

	@Column(name = "loteNumero")
	private int loteNumero;

	@Column(name = "loteNumeroMatricula")
	private String loteNumeroMatricula;

	@Column(name = "loteOriente")
	private String loteOriente;

	@Column(name = "lotePoligono")
	private String lotePoligono;

	@Column(name = "lotePoniente")
	private String lotePoniente;

	@Column(name = "lotePrecioContado")
	private float lotePrecioContado;

	@Column(name = "lotePrecioVaraCuadrada")
	private float lotePrecioVaraCuadrada;

	@Column(name = "loteSur")
	private String loteSur;

	@Column(name = "loteTasaInteres")
	private float loteTasaInteres;

	@Column(name = "loteVarasCuadradas")
	private float loteVarasCuadradas;

	@Column(name = "regActivo")
	private long regActivo;

	@Column(name = "fecCrea")
	private Date fecCrea;

	public Lote() {
	}

	public int getLoteId() {
		return this.loteId;
	}

	public void setLoteId(int loteId) {
		this.loteId = loteId;
	}

	public String getLoteCulataRecta() {
		return this.loteCulataRecta;
	}

	public void setLoteCulataRecta(String loteCulataRecta) {
		this.loteCulataRecta = loteCulataRecta;
	}

	public String getLoteEstado() {
		return this.loteEstado;
	}

	public void setLoteEstado(String loteEstado) {
		this.loteEstado = loteEstado;
	}

	public float getLoteMetrosCuadrados() {
		return this.loteMetrosCuadrados;
	}

	public void setLoteMetrosCuadrados(float loteMetrosCuadrados) {
		this.loteMetrosCuadrados = loteMetrosCuadrados;
	}

	public String getLoteNorte() {
		return this.loteNorte;
	}

	public void setLoteNorte(String loteNorte) {
		this.loteNorte = loteNorte;
	}

	public int getLoteNumero() {
		return this.loteNumero;
	}

	public void setLoteNumero(int loteNumero) {
		this.loteNumero = loteNumero;
	}

	public String getLoteNumeroMatricula() {
		return this.loteNumeroMatricula;
	}

	public void setLoteNumeroMatricula(String loteNumeroMatricula) {
		this.loteNumeroMatricula = loteNumeroMatricula;
	}

	public String getLoteOriente() {
		return this.loteOriente;
	}

	public void setLoteOriente(String loteOriente) {
		this.loteOriente = loteOriente;
	}

	public String getLotePoligono() {
		return this.lotePoligono;
	}

	public void setLotePoligono(String lotePoligono) {
		this.lotePoligono = lotePoligono;
	}

	public String getLotePoniente() {
		return this.lotePoniente;
	}

	public void setLotePoniente(String lotePoniente) {
		this.lotePoniente = lotePoniente;
	}

	public float getLotePrecioContado() {
		return this.lotePrecioContado;
	}

	public void setLotePrecioContado(float lotePrecioContado) {
		this.lotePrecioContado = lotePrecioContado;
	}

	public float getLotePrecioVaraCuadrada() {
		return this.lotePrecioVaraCuadrada;
	}

	public void setLotePrecioVaraCuadrada(float lotePrecioVaraCuadrada) {
		this.lotePrecioVaraCuadrada = lotePrecioVaraCuadrada;
	}

	public String getLoteSur() {
		return this.loteSur;
	}

	public void setLoteSur(String loteSur) {
		this.loteSur = loteSur;
	}

	public float getLoteTasaInteres() {
		return this.loteTasaInteres;
	}

	public void setLoteTasaInteres(float loteTasaInteres) {
		this.loteTasaInteres = loteTasaInteres;
	}

	public float getLoteVarasCuadradas() {
		return this.loteVarasCuadradas;
	}

	public void setLoteVarasCuadradas(float loteVarasCuadradas) {
		this.loteVarasCuadradas = loteVarasCuadradas;
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