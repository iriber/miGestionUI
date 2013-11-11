package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.model.Balance;
import com.migestion.model.MovimientoCheque;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.MovimientoChequeCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIMovimientoChequeCriteria;
import com.migestion.ui.swing.cheques.movimientos.UIMovimientoChequeCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de movimientos
 *  de cheques
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 * 
 */
public class UIMovimientoChequeService implements IControllerList {

	// instancia del manager (lo hacemos singleton).
	private static UIMovimientoChequeService instance;

	
	// pedimos la �nica instancia.
	public static UIMovimientoChequeService getInstance() {
		if (instance == null)
			instance = new UIMovimientoChequeService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIMovimientoChequeCollection uiList = new UIMovimientoChequeCollection( I18nMessages.MOVIMIENTOS_CAJA);

		uiList.setElements( new Vector<MovimientoCheque>() );

		uiList.setBalance( new Balance() );
		
		return uiList;
		
		//return list(new UIMovimientoChequeCriteria());
	}

	/**
	 * se listan los cajas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<MovimientoCheque> movimientos;
		Long totalSize;
		Balance balance = null;
		try {
			MovimientoChequeCriteria coreCriteria = ((UIMovimientoChequeCriteria)criteria).buildToService();
			movimientos = ServiceFactory.getMovimientoChequeService().list( coreCriteria );
			//totalSize = ServiceFactory.getMovimientoChequeService().getListSize(coreCriteria);
			balance = ServiceFactory.getMovimientoChequeService().getBalance(coreCriteria);
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cajas.
		UIMovimientoChequeCollection uiList = new UIMovimientoChequeCollection( I18nMessages.MOVIMIENTOS_CHEQUE);

		uiList.setElements( movimientos );
		
		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setBalance(balance);
		uiList.setTotalSize( balance.getCantidadMovimientos() );
		return uiList;
	}


	/**
	 * se obtiene un sucursal del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getMovimientoChequeService().get( ((MovimientoCheque)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIMovimientoChequeCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			MovimientoChequeCriteria coreCriteria = ((UIMovimientoChequeCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getMovimientoChequeService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
