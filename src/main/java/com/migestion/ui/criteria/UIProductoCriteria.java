package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.ProductoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de productos para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 *
 */
public class UIProductoCriteria extends UICustomCriteria{

	//nombre del producto.
	private String nombre;
	
	//----------------------
	//CONSTRUCTORES
	//----------------------
	
	public UIProductoCriteria() {
		
	}
	
	public UIProductoCriteria(String nombre) {
		this.nombre = nombre;
	}

	//-----------------------
	//M�TODOS P�BLICOS
	//-----------------------
	
	/**
	 * descripci�n del criteria
	 */
	public String getDescription() {
		String desc = I18nMessages.PRODUCTOS + " | " + I18nMessages.PRODUCTO_NOMBRE + ": '" + getNombre() + "'";
		if(StringUtils.isEmpty(getNombre()))
			desc = I18nMessages.PRODUCTOS + " | TODOS";
		return desc;
	}
	//-----------------------
	//GETTERS y SETTERS
	//-----------------------


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProductoCriteria buildToService(){
		
		ProductoCriteria criteria = new ProductoCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		return criteria;
	}	
}
