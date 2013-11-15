package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.model.Balance;
import com.migestion.model.MovimientoNotaCredito;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.MovimientoNotaCreditoCriteria;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIMovimientoNotaCreditoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.notasCredito.movimientos.UIMovimientoNotaCreditoCollection;

/**
 * Controlador utilizado para las operaciones de movimientos
 *  de notas de crédito
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/11/2013
 * 
 */
public class UIMovimientoNotaCreditoService implements IControllerList {

	// instancia del manager (lo hacemos singleton).
	private static UIMovimientoNotaCreditoService instance;

	
	// pedimos la �nica instancia.
	public static UIMovimientoNotaCreditoService getInstance() {
		if (instance == null)
			instance = new UIMovimientoNotaCreditoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIMovimientoNotaCreditoCollection uiList = new UIMovimientoNotaCreditoCollection( I18nMessages.MOVIMIENTOS_CAJA);

		uiList.setElements( new Vector<MovimientoNotaCredito>() );

		uiList.setBalance( new Balance() );
		
		return uiList;
		
		//return list(new UIMovimientoNotaCreditoCriteria());
	}

	/**
	 * se listan los cajas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<MovimientoNotaCredito> movimientos;
//		Long totalSize;
		Balance balance = null;
		try {
			MovimientoNotaCreditoCriteria coreCriteria = ((UIMovimientoNotaCreditoCriteria)criteria).buildToService();
			movimientos = ServiceFactory.getMovimientoNotaCreditoService().list( coreCriteria );
			//totalSize = ServiceFactory.getMovimientoNotaCreditoService().getListSize(coreCriteria);
			balance = ServiceFactory.getMovimientoNotaCreditoService().getBalance(coreCriteria);
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cajas.
		UIMovimientoNotaCreditoCollection uiList = new UIMovimientoNotaCreditoCollection( I18nMessages.MOVIMIENTOS_CHEQUE);

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
			
			object = ServiceFactory.getMovimientoNotaCreditoService().get( ((MovimientoNotaCredito)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIMovimientoNotaCreditoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			MovimientoNotaCreditoCriteria coreCriteria = ((UIMovimientoNotaCreditoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getMovimientoNotaCreditoService().getListSize(coreCriteria);
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
