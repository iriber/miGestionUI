package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaGasto;
import com.migestion.model.Gasto;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.GastoCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIGastoCriteria;
import com.migestion.ui.swing.gastos.UIGastoCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de los gastos.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 * 
 */
public class UIGastoService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIGastoService instance;

	
	// pedimos la única instancia.
	public static UIGastoService getInstance() {
		if (instance == null)
			instance = new UIGastoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIGastoCollection uiList = new UIGastoCollection( I18nMessages.GASTOS);

		uiList.setElements( new Vector<Gasto>() );
		//uiList.setEstadistica(new EstadisticaGasto());
		
		return uiList;
		
		//return list(new UIGastoCriteria());
	}

	/**
	 * se listan los gastos dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Gasto> gastos;
		Long totalSize;
		EstadisticaGasto estadistica;
		try {
			GastoCriteria coreCriteria = ((UIGastoCriteria)criteria).buildToService();
			gastos = ServiceFactory.getGastoService().list( coreCriteria );
			totalSize = ServiceFactory.getGastoService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getGastoService().getEstadisticaGasto(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los gastos.
		UIGastoCollection uiList = new UIGastoCollection( I18nMessages.GASTOS);

		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setTotalSize( estadistica.getCantidad() );
		uiList.setEstadistica(estadistica);
		uiList.setElements( gastos );
				
		return uiList;
	}

	/**
	 * se agrega un gasto. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getGastoService().add( (Gasto)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getGastoObserver().objectCreated((Gasto)object);
			
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
	 * se modifica un gasto. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getGastoService().update( (Gasto)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getGastoObserver().objectUpdated((Gasto)object);
			
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
	 * se elimina un gasto. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getGastoService().delete( ((Gasto)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getGastoObserver().objectDeleted((Gasto)object);

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
	 * se obtiene un gasto del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getGastoService().get( ((Gasto)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIGastoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			GastoCriteria coreCriteria = ((UIGastoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getGastoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}