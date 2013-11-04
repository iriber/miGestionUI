package com.migestion.ui.swing.productos.links;

import com.migestion.model.Producto;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.ui.swing.i18n.I18nImages;

/**
 * Link para activar un producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class LinkActivarProducto extends LinkUpdateObject{


	public LinkActivarProducto(ILinkWindowUpdate dialog, String title){
		super(dialog, title, I18nImages.BOTON_ACTIVAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null){
			
			Producto p = (Producto)selectedObject;
			
			setEnabled( p.getEstadoProducto().podesActivarte() );
			
		}
		
	}
}
