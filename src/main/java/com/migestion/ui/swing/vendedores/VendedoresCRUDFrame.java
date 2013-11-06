package com.migestion.ui.swing.vendedores;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.swing.view.frames.ICRUDFrame;
import com.migestion.ui.swing.vendedores.factories.LinkVendedorFactory;
import com.migestion.ui.swing.vendedores.panel.UIVendedorCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para vendedores
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class VendedoresCRUDFrame extends CRUDFrame{

	public VendedoresCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}
	
	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIVendedorCriteriaPanel();
	}

	public void initLinks() {
		
		LinkUpdateObject linkUpdate  = LinkVendedorFactory.getLinkUpdate();
		LinkAddObject linkAdd  = LinkVendedorFactory.getLinkAdd();
		LinkDeleteObject linkDelete  = LinkVendedorFactory.getLinkDelete();
		
		this.setLinkAdd( linkAdd, 0 );
		this.setLinkUpdate( linkUpdate, 1 );
		this.setLinkDelete( linkDelete, 2 );
		
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.VENDEDOR_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.VENDEDORES_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}
