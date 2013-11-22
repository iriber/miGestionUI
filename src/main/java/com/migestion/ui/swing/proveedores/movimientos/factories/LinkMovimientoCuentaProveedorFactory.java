package com.migestion.ui.swing.proveedores.movimientos.factories;

import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para
 * movimientos de proveedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class LinkMovimientoCuentaProveedorFactory {



	/**
	 * link para listar movimientos de proveedores.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowMovimientoCuentaProveedorFactory.getWindowList(), I18nMessages.MOVIMIENTO_CUENTA_PROVEEDOR_FRAME_TITULO, I18nImages.MOVIMIENTOS_CUENTA_ICON);
		link.setKeyStroke( LinkHelper.LINK_MOVIMIENTOS_CUENTA_PROVEEDOR_KEY_STROKE );
		return link;
	}
		
}