package com.migestion.ui.swing.categoriasProducto.factories;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.i18n.links.LinkLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.LinkOpenDialogWithSelected;
import com.migestion.swing.navigation.interfaces.ILinkWindowObjectOpen;
import com.migestion.swing.navigation.interfaces.ILinkWindowOpen;
import com.migestion.ui.swing.LinkHelper;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;


/**
 * Proporciona métodos para la construcción de links para 
 * categorías de productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class LinkCategoriaProductoFactory {


	/**
	 * link para agregar una categoría de producto.
	 */
	public static Link getLinkAdd(){			    
		//return LinkAddCuenta.getInstance();
		Link link =  new LinkOpenDialog(I18nMessages.CATEGORIA_PRODUCTO_ACCION_AGREGAR,LinkImagesBundle.link_Add, LinkLabelsBundle.link_Add_KeyStroke) {
			
			@Override
			protected ILinkWindowOpen getDialog() {
				
				return WindowCategoriaProductoFactory.getWindowAdd();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_ADD_KEY_STROKE );
		return link;
		
	}

	/**
	 * link para modificar una categoría de producto.
	 */
	public static LinkOpenDialogWithSelected getLinkUpdate(){			    
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CATEGORIA_PRODUCTO_ACCION_MODIFICAR,LinkImagesBundle.link_Update) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowCategoriaProductoFactory.getWindowUpdate();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_UPDATE_KEY_STROKE );
		return link;
		
	}
	
	/**
	 * link para eliminar una categoría de producto.
	 */
	public static LinkOpenDialogWithSelected getLinkDelete(){
		
		LinkOpenDialogWithSelected link =  new LinkOpenDialogWithSelected(I18nMessages.CATEGORIA_PRODUCTO_ACCION_ELIMINAR,LinkImagesBundle.link_Delete, LinkLabelsBundle.link_Delete_KeyStroke) {
			
			@Override
			protected ILinkWindowObjectOpen getDialog() {
				
				return WindowCategoriaProductoFactory.getWindowDelete();
			}
			
		};
		link.setKeyStroke( LinkHelper.LINK_DELETE_KEY_STROKE );
		return link;
	}
	
	
	/**
	 * link para listar categorías de producto.
	 * @return
	 */
	public static LinkListCollection getLinkList(){
		LinkListCollection link = new LinkListCollection(WindowCategoriaProductoFactory.getWindowList(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_LISTAR, I18nImages.CATEGORIAS_PRODUCTO_ICON);
		link.setKeyStroke( LinkHelper.LINK_CATEGORIAS_PRODUCTOS_KEY_STROKE );
		return link;
	}

	/**
	 * link para listar categorías de producto en forma de árbol.
	 * @return
	 */
	public static LinkListCollection getLinkListTree(){
		LinkListCollection link = new LinkListCollection(WindowCategoriaProductoFactory.getWindowListTree(), I18nMessages.CATEGORIA_PRODUCTO_ACCION_LISTAR, I18nImages.CATEGORIAS_PRODUCTO_ICON);
		link.setKeyStroke( LinkHelper.LINK_CATEGORIAS_PRODUCTOS_KEY_STROKE );
		return link;
	}
	
	
}
