package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.ClienteCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de clientes para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class UIClienteCriteria extends UIPersonaCriteria{

	
	public UIClienteCriteria() {

		super();
	}
	
	public UIClienteCriteria(String nombre) {
		super(nombre);
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		String desc = I18nMessages.CLIENTES + " | " + I18nMessages.CLIENTE_NOMBRE + ": '" + getNombre() + "'";
		if(StringUtils.isEmpty(getNombre()))
			desc = I18nMessages.CLIENTES + " | TODOS";
		return desc;
	}

	public ClienteCriteria buildToService(){
		
		ClienteCriteria criteria = new ClienteCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		return criteria;
	}	
}
