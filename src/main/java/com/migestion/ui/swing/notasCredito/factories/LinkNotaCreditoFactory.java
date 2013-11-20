package com.migestion.ui.swing.notasCredito.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para notas de crédito.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class LinkNotaCreditoFactory {


	/**
	 * link para listar notas de crédito.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowNotaCreditoFactory.getWindowList(), I18nMessages.NOTA_CREDITO_ACCION_LISTAR, I18nImages.NOTAS_CREDITO_ICON);
		link.setKeyStroke( LinkHelper.LINK_NOTAS_CREDITO_KEY_STROKE );
		return link;
	}
	
	
}
