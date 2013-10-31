package com.migestion.ui.swing.categoriasProducto;

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
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.categoriasProducto.panels.UICategoriaProductoCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
import com.migestion.ui.swing.productos.panel.UIProductoCriteriaPanel;

/**
 * Frame para categorías de producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class CategoriasProductoCRUDFrame implements ICRUDFrame{

	private UICategoriaProductoCriteriaPanel buscarPanel;
	
	public CategoriasProductoCRUDFrame(){
		buscarPanel = new UICategoriaProductoCriteriaPanel();
	}
	

	public ICriteriaPanel getUICriteriaPanel() {
		return buscarPanel;
	}

	public void setLinks(CRUDFrame frame) {
		
		LinkUpdateObject linkUpdate  = LinkCategoriaProductoFactory.getLinkUpdate();
		LinkAddObject linkAdd  = LinkCategoriaProductoFactory.getLinkAdd();
		LinkDeleteObject linkDelete  = LinkCategoriaProductoFactory.getLinkDelete();
		
		frame.setLinkAdd( linkAdd, 0 );
		frame.setLinkUpdate( linkUpdate, 1 );
		frame.setLinkDelete( linkDelete, 2 );
		
		
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		frame.setRightClickPopup(rightClick);
	}

	public String getMenuTitle() {
		
		return I18nMessages.CATEGORIA_PRODUCTO_FRAME_MENUADMIN ;
		
	}

	public URL getIcon() {
		
		return I18nImages.CATEGORIAS_PRODUCTO_SMALL_ICON;
		
	}

	public JComponent getFooter() {
		JLabel lblFooter = new JLabel(""  );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

}
