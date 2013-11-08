package com.migestion.ui.swing.notasCredito.factories;


import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.CRUDFrame;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.notasCredito.NotasCreditoCRUDFrame;

/**
 * Proporciona métodos para la creación de ventanas para notas de crédito.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class WindowNotaCreditoFactory {


	/**
	 * ventana para listar notas de crédito.
	 * @return
	 */
	public static CRUDFrame getWindowList(){
		NotasCreditoCRUDFrame frame = new NotasCreditoCRUDFrame(I18nMessages.NOTA_CREDITO_FRAME_TITULO, UIServiceFactory.getUINotaCreditoService());
		AppContext.getInstance().addToContainer((ILinkWindowList)frame);
		
		//escuchará cambios sobre los notas de crédito.
		//TODO AppContext.getInstance().getProductoObserver().addListener( frame );
		
		return frame;
	}
	

}
