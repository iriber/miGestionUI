package com.migestion.ui.swing.operaciones.ordenesCompra.factories;

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
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.links.LinkAnularOrdenCompra;
import com.migestion.ui.swing.operaciones.ordenesCompra.links.LinkEliminarOrdenCompra;


/**
 * Proporciona métodos para la construcción de links para órdenes de compra.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class LinkOrdenCompraFactory {



	/**
	 * link para agregar una ordenCompra.
	 */
	public static Link getLinkAdd(){			    
		LinkOpenDialog link =  new LinkOpenDialog(I18nMessages.ORDEN_COMPRA_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowOrdenCompraFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}

	
	/**
	 * link para visualizar una ordenCompra.
	 */
	public static LinkOpenDialogWithSelected getLinkView(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.ORDEN_COMPRA_ACCION_VER,LinkImagesBundle.link_View, LinkLabelsBundle.link_View_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowOrdenCompraFactory.getWindowView();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_VIEW_KEY_STROKE );
		return link;
		
	}
	
	
	

	/**
	 * link para eliminar una ordenCompra.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		LinkOpenDialogWithSelected link = new LinkEliminarOrdenCompra();
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
		
	}
	
	/**
	 * link para anular una ordenCompra
	 */
	public static LinkOpenDialogWithSelected getLinkAnularOrdenCompra(){			    
		LinkOpenDialogWithSelected link = new LinkAnularOrdenCompra();
		link.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
		return link;
	}	
	
	/**
	 * link para listar ordenCompras.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowOrdenCompraFactory.getWindowList(), I18nMessages.ORDEN_COMPRA_ACCION_LISTAR, I18nImages.ORDENES_COMPRA_ICON);
		link.setKeyStroke( LinkHelper.LINK_ORDENES_COMPRA_KEY_STROKE );
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
