package com.migestion.ui.swing.operaciones.ventas.links;

import com.migestion.model.EstadoVenta;
import com.migestion.model.Venta;
import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.WindowVentaFactory;

/**
 * Link para eliminar una venta
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 24/10/2013
 *
 */
public class LinkEliminarVenta  extends  LinkOpenDialogWithSelected{


	public LinkEliminarVenta(){
		super(I18nMessages.VENTA_ACCION_ELIMINAR, LinkImagesBundle.link_Delete);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Venta){
			
			Venta venta = (Venta)selectedObject;
			
			EstadoVenta estado = venta.getEstadoVenta();
			setEnabled(estado.equals(EstadoVenta.IMPAGA));
			
//			setEnabled( venta.getEstadoVenta().podesEliminarte() );			
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowVentaFactory.getWindowDelete();
	}
	
	
}
