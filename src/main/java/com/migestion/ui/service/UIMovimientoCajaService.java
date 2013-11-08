package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaCaja;
import com.migestion.model.MovimientoCaja;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.MovimientoCajaCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIMovimientoCajaCriteria;
import com.migestion.ui.swing.cajas.movimientos.UIMovimientoCajaCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de movimientos de caja.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 * 
 */
public class UIMovimientoCajaService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIMovimientoCajaService instance;

	
	// pedimos la �nica instancia.
	public static UIMovimientoCajaService getInstance() {
		if (instance == null)
			instance = new UIMovimientoCajaService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIMovimientoCajaCollection uiList = new UIMovimientoCajaCollection( I18nMessages.MOVIMIENTOS_CAJA);

		uiList.setElements( new Vector<MovimientoCaja>() );

		uiList.setEstadistica( new EstadisticaCaja() );
		
		return uiList;
		
		//return list(new UIMovimientoCajaCriteria());
	}

	/**
	 * se listan los cajas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<MovimientoCaja> cajas;
		Long totalSize;
		EstadisticaCaja estadistica;
		try {
			MovimientoCajaCriteria coreCriteria = ((UIMovimientoCajaCriteria)criteria).buildToService();
			cajas = ServiceFactory.getMovimientoCajaService().list( coreCriteria );
			//totalSize = ServiceFactory.getMovimientoCajaService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getMovimientoCajaService().getEstadisticaCaja(coreCriteria);
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cajas.
		UIMovimientoCajaCollection uiList = new UIMovimientoCajaCollection( I18nMessages.MOVIMIENTOS_CAJA);

		uiList.setElements( cajas );
		
		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setEstadistica(estadistica);
		uiList.setTotalSize( estadistica.getCantidad() );
		return uiList;
	}

	/**
	 * se agrega un sucursal. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getMovimientoCajaService().add( (MovimientoCaja)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		} catch (PersistenceContextException e) {
			throw new ControllerException( e.getMessage() );
		}		
	}

	/**
	 * se modifica un sucursal. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getMovimientoCajaService().update( (MovimientoCaja)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		} catch (PersistenceContextException e) {
			throw new ControllerException( e.getMessage() );
		}
		
	}

	/**
	 * se elimina un sucursal. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getMovimientoCajaService().delete( ((MovimientoCaja)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		} catch (PersistenceContextException e) {
			throw new ControllerException( e.getMessage() );
		}
	}

	/**
	 * se obtiene un sucursal del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getMovimientoCajaService().get( ((MovimientoCaja)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIMovimientoCajaCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			MovimientoCajaCriteria coreCriteria = ((UIMovimientoCajaCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getMovimientoCajaService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
