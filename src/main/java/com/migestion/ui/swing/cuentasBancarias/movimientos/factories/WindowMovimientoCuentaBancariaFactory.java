package com.migestion.ui.swing.cuentasBancarias.movimientos.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cuentasBancarias.movimientos.MovimientosCuentaBancariaCRUDFrame;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para
 * movimientos de cuentas bancarias.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class WindowMovimientoCuentaBancariaFactory {


	/**
	 * ventana para listar movimientos de cuentas bancarias.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		MovimientosCuentaBancariaCRUDFrame frame = new MovimientosCuentaBancariaCRUDFrame(I18nMessages.MOVIMIENTOS_CUENTA_BANCARIA, UIServiceFactory.getUIMovimientoCuentaBancariaService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		return frame;
	}
	
}