package com.migestion.ui.swing.cuentasBancarias.movimientos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.observers.listeners.ICuentaBancariaListener;
import com.migestion.ui.swing.cuentasBancarias.movimientos.panel.UIMovimientoCuentaBancariaCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para movimientos de cuentas bancarias
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class MovimientosCuentaBancariaCRUDFrame extends CRUDFrame{

	
	public MovimientosCuentaBancariaCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIMovimientoCuentaBancariaCriteriaPanel();
	}

	public void initLinks() {
		
//		LinkUpdateObject linkUpdate  = LinkClienteFactory.getLinkUpdate();
//		LinkAddObject linkAdd  = LinkClienteFactory.getLinkAdd();
//		LinkDeleteObject linkDelete  = LinkClienteFactory.getLinkDelete();
//		
//		frame.setLinkAdd( linkAdd, 0 );
//		frame.setLinkUpdate( linkUpdate, 1 );
//		frame.setLinkDelete( linkDelete, 2 );
//		
//		
//		JPopupMenu rightClick = new JPopupMenu();
//		
//		rightClick.add(linkUpdate);
//		rightClick.add(linkDelete);
//		
//		frame.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.MOVIMIENTO_CUENTA_BANCARIA_FRAME_MENUADMIN ;
		
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
