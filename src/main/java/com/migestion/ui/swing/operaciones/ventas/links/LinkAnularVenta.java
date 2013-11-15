package com.migestion.ui.swing.operaciones.ventas.links;

import com.migestion.model.Venta;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.WindowVentaFactory;

/**
 * Link para anular una venta
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 *
 */
public class LinkAnularVenta extends  LinkOpenDialogWithSelected{


	public LinkAnularVenta(){
		super(I18nMessages.VENTA_ACCION_ANULAR, I18nImages.BOTON_ANULAR);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Venta){
			
			Venta venta = (Venta)selectedObject;
			
			setEnabled( venta.getEstadoVenta().podesAnularte() );
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowVentaFactory.getWindowAnular();
	}
}
