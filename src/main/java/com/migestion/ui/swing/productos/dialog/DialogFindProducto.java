package com.migestion.ui.swing.productos.dialog;



import javax.swing.JPanel;

import com.migestion.model.Producto;
import com.migestion.model.Venta;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.context.observers.listeners.IProductoListener;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.UIProductoCollection;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
import com.migestion.ui.swing.productos.panel.UIProductoCriteriaPanel;

/**
 * Diálogo para buscar un producto.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class DialogFindProducto extends DialogFindObject<Producto> implements IProductoListener{

	private UIProductoCriteriaPanel criteriaPanel;
	
	public DialogFindProducto(String title) {
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
			 criteriaPanel = new UIProductoCriteriaPanel();
			
		return criteriaPanel;
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


	@Override
	protected LinkOpenDialog getLinkAdd() {
		return (LinkOpenDialog)LinkProductoFactory.getLinkAdd();
	}


	public void ventaChange(Venta venta) {
		// TODO Auto-generated method stub
		
	}

}