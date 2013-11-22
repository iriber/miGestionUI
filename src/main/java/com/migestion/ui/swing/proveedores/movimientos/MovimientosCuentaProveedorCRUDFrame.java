package com.migestion.ui.swing.proveedores.movimientos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.migestion.model.MovimientoCuentaProveedor;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.proveedores.movimientos.panel.UIMovimientoCuentaProveedorCriteriaPanel;

/**
 * Frame para movimientos de cuentas proveedores
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class MovimientosCuentaProveedorCRUDFrame extends CRUDFrame<MovimientoCuentaProveedor>{

	
	public MovimientosCuentaProveedorCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIMovimientoCuentaProveedorCriteriaPanel();
	}

	public void initLinks() {
		
	}

	public String getMenuTitle() {
		
		return I18nMessages.MOVIMIENTO_CUENTA_PROVEEDOR_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.MOVIMIENTOS_CUENTA_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}
