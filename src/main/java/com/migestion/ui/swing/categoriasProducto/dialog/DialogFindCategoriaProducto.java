package com.migestion.ui.swing.categoriasProducto.dialog;



import javax.swing.JPanel;

import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.categoriasProducto.UICategoriaProductoCollection;
import com.migestion.ui.swing.categoriasProducto.panels.UICategoriaProductoCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Diálogo para buscar una categoría de producto.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class DialogFindCategoriaProducto extends DialogFindObject{

	
	UICategoriaProductoCriteriaPanel panel;
	
	//-----------------
	// CONSTRUCTORES
	//-----------------
	
	public DialogFindCategoriaProducto(String title) {
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
//		UICategoriaProductoCriteria criteria = new UICategoriaProductoCriteria();
//		criteria.setNombre(getInputNombre());
//		criteria.setPaginable(true);
//		return criteria;
//		
		return panel.getCriteria();
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
		
//		JTextField txtNombre = JTextFieldFactory.getJTextField("",150);
//		PropertyInput prop1 = new PropertyInput("Nombre", I18nMessages.PRODUCTO_NOMBRE ,80,txtNombre);
//	
//		addPropertyInput(prop1);
//		
//		JPanel inputs = this.autoGenerateInfoPanel(1); 
//		JPanel inputsWithTip = new JPanel(new BorderLayout());
//		inputsWithTip.add(inputs, BorderLayout.NORTH);
//		return inputsWithTip;
		panel = new UICategoriaProductoCriteriaPanel();
		return panel;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUICategoriaProductoService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UICategoriaProductoCollection( I18nMessages.CATEGORIAS_PRODUCTO);
	}


	@Override
	protected LinkOpenDialog getLinkAdd() {
		// TODO Auto-generated method stub
		return null;
	}


}