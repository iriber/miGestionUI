package com.migestion.ui.swing.productos.dialog;



import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.factories.JTextFieldFactory;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.PropertyInput;
import com.migestion.ui.criteria.UIProductoCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.UIProductoCollection;

/**
 * Diálogo para buscar un producto.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class DialogFindProducto extends DialogFindObject{

	//-----------------
	// CONSTRUCTORES
	//-----------------
	
	public DialogFindProducto(String title) {
		super(title);
	}
	
	
	//--------------------
	//M�TODOS PROTECTED
	//--------------------	


	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		UIProductoCriteria criteria = new UIProductoCriteria();
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
		PropertyInput prop1 = new PropertyInput("Nombre", I18nMessages.PRODUCTO_NOMBRE ,80,txtNombre);
	
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
		return (IControllerList)UIServiceFactory.getUIProductoService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UIProductoCollection( I18nMessages.PRODUCTOS);
	}

	//--------------------
	//M�TODOS PRIVADOS
	//--------------------
	
	private String getInputNombre(){
		return ((JTextField)getInput("Nombre")).getText();
	}


	

}
