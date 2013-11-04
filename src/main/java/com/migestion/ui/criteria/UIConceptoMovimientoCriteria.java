package com.migestion.ui.criteria;

import org.apache.commons.lang3.StringUtils;

import com.migestion.services.criteria.ConceptoMovimientoCriteria;
import com.migestion.services.criteria.Criteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de conceptos de caja para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class UIConceptoMovimientoCriteria extends UICustomCriteria{

	//nombre.
	private String nombre;
	
	
	public UIConceptoMovimientoCriteria() {
		
	}
	
	public UIConceptoMovimientoCriteria(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.CONCEPTOS_MOVIMIENTO ;
		
		if(StringUtils.isEmpty(getNombre()))
			desc +=  " | " + I18nMessages.CONCEPTO_MOVIMIENTO_NOMBRE + ": '" + getNombre() + "'";
		
		return desc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ConceptoMovimientoCriteria buildToService(){
		
		ConceptoMovimientoCriteria criteria = new ConceptoMovimientoCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNombre(getNombre());
		criteria.orderByNombre(Criteria.ORDER_ASC);
		return criteria;
	}	
}
