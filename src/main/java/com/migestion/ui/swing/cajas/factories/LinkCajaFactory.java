package com.migestion.ui.swing.cajas.factories;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
import com.migestion.ui.swing.LinkHelper;
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
	/**
	 * link para agregar una categoría de producto.
	 */
	public static Link getLinkAdd(){			    
		Link link =  new LinkOpenDialog(I18nMessages.CAJA_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowCajaFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}
	
	/**
	 * link para modificar un caja.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CAJA_ACCION_MODIFICAR,LinkImagesBundle.link_Update) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowCajaFactory.getWindowUpdate();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_UPDATE_KEY_STROKE );
		return link;
		
	}
	
	/**
	 * link para eliminar un caja.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CAJA_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowCajaFactory.getWindowDelete();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
	}
	
	
	/**
	 * link para listar cajas.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowCajaFactory.getWindowList(), I18nMessages.CAJA_ACCION_LISTAR, I18nImages.CAJAS_ICON);
		link.setKeyStroke( LinkHelper.LINK_CAJAS_KEY_STROKE);
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
