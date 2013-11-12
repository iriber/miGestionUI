package com.migestion.ui.swing.gastos.factories;


import javax.swing.ImageIcon;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.dialogs.DialogAddObject;
import com.migestion.swing.view.dialogs.adapters.DialogAddAdapter;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.gastos.GastosCRUDFrame;
import com.migestion.ui.swing.gastos.panel.GastoPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para gastos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 *
 */
public class WindowGastoFactory {


	/**
	 * ventana para listar gastos.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		GastosCRUDFrame frame = new GastosCRUDFrame(I18nMessages.GASTO_FRAME_TITULO, UIServiceFactory.getUIGastoService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		//escuchará cambios sobre los gastos.
		//AppContext.getInstance().getGastoObserver().addListener( (IContextListener<Gasto>) frame );
		
		return frame;
	}


	/**
	 * ventana para agregar un gasto.
	 */
	public static DialogAddObject getWindowAdd(){			    

		DialogAddObject dialog = new DialogAddAdapter(I18nMessages.GASTO_DIALOG_AGREGAR_TITULO, UIServiceFactory.getUIGastoService(), new GastoPanel() );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}

	

}
