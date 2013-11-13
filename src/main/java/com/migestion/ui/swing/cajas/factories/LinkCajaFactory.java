package com.migestion.ui.swing.cajas.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para cajas.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class LinkCajaFactory {


	/**
	 * link para agregar una caja.
	 */
	public static LinkAddObject getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		LinkAddObject link =  new LinkAddObject(WindowCajaFactory.getWindowAdd(), I18nMessages.CAJA_ACCION_AGREGAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
		
	}
//
//	/**
//	 * link para activar un caja.
//	 */
//	public static LinkUpdateObject getLinkActivarCaja(){			    
//		LinkUpdateObject link = new LinkActivarCaja(WindowCajaFactory.getWindowActivar(), I18nMessages.CAJA_ACCION_ACTIVAR);
//		return link;
//	}	
//
//	/**
//	 * link para desactivar un caja.
//	 */
//	public static LinkUpdateObject getLinkDesactivarCaja(){			    
//		LinkUpdateObject link = new LinkDesactivarCaja(WindowCajaFactory.getWindowDesactivar(), I18nMessages.CAJA_ACCION_DESACTIVAR);
//		return link;
//	}	
//
	/**
	 * link para modificar un caja.
	 */
	public static LinkUpdateObject getLinkUpdate(){			    
		LinkUpdateObject link = new LinkUpdateObject(WindowCajaFactory.getWindowUpdate(), I18nMessages.CAJA_ACCION_MODIFICAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
	}	
	
	/**
	 * link para eliminar un caja.
	 */
	public static LinkDeleteObject getLinkDelete(){			    
		LinkDeleteObject link =  new LinkDeleteObject(WindowCajaFactory.getWindowDelete(), I18nMessages.CAJA_ACCION_ELIMINAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		return link;
	}
	
	
	/**
	 * link para listar cajas.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowCajaFactory.getWindowList(), I18nMessages.CAJA_ACCION_LISTAR, I18nImages.CAJAS_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
//	
//	/**
//	 * link para ingresar el criterio de búsqueda de cajas.
//	 *
//	public static LinkCreateCriteria getLinkCreateCriteria(){			    
//		LinkCreateCriteria link = new LinkCreateCriteria(WindowCajaFactory.getWindowCreateCriteria(), I18nMessages.CAJA_ACCION_BUSCAR);
//	    return link;
//	}*/
//	
//	/**
//	 * link imprimir cuentas.
//	 */
//	public static LinkPrintCollection getLinkPrintCollection(){			    
//		LinkPrintCollection linkPrint = new LinkPrintCollection();
////		linkPrint.setIReportPrinter(new SaltosReportPrinter(PropertiesJasperReport.SALTOS_TEMPLATE));
//	    return linkPrint;
//	}
//
//	/**
//	 * link imprimir cuentas en excel.
//	 */
//	public static LinkExportCollectionToExcel getLinkExportToExcel(){			    
//		LinkExportCollectionToExcel linkExcel = new LinkExportCollectionToExcel();
//		return linkExcel;
//	}

	
}
