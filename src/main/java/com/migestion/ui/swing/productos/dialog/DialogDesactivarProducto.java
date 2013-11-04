package com.migestion.ui.swing.productos.dialog;


import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.service.UIServiceFactory;

/**
 * Diálogo para desactivar un producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 * 
 */
public class DialogDesactivarProducto extends DialogActivarProducto{

	public DialogDesactivarProducto(String title) {
		super(title);
	}

	/*
	 * (non-Javadoc)
	 * @see com.migestion.ui.swing.productos.dialog.DialogActivarProducto#doOk()
	 */
	protected void doOk(){		
		try {			
			UIServiceFactory.getUIProductoService().desactivar(this.producto);
			this.accepted = true;
			this.dispose();
		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage(getTitle(), e.getMessage());
		}
	}
	

}
