package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.CategoriaProductoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de categorías de productos para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class UICategoriaProductoCriteria extends UICustomCriteria{

	//nombre de la categoria.
	private String nombre;
	
	//----------------------
	//CONSTRUCTORES
	//----------------------
	
	public UICategoriaProductoCriteria() {
		
	}
	
	public UICategoriaProductoCriteria(String nombre) {
		this.nombre = nombre;
	}

	//-----------------------
	//M�TODOS P�BLICOS
	//-----------------------
	
	/**
	 * descripci�n del criteria
	 */
	public String getDescription() {
		String desc = I18nMessages.CATEGORIAS_PRODUCTO + " | "+  I18nMessages.CATEGORIA_PRODUCTO_NOMBRE +   ": '" + getNombre() + "'";
		if(StringUtils.isEmpty(getNombre()))
			desc = I18nMessages.CATEGORIAS_PRODUCTO + " | TODOS";
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

	public CategoriaProductoCriteria buildToService(){
		
		CategoriaProductoCriteria criteria = new CategoriaProductoCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		return criteria;
	}	
}
