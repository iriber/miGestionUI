package com.migestion.ui.swing.pagos.panel.detalles;

import java.util.List;

import com.migestion.model.DetalleFormaPago;
import com.migestion.ui.swing.pagos.UIDetalleFormaPagoCollection;


/**
 * Clase para modificar el modelo de la tabla de detalles de forma de pago.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 29/10/2013
 */
public class DetalleFormaPagoTableController {

	/** El modelo de la tabla */
	private UIDetalleFormaPagoCollection model = null;

	/**
	 * Constructor. Se le pasa el modelo
	 */
	public DetalleFormaPagoTableController(UIDetalleFormaPagoCollection model) {
		this.model = model;
	}

	/**
	 * nueva fila en el modelo, al final del mismo
	 */
	public void addElement(DetalleFormaPago detalle) {
		this.model.addElement(detalle);
	}

	/** Elimina la fila del modelo */
	public void deleteElement(int fila) {
		if (model.getRowCount() > fila)
			model.deleteElement(fila);
	}

	public List<DetalleFormaPago> getDetalles(){
		
		return this.model.getElements();
	}

}
