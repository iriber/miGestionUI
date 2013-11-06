package com.migestion.ui.swing.operaciones.ventas;

import com.migestion.model.Pago;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.swing.view.frames.ICRUDFrame;
import com.migestion.ui.context.IVentaListener;

public class VentasFrame extends CRUDFrame implements IVentaListener{

	public VentasFrame(String title, IControllerList controller,
			ICRUDFrame icrudFrame) {
		super(title, controller, icrudFrame);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void pagoVentaCreado(Pago pago) {
		refreshTable();
	}

}
