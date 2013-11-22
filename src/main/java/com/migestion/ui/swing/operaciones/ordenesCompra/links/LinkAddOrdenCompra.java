package com.migestion.ui.swing.operaciones.ordenesCompra.links;

import java.net.URL;
import java.util.Vector;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.exception.LinkException;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.dialog.FrameAddOrdenCompra;

/**
 * Link para agregar un elemento. Llama a la ventana
 * para agregar un elemento.
 * 
 * @author Bernardo Iribarne
 *
 */
public class LinkAddOrdenCompra extends Link {

	//ventana para crear la orden de compra
	protected FrameAddOrdenCompra dialog;
	
	//objetos listeners que serán informados cuando
	//se cree el nuevo objeto
	private Vector listeners;
	
	
	public LinkAddOrdenCompra(FrameAddOrdenCompra dialog, String title, URL pathSmallIcon){
		super ( title, pathSmallIcon);
		this.dialog = dialog;
		//inicializamos los listeners
		listeners = new Vector();
		//key stroke por default
		setKeyStroke(KeyStroke.getKeyStroke(LinkLabelsBundle.link_Add_KeyStroke));
		//key event por default
		//setKeyEvent(KeyEvent.VK_F6);
		//imagen del link
		setImageURL(pathSmallIcon);
		//descripci�n del link
		setDescription(title);
	
	}
	
	
	/**
	 * se construye con la ventana que ser� invocada
	 * para cargar la informaci�n del nuevo objeto.
	 * si la ventana es nula, el link se deshabilitar�.
	 */
	public LinkAddOrdenCompra(FrameAddOrdenCompra dialog){
		this(dialog, I18nMessages.ORDEN_COMPRA_ACCION_AGREGAR, LinkImagesBundle.link_Add);
		
	}
	
	/**
	 * se ejecuta la acción.
	 */
	protected void doMyExecute() throws LinkException{
		//se llama al diálogo para crear el objeto.
		getDialog().open();
		
	}
	protected FrameAddOrdenCompra getDialog(){
		return this.dialog;
	}

}
