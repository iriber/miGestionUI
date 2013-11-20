package com.migestion.ui.swing.categoriasProducto;

import java.awt.Font;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.categoriasProducto.panels.UICategoriaProductoCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame para categorías de producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class CategoriasProductoCRUDFrame extends CRUDFrame{

	
	public CategoriasProductoCRUDFrame(String title, IControllerList controller){
		
		super(title, controller);
		
	}
	

	public ICriteriaPanel buildUICriteriaPanel() {
		return new UICategoriaProductoCriteriaPanel();
	}

	public void initLinks() {
		
		Link linkAdd  = LinkCategoriaProductoFactory.getLinkAdd();
		
		LinkOpenDialogWithSelected linkUpdate  = LinkCategoriaProductoFactory.getLinkUpdate();
		this.addElementsListener(linkUpdate);
		
		LinkOpenDialogWithSelected linkDelete  = LinkCategoriaProductoFactory.getLinkDelete();
		this.addElementsListener(linkDelete);
		
		this.addLinkToDefaultMenu( linkAdd, 0 );
		this.addLinkToDefaultMenu( linkUpdate, 1 );
		this.addLinkToDefaultMenu( linkDelete, 2 );
		
		
		JPopupMenu rightClick = new JPopupMenu();
		
		rightClick.add(linkUpdate);
		rightClick.add(linkDelete);
		
		this.setRightClickPopup(rightClick);
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
