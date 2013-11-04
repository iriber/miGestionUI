package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.Cliente;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.PagoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Criteria de pagos para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class UIPagoCriteria extends UICustomCriteria{

	/**
	 * fecha desde
	 */
	private Date fechaDesde;

	/**
	 * fecha hasta
	 */
	private Date fechaHasta;

	/**
	 * cliente
	 */
	private Cliente cliente;
	


	public UIPagoCriteria() {
		
	}

	
	/**
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}

	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}

	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.PAGOS;
		return desc;
	}	
	

	public PagoCriteria buildToService(){
		
		PagoCriteria criteria = new PagoCriteria();
		
		criteria.setCliente( getCliente() );
		criteria.setFechaDesde( getFechaDesde() );
		criteria.setFechaHasta( getFechaHasta() );
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.orderByFecha( Criteria.ORDER_DESC );
		criteria.orderByCodigo( Criteria.ORDER_DESC );
		return criteria;
	}
}