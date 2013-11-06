package com.migestion.ui.swing.productos.factories;


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
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.ProductosCRUDFrame;
import com.migestion.ui.swing.productos.dialog.DialogActivarProducto;
import com.migestion.ui.swing.productos.dialog.DialogDesactivarProducto;
import com.migestion.ui.swing.productos.dialog.DialogFindProducto;
import com.migestion.ui.swing.productos.panel.ProductoPanel2;

/**
 * Proporciona métodos para la creación de ventanas para productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class WindowProductoFactory {


	/**
	 * ventana para agregar un producto.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.PRODUCTO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIProductoService(), new ProductoPanel2() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

	/**
	 * ventana para modificar un producto.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.PRODUCTO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIProductoService(), new ProductoPanel2() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar un producto.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PRODUCTO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIProductoService(), new ProductoPanel2());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar productos.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		ProductosCRUDFrame frame = new ProductosCRUDFrame(I18nMessages.PRODUCTO_FRAME_TITULO, UIServiceFactory.getUIProductoService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		AppContext.getInstance().getProductoObserver().addListener( frame );
		
		return frame;
	}
	
	/**
	 * ventana para buscar un producto.
	 */
	public static DialogFindProducto getWindowFind() {
		DialogFindProducto dialog = new  DialogFindProducto( I18nMessages.PRODUCTO_DIALOG_BUSCAR_TITULO );
		return dialog;
	}

	/**
	 * ventana para activar un producto.
	 */
	public static DialogActivarProducto getWindowActivar(){			    

		DialogActivarProducto dialog = new DialogActivarProducto(I18nMessages.PRODUCTO_DIALOG_ACTIVAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para desactivar un producto.
	 */
	public static DialogDesactivarProducto getWindowDesactivar(){			    

		DialogDesactivarProducto dialog = new DialogDesactivarProducto(I18nMessages.PRODUCTO_DIALOG_DESACTIVAR_TITULO);
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}

}
