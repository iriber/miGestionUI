package com.migestion.ui.swing.vendedores.dialog;



import javax.swing.JPanel;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.vendedores.UIVendedorCollection;
import com.migestion.ui.swing.vendedores.panel.UIVendedorCriteriaPanel;

/**
 * Diálogo para buscar un vendedor.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 16/10/2013
 *
 */
public class DialogFindVendedor extends DialogFindObject{

	private UIVendedorCriteriaPanel criteriaPanel;
	
	
	public DialogFindVendedor(String title) {
		super(title);
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
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
			 criteriaPanel = new UIVendedorCriteriaPanel();
			
		return criteriaPanel;

	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUIVendedorService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UIVendedorCollection( I18nMessages.VENDEDORES);
	}

	
	@Override
	protected LinkOpenDialog getLinkAdd() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
