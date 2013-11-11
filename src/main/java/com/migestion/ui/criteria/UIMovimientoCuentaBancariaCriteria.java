package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.CuentaBancaria;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.MovimientoCuentaBancariaCriteria;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de movimientos de cuentas bancarias para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class UIMovimientoCuentaBancariaCriteria extends UICustomCriteria{

	private CuentaBancaria cuentaBancaria;
	
	private Date fecha;

	public UIMovimientoCuentaBancariaCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.MOVIMIENTOS_CUENTA_BANCARIA;
		
		if( getCuentaBancaria()!=null)
			desc +=  " | " + I18nMessages.MOVIMIENTO_CUENTA_BANCARIA_CUENTA + ": '" + getCuentaBancaria().toString() ;//+ "' | " + I18nMessages.CAJA_SALDO_INICIAL + ":" + AppUtils.formatMoneda( getCuentaBancaria().getSaldoInicial());
		
		if( getFecha()!=null)
			desc +=  " | " + I18nMessages.MOVIMIENTO_CUENTA_FECHA_HORA + ": '" + AppUtils.formatDate( getFecha());
		
		return desc;
	}


	public MovimientoCuentaBancariaCriteria buildToService(){
		
		MovimientoCuentaBancariaCriteria criteria = new MovimientoCuentaBancariaCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setFecha(getFecha());
		criteria.setCuentaBancaria(getCuentaBancaria());
		criteria.orderByFechaHora( Criteria.ORDER_DESC );
		
		return criteria;
	}


	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}


	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	
}
