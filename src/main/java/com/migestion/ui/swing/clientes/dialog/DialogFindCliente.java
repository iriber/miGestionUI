package com.migestion.ui.swing.clientes.dialog;



import javax.swing.JPanel;

import com.migestion.model.Cliente;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.context.observers.listeners.IClienteListener;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.clientes.UIClienteCollection;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.clientes.panel.UIClienteCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Diálogo para buscar un cliente.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class DialogFindCliente extends DialogFindObject<Cliente>{


	private UIClienteCriteriaPanel criteriaPanel;
	
	public DialogFindCliente(String title) {
		super(title);
	}
	

	/*
	 * 
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		return criteriaPanel.getCriteria();
	}

	/*
	 * 
	 */
	protected void validateInput() throws ViewException {
		// nada.		
	}

	/*
	 * 
	 */
	protected JPanel createCriteriaPanel() {
		if( criteriaPanel == null )
			 criteriaPanel = new UIClienteCriteriaPanel();
			
		return criteriaPanel;
	}
	
	/*
	 * 
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUIClienteService();
	}

	/*
	 * 
	 */
	protected UICollection getUICollectionDefault() {
		return new UIClienteCollection( I18nMessages.CLIENTES);
	}

	@Override
	protected LinkOpenDialog getLinkAdd() {
		
		return LinkClienteFactory.getLinkAdd();
	}

}
