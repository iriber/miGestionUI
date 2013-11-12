package com.migestion.ui.swing.operaciones.ventas.dialog;

import javax.swing.JPanel;

import com.migestion.model.Venta;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.criteria.UIVentaCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.UIVentaCollection;
import com.migestion.ui.swing.operaciones.ventas.panel.UIVentaCriteriaPanel;

/**
 * Diálogo para buscar una venta.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public class DialogFindVenta extends DialogFindObject<Venta>{

	
	public DialogFindVenta(String title) {
		super(title);
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getCriteriaFromUI()
	 */
	protected UICriteria getCriteriaFromUI() throws ViewException {
		UIVentaCriteria criteria = new UIVentaCriteria();
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
		
		return new UIVentaCriteriaPanel();
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUIVentaService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UIVentaCollection( I18nMessages.VENTAS);
	}

	@Override
	protected LinkOpenDialog getLinkAdd() {
		// TODO Auto-generated method stub
		return null;
	}

}
