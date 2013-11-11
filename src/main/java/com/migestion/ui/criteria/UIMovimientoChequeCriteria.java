package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.Cheque;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.MovimientoChequeCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de movimientos de cheques para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 *
 */
public class UIMovimientoChequeCriteria extends UICustomCriteria{

	private Cheque cheque;
	
	private Date fechaDesde;
	
	private Date fechaHasta;

	public UIMovimientoChequeCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.MOVIMIENTOS_CHEQUE;
		
		return desc;
	}


	public MovimientoChequeCriteria buildToService(){
		
		MovimientoChequeCriteria criteria = new MovimientoChequeCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setFechaDesde(getFechaDesde());
		criteria.setFechaHasta(getFechaHasta());
		criteria.setCheque(getCheque());
		criteria.orderByFechaHora( Criteria.ORDER_DESC );
		
		return criteria;
	}



	public Cheque getCheque() {
		return cheque;
	}


	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}


	public Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	
}
