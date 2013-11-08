package com.migestion.ui.swing.balances.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para balances.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 07/11/2013
 *
 */
public class LinkBalanceFactory {


	/**
	 * link para el balance diario.
	 */
	public static Link getLinkBalanceDiario(){			    
		//return LinkAddCuenta.getInstance();
		Link link =  new LinkOpenDialog(I18nMessages.BALANCE_DIARIO_ACCION_CONSULTAR, I18nImages.BALANCE_ICON) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowBalanceFactory.getWindowBalanceDiario();
			}
			
		};
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
		
	}
	
}
