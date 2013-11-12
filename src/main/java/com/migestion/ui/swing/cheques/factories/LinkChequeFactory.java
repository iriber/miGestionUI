package com.migestion.ui.swing.cheques.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.factories.WindowProductoFactory;


/**
 * Proporciona métodos para la construcción de links para cheques.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 07/11/2013
 *
 */
public class LinkChequeFactory {

	/**
	 * link para agregar un cheque
	 */
	public static LinkOpenDialog getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		LinkOpenDialog link =  new LinkOpenDialog(I18nMessages.CHEQUE_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowChequeFactory.getWindowAdd();
			}
			
		};
		return link;
		
	}

	/**
	 * link para listar cheques.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowChequeFactory.getWindowList(), I18nMessages.CHEQUE_ACCION_LISTAR, I18nImages.CHEQUES_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
}