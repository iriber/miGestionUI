package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.Cliente;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.MovimientoCuentaClienteCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de movimientos de cuentas de clientes
 * para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class UIMovimientoCuentaClienteCriteria extends UICustomCriteria{

	private Cliente cliente;
	
	private Date fechaDesde;
	private Date fechaHasta;
	
	public UIMovimientoCuentaClienteCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.MOVIMIENTOS_CUENTA_CLIENTE;
		
		if( getCliente()!=null)
			desc +=  " | " + I18nMessages.MOVIMIENTO_CUENTA_CLIENTE_CLIENTE + ": '" + getCliente().toString() ;
		
		return desc;
	}


	public MovimientoCuentaClienteCriteria buildToService(){
		
		MovimientoCuentaClienteCriteria criteria = new MovimientoCuentaClienteCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setFechaDesde(getFechaDesde());
		criteria.setFechaHasta(getFechaHasta());
		criteria.setCliente(getCliente());
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
	
}