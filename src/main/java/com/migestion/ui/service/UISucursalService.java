package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Sucursal;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.SucursalCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UISucursalCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.sucursales.UISucursalCollection;

/**
 * Controlador utilizado para las operaciones de las sucursales.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 25/10/2013
 * 
 */
public class UISucursalService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UISucursalService instance;

	
	// pedimos la �nica instancia.
	public static UISucursalService getInstance() {
		if (instance == null)
			instance = new UISucursalService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UISucursalCollection uiList = new UISucursalCollection( I18nMessages.PRODUCTOS);

		uiList.setElements( new Vector<Sucursal>() );
		
		return uiList;
		
		//return list(new UISucursalCriteria());
	}

	/**
	 * se listan los sucursales dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Sucursal> sucursales;
		Long totalSize;
		try {
			SucursalCriteria coreCriteria = ((UISucursalCriteria)criteria).buildToService();
			sucursales = ServiceFactory.getSucursalService().list( coreCriteria );
			totalSize = ServiceFactory.getSucursalService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los sucursales.
		UISucursalCollection uiList = new UISucursalCollection( I18nMessages.PRODUCTOS);

		uiList.setElements( sucursales );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un sucursal. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getSucursalService().add( (Sucursal)object );
			
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
			
			ServiceFactory.getSucursalService().update( (Sucursal)object );
			
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
			
			ServiceFactory.getSucursalService().delete( ((Sucursal)object).getOid() );
			
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
			
			object = ServiceFactory.getSucursalService().get( ((Sucursal)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UISucursalCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			SucursalCriteria coreCriteria = ((UISucursalCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getSucursalService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
