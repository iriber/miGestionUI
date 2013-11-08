package com.migestion.ui.swing.balances.factories;


import java.awt.Frame;

import javax.swing.ImageIcon;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.ui.swing.balances.DialogBalanceDiario;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para balances.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 07/11/2013
 *
 */
public class WindowBalanceFactory {


	/**
	 * ventana para agregar un producto.
	 */
	public static DialogBalanceDiario getWindowBalanceDiario(){			    

		DialogBalanceDiario dialog = new DialogBalanceDiario( new Frame(), true);
		dialog.setTitle(I18nMessages.BALANCE_DIARIO_DIALOG_VER_TITULO );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

}
