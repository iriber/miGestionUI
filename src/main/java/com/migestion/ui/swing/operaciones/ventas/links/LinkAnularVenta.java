package com.migestion.ui.swing.operaciones.ventas.links;

import com.migestion.model.Venta;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.ui.swing.i18n.I18nImages;

/**
 * Link para anular una venta
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 *
 */
public class LinkAnularVenta extends LinkUpdateObject{


	public LinkAnularVenta(ILinkWindowUpdate dialog, String title){
		super(dialog, title, I18nImages.BOTON_ANULAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Venta){
			
			Venta venta = (Venta)selectedObject;
			
			setEnabled( venta.getEstadoVenta().podesAnularte() );
			
		}
		
	}
}
