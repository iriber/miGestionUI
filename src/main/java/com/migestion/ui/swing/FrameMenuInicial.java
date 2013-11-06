package com.migestion.ui.swing;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame principal de la app
 *  
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 * 
 */

public class FrameMenuInicial extends JFrameContainer {

	// men�
	protected JMenuBar menuBar;
	
	

	public FrameMenuInicial() {
		super( I18nMessages.TITULO_MAIN );
		inicializar();
	}

	private void inicializar() {

		AppContext.getInstance().setMainContainer(this);
		
		setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());

		this.replaceToolbar( new PanelMenuToolbar() );
		
		toogleTaskPane();
		
		setSize(850, 700);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
	}

}
