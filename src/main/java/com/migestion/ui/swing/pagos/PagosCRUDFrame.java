package com.migestion.ui.swing.pagos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.LinkViewObject;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.swing.view.frames.ICRUDFrame;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.pagos.links.LinkAddPago;
import com.migestion.ui.swing.pagos.panel.UIPagoCriteriaPanel;

/**
 * Frame para pagos
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class PagosCRUDFrame implements ICRUDFrame{

	private UIPagoCriteriaPanel buscarPanel;
	
	public PagosCRUDFrame(){
		buscarPanel = new UIPagoCriteriaPanel();
	}
	

	public ICriteriaPanel getUICriteriaPanel() {
		return buscarPanel;
	}

	public void setLinks(CRUDFrame frame) {
		
		//LinkUpdateObject linkUpdate  = LinkPagoFactory.getLinkUpdate();
		
//		LinkAddPago linkAdd  = LinkPagoFactory.getLinkAddPago();
//		linkAdd.addListener( frame );
		
		LinkViewObject linkView = LinkPagoFactory.getLinkView();

//		LinkUpdateObject linkAnular = LinkPagoFactory.getLinkAnularPago();

		LinkDeleteObject linkDelete  = LinkPagoFactory.getLinkDelete();
		
//		frame.addLinkToDefaultMenu(linkAdd, 0 );
		frame.setLinkView( linkView, 1 );

//		frame.addElementsListener(linkAnular);
//		linkAnular.addListener(frame);
//		frame.addLinkToDefaultMenu( linkAnular, 2 );
		
		frame.setLinkDelete( linkDelete, 3 );
		
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkView);
//		rightClick.add(linkAnular);
		rightClick.add(linkDelete);
		
		frame.setRightClickPopup(rightClick);
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