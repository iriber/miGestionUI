package com.migestion.ui.swing.clientes.movimientos.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.clientes.movimientos.MovimientosCuentaClienteCRUDFrame;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para
 * movimientos de cuentas de clientes.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class WindowMovimientoCuentaClienteFactory {


	/**
	 * ventana para listar movimientos de cuentas de clientes.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		MovimientosCuentaClienteCRUDFrame frame = new MovimientosCuentaClienteCRUDFrame(I18nMessages.MOVIMIENTOS_CUENTA_CLIENTE, UIServiceFactory.getUIMovimientoCuentaClienteService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		return frame;
	}
	
}