package com.migestion.ui.swing.gastos.factories;

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
 * Proporciona métodos para la construcción de links para gastos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 *
 */
public class LinkGastoFactory {


	/**
	 * link para listar gastos.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowGastoFactory.getWindowList(), I18nMessages.GASTO_ACCION_LISTAR, I18nImages.GASTOS_ICON);
		link.setKeyStroke( LinkHelper.LINK_GASTOS_KEY_STROKE );
		return link;
	}
	
	/**
	 * link para agregar un gasto.
	 */
	public static Link getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		Link link =  new LinkOpenDialog(I18nMessages.GASTO_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowGastoFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}


	/**
	 * link para eliminar un gasto.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.GASTO_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowGastoFactory.getWindowDelete();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
		
	}
	
}
