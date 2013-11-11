package com.migestion.ui.swing.cuentasBancarias;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.model.CuentaBancaria;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.observers.listeners.ICuentaBancariaListener;
import com.migestion.ui.swing.cuentasBancarias.factories.LinkCuentaBancariaFactory;
import com.migestion.ui.swing.cuentasBancarias.panel.UICuentaBancariaCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para cuentas bancarias
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class CuentasBancariasCRUDFrame extends CRUDFrame<CuentaBancaria> implements ICuentaBancariaListener{

	
	public CuentasBancariasCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UICuentaBancariaCriteriaPanel();
	}

	public void initLinks() {
		
		//LinkUpdateObject linkUpdate  = LinkCuentaBancariaFactory.getLinkUpdate();
		//LinkAddObject linkAdd  = LinkCuentaBancariaFactory.getLinkAdd();
//		LinkDeleteObject linkDelete  = LinkCuentaBancariaFactory.getLinkDelete();
//		LinkUpdateObject linkActivar = LinkCuentaBancariaFactory.getLinkActivarCuentaBancaria();
//		LinkUpdateObject linkDesactivar = LinkCuentaBancariaFactory.getLinkDesactivarCuentaBancaria();
		
		Link linkAdd  = LinkCuentaBancariaFactory.getLinkAdd();
		
		LinkOpenDialogWithSelected linkUpdate  = LinkCuentaBancariaFactory.getLinkUpdate();
		this.addElementsListener(linkUpdate);
		
		LinkOpenDialogWithSelected linkDelete  = LinkCuentaBancariaFactory.getLinkDelete();
		this.addElementsListener(linkDelete);
		
		//this.setLinkAdd( linkAdd, 0 );
		//this.setLinkUpdate( linkUpdate, 1 );
		
		this.addLinkToDefaultMenu( linkAdd, 0 );
		this.addLinkToDefaultMenu( linkUpdate, 1 );
		this.addLinkToDefaultMenu( linkDelete, 2 );
		
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.CUENTA_BANCARIA_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.CUENTAS_BANCARIAS_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}


	

}
