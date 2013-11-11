package com.migestion.ui.context.observers;

import com.migestion.model.Pago;
import com.migestion.model.Venta;
import com.migestion.swing.context.ContextObserver;
import com.migestion.swing.context.IContextListener;
import com.migestion.ui.context.observers.listeners.IVentaListener;

/**
 * escucha cambios sobre las ventas y avisa a sus subscriptores.
 * @author bernardo
 *
 */
public class VentaObserver extends ContextObserver<Venta>{

	public void pagoVentaCreado(Pago pago) {

		for (IContextListener listener : listeners) {
			
			((IVentaListener)listener).pagoVentaCreado(pago);
		}
	}

}
