package quintamc.beans;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import quintamc.entidades.Lote;
import quintamc.sessions.SessionSBSL;

@ManagedBean
@ViewScoped
public class LotesMB {

	@EJB
	private SessionSBSL sessionLocal;

	private List<Lote> listaLotes = new ArrayList<Lote>();
	private Lote nuevoLote = new Lote();

	private boolean renderPanelNuevoLote = false;

	private String factorConversionVaraCuadrada = "";
	private String tasaInteresPrestamo = "";

	private int totalLotesRegistrados = 0;

	private static final DecimalFormat formatoDecimal = new DecimalFormat("0.00");

	@PostConstruct
	public void inicio() {
		cargarListadoLotes();
		factorConversionVaraCuadrada = sessionLocal.obtenerPropiedadBD("M2_A_V2");
		tasaInteresPrestamo = sessionLocal.obtenerPropiedadBD("TASA_INTERES");
	}

	@SuppressWarnings("unchecked")
	private void cargarListadoLotes() {
		listaLotes = new ArrayList<Lote>();
		listaLotes = (List<Lote>) sessionLocal.buscar(Lote.class, "o.regActivo=1", null);

		if (listaLotes.size() > 0) {
			totalLotesRegistrados = listaLotes.size();
		} else {
			totalLotesRegistrados = 0;
		}
	}

	public void calcularVarasCuadradas() {
		Double dimensionenvaras = nuevoLote.getLoteMetrosCuadrados() * Double.valueOf(factorConversionVaraCuadrada);

		nuevoLote.setLoteVarasCuadradas(Float.valueOf(String.format("%.6f", dimensionenvaras)));

	}

	public void calcularPrecioLote() {
		Double preciolote = (double) (nuevoLote.getLoteVarasCuadradas() * nuevoLote.getLotePrecioVaraCuadrada());

		nuevoLote.setLotePrecioContado(Float.valueOf(String.format("%.2f", preciolote)));

		if (nuevoLote.getLotePrecioContado() > 0) {
			calcularValorCuotas();
		}

	}

	private void calcularValorCuotas() {
		Double interes = Double.valueOf(tasaInteresPrestamo) / 100;
		Double tasaAnual = interes / 12;

		Double factor1 = tasaAnual + 1;
		Double factor2 = Math.pow(factor1, 60);

		Double dividendo = tasaAnual * factor2;
		Double divisor = factor2 - 1;
		
		 

	}

	public void mostrarPanelNuevoLote() {
		renderPanelNuevoLote = true;
	}

	public void agregarNuevoLote() {

		nuevoLote.setFecCrea(new Date());
		nuevoLote.setLoteEstado("D");

		if (sessionLocal.insertar(Lote.class, nuevoLote)) {
			FacesMessage message = new FacesMessage("Lote registrado de forma exitosa");
			FacesContext.getCurrentInstance().addMessage("Lote registrado", message);
			cargarListadoLotes();
		} else {
			FacesMessage message = new FacesMessage("Error registrado informacion del lote");
			FacesContext.getCurrentInstance().addMessage("Lote registrado", message);
		}
	}

	public void cancelAddLote() {
		nuevoLote = new Lote();
		renderPanelNuevoLote = false;
	}

	public List<Lote> getListaLotes() {
		return listaLotes;
	}

	public void setListaLotes(List<Lote> listaLotes) {
		this.listaLotes = listaLotes;
	}

	public boolean isRenderPanelNuevoLote() {
		return renderPanelNuevoLote;
	}

	public void setRenderPanelNuevoLote(boolean renderPanelNuevoLote) {
		this.renderPanelNuevoLote = renderPanelNuevoLote;
	}

	public Lote getNuevoLote() {
		return nuevoLote;
	}

	public void setNuevoLote(Lote nuevoLote) {
		this.nuevoLote = nuevoLote;
	}

	public String getTasaInteresPrestamo() {
		return tasaInteresPrestamo;
	}

	public void setTasaInteresPrestamo(String tasaInteresPrestamo) {
		this.tasaInteresPrestamo = tasaInteresPrestamo;
	}

	public int getTotalLotesRegistrados() {
		return totalLotesRegistrados;
	}

	public void setTotalLotesRegistrados(int totalLotesRegistrados) {
		this.totalLotesRegistrados = totalLotesRegistrados;
	}

}
