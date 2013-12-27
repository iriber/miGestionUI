package com.migestion.ui.swing.operaciones.ordenesCompra.links;

import com.migestion.model.EstadoOrdenCompra;
import com.migestion.model.OrdenCompra;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.factories.WindowOrdenCompraFactory;

/**
 * Link para recibir una orden de compra
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 01/12/2013
 *
 */
public class LinkRecibirOrdenCompra extends  LinkOpenDialogWithSelected{


	public LinkRecibirOrdenCompra(){
		super(I18nMessages.ORDEN_COMPRA_ACCION_RECIBIR, I18nImages.BOTON_RECIBIR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof OrdenCompra){
			
			OrdenCompra ordenCompra = (OrdenCompra)selectedObject;
			
			EstadoOrdenCompra estado = ordenCompra.getEstadoOrdenCompra();
			setEnabled( estado.podesEntregarte() );
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowOrdenCompraFactory.getWindowRecibir();
	}
}
