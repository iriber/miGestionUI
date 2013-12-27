package com.migestion.ui.swing.operaciones.ordenesCompra.dialog;


import java.awt.Container;

import com.migestion.model.DetalleOperacion;
import com.migestion.model.DetalleOrdenCompra;
import com.migestion.model.OrdenCompra;
import com.migestion.services.ServiceFactory;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.swing.view.dialogs.DialogOkCancel;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.operaciones.ordenesCompra.panel.OrdenCompraPanel;

/**
 * Diálogo para recibir una orden de compra
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 01/12/2013
 * 
 */
public class DialogRecibirOrdenCompra extends DialogOkCancel implements  ILinkWindowObjectOpen{

	//ordenCompra que será recibida
	protected OrdenCompra ordenCompra= null;

	private OrdenCompraPanel panel;
	
	/**
	 * 
	 */
	public DialogRecibirOrdenCompra(String title) {

		super(title);
	
	}

	/**
	 * 
	 * @param title
	 * @param controller
	 */
	public DialogRecibirOrdenCompra(String title, String pathImage) {
		
		super(title, pathImage);
		
	}

	
	
	/**
	 * se abre el diálogo centrado en la pantalla.
	 */
	public void open(Object object) {
		this.ordenCompra = (OrdenCompra)object;
		showOrdenCompra();
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
			
			//marcamos como recibidos todos los productos
			for (DetalleOperacion detalle : this.ordenCompra.getDetalles() ) {
				((DetalleOrdenCompra)detalle).setCantidadEntregada( detalle.getCantidad()  );
			}
			
			UIServiceFactory.getUIOrdenCompraService().recibirOrdenCompra(this.ordenCompra);
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
		
		panel = new OrdenCompraPanel();
		return panel.getViewPanel();

	}

	/**
	 * se muestra la ordenCompra a anular
	 * 
	 * @return
	 */
	protected void showOrdenCompra(){
		
		panel.showObject(this.ordenCompra);
		
	}

	public Object getObjectUpdated() {
		return this.ordenCompra;
	}

	public void addToJFrameContainer(JFrameContainer container) {
		// TODO Auto-generated method stub
		
	}

}
