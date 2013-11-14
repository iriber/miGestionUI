package com.migestion.ui.swing.vendedores.factories;


import javax.swing.ImageIcon;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.dialogs.DialogAddObject;
import com.migestion.swing.view.dialogs.DialogDeleteObject;
import com.migestion.swing.view.dialogs.DialogUpdateObject;
import com.migestion.swing.view.dialogs.adapters.DialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.DialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.DialogUpdateAdapter;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.vendedores.VendedoresCRUDFrame;
import com.migestion.ui.swing.vendedores.dialog.DialogFindVendedor;
import com.migestion.ui.swing.vendedores.panel.VendedorPanel;

/**
 * Proporciona métodos para la creación de ventanas para vendedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 16/10/2013
 *
 */
public class WindowVendedorFactory {

	
	/**
	 * ventana para agregar un vendedor.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.VENDEDOR_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIVendedorService(), new VendedorPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

	/**
	 * ventana para modificar un vendedor.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.VENDEDOR_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIVendedorService(), new VendedorPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar un vendedor.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.VENDEDOR_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIVendedorService(), new VendedorPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar vendedores.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		VendedoresCRUDFrame frame = new VendedoresCRUDFrame(I18nMessages.VENDEDOR_FRAME_TITULO, UIServiceFactory.getUIVendedorService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		AppContext.getInstance().getVendedorObserver().addListener( frame );
		return frame;
	}
	
	/**
	 * ventana para buscar un vendedor.
	 */
	public static DialogFindVendedor getWindowFind() {
		DialogFindVendedor dialog = new  DialogFindVendedor( I18nMessages.VENDEDOR_DIALOG_BUSCAR_TITULO );
		return dialog;
	}


}
