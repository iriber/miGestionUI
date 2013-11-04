package com.migestion.ui.swing.operaciones.ventas.dialog;


import java.awt.Container;

import com.migestion.model.Venta;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.swing.view.dialogs.DialogOkCancel;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.operaciones.ventas.panel.VentaPanel;

/**
 * Diálogo para anular una venta
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 * 
 */
public class DialogAnularVenta extends DialogOkCancel implements ILinkWindowUpdate{

	//venta que será anulada
	protected Venta venta= null;

	private VentaPanel panel;
	
	/**
	 * 
	 */
	public DialogAnularVenta(String title) {

		super(title);
	
	}

	/**
	 * 
	 * @param title
	 * @param controller
	 */
	public DialogAnularVenta(String title, String pathImage) {
		
		super(title, pathImage);
		
	}

	
	
	/**
	 * se abre el diálogo centrado en la pantalla.
	 */
	public void open(Object object) {
		this.venta = (Venta)object;
		showVenta();
		open();
	}
	
	/**
	 * se acepta la operación.
	 * si hay algín error, se informa el mismo.
	 * si todo estó ok, la operación se concluye y se
	 * cierra la ventana.
	 */
	protected void doOk(){		
		try {			
			UIServiceFactory.getUIVentaService().anularVenta(this.venta);
			this.accepted = true;
			this.dispose();
		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage(getTitle(), e.getMessage());
		}
	}
	
	
	/**
	 * retorna el panel donde se mostrará el producto.
	 * 
	 */
	protected Container createInfoPanel(){
		
		panel = new VentaPanel();
		return panel.getViewPanel();

	}

	/**
	 * se muestra la venta a anular
	 * 
	 * @return
	 */
	protected void showVenta(){
		
		panel.showObject(this.venta);
		
		
	}

	public Object getObjectUpdated() {
		return this.venta;
	}

}
