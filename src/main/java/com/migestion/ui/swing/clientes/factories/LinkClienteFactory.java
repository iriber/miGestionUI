package com.migestion.ui.swing.clientes.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para clientes.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class LinkClienteFactory {


	/**
	 * link para agregar un cliente.
	 */
	public static LinkAddObject getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		LinkAddObject link =  new LinkAddObject(WindowClienteFactory.getWindowAdd(), I18nMessages.CLIENTE_ACCION_AGREGAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
		
	}

	/**
	 * link para modificar un cliente.
	 */
	public static LinkUpdateObject getLinkUpdate(){			    
		LinkUpdateObject link = new LinkUpdateObject(WindowClienteFactory.getWindowUpdate(), I18nMessages.CLIENTE_ACCION_MODIFICAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
	}	
	
	/**
	 * link para eliminar un cliente.
	 */
	public static LinkDeleteObject getLinkDelete(){			    
		LinkDeleteObject link =  new LinkDeleteObject(WindowClienteFactory.getWindowDelete(), I18nMessages.CLIENTE_ACCION_ELIMINAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		return link;
	}
	
	
	/**
	 * link para listar clientes.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowClienteFactory.getWindowList(), I18nMessages.CLIENTE_ACCION_LISTAR, I18nImages.CLIENTES_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
	/**
	 * link para ingresar el criterio de búsqueda de clientes.
	 *
	public static LinkCreateCriteria getLinkCreateCriteria(){			    
		LinkCreateCriteria link = new LinkCreateCriteria(WindowClienteFactory.getWindowCreateCriteria(), I18nMessages.CLIENTE_ACCION_BUSCAR);
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
