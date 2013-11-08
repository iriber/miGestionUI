package com.migestion.ui.swing.productos.links;

import com.migestion.model.Producto;
import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowUpdate;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.factories.WindowProductoFactory;

/**
 * Link para activar un producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class LinkActivarProducto extends LinkOpenDialogWithSelected{


	public LinkActivarProducto(){
		
		super(I18nMessages.PRODUCTO_ACCION_ACTIVAR, I18nImages.BOTON_ACTIVAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null){
			
			Producto p = (Producto)selectedObject;
			
			setEnabled( p.getEstadoProducto().podesActivarte() );
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		
		return WindowProductoFactory.getWindowActivar();
	}
}
