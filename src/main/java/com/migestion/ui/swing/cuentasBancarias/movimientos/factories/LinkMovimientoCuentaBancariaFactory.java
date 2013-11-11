package com.migestion.ui.swing.cuentasBancarias.movimientos.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para
 * movimientos de cuentas bancarias.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class LinkMovimientoCuentaBancariaFactory {



	/**
	 * link para listar movimientos de cuentas bancarias.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowMovimientoCuentaBancariaFactory.getWindowList(), I18nMessages.MOVIMIENTO_CUENTA_BANCARIA_FRAME_TITULO, I18nImages.MOVIMIENTOS_CUENTA_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
		
}