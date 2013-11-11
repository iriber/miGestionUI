package com.migestion.ui.context.observers;

import com.migestion.model.Producto;
import com.migestion.model.Venta;
import com.migestion.swing.context.ContextObserver;
import com.migestion.swing.context.IContextListener;
import com.migestion.ui.context.observers.listeners.IProductoListener;

/**
 * escucha cambios sobre los productos y avisa a sus subscriptores.
 * @author bernardo
 *
 */
public class ProductoObserver extends ContextObserver<Producto>{

	public void ventaChange(Venta venta) {

		for (IContextListener listener : listeners) {
			
			((IProductoListener)listener).ventaChange(venta);
		}
	}

}
