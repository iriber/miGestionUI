package com.migestion.ui.swing.categoriasProducto.factories;


import javax.swing.ImageIcon;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.dialogs.DialogAddObject;
import com.migestion.swing.view.dialogs.DialogDeleteObject;
import com.migestion.swing.view.dialogs.DialogUpdateObject;
import com.migestion.swing.view.dialogs.adapters.DialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.DialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.DialogUpdateAdapter;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.categoriasProducto.CategoriasProductoCRUDFrame;
import com.migestion.ui.swing.categoriasProducto.dialog.DialogFindCategoriaProducto;
import com.migestion.ui.swing.categoriasProducto.panels.CategoriaProductoPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para 
 * categorías de productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class WindowCategoriaProductoFactory {

	
	/**
	 * ventana para agregar una categoria de producto.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.CATEGORIA_PRODUCTO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUICategoriaProductoService(), new CategoriaProductoPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

	/**
	 * ventana para modificar una categoria de producto.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.CATEGORIA_PRODUCTO_DIALOG_MODIFICAR_TITULO, UIServiceFactory.getUICategoriaProductoService(), new CategoriaProductoPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar una categoria de producto.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.CATEGORIA_PRODUCTO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUICategoriaProductoService(), new CategoriaProductoPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar categorias de producto.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		CRUDFrame frame = new CRUDFrame(I18nMessages.CATEGORIA_PRODUCTO_FRAME_TITULO, UIServiceFactory.getUICategoriaProductoService(), new CategoriasProductoCRUDFrame());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		return frame;
	}
	
	/**
	 * ventana para buscar una categoría de producto.
	 */
	public static DialogFindCategoriaProducto getWindowFind() {
		DialogFindCategoriaProducto dialog = new  DialogFindCategoriaProducto( I18nMessages.CATEGORIA_PRODUCTO_DIALOG_BUSCAR_TITULO );
		return dialog;
	}
	
}
