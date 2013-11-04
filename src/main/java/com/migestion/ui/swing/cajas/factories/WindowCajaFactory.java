package com.migestion.ui.swing.cajas.factories;


import com.migestion.ui.swing.cajas.dialog.DialogFindCaja;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para productos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class WindowCajaFactory {


	/**
	 * ventana para buscar una caja.
	 */
	public static DialogFindCaja getWindowFind() {
		DialogFindCaja dialog = new  DialogFindCaja( I18nMessages.CAJA_DIALOG_BUSCAR_TITULO );
		return dialog;
	}
	
//	/**
//	 * ventana para agregar un producto.
//	 */
//	public static DialogAddObject getWindowAdd(){			    
//
//		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.PRODUCTO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIProductoService(), new ProductoPanel() );
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
//		return dialog;
//	}
//
//	/**
//	 * ventana para modificar un producto.
//	 */
//	public static DialogUpdateObject getWindowUpdate(){			    
//
//		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.PRODUCTO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIProductoService(), new ProductoPanel() );
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}
//		
//	/**
//	 * ventana para eliminar un producto.
//	 */
//	public static DialogDeleteObject getWindowDelete(){			    
//		
//		
//		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.PRODUCTO_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUIProductoService(), new ProductoPanel());
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
//		return dialog;
//		
//	}
//
//	/**
//	 * ventana para listar productos.
//	 * @return
//	 */
//	public static CRUDFrame getWindowList(){
//		CRUDFrame frame = new CRUDFrame(I18nMessages.PRODUCTO_FRAME_TITULO, UIServiceFactory.getUIProductoService(), new ProductosCRUDFrame());
//		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
//		return frame;
//	}
//	
//
//	/**
//	 * ventana para activar un producto.
//	 */
//	public static DialogActivarProducto getWindowActivar(){			    
//
//		DialogActivarProducto dialog = new DialogActivarProducto(I18nMessages.PRODUCTO_DIALOG_ACTIVAR_TITULO);
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}
//		
//	/**
//	 * ventana para desactivar un producto.
//	 */
//	public static DialogDesactivarProducto getWindowDesactivar(){			    
//
//		DialogDesactivarProducto dialog = new DialogDesactivarProducto(I18nMessages.PRODUCTO_DIALOG_DESACTIVAR_TITULO);
//		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
//		return dialog;
//
//	}

}
