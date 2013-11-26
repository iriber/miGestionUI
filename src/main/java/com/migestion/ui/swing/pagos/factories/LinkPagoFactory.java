package com.migestion.ui.swing.pagos.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.links.LinkAnularPagoCliente;
import com.migestion.ui.swing.pagos.links.LinkAnularPagoProveedor;
import com.migestion.ui.swing.pagos.links.LinkEliminarPagoCliente;
import com.migestion.ui.swing.pagos.links.LinkEliminarPagoProveedor;
import com.migestion.ui.swing.pagos.links.LinkPagarOrdenCompra;
import com.migestion.ui.swing.pagos.links.LinkPagarVenta;


/**
 * Proporciona métodos para la construcción de links para pagos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class LinkPagoFactory {



	/**
	 * link para pagar una venta.
	 */
	public static LinkPagarVenta getLinkPagarVenta(){			    
		//return LinkAddCuenta.getInstance();
		LinkPagarVenta link =  new LinkPagarVenta();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
		
	}



	/**
	 * link para visualizar un pago de cliente.
	 */
	public static LinkOpenDialogWithSelected getLinkViewPagoCliente(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.PAGO_ACCION_VER,LinkImagesBundle.link_View, LinkLabelsBundle.link_View_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowPagoFactory.getWindowViewPagoCliente();
			}
			
		};
		return link;

	}	
	
	/**
	 * link para eliminar un pago de cliente
	 */
	public static LinkOpenDialogWithSelected getLinkDeletePagoCliente(){			    
		
		LinkOpenDialogWithSelected link = new LinkEliminarPagoCliente();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;

	}
	
	/**
	 * link para anular un pago de cliente
	 */
	public static LinkOpenDialogWithSelected getLinkAnularPagoCliente(){			    
		
		LinkOpenDialogWithSelected link = new LinkAnularPagoCliente();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;

	}
	
	/**
	 * link para listar pagos.
	 * @return
	 */
	public static LinkListCollection getLinkPagosCliente(){
		LinkListCollection link = new LinkListCollection(WindowPagoFactory.getWindowListPagoCliente(), I18nMessages.PAGO_ACCION_LISTAR, I18nImages.PAGOS_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}

	/**
	 * link para listar pagos a proveedores.
	 * @return
	 */
	public static LinkListCollection getLinkPagosProveedor(){
		LinkListCollection link = new LinkListCollection(WindowPagoFactory.getWindowListPagoProveedor(), I18nMessages.PAGO_PROVEEDOR_ACCION_LISTAR, I18nImages.PAGOS_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}

	/**
	 * link imprimir cuentas.
	 */
	public static LinkPrintCollection getLinkPrintCollection(){			    
		LinkPrintCollection linkPrint = new LinkPrintCollection();
//		linkPrint.setIReportPrinter(new SaltosReportPrinter(PropertiesJasperReport.SALTOS_TEMPLATE));
	    return linkPrint;
	}

	/**
	 * link imprimir cuentas en excel.
	 */
	public static LinkExportCollectionToExcel getLinkExportToExcel(){			    
		LinkExportCollectionToExcel linkExcel = new LinkExportCollectionToExcel();
		return linkExcel;
	}


	/**
	 * link para pagar una orden de compra.
	 */
	public static LinkPagarOrdenCompra getLinkPagarOrdenCompra(){			    
		//return LinkAddCuenta.getInstance();
		LinkPagarOrdenCompra link =  new LinkPagarOrdenCompra();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
		
	}


	/**
	 * link para visualizar un pago a proveedor.
	 */
	public static LinkOpenDialogWithSelected getLinkViewPagoProveedor(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.PAGO_ACCION_VER,LinkImagesBundle.link_View, LinkLabelsBundle.link_View_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowPagoFactory.getWindowViewPagoProveedor();
			}
			
		};
		return link;

	}	
	
	/**
	 * link para eliminar un pago a proveedor
	 */
	public static LinkOpenDialogWithSelected getLinkDeletePagoProveedor(){			    
		
		LinkOpenDialogWithSelected link = new LinkEliminarPagoProveedor();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;

	}
	
	/**
	 * link para anular un pago a proveedor.
	 */
	public static LinkOpenDialogWithSelected getLinkAnularPagoProveedor(){			    
		
		LinkOpenDialogWithSelected link = new LinkAnularPagoProveedor();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;

	}

}
