package com.migestion.ui.swing.cheques.movimientos.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para
 * movimientos de cheques.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 *
 */
public class LinkMovimientoChequeFactory {



	/**
	 * link para listar movimientos de cheques.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowMovimientoChequeFactory.getWindowList(), I18nMessages.MOVIMIENTO_CHEQUE_FRAME_TITULO, I18nImages.MOVIMIENTOS_CUENTA_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
		
}