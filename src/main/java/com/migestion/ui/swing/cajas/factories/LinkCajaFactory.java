package com.migestion.ui.swing.cajas.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.links.LinkActivarProducto;
import com.migestion.ui.swing.productos.links.LinkDesactivarProducto;


/**
 * Proporciona métodos para la construcción de links para productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class LinkCajaFactory {

//
//	/**
//	 * link para agregar un producto.
//	 */
//	public static LinkAddObject getLinkAdd(){			    
//		//return LinkAddCuenta.getInstance();
//		LinkAddObject link =  new LinkAddObject(WindowCajaFactory.getWindowAdd(), I18nMessages.PRODUCTO_ACCION_AGREGAR);
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		return link;
//		
//	}
//
//	/**
//	 * link para activar un producto.
//	 */
//	public static LinkUpdateObject getLinkActivarProducto(){			    
//		LinkUpdateObject link = new LinkActivarProducto(WindowCajaFactory.getWindowActivar(), I18nMessages.PRODUCTO_ACCION_ACTIVAR);
//		return link;
//	}	
//
//	/**
//	 * link para desactivar un producto.
//	 */
//	public static LinkUpdateObject getLinkDesactivarProducto(){			    
//		LinkUpdateObject link = new LinkDesactivarProducto(WindowCajaFactory.getWindowDesactivar(), I18nMessages.PRODUCTO_ACCION_DESACTIVAR);
//		return link;
//	}	
//
//	/**
//	 * link para modificar un producto.
//	 */
//	public static LinkUpdateObject getLinkUpdate(){			    
//		LinkUpdateObject link = new LinkUpdateObject(WindowCajaFactory.getWindowUpdate(), I18nMessages.PRODUCTO_ACCION_MODIFICAR);
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		return link;
//	}	
//	
//	/**
//	 * link para eliminar un producto.
//	 */
//	public static LinkDeleteObject getLinkDelete(){			    
//		LinkDeleteObject link =  new LinkDeleteObject(WindowCajaFactory.getWindowDelete(), I18nMessages.PRODUCTO_ACCION_ELIMINAR);
//		//link.addListener(AppContext.getInstance().getCuentaObserver());
//		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
//		return link;
//	}
//	
//	
//	/**
//	 * link para listar productos.
//	 * @return
//	 */
//	public static LinkListCollection getLinkList(){
//		LinkListCollection link = new LinkListCollection(WindowCajaFactory.getWindowList(), I18nMessages.PRODUCTO_ACCION_LISTAR, I18nImages.PRODUCTOS_ICON);
//		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_DOWN_MASK));
//		return link;
//	}
//	
//	/**
//	 * link para ingresar el criterio de búsqueda de productos.
//	 *
//	public static LinkCreateCriteria getLinkCreateCriteria(){			    
//		LinkCreateCriteria link = new LinkCreateCriteria(WindowProductoFactory.getWindowCreateCriteria(), I18nMessages.PRODUCTO_ACCION_BUSCAR);
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
