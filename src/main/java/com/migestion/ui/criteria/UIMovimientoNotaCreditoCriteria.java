package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.NotaCredito;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.MovimientoNotaCreditoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de movimientos de notas de crédito para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 *
 */
public class UIMovimientoNotaCreditoCriteria extends UICustomCriteria{

	private NotaCredito notaCredito;
	
	private Date fechaDesde;
	
	private Date fechaHasta;

	public UIMovimientoNotaCreditoCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.MOVIMIENTOS_NOTA_CREDITO;
		
		return desc;
	}


	public MovimientoNotaCreditoCriteria buildToService(){
		
		MovimientoNotaCreditoCriteria criteria = new MovimientoNotaCreditoCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setFechaDesde(getFechaDesde());
		criteria.setFechaHasta(getFechaHasta());
		criteria.setNotaCredito(getNotaCredito());
		criteria.orderByFechaHora( Criteria.ORDER_DESC );
		
		return criteria;
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


	public NotaCredito getNotaCredito() {
		return notaCredito;
	}


	public void setNotaCredito(NotaCredito notaCredito) {
		this.notaCredito = notaCredito;
	}


	
}
