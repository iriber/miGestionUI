package com.migestion.ui.swing.operaciones.ventas.links;

import java.net.URL;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.exception.LinkException;
import com.migestion.swing.navigation.listeners.LinkAddListener;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.dialog.FrameAddVenta;

/**
 * Link para agregar un elemento. Llama a la ventana
 * para agregar un elemento.
 * 
 * @author Bernardo Iribarne
 *
 */
public class LinkAddVenta extends Link implements LinkAddListener{

	//ventana para crear la venta
	protected FrameAddVenta dialog;
	
	//objetos listeners que serán informados cuando
	//se cree el nuevo objeto
	private Vector listeners;
	
	
	public LinkAddVenta(FrameAddVenta dialog, String title, URL pathSmallIcon){
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
	
		
		//el link se hace oyente de la ventana y ante un update aviso a sus propios listeners.
		dialog.addListener( this );
	}
	
	
	/**
	 * se construye con la ventana que ser� invocada
	 * para cargar la informaci�n del nuevo objeto.
	 * si la ventana es nula, el link se deshabilitar�.
	 */
	public LinkAddVenta(FrameAddVenta dialog){
		this(dialog, I18nMessages.VENTA_ACCION_AGREGAR, LinkImagesBundle.link_Add);
		
	}
	
	/**
	 * se ejecuta la acción.
	 */
	protected void doMyExecute() throws LinkException{
		//se llama al diálogo para crear el objeto.
		getDialog().open();
		
	}

	/**
	 * se agrega un listener para avisarle y darle
	 * el objeto creado.
	 * 
	 * @param listener
	 */
	public void addListener(LinkAddListener listener){
		this.listeners.add(listener);
	}
	
	/*
	 * se avisa a los listener que el objeto
	 * fue creado.  
	 */
	private void alertListeners(Object objectCreated){
		Iterator iter = listeners.iterator();
		while (iter.hasNext()) {
			//le avisamos a cada listener
			LinkAddListener element = (LinkAddListener) iter.next();
			element.objectCreated( objectCreated );			
		}
	}
	
	protected FrameAddVenta getDialog(){
		return this.dialog;
	}


	/*
	 * (non-Javadoc)
	 * @see com.migestion.swing.navigation.listeners.LinkAddListener#objectCreated(java.lang.Object)
	 */
	public void objectCreated(Object objectCreated) {
		
		this.alertListeners(objectCreated);
		
	}
}
