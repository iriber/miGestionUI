package com.migestion.ui.swing.pagos.links;

import com.migestion.model.Pago;
import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.factories.WindowPagoFactory;

/**
 * Link para anular un pago a proveedor
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class LinkAnularPagoProveedor extends  LinkOpenDialogWithSelected{


	public LinkAnularPagoProveedor(){
		super(I18nMessages.PAGO_ACCION_ANULAR, I18nImages.BOTON_ANULAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Pago){
			
			Pago pago = (Pago)selectedObject;
			
			setEnabled( pago.getEstadoPago().podesAnularte() );
			
		}
		
	}
	
	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowPagoFactory.getWindowAnularPagoCliente();
	}
}
