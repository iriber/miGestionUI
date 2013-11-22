package com.migestion.ui.context.observers;

import com.migestion.model.OrdenCompra;
import com.migestion.model.Pago;
import com.migestion.swing.context.ContextObserver;
import com.migestion.swing.context.IContextListener;
import com.migestion.ui.context.observers.listeners.IOrdenCompraListener;

/**
 * escucha cambios sobre las órdenes de compra y avisa a sus subscriptores.
 * @author bernardo
 *
 */
public class OrdenCompraObserver extends ContextObserver<OrdenCompra>{

	public void pagoOrdenCompraCreado(Pago pago) {

		for (IContextListener listener : listeners) {
			
			((IOrdenCompraListener)listener).pagoOrdenCompraCreado(pago);
		}
	}

}
