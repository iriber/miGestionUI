package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.CuentaBancariaCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de cuentas bancarias para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 25/10/2013
 *
 */
public class UICuentaBancariaCriteria extends UICustomCriteria{

	//nombre.
	private String nombre;
	
	
	public UICuentaBancariaCriteria() {
		
	}
	
	public UICuentaBancariaCriteria(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.CUENTAS_BANCARIAS ;
		
		if(!StringUtils.isEmpty(getNombre()))
			desc +=  " | " + I18nMessages.CUENTA_BANCARIA_BANCO + ": '" + getNombre() + "'";
		
		return desc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CuentaBancariaCriteria buildToService(){
		
		CuentaBancariaCriteria criteria = new CuentaBancariaCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		criteria.orderByNombre(Criteria.ORDER_ASC);
		return criteria;
	}	
}
