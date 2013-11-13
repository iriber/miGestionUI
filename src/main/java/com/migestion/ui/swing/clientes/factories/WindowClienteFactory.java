package com.migestion.ui.swing.clientes.factories;


import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

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
import com.migestion.ui.swing.clientes.ClientesCRUDFrame;
import com.migestion.ui.swing.clientes.dialog.DialogFindCliente;
import com.migestion.ui.swing.clientes.panel.ClientePanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para clientes.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class WindowClienteFactory {

	
	/**
	 * ventana para agregar un cliente.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.CLIENTE_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIClienteService(), new ClientePanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		
		//dialog.setPreferredSize( new Dimension(1200,450) );
		//dialog.setMinimumSize( new Dimension(1200,450) );
		//dialog.pack();
		return dialog;
	}

	/**
	 * ventana para modificar un cliente.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.CLIENTE_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIClienteService(), new ClientePanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar un cliente.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.CLIENTE_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIClienteService(), new ClientePanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar clientes.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		
		ClientesCRUDFrame frame = new ClientesCRUDFrame(I18nMessages.CLIENTE_FRAME_TITULO, UIServiceFactory.getUIClienteService());
		
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getClienteObserver().addListener( frame );
		
		return frame;
	}
	
	/**
	 * ventana para buscar un cliente.
	 */
	public static DialogFindCliente getWindowFind() {
		DialogFindCliente dialog = new  DialogFindCliente( I18nMessages.CLIENTE_DIALOG_BUSCAR_TITULO );
		return dialog;
	}


}
