package com.migestion.ui.swing.operaciones.ordenesCompra.factories;


import javax.swing.ImageIcon;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.dialogs.DialogDeleteObject;
import com.migestion.swing.view.dialogs.DialogViewObject;
import com.migestion.swing.view.dialogs.adapters.DialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.DialogViewAdapter;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.OrdenesCompraCRUDFrame;
import com.migestion.ui.swing.operaciones.ordenesCompra.dialog.DialogAnularOrdenCompra;
import com.migestion.ui.swing.operaciones.ordenesCompra.dialog.DialogFindOrdenCompra;
import com.migestion.ui.swing.operaciones.ordenesCompra.dialog.DialogRecibirOrdenCompra;
import com.migestion.ui.swing.operaciones.ordenesCompra.dialog.FrameAddOrdenCompra;
import com.migestion.ui.swing.operaciones.ordenesCompra.panel.OrdenCompraPanel;

/**
 * Proporciona métodos para la creación de ventanas para órdenes de compra.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class WindowOrdenCompraFactory {

	
	/**
	 * ventana para agregar un ordenCompra.
	 */
	public static FrameAddOrdenCompra getWindowAdd(){			    

		FrameAddOrdenCompra dialog = new FrameAddOrdenCompra( );
		//dialog.setResizable(true);
		dialog.setFrameIcon(new ImageIcon( LinkImagesBundle.link_Add ) );
		//AppContext.getInstance().addToContainer(dialog);
		//AppContext.getInstance().getMainContainer().addToDesktop(dialog);
		dialog.addToJFrameContainer(AppContext.getInstance().getMainContainer());
		return dialog;		
	}

//	/**
//	 * ventana para modificar un ordenCompra.
//	 */
//	public static DialogUpdateObject getWindowUpdate(){			    
//
//		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.ORDEN_COMPRA_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIOrdenCompraService(), new OrdenCompraPanel() );
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}
		
	/**
	 * ventana para eliminar un ordenCompra.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.ORDEN_COMPRA_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIOrdenCompraService(), new OrdenCompraPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para anular una ordenCompra.
	 */
	public static DialogAnularOrdenCompra getWindowAnular(){			    

		DialogAnularOrdenCompra dialog = new DialogAnularOrdenCompra(I18nMessages.ORDEN_COMPRA_DIALOG_ANULAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}	
	/**
	 * ventana para listar ordenCompras.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		OrdenesCompraCRUDFrame frame = new OrdenesCompraCRUDFrame(I18nMessages.ORDEN_COMPRA_FRAME_TITULO, UIServiceFactory.getUIOrdenCompraService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getOrdenCompraObserver().addListener( frame );
		
		return frame;
	}
	
	/**
	 * ventana para buscar un ordenCompra.
	 */
	public static DialogFindOrdenCompra getWindowFind() {
		DialogFindOrdenCompra dialog = new  DialogFindOrdenCompra( I18nMessages.ORDEN_COMPRA_DIALOG_BUSCAR_TITULO );
		return dialog;
	}

	
	/**
	 * ventana para visualizar una ordenCompra.
	 */
	public static DialogViewObject getWindowView(){			    
	
		DialogViewObject dialog = new DialogViewAdapter(I18nMessages.ORDEN_COMPRA_DIALOG_VER_TITULO, UIServiceFactory.getUIOrdenCompraService(), new OrdenCompraPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_View).getImage() );
		return dialog;
	
	}

	/**
	 * ventana para recibir una ordenCompra.
	 */
	public static DialogRecibirOrdenCompra getWindowRecibir(){			    

		DialogRecibirOrdenCompra dialog = new DialogRecibirOrdenCompra(I18nMessages.ORDEN_COMPRA_DIALOG_RECIBIR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}	

}
