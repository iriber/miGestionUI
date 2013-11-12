package com.migestion.ui.swing.cheques.factories;


import java.awt.Frame;

import javax.swing.ImageIcon;

import com.migestion.swing.i18n.links.LinkImagesBundle;
import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cheques.ChequesCRUDFrame;
import com.migestion.ui.swing.cheques.dialog.DialogAddCheque;
import com.migestion.ui.swing.cheques.dialog.DialogFindCheque;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Proporciona métodos para la creación de ventanas para cheques.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class WindowChequeFactory {


	/**
	 * ventana para agregar un cheque.
	 */
	public static DialogAddCheque getWindowAdd(){			    

		DialogAddCheque dialog = new DialogAddCheque(new Frame(), true );
		dialog.setIconImage(new ImageIcon( LinkImagesBundle.link_Add ).getImage() );
		return dialog;
	}


	/**
	 * ventana para listar cheques.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		ChequesCRUDFrame frame = new ChequesCRUDFrame(I18nMessages.CHEQUE_FRAME_TITULO, UIServiceFactory.getUIChequeService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		//escuchará cambios sobre los cheques.
		//TODO AppContext.getInstance().getProductoObserver().addListener( frame );
		
		return frame;
	}

	
	/**
	 * ventana para buscar un cheque.
	 */
	public static DialogFindCheque getWindowFind() {
		DialogFindCheque dialog = new  DialogFindCheque( I18nMessages.CHEQUE_DIALOG_BUSCAR_TITULO );
		return dialog;
	}



}
