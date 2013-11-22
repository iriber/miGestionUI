package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.Cliente;
import com.migestion.model.Vendedor;


/**
 * Criteria de operaciones para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public abstract class UIOperacionCriteria extends UICustomCriteria{

	/**
	 * fecha de venta desde
	 */
	private Date fechaDesde;

	/**
	 * fecha de venta hasta
	 */
	private Date fechaHasta;

	/**
	 * vendedor
	 */
	private Vendedor vendedor;


	public UIOperacionCriteria() {
		
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
	 * @return the vendedor
	 */
	public Vendedor getVendedor() {
		return vendedor;
	}

	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	
	
}