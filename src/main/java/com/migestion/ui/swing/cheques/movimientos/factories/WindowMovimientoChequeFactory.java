package com.migestion.ui.swing.cheques.movimientos.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cheques.movimientos.MovimientosChequeCRUDFrame;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para
 * movimientos de cheques.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 *
 */
public class WindowMovimientoChequeFactory {


	/**
	 * ventana para listar movimientos de cheques.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		MovimientosChequeCRUDFrame frame = new MovimientosChequeCRUDFrame(I18nMessages.MOVIMIENTOS_CHEQUE, UIServiceFactory.getUIMovimientoChequeService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		return frame;
	}
	
}