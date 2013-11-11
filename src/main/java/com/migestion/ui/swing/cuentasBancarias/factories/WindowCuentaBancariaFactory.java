package com.migestion.ui.swing.cuentasBancarias.factories;


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
import com.migestion.ui.swing.cuentasBancarias.CuentasBancariasCRUDFrame;
import com.migestion.ui.swing.cuentasBancarias.panel.CuentaBancariaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para cuentasBancarias.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class WindowCuentaBancariaFactory {


	/**
	 * ventana para agregar un cuentaBancaria.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.CUENTA_BANCARIA_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUICuentaBancariaService(), new CuentaBancariaPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

	/**
	 * ventana para modificar un cuentaBancaria.
	 */
	public static DialogUpdateObject getWindowUpdate(){			    

		DialogUpdateObject dialog = new DialogUpdateAdapter(I18nMessages.CUENTA_BANCARIA_DIALOG_MODIFICAR_TITULO, UIServiceFactory.getUICuentaBancariaService(), new CuentaBancariaPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Update ).getImage() );
		return dialog;

	}
		
	/**
	 * ventana para eliminar un cuentaBancaria.
	 */
	public static DialogDeleteObject getWindowDelete(){			    
		
		
		DialogDeleteObject dialog = new DialogDeleteAdapter( I18nMessages.CUENTA_BANCARIA_DIALOG_ELIMINAR_TITULO, UIServiceFactory.getUICuentaBancariaService(), new CuentaBancariaPanel());
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Delete ).getImage() );
		return dialog;
		
	}

	/**
	 * ventana para listar cuentasBancarias.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		CuentasBancariasCRUDFrame frame = new CuentasBancariasCRUDFrame(I18nMessages.CUENTA_BANCARIA_FRAME_TITULO, UIServiceFactory.getUICuentaBancariaService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		//escuchará cambios sobre los cuentasBancarias.
		AppContext.getInstance().getCuentaBancariaObserver().addListener( frame );
		
		return frame;
	}


}