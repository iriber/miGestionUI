package com.migestion.ui.swing.pagos.links;

import com.migestion.model.Pago;
import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.factories.WindowPagoFactory;

/**
 * Link para eliminar una pago
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 *
 */
public class LinkEliminarPagoCliente extends  LinkOpenDialogWithSelected{


	public LinkEliminarPagoCliente(){
		super(I18nMessages.PAGO_ACCION_ELIMINAR, LinkImagesBundle.link_Delete);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Pago){
			
			Pago pago = (Pago)selectedObject;
			
			setEnabled( pago.getEstadoPago().podesEliminarte() );
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowPagoFactory.getWindowDeletePagoCliente();
	}
}
