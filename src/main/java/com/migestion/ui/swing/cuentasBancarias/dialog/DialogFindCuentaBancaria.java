package com.migestion.ui.swing.cuentasBancarias.dialog;



import javax.swing.JPanel;

import com.migestion.model.CuentaBancaria;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cuentasBancarias.UICuentaBancariaCollection;
import com.migestion.ui.swing.cuentasBancarias.panel.UICuentaBancariaCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Diálogo para buscar una cuenta bancaria.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 *
 */
public class DialogFindCuentaBancaria extends DialogFindObject<CuentaBancaria>{

	private UICuentaBancariaCriteriaPanel criteriaPanel;
	
	public DialogFindCuentaBancaria(String title) {
		super(title);
	}
	

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		//UIChequeCriteria criteria = new UIChequeCriteria();
		//criteria.setPaginable(true);
		return criteriaPanel.getCriteria();
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
		if( criteriaPanel == null )
		 criteriaPanel = new UICuentaBancariaCriteriaPanel();
		
		return criteriaPanel;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUICuentaBancariaService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UICuentaBancariaCollection( I18nMessages.CUENTAS_BANCARIAS);
	}

	@Override
	protected LinkOpenDialog getLinkAdd() {
		
		return null;
	}

}