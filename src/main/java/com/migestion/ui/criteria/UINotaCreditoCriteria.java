package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.Cliente;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.NotaCreditoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de notas de crédito para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class UINotaCreditoCriteria extends UICustomCriteria{

	private String numero;
	
	private Date fecha;
	
	private Cliente cliente;
	
	public UINotaCreditoCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.NOTAS_CREDITO;
		
//		if(StringUtils.isEmpty(getNombre()))
//			desc +=  " | " + I18nMessages.CUENTA_BANCARIA_BANCO + ": '" + getNombre() + "'";
		
		return desc;
	}


	public NotaCreditoCriteria buildToService(){
		
		NotaCreditoCriteria criteria = new NotaCreditoCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNumero(getNumero());
		criteria.setFecha(getFecha());
		criteria.setCliente(getCliente());
		criteria.orderByFecha(Criteria.ORDER_DESC);
		return criteria;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}
