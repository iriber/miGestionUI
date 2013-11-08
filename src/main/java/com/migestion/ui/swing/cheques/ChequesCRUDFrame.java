package com.migestion.ui.swing.cheques;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.swing.cheques.panel.UIChequeCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para cheques
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class ChequesCRUDFrame extends CRUDFrame { //implements IProductoListener{

	
	public ChequesCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIChequeCriteriaPanel();
	}

	public void initLinks() {
		
		
//		Link linkAdd  = LinkProductoFactory.getLinkAdd();
//		
//		LinkOpenDialogWithSelected linkUpdate  = LinkProductoFactory.getLinkUpdate();
//		this.addElementsListener(linkUpdate);
//		
//		LinkOpenDialogWithSelected linkActivar = LinkProductoFactory.getLinkActivarProducto();
//		this.addElementsListener(linkActivar);
//
//		LinkOpenDialogWithSelected linkDesactivar = LinkProductoFactory.getLinkDesactivarProducto();
//		this.addElementsListener(linkDesactivar);
//		
//		LinkOpenDialogWithSelected linkDelete  = LinkProductoFactory.getLinkDelete();
//		this.addElementsListener(linkDelete);
//		
//		
//		this.addLinkToDefaultMenu( linkAdd, 0 );
//		this.addLinkToDefaultMenu( linkUpdate, 1 );
//		this.addLinkToDefaultMenu( linkActivar, 2 );
//		this.addLinkToDefaultMenu( linkDesactivar, 3 );
//		this.addLinkToDefaultMenu( linkDelete, 4 );
//		
//		
//		JPopupMenu rightClick = new JPopupMenu();
//		
//		rightClick.add(linkActivar);
//		rightClick.add(linkDesactivar);
//		rightClick.add(linkUpdate);
//		rightClick.add(linkDelete);
//		
//		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.CHEQUE_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.CHEQUES_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}


}
