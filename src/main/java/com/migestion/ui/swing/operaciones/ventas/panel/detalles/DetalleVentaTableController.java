package com.migestion.ui.swing.operaciones.ventas.panel.detalles;

import java.util.List;

import com.migestion.model.DetalleVenta;
import com.migestion.ui.swing.operaciones.ventas.UIDetalleVentaCollection;


/**
 * Clase para modificar el modelo de la tabla de detalles de venta.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 */
public class DetalleVentaTableController {

	/** El modelo de la tabla */
	private UIDetalleVentaCollection model = null;

	/**
	 * Constructor. Se le pasa el modelo
	 */
	public DetalleVentaTableController(UIDetalleVentaCollection model) {
		this.model = model;
	}

	/**
	 * nueva fila en el modelo, al final del mismo
	 */
	public void addElement(DetalleVenta detalle) {
		this.model.addElement(detalle);
	}

	/** Elimina la fila del modelo */
	public void deleteElement(int fila) {
		if (model.getRowCount() > fila)
			model.deleteElement(fila);
	}

	public List<DetalleVenta> getDetalles(){
		
		return this.model.getElements();
	}

}
