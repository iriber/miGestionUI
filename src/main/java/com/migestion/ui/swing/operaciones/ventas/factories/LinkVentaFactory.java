package com.migestion.ui.swing.operaciones.ventas.factories;

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



	/**
	 * link para agregar una venta.
	 */
	public static Link getLinkAdd(){			    
		LinkOpenDialog link =  new LinkOpenDialog(I18nMessages.VENTA_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowVentaFactory.getWindowAdd();
			}
			
		};
		return link;
		
	}

	
	/**
	 * link para visualizar una venta.
	 */
	public static LinkOpenDialogWithSelected getLinkView(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.VENTA_ACCION_VER,LinkImagesBundle.link_View, LinkLabelsBundle.link_View_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowVentaFactory.getWindowView();
			}
			
		};
		return link;
		
	}
	
	
	

	/**
	 * link para eliminar una venta.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		
		LinkOpenDialogWithSelected link = new LinkEliminarVenta();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
		
	}
	
	/**
	 * link para anular una venta
	 */
	public static LinkOpenDialogWithSelected getLinkAnularVenta(){			    
		LinkOpenDialogWithSelected link = new LinkAnularVenta();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
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
	 * link imprimir.
	 */
	public static LinkPrintCollection getLinkPrintCollection(){			    
		LinkPrintCollection linkPrint = new LinkPrintCollection();
//		linkPrint.setIReportPrinter(new SaltosReportPrinter(PropertiesJasperReport.SALTOS_TEMPLATE));
	    return linkPrint;
	}

	/**
	 * link imprimir en excel.
	 */
	public static LinkExportCollectionToExcel getLinkExportToExcel(){			    
		LinkExportCollectionToExcel linkExcel = new LinkExportCollectionToExcel();
		return linkExcel;
	}

	
}
