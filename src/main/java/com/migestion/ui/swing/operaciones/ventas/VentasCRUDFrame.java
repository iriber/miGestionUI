package com.migestion.ui.swing.operaciones.ventas;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.model.Pago;
import com.migestion.model.Venta;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.observers.listeners.IVentaListener;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
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
public class VentasCRUDFrame extends CRUDFrame<Venta> implements IVentaListener{

	public VentasCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIVentaCriteriaPanel();
	}

	public void initLinks() {
		
		
		Link linkAdd  = LinkVentaFactory.getLinkAdd();
		
		LinkOpenDialogWithSelected linkView = LinkVentaFactory.getLinkView();
		this.addElementsListener(linkView);

		LinkOpenDialogWithSelected linkAnular = LinkVentaFactory.getLinkAnularVenta();
		this.addElementsListener(linkAnular);

		LinkOpenDialogWithSelected linkDelete  = LinkVentaFactory.getLinkDelete();
		this.addElementsListener(linkDelete);

		LinkPagarVenta linkPagarVenta = LinkPagoFactory.getLinkPagarVenta();
		this.addElementsListener(linkPagarVenta);

		//this.setLinkAdd( linkAdd, 0 );
		//this.setLinkUpdate( linkUpdate, 1 );
		
		this.addLinkToDefaultMenu( linkAdd, 0 );
		this.addLinkToDefaultMenu( linkView, 1 );
		this.addLinkToDefaultMenu( linkAnular, 2 );
		this.addLinkToDefaultMenu( linkPagarVenta, 3 );
		this.addLinkToDefaultMenu( linkDelete, 4 );

		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkView);
		rightClick.add(linkPagarVenta);
		rightClick.add(linkAnular);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
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

	public void pagoVentaCreado(Pago pago) {
		refreshTable();
	}
}
