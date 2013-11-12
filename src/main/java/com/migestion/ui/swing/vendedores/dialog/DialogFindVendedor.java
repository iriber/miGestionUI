package com.migestion.ui.swing.vendedores.dialog;



import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.factories.JTextFieldFactory;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.navigation.LinkOpenWindow;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.PropertyInput;
import com.migestion.ui.criteria.UIVendedorCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.vendedores.UIVendedorCollection;

/**
 * Diálogo para buscar un vendedor.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 16/10/2013
 *
 */
public class DialogFindVendedor extends DialogFindObject{

	
	public DialogFindVendedor(String title) {
		super(title);
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		UIVendedorCriteria criteria = new UIVendedorCriteria();
		criteria.setNombre(getInputNombre());
		criteria.setPaginable(true);
		return criteria;
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
		JTextField txtNombre = JTextFieldFactory.getJTextField("",150);
		PropertyInput prop1 = new PropertyInput("Nombre", I18nMessages.CLIENTE_NOMBRE ,80,txtNombre);
	
		addPropertyInput(prop1);
		
		JPanel inputs = this.autoGenerateInfoPanel(1); 
		JPanel inputsWithTip = new JPanel(new BorderLayout());
		inputsWithTip.add(inputs, BorderLayout.NORTH);
		return inputsWithTip;
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

	//--------------------
	//M�TODOS PRIVADOS
	//--------------------
	
	private String getInputNombre(){
		return ((JTextField)getInput("Nombre")).getText();
	}
	
	@Override
	protected LinkOpenDialog getLinkAdd() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
