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
import com.migestion.ui.swing.pagos.PagosClienteCRUDFrame;
import com.migestion.ui.swing.pagos.PagosProveedorCRUDFrame;
import com.migestion.ui.swing.pagos.dialog.DialogAnularPago;
import com.migestion.ui.swing.pagos.dialog.FrameAddPagoOrdenCompra;
import com.migestion.ui.swing.pagos.dialog.FrameAddPagoVenta;
import com.migestion.ui.swing.pagos.panel.PagoClientePanel;
import com.migestion.ui.swing.pagos.panel.PagoProveedorPanel;

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
	 * ventana para eliminar un pago de cliente.
	 */
	public static DialogDeleteObject getWindowDeletePagoCliente(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PAGO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIPagoClienteService(), new PagoClientePanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para eliminar un pago a proveedor.
	 */
	public static DialogDeleteObject getWindowDeletePagoProveedor(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PAGO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIPagoProveedorService(), new PagoProveedorPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para anular un pago de cliente.
	 */
	public static DialogAnularPago getWindowAnularPagoCliente(){			    

		DialogAnularPago dialog = new DialogAnularPago(I18nMessages.PAGO_DIALOG_ANULAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}	

	/**
	 * ventana para anular un pago a proveedor.
	 */
	public static DialogAnularPago getWindowAnularPagoProveedor(){			    

		DialogAnularPago dialog = new DialogAnularPago(I18nMessages.PAGO_DIALOG_ANULAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}	

	/**
	 * ventana para listar pagos de clientes.
	 * @return
	 */
	public static CRUDFrame getWindowListPagoCliente(){
		PagosClienteCRUDFrame frame = new PagosClienteCRUDFrame(I18nMessages.PAGO_FRAME_TITULO, UIServiceFactory.getUIPagoClienteService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getPagoClienteObserver().addListener( frame );
		
//		AppContext.getInstance().addPagoListener( frame );
		
		return frame;
	}
	

	/**
	 * ventana para listar pagos a proveedores.
	 * @return
	 */
	public static CRUDFrame getWindowListPagoProveedor(){
		PagosProveedorCRUDFrame frame = new PagosProveedorCRUDFrame(I18nMessages.PAGO_PROVEEDOR_FRAME_TITULO, UIServiceFactory.getUIPagoProveedorService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getPagoProveedorObserver().addListener( frame );
		
		return frame;
	}
	
	
	/**
	 * ventana para visualizar una pago de cliente.
	 */
	public static DialogViewObject getWindowViewPagoCliente(){			    
	
		DialogViewObject dialog = new DialogViewAdapter(I18nMessages.PAGO_DIALOG_VER_TITULO, UIServiceFactory.getUIPagoClienteService(), new PagoClientePanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_View).getImage() );
		return dialog;
	
	}

	
	/**
	 * ventana para visualizar una pago a proveedor.
	 */
	public static DialogViewObject getWindowViewPagoProveedor(){			    
	
		DialogViewObject dialog = new DialogViewAdapter(I18nMessages.PAGO_DIALOG_VER_TITULO, UIServiceFactory.getUIPagoProveedorService(), new PagoProveedorPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_View).getImage() );
		return dialog;
	
	}
}
