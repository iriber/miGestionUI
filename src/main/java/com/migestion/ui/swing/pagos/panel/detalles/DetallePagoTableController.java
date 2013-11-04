package com.migestion.ui.swing.pagos.panel.detalles;

import java.util.List;

import com.migestion.model.DetallePago;
import com.migestion.ui.swing.pagos.UIDetallePagoCollection;


/**
 * Clase para modificar el modelo de la tabla de detalles de pago.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 */
public class DetallePagoTableController {

	/** El modelo de la tabla */
	private UIDetallePagoCollection model = null;

	/**
	 * Constructor. Se le pasa el modelo
	 */
	public DetallePagoTableController(UIDetallePagoCollection model) {
		this.model = model;
	}

	/**
	 * nueva fila en el modelo, al final del mismo
	 */
	public void addElement(DetallePago detalle) {
		this.model.addElement(detalle);
	}

	/** Elimina la fila del modelo */
	public void deleteElement(int fila) {
		if (model.getRowCount() > fila)
			model.deleteElement(fila);
	}

	public List<DetallePago> getDetalles(){
		
		return this.model.getElements();
	}

}
