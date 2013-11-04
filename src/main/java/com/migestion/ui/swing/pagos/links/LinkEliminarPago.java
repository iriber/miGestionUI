package com.migestion.ui.swing.pagos.links;

import com.migestion.model.Pago;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowDelete;

/**
 * Link para eliminar una pago
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 *
 */
public class LinkEliminarPago extends LinkDeleteObject{


	public LinkEliminarPago(ILinkWindowDelete dialog, String title){
		super(dialog, title);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Pago){
			
			Pago pago = (Pago)selectedObject;
			
			setEnabled( pago.getEstadoPago().podesEliminarte() );
			
		}
		
	}
}
