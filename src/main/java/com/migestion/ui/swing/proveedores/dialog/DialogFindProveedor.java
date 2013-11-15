package com.migestion.ui.swing.proveedores.dialog;



import javax.swing.JPanel;

import com.migestion.model.Proveedor;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.proveedores.UIProveedorCollection;
import com.migestion.ui.swing.proveedores.factories.LinkProveedorFactory;
import com.migestion.ui.swing.proveedores.panel.UIProveedorCriteriaPanel;

/**
 * Diálogo para buscar un proveedor.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class DialogFindProveedor extends DialogFindObject<Proveedor>{


	private UIProveedorCriteriaPanel criteriaPanel;
	
	public DialogFindProveedor(String title) {
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
			 criteriaPanel = new UIProveedorCriteriaPanel();
			
		return criteriaPanel;
	}
	
	/*
	 * 
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUIProveedorService();
	}

	/*
	 * 
	 */
	protected UICollection getUICollectionDefault() {
		return new UIProveedorCollection( I18nMessages.PROVEEDORES);
	}

	@Override
	protected LinkOpenDialog getLinkAdd() {
		
		return LinkProveedorFactory.getLinkAdd();
	}


	

}
