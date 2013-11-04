package com.migestion.ui.swing.operaciones.ventas.links;

import com.migestion.model.Venta;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowDelete;

/**
 * Link para eliminar una venta
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 *
 */
public class LinkEliminarVenta extends LinkDeleteObject{


	public LinkEliminarVenta(ILinkWindowDelete dialog, String title){
		super(dialog, title);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Venta){
			
			Venta venta = (Venta)selectedObject;
			
			setEnabled( venta.getEstadoVenta().podesEliminarte() );
			
		}
		
	}
}
