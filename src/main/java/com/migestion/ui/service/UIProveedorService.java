package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Proveedor;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.ProveedorCriteria;
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
import com.migestion.ui.criteria.UIProveedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.proveedores.UIProveedorCollection;

/**
 * Controlador utilizado para las operaciones de los proveedores.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/11/2013
 * 
 */
public class UIProveedorService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIProveedorService instance;

	
	// pedimos la �nica instancia.
	public static UIProveedorService getInstance() {
		if (instance == null)
			instance = new UIProveedorService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIProveedorCollection uiList = new UIProveedorCollection( I18nMessages.PROVEEDORES);

		uiList.setElements( new Vector<Proveedor>() );
		
		return uiList;
		
		//return list(new UIProveedorCriteria());
	}

	/**
	 * se listan los proveedores dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Proveedor> proveedores;
		Long totalSize;
		try {
			ProveedorCriteria coreCriteria = ((UIProveedorCriteria)criteria).buildToService();
			proveedores = ServiceFactory.getProveedorService().list( coreCriteria );
			totalSize = ServiceFactory.getProveedorService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los proveedores.
		UIProveedorCollection uiList = new UIProveedorCollection( I18nMessages.PROVEEDORES);

		uiList.setElements( proveedores );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un proveedor. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProveedorService().add( (Proveedor)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProveedorObserver().objectCreated((Proveedor)object);
			
		} catch (Exception e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e1.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		}
		
	}

	/**
	 * se modifica un proveedor. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProveedorService().update( (Proveedor)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProveedorObserver().objectUpdated((Proveedor)object);
			
		} catch (Exception e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e1.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		}
		
	}

	/**
	 * se elimina un proveedor. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProveedorService().delete( ((Proveedor)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProveedorObserver().objectDeleted((Proveedor)object);
			
		} catch (Exception e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e1.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		}

		
	}

	/**
	 * se obtiene un proveedor del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getProveedorService().get( ((Proveedor)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIProveedorCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			ProveedorCriteria coreCriteria = ((UIProveedorCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getProveedorService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	


}
