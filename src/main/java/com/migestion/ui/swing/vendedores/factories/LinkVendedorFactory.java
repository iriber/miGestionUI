package com.migestion.ui.swing.vendedores.factories;

import javax.swing.KeyStroke;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.LinkExportCollectionToExcel;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.LinkPrintCollection;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
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
	public static LinkOpenDialog getLinkAdd(){			    
		LinkOpenDialog link =  new LinkOpenDialog(I18nMessages.VENDEDOR_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowVendedorFactory.getWindowAdd();
			}
			
		};
		return link;
		
	}

	/**
	 * link para modificar un vendedor.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.VENDEDOR_ACCION_MODIFICAR,LinkImagesBundle.link_Update, LinkLabelsBundle.link_Update_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowVendedorFactory.getWindowUpdate();
			}
			
		};
		return link;
		
	}
	
	/**
	 * link para eliminar un vendedor.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.VENDEDOR_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowVendedorFactory.getWindowDelete();
			}
			
		};
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
