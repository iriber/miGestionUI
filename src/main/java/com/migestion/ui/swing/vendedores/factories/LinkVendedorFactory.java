package com.migestion.ui.swing.vendedores.factories;

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
 * Proporciona métodos para la construcción de links para vendedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 16/10/2013
 *
 */
public class LinkVendedorFactory {


	/**
	 * link para agregar un vendedor.
	 */
	public static LinkAddObject getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		LinkAddObject link =  new LinkAddObject(WindowVendedorFactory.getWindowAdd(), I18nMessages.VENDEDOR_ACCION_AGREGAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
		
	}

	/**
	 * link para modificar un vendedor.
	 */
	public static LinkUpdateObject getLinkUpdate(){			    
		LinkUpdateObject link = new LinkUpdateObject(WindowVendedorFactory.getWindowUpdate(), I18nMessages.VENDEDOR_ACCION_MODIFICAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
	}	
	
	/**
	 * link para eliminar un vendedor.
	 */
	public static LinkDeleteObject getLinkDelete(){			    
		LinkDeleteObject link =  new LinkDeleteObject(WindowVendedorFactory.getWindowDelete(), I18nMessages.VENDEDOR_ACCION_ELIMINAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		return link;
	}
	
	
	/**
	 * link para listar vendedores.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowVendedorFactory.getWindowList(), I18nMessages.VENDEDOR_ACCION_LISTAR, I18nImages.VENDEDORES_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
	/**
	 * link para ingresar el criterio de búsqueda de vendedores.
	 *
	public static LinkCreateCriteria getLinkCreateCriteria(){			    
		LinkCreateCriteria link = new LinkCreateCriteria(WindowVendedorFactory.getWindowCreateCriteria(), I18nMessages.VENDEDOR_ACCION_BUSCAR);
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
