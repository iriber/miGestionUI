package com.migestion.ui.context;

import com.migestion.model.Pago;
import com.migestion.model.Venta;
import com.migestion.swing.context.ContextObserver;
import com.migestion.swing.context.IContextListener;

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
