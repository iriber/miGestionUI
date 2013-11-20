package com.migestion.ui.swing.clientes.factories;

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
	public static LinkOpenDialog getLinkAdd(){			    
		LinkOpenDialog link =  new LinkOpenDialog(I18nMessages.CLIENTE_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowClienteFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}

	/**
	 * link para modificar un cliente.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CLIENTE_ACCION_MODIFICAR,LinkImagesBundle.link_Update, LinkLabelsBundle.link_Update_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowClienteFactory.getWindowUpdate();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_UPDATE_KEY_STROKE );
		return link;
		
	}
	
	/**
	 * link para eliminar un cliente.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){			    
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CLIENTE_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowClienteFactory.getWindowDelete();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
		
	}
		
	
	/**
	 * link para listar clientes.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowClienteFactory.getWindowList(), I18nMessages.CLIENTE_ACCION_LISTAR, I18nImages.CLIENTES_ICON);
		link.setKeyStroke( LinkHelper.LINK_CLIENTES_KEY_STROKE );
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
