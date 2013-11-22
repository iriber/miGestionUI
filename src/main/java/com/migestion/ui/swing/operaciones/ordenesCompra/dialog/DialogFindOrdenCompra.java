package com.migestion.ui.swing.operaciones.ordenesCompra.dialog;


import javax.swing.JPanel;

import com.migestion.model.OrdenCompra;
import com.migestion.model.Venta;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.criteria.UIOrdenCompraCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.UIOrdenCompraCollection;
import com.migestion.ui.swing.operaciones.ordenesCompra.panel.UIOrdenCompraCriteriaPanel;

/**
 * Diálogo para buscar una orden de compra.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class DialogFindOrdenCompra extends DialogFindObject<OrdenCompra>{

	
	public DialogFindOrdenCompra(String title) {
		super(title);
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		UIOrdenCompraCriteria criteria = new UIOrdenCompraCriteria();
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
//		JTextField txtNombre = JTextFieldFactory.getJTextField("",150);
//		PropertyInput prop1 = new PropertyInput("Nombre", I18nMessages.CLIENTE_NOMBRE ,80,txtNombre);
//	
//		addPropertyInput(prop1);
//		
//		JPanel inputs = this.autoGenerateInfoPanel(1); 
//		JPanel inputsWithTip = new JPanel(new BorderLayout());
//		inputsWithTip.add(inputs, BorderLayout.NORTH);
//		return inputsWithTip;
		
		return new UIOrdenCompraCriteriaPanel();
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUIOrdenCompraService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UIOrdenCompraCollection( I18nMessages.ORDENES_COMPRA);
	}

	@Override
	protected LinkOpenDialog getLinkAdd() {
		// TODO Auto-generated method stub
		return null;
	}

}
