package com.migestion.ui.criteria;

import com.migestion.model.Cliente;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.PagoClienteCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Criteria de pagos para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class UIPagoClienteCriteria extends UIPagoCriteria{


	/**
	 * cliente
	 */
	private Cliente cliente;
	


	public UIPagoClienteCriteria() {
		
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
	

	public PagoClienteCriteria buildToService(){
		
		PagoClienteCriteria criteria = new PagoClienteCriteria();
		
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