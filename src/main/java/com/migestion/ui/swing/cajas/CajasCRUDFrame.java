package com.migestion.ui.swing.cajas;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.migestion.model.Caja;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.swing.cajas.panel.UICajaCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para cajas
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 04/11/2013
 *
 */
public class CajasCRUDFrame extends CRUDFrame<Caja>{

	public CajasCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UICajaCriteriaPanel();
	}

	public void initLinks() {
//		
//		LinkUpdateObject linkUpdate  = LinkClienteFactory.getLinkUpdate();
//		LinkAddObject linkAdd  = LinkClienteFactory.getLinkAdd();
//		LinkDeleteObject linkDelete  = LinkClienteFactory.getLinkDelete();
//		
//		this.setLinkAdd( linkAdd, 0 );
//		this.setLinkUpdate( linkUpdate, 1 );
//		this.setLinkDelete( linkDelete, 2 );
//		
//		
//		JPopupMenu rightClick = new JPopupMenu();
//		
//		rightClick.add(linkUpdate);
//		rightClick.add(linkDelete);
//		
//		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.CAJA_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.CAJAS_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}
