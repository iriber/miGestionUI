package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.GastoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Criteria de gastos para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 *
 */
public class UIGastoCriteria extends UICustomCriteria{

	/**
	 * fecha desde
	 */
	private Date fechaDesde;

	/**
	 * fecha hasta
	 */
	private Date fechaHasta;



	public UIGastoCriteria() {
		
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
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.GASTOS;
		return desc;
	}	
	

	public GastoCriteria buildToService(){
		
		GastoCriteria criteria = new GastoCriteria();
		
		criteria.setFechaDesde( getFechaDesde() );
		criteria.setFechaHasta( getFechaHasta() );
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.orderByFecha( Criteria.ORDER_DESC );
		criteria.orderByCodigo( Criteria.ORDER_DESC );
		return criteria;
	}
}