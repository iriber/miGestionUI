package com.migestion.ui.swing.pagos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.model.Pago;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.observers.listeners.IPagoListener;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.pagos.panel.UIPagoCriteriaPanel;

/**
 * Frame para pagos
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class PagosCRUDFrame extends CRUDFrame<Pago> implements IPagoListener{

	public PagosCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIPagoCriteriaPanel();
	}

	public void initLinks() {
		
		
		LinkOpenDialogWithSelected linkView = LinkPagoFactory.getLinkView();
		this.addElementsListener(linkView);

		LinkOpenDialogWithSelected linkAnular = LinkPagoFactory.getLinkAnular();
		this.addElementsListener(linkAnular);

		LinkOpenDialogWithSelected linkDelete  = LinkPagoFactory.getLinkDelete();
		this.addElementsListener(linkDelete);
		
		this.addLinkToDefaultMenu( linkView, 0 );
		this.addLinkToDefaultMenu( linkAnular, 1 );
		this.addLinkToDefaultMenu( linkDelete, 2 );

		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkView);
		rightClick.add(linkAnular);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.PAGO_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.PAGOS_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}