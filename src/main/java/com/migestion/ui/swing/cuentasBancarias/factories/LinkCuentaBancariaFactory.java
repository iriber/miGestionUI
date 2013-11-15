package com.migestion.ui.swing.cuentasBancarias.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para cuentasBancarias.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class LinkCuentaBancariaFactory {


	/**
	 * link para agregar un cuentaBancaria.
	 */
	public static Link getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		Link link =  new LinkOpenDialog(I18nMessages.CUENTA_BANCARIA_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowCuentaBancariaFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}


	/**
	 * link para modificar un cuentaBancaria.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		//return LinkAddCuenta.getInstance();
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CUENTA_BANCARIA_ACCION_MODIFICAR,LinkImagesBundle.link_Update) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowCuentaBancariaFactory.getWindowUpdate();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_UPDATE_KEY_STROKE );
		return link;
		
	}


	/**
	 * link para eliminar un cuentaBancaria.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		
		//return LinkAddCuenta.getInstance();
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CUENTA_BANCARIA_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowCuentaBancariaFactory.getWindowDelete();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
		
	}

	/**
	 * link para listar cuentasBancarias.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowCuentaBancariaFactory.getWindowList(), I18nMessages.CUENTA_BANCARIA_ACCION_LISTAR, I18nImages.CUENTAS_BANCARIAS_ICON);
		link.setKeyStroke( LinkHelper.LINK_CUENTAS_BANCARIAS_KEY_STROKE );
		return link;
	}
	
	
	
}
