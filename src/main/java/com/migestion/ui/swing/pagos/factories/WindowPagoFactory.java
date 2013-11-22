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
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.PagosCRUDFrame;
import com.migestion.ui.swing.pagos.dialog.DialogAnularPago;
import com.migestion.ui.swing.pagos.dialog.FrameAddPagoOrdenCompra;
import com.migestion.ui.swing.pagos.dialog.FrameAddPagoVenta;
import com.migestion.ui.swing.pagos.panel.PagoClientePanel;

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
		dialog.setFrameIcon(new ImageIcon( I18nImages.BOTON_PAGAR ) );
		//AppContext.getInstance().addToContainer(dialog);
		//AppContext.getInstance().getMainContainer().addToDesktop(dialog);
		dialog.addToJFrameContainer(AppContext.getInstance().getMainContainer());		
		return dialog;		
	}

	/**
	 * para pagar una orden de compra.
	 */
	public static FrameAddPagoOrdenCompra getWindowPagarOrdenCompra(){			    

		FrameAddPagoOrdenCompra dialog = new FrameAddPagoOrdenCompra( );
		//dialog.setResizable(true);
		dialog.setFrameIcon(new ImageIcon( I18nImages.BOTON_PAGAR ) );
		//AppContext.getInstance().addToContainer(dialog);
		//AppContext.getInstance().getMainContainer().addToDesktop(dialog);
		dialog.addToJFrameContainer(AppContext.getInstance().getMainContainer());		
		return dialog;		
	}

	/**
	 * pagona para eliminar un pago.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PAGO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIPagoClienteService(), new PagoClientePanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * pagona para anular una pago.
	 */
	public static DialogAnularPago getWindowAnular(){			    

		DialogAnularPago dialog = new DialogAnularPago(I18nMessages.PAGO_DIALOG_ANULAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}	
	
	/**
	 * pagona para listar pagos.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		PagosCRUDFrame frame = new PagosCRUDFrame(I18nMessages.PAGO_FRAME_TITULO, UIServiceFactory.getUIPagoClienteService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getPagoClienteObserver().addListener( frame );
		
//		AppContext.getInstance().addPagoListener( frame );
		
		return frame;
	}
	

	
	/**
	 * pagona para visualizar una pago.
	 */
	public static DialogViewObject getWindowView(){			    
	
		DialogViewObject dialog = new DialogViewAdapter(I18nMessages.PAGO_DIALOG_VER_TITULO, UIServiceFactory.getUIPagoClienteService(), new PagoClientePanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_View).getImage() );
		return dialog;
	
	}

}
