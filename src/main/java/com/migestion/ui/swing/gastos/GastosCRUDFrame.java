package com.migestion.ui.swing.gastos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.model.Gasto;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.observers.listeners.IGastoListener;
import com.migestion.ui.swing.gastos.factories.LinkGastoFactory;
import com.migestion.ui.swing.gastos.panel.UIGastoCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para gastos
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 *
 */
public class GastosCRUDFrame extends CRUDFrame<Gasto> implements IGastoListener{

	public GastosCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIGastoCriteriaPanel();
	}

	public void initLinks() {
		
		Link linkAdd  = LinkGastoFactory.getLinkAdd();
		LinkOpenDialogWithSelected linkDelete  = LinkGastoFactory.getLinkDelete();

		this.addLinkToDefaultMenu( linkAdd, 0 );
		this.addLinkToDefaultMenu( linkDelete, 1 );
		
		this.addElementsListener(linkDelete);
		
		JPopupMenu rightClick = new JPopupMenu();
		
//		rightClick.add(linkView);
//		rightClick.add(linkAnular);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.GASTO_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.GASTOS_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}