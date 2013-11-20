package com.migestion.ui.swing.pagos.dialog;


import java.awt.Container;

import com.migestion.model.Pago;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.swing.view.dialogs.DialogOkCancel;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.pagos.panel.PagoPanel;

/**
 * Diálogo para anular un pago
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 19/11/2013
 * 
 */
public class DialogAnularPago extends DialogOkCancel implements  ILinkWindowObjectOpen{

	//pago que será anulado
	protected Pago pago= null;

	private PagoPanel panel;
	
	/**
	 * 
	 */
	public DialogAnularPago(String title) {

		super(title);
	
	}

	/**
	 * 
	 * @param title
	 * @param controller
	 */
	public DialogAnularPago(String title, String pathImage) {
		
		super(title, pathImage);
		
	}

	
	
	/**
	 * se abre el diálogo centrado en la pantalla.
	 */
	public void open(Object object) {
		this.pago = (Pago)object;
		showPago();
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
			UIServiceFactory.getUIPagoService().anularPago(this.pago);
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
		
		panel = new PagoPanel();
		return panel.getViewPanel();

	}

	/**
	 * se muestra el pago a anular
	 * 
	 * @return
	 */
	protected void showPago(){
		
		panel.showObject(this.pago);
		
	}

	public Object getObjectUpdated() {
		return this.pago;
	}

	public void addToJFrameContainer(JFrameContainer container) {
		// TODO Auto-generated method stub
		
	}

}
