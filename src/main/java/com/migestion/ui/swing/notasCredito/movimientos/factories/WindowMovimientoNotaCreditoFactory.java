package com.migestion.ui.swing.notasCredito.movimientos.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.notasCredito.movimientos.MovimientosNotaCreditoCRUDFrame;

/**
 * Proporciona métodos para la creación de ventanas para
 * movimientos de notas de crédito.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 *
 */
public class WindowMovimientoNotaCreditoFactory {


	/**
	 * ventana para listar movimientos de notas de crédito.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		MovimientosNotaCreditoCRUDFrame frame = new MovimientosNotaCreditoCRUDFrame(I18nMessages.MOVIMIENTOS_NOTA_CREDITO, UIServiceFactory.getUIMovimientoNotaCreditoService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		return frame;
	}
	
}