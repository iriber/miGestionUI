package com.migestion.ui.swing.operaciones.ventas;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.swing.navigation.LinkAddRelatedObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.navigation.LinkViewObject;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.swing.view.frames.ICRUDFrame;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
import com.migestion.ui.swing.operaciones.ventas.links.LinkAddVenta;
import com.migestion.ui.swing.operaciones.ventas.panel.UIVentaCriteriaPanel;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.pagos.links.LinkPagarVenta;

/**
 * Frame para ventas
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public class VentasCRUDFrame implements ICRUDFrame{

	private UIVentaCriteriaPanel buscarPanel;
	
	public VentasCRUDFrame(){
		buscarPanel = new UIVentaCriteriaPanel();
	}
	

	public ICriteriaPanel getUICriteriaPanel() {
		return buscarPanel;
	}

	public void setLinks(CRUDFrame frame) {
		
		//LinkUpdateObject linkUpdate  = LinkVentaFactory.getLinkUpdate();
		
		LinkAddVenta linkAdd  = LinkVentaFactory.getLinkAddVenta();
		linkAdd.addListener( frame );
		
		LinkViewObject linkView = LinkVentaFactory.getLinkView();

		LinkPagarVenta linkPagarVenta = LinkPagoFactory.getLinkPagarVenta();
		frame.addElementsListener(linkPagarVenta);
		linkPagarVenta.addListener(frame);

		LinkUpdateObject linkAnular = LinkVentaFactory.getLinkAnularVenta();

		LinkDeleteObject linkDelete  = LinkVentaFactory.getLinkDelete();
		
		frame.addLinkToDefaultMenu(linkAdd, 0 );
		frame.setLinkView( linkView, 1 );

		frame.addElementsListener(linkAnular);
		linkAnular.addListener(frame);
		frame.addLinkToDefaultMenu( linkAnular, 2 );
		
		frame.setLinkDelete( linkDelete, 3 );
		
		frame.addLinkToDefaultMenu(linkPagarVenta, 4 );
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkView);
		rightClick.add(linkPagarVenta);
		rightClick.add(linkAnular);
		rightClick.add(linkDelete);
		
		frame.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.VENTA_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.VENTAS_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}
