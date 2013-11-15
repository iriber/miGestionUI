package com.migestion.ui.swing.operaciones.ventas.factories;


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
import com.migestion.ui.swing.operaciones.ventas.VentasCRUDFrame;
import com.migestion.ui.swing.operaciones.ventas.dialog.DialogAnularVenta;
import com.migestion.ui.swing.operaciones.ventas.dialog.DialogFindVenta;
import com.migestion.ui.swing.operaciones.ventas.dialog.FrameAddVenta;
import com.migestion.ui.swing.operaciones.ventas.panel.VentaPanel;

/**
 * Proporciona métodos para la creación de ventanas para ventas.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public class WindowVentaFactory {

	
	/**
	 * ventana para agregar un venta.
	 */
	public static FrameAddVenta getWindowAdd(){			    

		FrameAddVenta dialog = new FrameAddVenta( );
		//dialog.setResizable(true);
		dialog.setFrameIcon(new ImageIcon( LinkImagesBundle.link_Add ) );
		//AppContext.getInstance().addToContainer(dialog);
		//AppContext.getInstance().getMainContainer().addToDesktop(dialog);
		dialog.addToJFrameContainer(AppContext.getInstance().getMainContainer());
		return dialog;		
	}

//	/**
//	 * ventana para modificar un venta.
//	 */
//	public static DialogUpdateObject getWindowUpdate(){			    
//
//		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.VENTA_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIVentaService(), new VentaPanel() );
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}
		
	/**
	 * ventana para eliminar un venta.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.VENTA_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIVentaService(), new VentaPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para anular una venta.
	 */
	public static DialogAnularVenta getWindowAnular(){			    

		DialogAnularVenta dialog = new DialogAnularVenta(I18nMessages.VENTA_DIALOG_ANULAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}	
	/**
	 * ventana para listar ventas.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		VentasCRUDFrame frame = new VentasCRUDFrame(I18nMessages.VENTA_FRAME_TITULO, UIServiceFactory.getUIVentaService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getVentaObserver().addListener( frame );
		
		return frame;
	}
	
	/**
	 * ventana para buscar un venta.
	 */
	public static DialogFindVenta getWindowFind() {
		DialogFindVenta dialog = new  DialogFindVenta( I18nMessages.VENTA_DIALOG_BUSCAR_TITULO );
		return dialog;
	}

	
	/**
	 * ventana para visualizar una venta.
	 */
	public static DialogViewObject getWindowView(){			    
	
		DialogViewObject dialog = new DialogViewAdapter(I18nMessages.VENTA_DIALOG_VER_TITULO, UIServiceFactory.getUIVentaService(), new VentaPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_View).getImage() );
		return dialog;
	
	}

}
