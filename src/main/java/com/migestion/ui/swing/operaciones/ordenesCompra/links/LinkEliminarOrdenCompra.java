package com.migestion.ui.swing.operaciones.ordenesCompra.links;

import com.migestion.model.EstadoOrdenCompra;
import com.migestion.model.OrdenCompra;
import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.factories.WindowOrdenCompraFactory;

/**
 * Link para eliminar una orden de compra
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class LinkEliminarOrdenCompra  extends  LinkOpenDialogWithSelected{


	public LinkEliminarOrdenCompra(){
		super(I18nMessages.ORDEN_COMPRA_ACCION_ELIMINAR, LinkImagesBundle.link_Delete);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof OrdenCompra){
			
			OrdenCompra ordenCompra = (OrdenCompra)selectedObject;
			
			EstadoOrdenCompra estado = ordenCompra.getEstadoOrdenCompra();
			setEnabled(estado.equals(EstadoOrdenCompra.IMPAGA));
			
//			setEnabled( ordenCompra.getEstadoOrdenCompra().podesEliminarte() );			
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowOrdenCompraFactory.getWindowDelete();
	}
	
	
}
