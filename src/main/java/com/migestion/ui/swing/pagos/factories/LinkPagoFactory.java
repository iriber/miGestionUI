package com.migestion.ui.swing.pagos.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.LinkViewObject;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.links.LinkAddPago;
import com.migestion.ui.swing.pagos.links.LinkAnularPago;
import com.migestion.ui.swing.pagos.links.LinkEliminarPago;
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
	 * link para agregar un pago.
	 */
//	public static LinkAddPago getLinkAddPago(){			    
//		//return LinkAddCuenta.getInstance();
//		LinkAddPago link =  new LinkAddPago(WindowPagoFactory.getWindowAdd() );
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		return link;
//		
//	}

	/**
	 * link para pagar una venta.
	 */
	public static LinkPagarVenta getLinkPagarVenta(){			    
		//return LinkAddCuenta.getInstance();
		LinkPagarVenta link =  new LinkPagarVenta(WindowPagoFactory.getWindowPagarVenta() );
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
		
	}

	/**
	 * link para visualizar una pago.
	 */
	public static LinkViewObject getLinkView(){			    
		LinkViewObject link = new LinkViewObject(WindowPagoFactory.getWindowView(), I18nMessages.PAGO_ACCION_VER);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
	}	
	
	
//	/**
//	 * link para modificar un pago.
//	 */
//	public static LinkUpdateObject getLinkUpdate(){			    
//		LinkUpdateObject link = new LinkUpdateObject(WindowPagoFactory.getWindowUpdate(), I18nMessages.PAGO_ACCION_MODIFICAR);
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		return link;
//	}	
	
	/**
	 * link para eliminar un pago.
	 */
	public static LinkDeleteObject getLinkDelete(){			    
		LinkDeleteObject link =  new LinkEliminarPago(WindowPagoFactory.getWindowDelete(), I18nMessages.PAGO_ACCION_ELIMINAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		return link;
	}
	
	
//	/**
//	 * link para anular una pago
//	 */
//	public static LinkUpdateObject getLinkAnularPago(){			    
//		LinkUpdateObject link = new LinkAnularPago(WindowPagoFactory.getWindowAnular(), I18nMessages.PAGO_ACCION_ANULAR);
//		return link;
//	}	
	
	/**
	 * link para listar pagos.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowPagoFactory.getWindowList(), I18nMessages.PAGO_ACCION_LISTAR, I18nImages.PAGOS_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
	/**
	 * link para ingresar el criterio de búsqueda de pagos.
	 *
	public static LinkCreateCriteria getLinkCreateCriteria(){			    
		LinkCreateCriteria link = new LinkCreateCriteria(WindowPagoFactory.getWindowCreateCriteria(), I18nMessages.PAGO_ACCION_BUSCAR);
	    return link;
	}*/
	
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

	
}
