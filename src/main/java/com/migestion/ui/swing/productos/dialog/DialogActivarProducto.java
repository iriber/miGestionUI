package com.migestion.ui.swing.productos.dialog;


import java.awt.Container;

import com.migestion.model.Producto;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.swing.view.dialogs.DialogOkCancel;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.productos.panel.ProductoPanel;
import com.migestion.ui.swing.productos.panel.ProductoPanel2;

/**
 * Diálogo para activar un producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 * 
 */
public class DialogActivarProducto extends DialogOkCancel implements ILinkWindowObjectOpen{

	//producto que será activado
	protected Producto producto = null;

	private ProductoPanel2 panel;
	
	//----------------
	// CONSTRUCTORES
	//----------------

	/**
	 * 
	 */
	public DialogActivarProducto(String title) {

		super(title);
	
	}

	/**
	 * 
	 * @param title
	 * @param controller
	 */
	public DialogActivarProducto(String title, String pathImage) {
		
		super(title, pathImage);
		
	}

	
	
	/**
	 * se abre el diálogo centrado en la pantalla.
	 */
	public void open(Object object) {
		this.producto = (Producto)object;
		showProducto();
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
			UIServiceFactory.getUIProductoService().activar(this.producto);
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
		
		panel = new ProductoPanel2();
		return panel.getViewPanel();

	}

	/**
	 * se muestra el producto a activar.
	 * 
	 * @return
	 */
	protected void showProducto(){
		
		panel.showObject(this.producto);
		
		
	}

	public Object getObjectUpdated() {
		return this.producto;
	}

	public void addToJFrameContainer(JFrameContainer container) {
		// TODO Auto-generated method stub
		
	}

}
