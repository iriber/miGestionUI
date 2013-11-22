package com.migestion.ui.swing.operaciones.ordenesCompra;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.model.OrdenCompra;
import com.migestion.model.Pago;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.observers.listeners.IOrdenCompraListener;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.factories.LinkOrdenCompraFactory;
import com.migestion.ui.swing.operaciones.ordenesCompra.panel.UIOrdenCompraCriteriaPanel;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.pagos.links.LinkPagarOrdenCompra;

/**
 * Frame para órdenes de compra
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class OrdenesCompraCRUDFrame extends CRUDFrame<OrdenCompra> implements IOrdenCompraListener{

	public OrdenesCompraCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIOrdenCompraCriteriaPanel();
	}

	public void initLinks() {
		
		
		Link linkAdd  = LinkOrdenCompraFactory.getLinkAdd();
		
		LinkOpenDialogWithSelected linkView = LinkOrdenCompraFactory.getLinkView();
		this.addElementsListener(linkView);

		LinkOpenDialogWithSelected linkAnular = LinkOrdenCompraFactory.getLinkAnularOrdenCompra();
		this.addElementsListener(linkAnular);

		LinkOpenDialogWithSelected linkDelete  = LinkOrdenCompraFactory.getLinkDelete();
		this.addElementsListener(linkDelete);

		LinkPagarOrdenCompra linkPagarOrdenCompra = LinkPagoFactory.getLinkPagarOrdenCompra();
		this.addElementsListener(linkPagarOrdenCompra);

		//this.setLinkAdd( linkAdd, 0 );
		//this.setLinkUpdate( linkUpdate, 1 );
		
		this.addLinkToDefaultMenu( linkAdd, 0 );
		this.addLinkToDefaultMenu( linkView, 1 );
		this.addLinkToDefaultMenu( linkAnular, 2 );
		this.addLinkToDefaultMenu( linkPagarOrdenCompra, 3 );
		this.addLinkToDefaultMenu( linkDelete, 4 );

		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkView);
		rightClick.add(linkPagarOrdenCompra);
		rightClick.add(linkAnular);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.ORDEN_COMPRA_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.ORDENES_COMPRA_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

	public void pagoOrdenCompraCreado(Pago pago) {
		refreshTable();
	}
}
