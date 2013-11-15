package com.migestion.ui.swing.pagos.links;

import java.net.URL;

import com.migestion.model.EstadoVenta;
import com.migestion.model.Venta;
import com.migestion.swing.navigation.LinkAddRelatedObject;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowAddRelated;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.WindowVentaFactory;
import com.migestion.ui.swing.pagos.factories.WindowPagoFactory;

/**
 * Link para pagar una venta.
 * 
 * @author Bernardo Iribarne
 *
 */
public class LinkPagarVenta extends  LinkOpenDialogWithSelected{


	public LinkPagarVenta(){
		super(I18nMessages.VENTA_ACCION_PAGAR, I18nImages.BOTON_PAGAR);
	} 
//extends LinkAddRelatedObject{
//	
//	public LinkPagarVenta(ILinkWindowAddRelated dialog) {
//		super(dialog);
//	}
//
//	public LinkPagarVenta(ILinkWindowAddRelated dialog, String title, URL pathSmallIcon){
//		super(dialog, title, pathSmallIcon);
//	}
//	
//	public void valueSelectedChange(Object selectedObject) {
//		
//		//super.valueSelectedChange(selectedObject);
//		setRelatedObject(selectedObject);
//		if( selectedObject!=null && selectedObject instanceof Venta){
//			
//			EstadoVenta estado = ((Venta)selectedObject).getEstadoVenta();
//			setEnabled(estado.equals(EstadoVenta.PAGADA_PARCIALMENTE) || estado.equals(EstadoVenta.IMPAGA));
//			
//		}
//		
//	}
	
	public void valueSelectedChange(Object selectedObject) {
		
		super.valueSelectedChange(selectedObject);
		
		if( selectedObject!=null && selectedObject instanceof Venta){
			
			Venta venta = (Venta)selectedObject;
			
			EstadoVenta estado = venta.getEstadoVenta();
			setEnabled(estado.equals(EstadoVenta.PAGADA_PARCIALMENTE) || estado.equals(EstadoVenta.IMPAGA));
			
		}
		
	}

	@Override
	protected ILinkWindowObjectOpen getDialog() {
		return WindowPagoFactory.getWindowPagarVenta();
	}

}
