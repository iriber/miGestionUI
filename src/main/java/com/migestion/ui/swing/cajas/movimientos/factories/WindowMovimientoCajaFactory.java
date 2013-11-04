package com.migestion.ui.swing.cajas.movimientos.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cajas.movimientos.MovimientosCajaCRUDFrame;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para
 * movimientos de caja.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class WindowMovimientoCajaFactory {


	/**
	 * pagona para listar pagos.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		CRUDFrame frame = new CRUDFrame(I18nMessages.MOVIMIENTOS_CAJA, UIServiceFactory.getUIMovimientoCajaService(), new MovimientosCajaCRUDFrame());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		//AppContext.getInstance().addPagoListener( frame );
		
		return frame;
	}
	
}