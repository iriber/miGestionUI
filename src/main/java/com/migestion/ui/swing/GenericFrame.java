package com.migestion.ui.swing;


import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.frames.GenericInternalFrameList;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Frame genérico para MiGestion
 *  
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 *
 */
public class GenericFrame extends GenericInternalFrameList{ //implements IContextoAplicacionListener{

	public GenericFrame(String title, IControllerList controller) {
		super( title );
		init(title, controller);
	}

	public GenericFrame(String title, IControllerList controller, UICollection initCollection) {
		super( title );
		init(title, controller,initCollection);
	}
	
	/**
	 * retorna el panel de header donde se mostrar� 
	 * la descripci�n del listado.
	 * 
	 * por default nos proporciona un label con la descripci�n 
	 * del criteria, vamos a tomar eso y le vamos a agregar
	 * el logo de la empresa.
	 */
	/* TODO cambiar cuando tengamos el logo.
	protected JComponent getHeader(){
		//panel para el header.
		JPanel panelHeader = new JPanel(new BorderLayout());
		panelHeader.add(getCustomHeader(), BorderLayout.NORTH);
		panelHeader.add(super.getHeader(), BorderLayout.SOUTH);
		return panelHeader;
	}*/
	
/*
    protected JComponent getCustomHeader(){
        //scroller para mostrar el logo de la empresa.
        return new ImageScroller(new CustomImageIcon(PropertiesImages.LOGO), getBackground());
    }
*/

    
    
	@Override
	protected JPanel getNavigation() {
		this.rowCount = 20;
		return super.getNavigation();
	}

	/**
	 * retorna el panel de footer.
	 */
	public JComponent getFooter(){			
		//JLabel lblFooter = new JLabel(" � Copyright 2005-" + DateUtils.getYear(DateUtils.today())+ " " + PropertiesEmpresa.EMPRESA_NOMBRE + " | Cuentas ");
		JLabel lblFooter = new JLabel(" (c) Copyright 2005-"  + I18nMessages.EMPRESA_NOMBRE + " | " + I18nMessages.TITULO_MAIN );
		lblFooter.setFont(new Font("Arial",1,11));
		lblFooter.setHorizontalAlignment(SwingConstants.RIGHT);		
		return lblFooter;
	}

	public void open(){
		super.open();
	}
	
	
}
