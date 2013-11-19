package com.migestion.ui.swing.productos.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
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
public class LinkProductoFactory {


	/**
	 * link para agregar un producto.
	 */
	public static Link getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		Link link =  new LinkOpenDialog(I18nMessages.PRODUCTO_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowProductoFactory.getWindowAdd();
			}
			
		};
		return link;
		
	}


	/**
	 * link para modificar un producto.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		//return LinkAddCuenta.getInstance();
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.PRODUCTO_ACCION_MODIFICAR,LinkImagesBundle.link_Update, LinkLabelsBundle.link_Update_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowProductoFactory.getWindowUpdate();
			}
			
		};
		return link;
		
	}
	
	/**
	 * link para activar un producto.
	 */
	public static LinkOpenDialogWithSelected getLinkActivarProducto(){			    
		LinkOpenDialogWithSelected link = new LinkActivarProducto();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}	

	/**
	 * link para desactivar un producto.
	 */
	public static LinkOpenDialogWithSelected getLinkDesactivarProducto(){			    
		LinkOpenDialogWithSelected link = new LinkDesactivarProducto();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}	


	/**
	 * link para eliminar un producto.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		
		//return LinkAddCuenta.getInstance();
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.PRODUCTO_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowProductoFactory.getWindowDelete();
			}
			
		};
//		link.setKeyStroke(KeyStroke.getKeyStroke("DELETE"));
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
		
	}
	
	/**
	 * link para listar productos.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowProductoFactory.getWindowList(), I18nMessages.PRODUCTO_ACCION_LISTAR, I18nImages.PRODUCTOS_ICON);
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}
	
	/**
	 * link para ingresar el criterio de búsqueda de productos.
	 *
	public static LinkCreateCriteria getLinkCreateCriteria(){			    
		LinkCreateCriteria link = new LinkCreateCriteria(WindowProductoFactory.getWindowCreateCriteria(), I18nMessages.PRODUCTO_ACCION_BUSCAR);
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
