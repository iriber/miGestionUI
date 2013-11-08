package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Producto;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.ProductoCriteria;
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
import com.migestion.ui.criteria.UIProductoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.productos.UIProductoCollection;

/**
 * Controlador utilizado para las operaciones de los productos.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 * 
 */
public class UIProductoService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIProductoService instance;

	
	// pedimos la �nica instancia.
	public static UIProductoService getInstance() {
		if (instance == null)
			instance = new UIProductoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIProductoCollection uiList = new UIProductoCollection( I18nMessages.PRODUCTOS);

		uiList.setElements( new Vector<Producto>() );
		
		return uiList;
		
		//return list(new UIProductoCriteria());
	}

	/**
	 * se listan los productos dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Producto> productos;
		Long totalSize;
		try {
			ProductoCriteria coreCriteria = ((UIProductoCriteria)criteria).buildToService();
			productos = ServiceFactory.getProductoService().list( coreCriteria );
			totalSize = ServiceFactory.getProductoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los productos.
		UIProductoCollection uiList = new UIProductoCollection( I18nMessages.PRODUCTOS);

		uiList.setElements( productos );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un producto. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProductoService().add( (Producto)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProductoObserver().objectCreated(object);
			
		} catch (Exception e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		}
		
	}

	/**
	 * se modifica un producto. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProductoService().update( (Producto)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProductoObserver().objectUpdated(object);
			
		} catch (Exception e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
		
		}
		
	}

	/**
	 * se elimina un producto. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProductoService().delete( ((Producto)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProductoObserver().objectDeleted(object);
			
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
	 * se obtiene un producto del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getProductoService().get( ((Producto)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIProductoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			ProductoCriteria coreCriteria = ((UIProductoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getProductoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	
	/**
	 * se desactiva un producto.
	 */
	public void desactivar(Producto producto) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProductoService().desactivar(producto);
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProductoObserver().objectUpdated(producto);
			
		} catch (ServiceException e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e1.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
			
		} catch (PersistenceContextException e) {
			throw new ControllerException( e.getMessage() );
		}		
	}
	
	/**
	 * se activa un producto.
	 */
	public void activar(Producto producto) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getProductoService().activar(producto);
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getProductoObserver().objectUpdated(producto);
			
		} catch (Exception e) {
			
			try {
				PersistenceContext.getInstance().rollback();
			} catch (PersistenceContextException e1) {
				throw new ControllerException( e1.getMessage() );
			}
			
			throw new ControllerException( e.getMessage() );
		}
		
		
	}

}
