package com.migestion.ui.swing.cajas.movimientos.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para
 * movimientos de caja.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class LinkMovimientoCajaFactory {



	/**
	 * link para listar movimientos de caja.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowMovimientoCajaFactory.getWindowList(), I18nMessages.MOVIMIENTO_CAJA_FRAME_TITULO, I18nImages.MOVIMIENTOS_CUENTA_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
		
}