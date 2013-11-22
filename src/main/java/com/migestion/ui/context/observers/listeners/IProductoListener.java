package com.migestion.ui.context.observers.listeners;

import com.migestion.model.OrdenCompra;
import com.migestion.model.Producto;
import com.migestion.model.Venta;
import com.migestion.swing.context.IContextListener;

/**
 * Listener para el contexto de la aplicación.
 * 
 * @author bernardo
 *
 */
public interface IProductoListener extends IContextListener<Producto>{

	public void ventaChange(Venta venta);
	
	public void ordenCompraChange(OrdenCompra ordenCompra);
}
