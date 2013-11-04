package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.SucursalCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de sucursales para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 25/10/2013
 *
 */
public class UISucursalCriteria extends UICustomCriteria{

	//nombre del producto.
	private String nombre;
	
	
	public UISucursalCriteria() {
		
	}
	
	public UISucursalCriteria(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.SUCURSALES ;
		
		if(StringUtils.isEmpty(getNombre()))
			desc +=  " | " + I18nMessages.SUCURSAL_NOMBRE + ": '" + getNombre() + "'";
		
		return desc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SucursalCriteria buildToService(){
		
		SucursalCriteria criteria = new SucursalCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		criteria.orderByNombre(Criteria.ORDER_ASC);
		return criteria;
	}	
}
