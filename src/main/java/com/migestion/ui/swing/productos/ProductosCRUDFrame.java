package com.migestion.ui.swing.productos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.model.Venta;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.IProductoListener;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
import com.migestion.ui.swing.productos.panel.UIProductoCriteriaPanel;

/**
 * Frame para productos
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class ProductosCRUDFrame extends CRUDFrame implements IProductoListener{

	
	public ProductosCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UIProductoCriteriaPanel();
	}

	public void initLinks() {
		
		LinkUpdateObject linkUpdate  = LinkProductoFactory.getLinkUpdate();
		LinkAddObject linkAdd  = LinkProductoFactory.getLinkAdd();
		LinkDeleteObject linkDelete  = LinkProductoFactory.getLinkDelete();
		LinkUpdateObject linkActivar = LinkProductoFactory.getLinkActivarProducto();
		LinkUpdateObject linkDesactivar = LinkProductoFactory.getLinkDesactivarProducto();
		
		this.setLinkAdd( linkAdd, 0 );
		this.setLinkUpdate( linkUpdate, 1 );
		this.setLinkDelete( linkDelete, 2 );
		
		
		this.addElementsListener(linkActivar);
		linkActivar.addListener(this);
		this.addLinkToDefaultMenu( linkActivar, 3 );
		
		this.addElementsListener(linkDesactivar);
		linkDesactivar.addListener(this);
		this.addLinkToDefaultMenu( linkDesactivar, 4 );
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkActivar);
		rightClick.add(linkDesactivar);
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.PRODUCTO_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.PRODUCTOS_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}


	public void ventaChange(Venta venta) {
		refreshTable();
	}

}
