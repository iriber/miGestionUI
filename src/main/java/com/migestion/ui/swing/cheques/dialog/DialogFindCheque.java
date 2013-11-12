package com.migestion.ui.swing.cheques.dialog;



import java.awt.Frame;

import javax.swing.JPanel;

import com.migestion.model.Cheque;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.LinkOpenDialog;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.utils.UbicacionVentana;
import com.migestion.swing.view.dialogs.DialogFindObject;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cheques.UIChequeCollection;
import com.migestion.ui.swing.cheques.factories.LinkChequeFactory;
import com.migestion.ui.swing.cheques.panel.UIChequeCriteriaPanel;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Diálogo para buscar un cheque.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 *
 */
public class DialogFindCheque extends DialogFindObject<Cheque>{

	private UIChequeCriteriaPanel criteriaPanel;
	public DialogFindCheque(String title) {
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
		 criteriaPanel = new UIChequeCriteriaPanel();
		
		return criteriaPanel;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getController()
	 */
	protected IControllerList getController() {
		return (IControllerList)UIServiceFactory.getUIChequeService();
	}

	/*
	 * (non-Javadoc)
	 * @see com.codnet.swing.view.dialogs.DialogFindObject#getUICollectionDefault()
	 */
	protected UICollection getUICollectionDefault() {
		return new UIChequeCollection( I18nMessages.CHEQUES);
	}

	@Override
	protected LinkOpenDialog getLinkAdd() {
		
		return LinkChequeFactory.getLinkAdd();
	}

	protected void doAdd() {
		
		DialogAddCheque dialogCheque = new DialogAddCheque(new Frame(), true);
        UbicacionVentana.centrar(dialogCheque, false);
        dialogCheque.setVisible( true );               
        if( dialogCheque.getReturnStatus() == DialogAddCheque.RET_OK ){

            objectCreated( dialogCheque.getCheque() );
         		   
        }
	}
}