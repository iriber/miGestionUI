package com.migestion.ui.context.observers.listeners;

import com.migestion.model.OrdenCompra;
import com.migestion.model.Pago;
import com.migestion.swing.context.IContextListener;

/**
 * Listener para el contexto de la aplicación.
 * 
 * @author bernardo
 *
 */
public interface IOrdenCompraListener extends IContextListener<OrdenCompra>{

	public void pagoOrdenCompraCreado(Pago pago);
	
}
