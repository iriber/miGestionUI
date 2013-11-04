package com.migestion.ui.swing.cajas.dialog;

import javax.swing.JPanel;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cajas.UICajaCollection;
import com.migestion.ui.swing.cajas.panel.UICajaCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Diálogo para buscar una caja.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class DialogFindCaja extends DialogFindObject{

	private UICajaCriteriaPanel buscarPanel;
	
	
	public DialogFindCaja(String title) {
		super(title);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		return buscarPanel.getCriteria();
	}

	/*
	 *  (non-Javadoc)
	 * @see com.ostrich.commonui.view.dialogs.DialogFindObject#validateInput()
	 */
	protected void validateInput() throws ViewException {
		// nada.		
	}

	/*
	 *  (non-Javadoc)
	 * @see com.ostrich.commonui.view.dialogs.DialogFindObject#createCriteriaPanel()
	 */
	protected JPanel createCriteriaPanel() {

		
		if(buscarPanel == null )
			buscarPanel = new UICajaCriteriaPanel();
		
		return buscarPanel;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUICajaService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UICajaCollection( I18nMessages.CAJAS);
	}

	

}
