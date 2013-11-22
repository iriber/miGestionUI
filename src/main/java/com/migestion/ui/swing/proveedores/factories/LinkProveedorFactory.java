package com.migestion.ui.swing.proveedores.factories;

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
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para proveedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class LinkProveedorFactory {


	/**
	 * link para agregar un proveedor.
	 */
	public static LinkOpenDialog getLinkAdd(){			    
		LinkOpenDialog link =  new LinkOpenDialog(I18nMessages.PROVEEDOR_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowProveedorFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}

	/**
	 * link para modificar un proveedor.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.PROVEEDOR_ACCION_MODIFICAR,LinkImagesBundle.link_Update, LinkLabelsBundle.link_Update_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowProveedorFactory.getWindowUpdate();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_UPDATE_KEY_STROKE );
		return link;
		
	}
	
	/**
	 * link para eliminar un proveedor.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.PROVEEDOR_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowProveedorFactory.getWindowDelete();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
		
	}
		
	
	/**
	 * link para listar proveedores.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowProveedorFactory.getWindowList(), I18nMessages.PROVEEDOR_ACCION_LISTAR, I18nImages.PROVEEDORES_ICON);
		link.setKeyStroke( LinkHelper.LINK_PROVEEDORES_KEY_STROKE );
		return link;
	}
	
	
	/**
	 * link imprimir
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
