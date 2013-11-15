package com.migestion.ui.swing.proveedores.factories;


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
import com.migestion.ui.swing.proveedores.ProveedoresCRUDFrame;
import com.migestion.ui.swing.proveedores.dialog.DialogFindProveedor;
import com.migestion.ui.swing.proveedores.panel.ProveedorPanel;

/**
 * Proporciona métodos para la creación de ventanas para proveedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class WindowProveedorFactory {

	
	/**
	 * ventana para agregar un proveedor.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.PROVEEDOR_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIProveedorService(), new ProveedorPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		
		//dialog.setPreferredSize( new Dimension(1200,450) );
		//dialog.setMinimumSize( new Dimension(1200,450) );
		//dialog.pack();
		return dialog;
	}

	/**
	 * ventana para modificar un proveedor.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.PROVEEDOR_DIALOG_MODIFICAR_TITULO, UIServiceFactory.getUIProveedorService(), new ProveedorPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar un proveedor.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PROVEEDOR_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIProveedorService(), new ProveedorPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar proveedores.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		
		ProveedoresCRUDFrame frame = new ProveedoresCRUDFrame(I18nMessages.PROVEEDOR_FRAME_TITULO, UIServiceFactory.getUIProveedorService());
		
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getProveedorObserver().addListener( frame );
		
		return frame;
	}
	
	/**
	 * ventana para buscar un proveedor.
	 */
	public static DialogFindProveedor getWindowFind() {
		DialogFindProveedor dialog = new  DialogFindProveedor( I18nMessages.PROVEEDOR_DIALOG_BUSCAR_TITULO );
		return dialog;
	}


}
