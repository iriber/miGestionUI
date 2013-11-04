package com.migestion.ui.swing.productos;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.swing.navigation.LinkAddObject;
import com.migestion.swing.navigation.LinkDeleteObject;
import com.migestion.swing.navigation.LinkUpdateObject;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.swing.view.frames.ICRUDFrame;
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
public class ProductosCRUDFrame implements ICRUDFrame{

	private UIProductoCriteriaPanel buscarPanel;
	
	public ProductosCRUDFrame(){
		buscarPanel = new UIProductoCriteriaPanel();
	}
	

	public ICriteriaPanel getUICriteriaPanel() {
		return buscarPanel;
	}

	public void setLinks(CRUDFrame frame) {
		
		LinkUpdateObject linkUpdate  = LinkProductoFactory.getLinkUpdate();
		LinkAddObject linkAdd  = LinkProductoFactory.getLinkAdd();
		LinkDeleteObject linkDelete  = LinkProductoFactory.getLinkDelete();
		LinkUpdateObject linkActivar = LinkProductoFactory.getLinkActivarProducto();
		LinkUpdateObject linkDesactivar = LinkProductoFactory.getLinkDesactivarProducto();
		
		frame.setLinkAdd( linkAdd, 0 );
		frame.setLinkUpdate( linkUpdate, 1 );
		frame.setLinkDelete( linkDelete, 2 );
		
		
		frame.addElementsListener(linkActivar);
		linkActivar.addListener(frame);
		frame.addLinkToDefaultMenu( linkActivar, 3 );
		
		frame.addElementsListener(linkDesactivar);
		linkDesactivar.addListener(frame);
		frame.addLinkToDefaultMenu( linkDesactivar, 4 );
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkActivar);
		rightClick.add(linkDesactivar);
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		frame.setRightClickPopup(rightClick);
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

}
