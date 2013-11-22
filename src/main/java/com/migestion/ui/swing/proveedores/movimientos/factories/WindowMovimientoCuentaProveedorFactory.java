package com.migestion.ui.swing.proveedores.movimientos.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.proveedores.movimientos.MovimientosCuentaProveedorCRUDFrame;

/**
 * Proporciona métodos para la creación de ventanas para
 * movimientos de cuentas de proveedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class WindowMovimientoCuentaProveedorFactory {


	/**
	 * ventana para listar movimientos de cuentas de proveedores.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		MovimientosCuentaProveedorCRUDFrame frame = new MovimientosCuentaProveedorCRUDFrame(I18nMessages.MOVIMIENTOS_CUENTA_PROVEEDOR, UIServiceFactory.getUIMovimientoCuentaProveedorService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		return frame;
	}
	
}