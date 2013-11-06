package com.migestion.ui.context;

import com.migestion.model.Pago;
import com.migestion.model.Venta;
import com.migestion.swing.context.IContextListener;

/**
 * Listener para el contexto de la aplicación.
 * 
 * @author bernardo
 *
 */
public interface IVentaListener extends IContextListener<Venta>{

	public void pagoVentaCreado(Pago pago);
	
}
