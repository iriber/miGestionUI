package com.migestion.ui.swing.operaciones.ordenesCompra.panel.detalles;

import java.util.List;

import com.migestion.model.DetalleOrdenCompra;
import com.migestion.ui.swing.operaciones.ordenesCompra.UIDetalleOrdenCompraCollection;


/**
 * Clase para modificar el modelo de la tabla de detalles de orden de compra.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 */
public class DetalleOrdenCompraTableController {

	/** El modelo de la tabla */
	private UIDetalleOrdenCompraCollection model = null;

	/**
	 * Constructor. Se le pasa el modelo
	 */
	public DetalleOrdenCompraTableController(UIDetalleOrdenCompraCollection model) {
		this.model = model;
	}

	/**
	 * nueva fila en el modelo, al final del mismo
	 */
	public void addElement(DetalleOrdenCompra detalle) {
		this.model.addElement(detalle);
	}

	/** Elimina la fila del modelo */
	public void deleteElement(int fila) {
		if (model.getRowCount() > fila)
			model.deleteElement(fila);
	}

	public List<DetalleOrdenCompra> getDetalles(){
		
		return this.model.getElements();
	}

}
