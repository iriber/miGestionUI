package com.migestion.ui.swing.cheques.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cheques.ChequesCRUDFrame;
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
	

}
