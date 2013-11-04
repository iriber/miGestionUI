package com.migestion.ui.swing.pagos.links;

import com.migestion.model.Pago;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.ui.swing.i18n.I18nImages;

/**
 * Link para anular una pago
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class LinkAnularPago extends LinkUpdateObject{


	public LinkAnularPago(ILinkWindowUpdate dialog, String title){
		super(dialog, title, I18nImages.BOTON_ANULAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Pago){
			
			Pago pago = (Pago)selectedObject;
			
			setEnabled( pago.getEstadoPago().podesAnularte() );
			
		}
		
	}
}
