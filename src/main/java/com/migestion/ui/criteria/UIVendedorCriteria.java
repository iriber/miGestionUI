package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.VendedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de vendedores para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class UIVendedorCriteria extends UIPersonaCriteria{

	
	public UIVendedorCriteria() {

		super();
	}
	
	public UIVendedorCriteria(String nombre) {
		super(nombre);
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		String desc = I18nMessages.VENDEDORES + " | " + I18nMessages.VENDEDOR_NOMBRE + ": '" + getNombre() + "'";
		if(StringUtils.isEmpty(getNombre()))
			desc = I18nMessages.VENDEDORES + " | TODOS";
		return desc;
	}

	public VendedorCriteria buildToService(){
		
		VendedorCriteria criteria = new VendedorCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		criteria.orderByNombre( Criteria.ORDER_ASC );
		return criteria;
	}	
}
