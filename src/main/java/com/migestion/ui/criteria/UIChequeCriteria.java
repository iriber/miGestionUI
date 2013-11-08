package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.services.criteria.ChequeCriteria;
import com.migestion.services.criteria.Criteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de cheques para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class UIChequeCriteria extends UICustomCriteria{

	private String numero;
	
	private String banco;
		
	private Date fechaVencimiento;
	
	public UIChequeCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.CHEQUES;
		
//		if(StringUtils.isEmpty(getNombre()))
//			desc +=  " | " + I18nMessages.CUENTA_BANCARIA_BANCO + ": '" + getNombre() + "'";
		
		return desc;
	}


	public ChequeCriteria buildToService(){
		
		ChequeCriteria criteria = new ChequeCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNumero(getNumero());
		criteria.setBanco(getBanco());
		criteria.setFechaVencimiento(getFechaVencimiento());
		criteria.orderByFechaVencimiento(Criteria.ORDER_ASC);
		return criteria;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}	
}
