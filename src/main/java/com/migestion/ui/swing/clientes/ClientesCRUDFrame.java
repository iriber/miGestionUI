package com.migestion.ui.swing.clientes;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.swing.view.frames.ICRUDFrame;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.clientes.panel.UIClienteCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para clientes
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class ClientesCRUDFrame implements ICRUDFrame{

	private UIClienteCriteriaPanel buscarPanel;
	
	public ClientesCRUDFrame(){
		buscarPanel = new UIClienteCriteriaPanel();
	}
	

	public ICriteriaPanel getUICriteriaPanel() {
		return buscarPanel;
	}

	public void setLinks(CRUDFrame frame) {
		
		LinkUpdateObject linkUpdate  = LinkClienteFactory.getLinkUpdate();
		LinkAddObject linkAdd  = LinkClienteFactory.getLinkAdd();
		LinkDeleteObject linkDelete  = LinkClienteFactory.getLinkDelete();
		
		frame.setLinkAdd( linkAdd, 0 );
		frame.setLinkUpdate( linkUpdate, 1 );
		frame.setLinkDelete( linkDelete, 2 );
		
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		frame.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.CLIENTE_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.CLIENTES_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}
