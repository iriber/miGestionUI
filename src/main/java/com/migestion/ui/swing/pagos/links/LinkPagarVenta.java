package com.migestion.ui.swing.pagos.links;

import java.net.URL;

import com.migestion.model.EstadoVenta;
import com.migestion.model.Venta;
import com.migestion.swing.navigation.LinkAddRelatedObject;
import com.migestion.swing.navigation.exception.LinkException;
import com.migestion.swing.navigation.interfaces.ILinkWindowAddRelated;
import com.migestion.ui.swing.pagos.dialog.FrameAddPagoVenta;

/**
 * Link para pagar una venta.
 * 
 * @author Bernardo Iribarne
 *
 */
public class LinkPagarVenta extends LinkAddRelatedObject{
	
	public LinkPagarVenta(ILinkWindowAddRelated dialog) {
		super(dialog);
	}

	public LinkPagarVenta(ILinkWindowAddRelated dialog, String title, URL pathSmallIcon){
		super(dialog, title, pathSmallIcon);
	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		//super.valueSelectedChange(selectedObject);
		setRelatedObject(selectedObject);
		if( selectedObject!=null && selectedObject instanceof Venta){
			
			EstadoVenta estado = ((Venta)selectedObject).getEstadoVenta();
			setEnabled(estado.equals(EstadoVenta.PAGADA_PARCIALMENTE) || estado.equals(EstadoVenta.IMPAGA));
			
		}
		
	}

}
