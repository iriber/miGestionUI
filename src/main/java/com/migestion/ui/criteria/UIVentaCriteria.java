package com.migestion.ui.criteria;

import java.util.ArrayList;
import java.util.Collection;

import com.migestion.model.EstadoVenta;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.VentaCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de clientes para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class UIVentaCriteria extends UIOperacionCriteria{

	/**
	 * estados posibles para la venta.
	 */
	private Collection<EstadoVenta> estados;

	/**
	 * estados de venta a excluir
	 */
	private Collection<EstadoVenta> estadosExcluir;

	
	public UIVentaCriteria() {

		super();
		
		estadosExcluir = new ArrayList<EstadoVenta>();
		estados = new ArrayList<EstadoVenta>();
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
//		String desc = I18nMessages.VENTAS + " | " + I18nMessages.CLIENTE_NOMBRE + ": '" + getNombre() + "'";
//		if(StringUtils.isEmpty(getNombre()))
//			desc = I18nMessages.VENTAS + " | TODAS";
		
		String desc = I18nMessages.VENTAS;
		return desc;
	}

	
		
	/**
	 * @return the estadosExcluir
	 */
	public Collection<EstadoVenta> getEstadosExcluir() {
		return estadosExcluir;
	}

	/**
	 * @param estadosExcluir the estadosExcluir to set
	 */
	public void setEstadosExcluir(Collection<EstadoVenta> estadosExcluir) {
		this.estadosExcluir = estadosExcluir;
	}
	
	public void addEstadoExcluir(EstadoVenta estado){
		
		this.estadosExcluir.add(estado);
	}

	/**
	 * @return the estados
	 */
	public Collection<EstadoVenta> getEstados() {
		return estados;
	}

	/**
	 * @param estados the estados to set
	 */
	public void setEstados(Collection<EstadoVenta> estados) {
		this.estados = estados;
	}

	public VentaCriteria buildToService(){
		
		VentaCriteria criteria = new VentaCriteria();
		
		criteria.setCliente( getCliente() );
		criteria.setVendedor( getVendedor() );
		criteria.setFechaDesde( getFechaDesde() );
		criteria.setFechaHasta( getFechaHasta() );
		criteria.setEstados( getEstados() );
		criteria.setEstadosExcluir(getEstadosExcluir());
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.orderByFecha( Criteria.ORDER_DESC );
		criteria.orderByCodigo( Criteria.ORDER_DESC );
		return criteria;
	}	
}
