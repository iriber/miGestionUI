package com.migestion.ui.swing.categoriasProducto.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para 
 * categorías de productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class LinkCategoriaProductoFactory {


	/**
	 * link para agregar una categoría de producto.
	 */
	public static LinkAddObject getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		LinkAddObject link =  new LinkAddObject(WindowCategoriaProductoFactory.getWindowAdd(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_AGREGAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
		
	}


	/**
	 * link para modificar una categoría de producto.
	 */
	public static LinkUpdateObject getLinkUpdate(){			    
		LinkUpdateObject link = new LinkUpdateObject(WindowCategoriaProductoFactory.getWindowUpdate(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_MODIFICAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		return link;
	}	
	
	/**
	 * link para eliminar una categoría de producto.
	 */
	public static LinkDeleteObject getLinkDelete(){			    
		LinkDeleteObject link =  new LinkDeleteObject(WindowCategoriaProductoFactory.getWindowDelete(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_ELIMINAR);
		//link.addListener(AppContext.getInstance().getCuentaObserver());
		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		return link;
	}
	
	
	/**
	 * link para listar categorías de producto.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowCategoriaProductoFactory.getWindowList(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_LISTAR, I18nImages.CATEGORIAS_PRODUCTO_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}

	/**
	 * link para listar categorías de producto en forma de árbol.
	 * @return
	 */
	public static LinkListCollection getLinkListTree(){
		LinkListCollection link = new LinkListCollection(WindowCategoriaProductoFactory.getWindowListTree(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_LISTAR, I18nImages.CATEGORIAS_PRODUCTO_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
	
//	/**
//	 * link imprimir cuentas.
//	 */
//	public static LinkPrintCollection getLinkPrintCollection(){			    
//		LinkPrintCollection linkPrint = new LinkPrintCollection();
////		linkPrint.setIReportPrinter(new SaltosReportPrinter(PropertiesJasperReport.SALTOS_TEMPLATE));
//	    return linkPrint;
//	}

//	/**
//	 * link imprimir cuentas en excel.
//	 */
//	public static LinkExportCollectionToExcel getLinkExportToExcel(){			    
//		LinkExportCollectionToExcel linkExcel = new LinkExportCollectionToExcel();
//		return linkExcel;
//	}

}
