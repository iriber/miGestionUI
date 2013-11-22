package com.migestion.ui.swing.clientes.movimientos.factories;

import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para
 * movimientos de clientes.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class LinkMovimientoCuentaClienteFactory {



	/**
	 * link para listar movimientos de clientes.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowMovimientoCuentaClienteFactory.getWindowList(), I18nMessages.MOVIMIENTO_CUENTA_CLIENTE_FRAME_TITULO, I18nImages.MOVIMIENTOS_CUENTA_ICON);
		link.setKeyStroke( LinkHelper.LINK_MOVIMIENTOS_CUENTA_CLIENTE_KEY_STROKE );
		return link;
	}
		
}