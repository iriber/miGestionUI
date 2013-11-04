package com.migestion.ui.criteria;

import com.migestion.model.Caja;
import com.migestion.services.criteria.MovimientoCajaCriteria;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de movimientos de caja para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class UIMovimientoCajaCriteria extends UICustomCriteria{

	//numero
	private Caja caja;
	
	public UIMovimientoCajaCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.MOVIMIENTOS_CAJA ;
		
		if( getCaja()!=null)
			desc +=  " | " + I18nMessages.MOVIMIENTO_CAJA_CAJA + ": '" + getCaja().toString(new I18nMessages()) + "' | " + I18nMessages.CAJA_SALDO_INICIAL + ":" + AppUtils.formatMoneda( getCaja().getSaldoInicial());
		
		return desc;
	}


	public MovimientoCajaCriteria buildToService(){
		
		MovimientoCajaCriteria criteria = new MovimientoCajaCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setCaja(getCaja());
		return criteria;
	}


	/**
	 * @return the caja
	 */
	public Caja getCaja() {
		return caja;
	}


	/**
	 * @param caja the caja to set
	 */
	public void setCaja(Caja caja) {
		this.caja = caja;
	}
	
}
