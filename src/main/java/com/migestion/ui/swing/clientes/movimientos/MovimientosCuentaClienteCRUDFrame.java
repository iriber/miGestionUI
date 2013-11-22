package com.migestion.ui.swing.clientes.movimientos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.migestion.model.MovimientoCuentaCliente;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.swing.clientes.movimientos.panel.UIMovimientoCuentaClienteCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para movimientos de cuentas de clientes
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class MovimientosCuentaClienteCRUDFrame extends CRUDFrame<MovimientoCuentaCliente>{

	
	public MovimientosCuentaClienteCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIMovimientoCuentaClienteCriteriaPanel();
	}

	public void initLinks() {
		
	}

	public String getMenuTitle() {
		
		return I18nMessages.MOVIMIENTO_CUENTA_CLIENTE_FRAME_MENUADMIN ;
		
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
