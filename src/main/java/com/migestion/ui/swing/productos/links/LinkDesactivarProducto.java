package com.migestion.ui.swing.productos.links;

import com.migestion.model.Producto;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.factories.WindowProductoFactory;

/**
 * Link para desactivar un producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class LinkDesactivarProducto extends LinkOpenDialogWithSelected{


	public LinkDesactivarProducto(){
		super(I18nMessages.PRODUCTO_ACCION_DESACTIVAR, I18nImages.BOTON_DESACTIVAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null){
			
			Producto p = (Producto)selectedObject;
			
			setEnabled( p.getEstadoProducto().podesDesactivarte() );
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		
		return WindowProductoFactory.getWindowDesactivar();
	}
}
