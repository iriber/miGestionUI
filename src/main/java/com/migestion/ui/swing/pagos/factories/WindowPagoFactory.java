package com.migestion.ui.swing.pagos.factories;


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
import com.migestion.ui.swing.pagos.PagosCRUDFrame;
import com.migestion.ui.swing.pagos.dialog.FrameAddPagoVenta;
import com.migestion.ui.swing.pagos.panel.PagoPanel;

/**
 * Proporciona métodos para la creación de pagonas para pagos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public class WindowPagoFactory {


	/**
	 * para pagar una venta.
	 */
	public static FrameAddPagoVenta getWindowPagarVenta(){			    

		FrameAddPagoVenta dialog = new FrameAddPagoVenta( );
		//dialog.setResizable(true);
		dialog.setFrameIcon(new ImageIcon( LinkImagesBundle.link_Add ) );
		//AppContext.getInstance().addToContainer(dialog);
		AppContext.getInstance().getMainContainer().addToDesktop(dialog);
		
		return dialog;		
	}


	
//	/**
//	 * pagona para agregar un pago.
//	 */
//	public static FrameAddPago getWindowAdd(){			    
//
//		FrameAddPago dialog = new FrameAddPago( );
//		//dialog.setResizable(true);
//		dialog.setFrameIcon(new ImageIcon( LinkImagesBundle.link_Add ) );
//		//AppContext.getInstance().addToContainer(dialog);
//		AppContext.getInstance().getMainContainer().addToDesktop(dialog);
//		
//		return dialog;		
//	}

//	/**
//	 * pagona para modificar un pago.
//	 */
//	public static DialogUpdateObject getWindowUpdate(){			    
//
//		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.PAGO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIPagoService(), new PagoPanel() );
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}
		
	/**
	 * pagona para eliminar un pago.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PAGO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIPagoService(), new PagoPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

//	/**
//	 * pagona para anular una pago.
//	 */
//	public static DialogAnularPago getWindowAnular(){			    
//
//		DialogAnularPago dialog = new DialogAnularPago(I18nMessages.PAGO_DIALOG_ANULAR_TITULO);
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}	
	/**
	 * pagona para listar pagos.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		CRUDFrame frame = new CRUDFrame(I18nMessages.PAGO_FRAME_TITULO, UIServiceFactory.getUIPagoService(), new PagosCRUDFrame());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		//AppContext.getInstance().addPagoListener( frame );
		
		return frame;
	}
	

	
	/**
	 * pagona para visualizar una pago.
	 */
	public static DialogViewObject getWindowView(){			    
	
		DialogViewObject dialog = new DialogViewAdapter(I18nMessages.PAGO_DIALOG_VER_TITULO, UIServiceFactory.getUIPagoService(), new PagoPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_View).getImage() );
		return dialog;
	
	}

}
