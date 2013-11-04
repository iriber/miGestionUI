package com.migestion.ui.swing.operaciones.ventas.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.LinkViewObject;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.links.LinkAddVenta;
import com.migestion.ui.swing.operaciones.ventas.links.LinkAnularVenta;
import com.migestion.ui.swing.operaciones.ventas.links.LinkEliminarVenta;


/**
 * Proporciona métodos para la construcción de links para ventas.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public class LinkVentaFactory {


//	/**
//	 * link para agregar un venta.
//	 */
//	public static LinkAddObject getLinkAdd(){			    
//		//return LinkAddCuenta.getInstance();
//		LinkAddObject link =  new LinkAddObject(WindowVentaFactory.getWindowAdd(), I18nMessages.VENTA_ACCION_AGREGAR);
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		return link;
//		
//	}

	/**
	 * link para agregar un venta.
	 */
	public static LinkAddVenta getLinkAddVenta(){			    
		//return LinkAddCuenta.getInstance();
		LinkAddVenta link =  new LinkAddVenta(WindowVentaFactory.getWindowAdd() );
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
		
	}
	
	/**
	 * link para visualizar una venta.
	 */
	public static LinkViewObject getLinkView(){			    
		LinkViewObject link = new LinkViewObject(WindowVentaFactory.getWindowView(), I18nMessages.VENTA_ACCION_VER);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
	}	
	
	
//	/**
//	 * link para modificar un venta.
//	 */
//	public static LinkUpdateObject getLinkUpdate(){			    
//		LinkUpdateObject link = new LinkUpdateObject(WindowVentaFactory.getWindowUpdate(), I18nMessages.VENTA_ACCION_MODIFICAR);
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		return link;
//	}	
	
	/**
	 * link para eliminar un venta.
	 */
	public static LinkDeleteObject getLinkDelete(){			    
		LinkDeleteObject link =  new LinkEliminarVenta(WindowVentaFactory.getWindowDelete(), I18nMessages.VENTA_ACCION_ELIMINAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		return link;
	}
	
	
	/**
	 * link para anular una venta
	 */
	public static LinkUpdateObject getLinkAnularVenta(){			    
		LinkUpdateObject link = new LinkAnularVenta(WindowVentaFactory.getWindowAnular(), I18nMessages.VENTA_ACCION_ANULAR);
		return link;
	}	
	
	/**
	 * link para listar ventas.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowVentaFactory.getWindowList(), I18nMessages.VENTA_ACCION_LISTAR, I18nImages.VENTAS_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
	/**
	 * link para ingresar el criterio de búsqueda de ventas.
	 *
	public static LinkCreateCriteria getLinkCreateCriteria(){			    
		LinkCreateCriteria link = new LinkCreateCriteria(WindowVentaFactory.getWindowCreateCriteria(), I18nMessages.VENTA_ACCION_BUSCAR);
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
