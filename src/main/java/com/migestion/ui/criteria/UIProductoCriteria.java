package com.migestion.ui.criteria;

import com.migestion.model.CategoriaProducto;
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
	
	private CategoriaProducto categoriaProducto;
	
	public UIProductoCriteria() {
		
	}
	
	public UIProductoCriteria(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * descripci�n del criteria
	 */
	public String getDescription() {
		String desc = I18nMessages.PRODUCTOS ;
		return desc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProductoCriteria buildToService(){
		
		ProductoCriteria criteria = new ProductoCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setCategoriaProducto(getCategoriaProducto());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		return criteria;
	}

	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}	
}
