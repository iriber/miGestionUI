package com.migestion.ui.swing.cajas.factories;


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
import com.migestion.ui.swing.cajas.CajasCRUDFrame;
import com.migestion.ui.swing.cajas.dialog.DialogFindCaja;
import com.migestion.ui.swing.cajas.panel.CajaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class WindowCajaFactory {


	/**
	 * ventana para buscar una caja.
	 */
	public static DialogFindCaja getWindowFind() {
		DialogFindCaja dialog = new  DialogFindCaja( I18nMessages.CAJA_DIALOG_BUSCAR_TITULO );
		return dialog;
	}
	
	/**
	 * ventana para agregar un producto.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.CAJA_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUICajaService(), new CajaPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

	/**
	 * ventana para modificar una caja.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.CAJA_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUICajaService(), new CajaPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar una caja.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.CAJA_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUICajaService(), new CajaPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar cajas.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		CRUDFrame frame = new CajasCRUDFrame(I18nMessages.CAJA_FRAME_TITULO, UIServiceFactory.getUICajaService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		return frame;
	}
	

//	/**
//	 * ventana para activar un producto.
//	 */
//	public static DialogActivarCaja getWindowActivar(){			    
//
//		DialogActivarCaja dialog = new DialogActivarCaja(I18nMessages.CAJA_DIALOG_ACTIVAR_TITULO);
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}
//		
//	/**
//	 * ventana para desactivar un producto.
//	 */
//	public static DialogDesactivarCaja getWindowDesactivar(){			    
//
//		DialogDesactivarCaja dialog = new DialogDesactivarCaja(I18nMessages.CAJA_DIALOG_DESACTIVAR_TITULO);
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}

}
