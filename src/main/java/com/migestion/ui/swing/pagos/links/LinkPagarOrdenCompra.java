package com.migestion.ui.swing.pagos.links;

import com.migestion.model.EstadoOrdenCompra;
import com.migestion.model.OrdenCompra;
import com.migestion.model.Venta;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.factories.WindowPagoFactory;

/**
 * Link para pagar una orden de compra.
 * 
 * @author Bernardo Iribarne
 *
 */
public class LinkPagarOrdenCompra extends  LinkOpenDialogWithSelected{


	public LinkPagarOrdenCompra(){
		super(I18nMessages.ORDEN_COMPRA_ACCION_PAGAR, I18nImages.BOTON_PAGAR);
	} 
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Venta){
			

			OrdenCompra ordenCompra = (OrdenCompra)selectedObject;
			
			EstadoOrdenCompra estado = ordenCompra.getEstadoOrdenCompra();
			setEnabled(estado.equals(EstadoOrdenCompra.PAGADA_PARCIALMENTE) || estado.equals(EstadoOrdenCompra.IMPAGA));
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowPagoFactory.getWindowPagarOrdenCompra();
	}

}
