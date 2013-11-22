package com.migestion.ui.criteria;

import java.util.Date;

import com.migestion.model.Proveedor;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.MovimientoCuentaProveedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de movimientos de cuentas de proveedores para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class UIMovimientoCuentaProveedorCriteria extends UICustomCriteria{

	private Proveedor proveedor;
	
	private Date fechaDesde;
	private Date fechaHasta;
	
	public UIMovimientoCuentaProveedorCriteria() {
		
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.MOVIMIENTOS_CUENTA_PROVEEDOR;
		
		if( getProveedor()!=null)
			desc +=  " | " + I18nMessages.MOVIMIENTO_CUENTA_PROVEEDOR_PROVEEDOR + ": '" + getProveedor().toString() ;
		
		return desc;
	}


	public MovimientoCuentaProveedorCriteria buildToService(){
		
		MovimientoCuentaProveedorCriteria criteria = new MovimientoCuentaProveedorCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setFechaDesde(getFechaDesde());
		criteria.setFechaHasta(getFechaHasta());
		criteria.setProveedor(getProveedor());
		criteria.orderByFechaHora( Criteria.ORDER_DESC );
		
		return criteria;
	}



	public Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}


	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	
}
