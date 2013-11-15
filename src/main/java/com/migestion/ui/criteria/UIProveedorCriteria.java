package com.migestion.ui.criteria;

import com.migestion.services.criteria.ProveedorCriteria;
import com.migestion.services.criteria.Criteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de proveedores para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/11/2013
 *
 */
public class UIProveedorCriteria extends UIPersonaCriteria{

	private String cuit;
	
	public UIProveedorCriteria() {

		super();
	}
	
	public UIProveedorCriteria(String nombre) {
		super(nombre);
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		String desc = I18nMessages.PROVEEDORES;
		return desc;
	}

	public ProveedorCriteria buildToService(){
		
		ProveedorCriteria criteria = new ProveedorCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		criteria.setNroDocumento(getNroDocumento());
		criteria.setCuit(getCuit());
		criteria.orderByNombre(Criteria.ORDER_ASC);
		return criteria;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}	
}
