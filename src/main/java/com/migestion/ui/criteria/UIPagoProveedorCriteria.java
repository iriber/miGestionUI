package com.migestion.ui.criteria;

import com.migestion.model.Proveedor;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.PagoProveedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Criteria de pagos a proveedores para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class UIPagoProveedorCriteria extends UIPagoCriteria{


	/**
	 * proveedor
	 */
	private Proveedor proveedor;
	


	public UIPagoProveedorCriteria() {
		
	}


	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		//TODO pago a proveedores.
		String desc = I18nMessages.PAGOS;
		return desc;
	}	
	

	public PagoProveedorCriteria buildToService(){
		
		PagoProveedorCriteria criteria = new PagoProveedorCriteria();
		
		criteria.setProveedor( getProveedor() );
		criteria.setFechaDesde( getFechaDesde() );
		criteria.setFechaHasta( getFechaHasta() );
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.orderByFecha( Criteria.ORDER_DESC );
		criteria.orderByCodigo( Criteria.ORDER_DESC );
		return criteria;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
}