package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.model.CategoriaProducto;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.CategoriaProductoCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UICategoriaProductoCriteria;
import com.migestion.ui.swing.categoriasProducto.UICategoriaProductoCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Servicio UI para las operaciones de las categorías de productos.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 * 
 */
public class UICategoriaProductoService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UICategoriaProductoService instance;

	
	// pedimos la �nica instancia.
	public static UICategoriaProductoService getInstance() {
		if (instance == null)
			instance = new UICategoriaProductoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UICategoriaProductoCollection uiList = new UICategoriaProductoCollection( I18nMessages.CATEGORIAS_PRODUCTO);

		uiList.setElements( new Vector<CategoriaProducto>() );
		
		return uiList;
		
		//return list(new UIProductoCriteria());
	}

	/**
	 * se listan los productos dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<CategoriaProducto> categorias;
		Long totalSize;
		try {
			CategoriaProductoCriteria coreCriteria = ((UICategoriaProductoCriteria)criteria).buildToService();
			categorias = ServiceFactory.getCategoriaProductoService().list( coreCriteria );
			totalSize = ServiceFactory.getCategoriaProductoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las categorías.
		UICategoriaProductoCollection uiList = new UICategoriaProductoCollection( I18nMessages.CATEGORIAS_PRODUCTO);

		uiList.setElements( categorias );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega una categoría. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getCategoriaProductoService().add( (CategoriaProducto)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
		
	}

	/**
	 * se modifica. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getCategoriaProductoService().update( (CategoriaProducto)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
		
	}

	/**
	 * se elimina. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getCategoriaProductoService().delete( ((CategoriaProducto)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
	}

	/**
	 * se obtiene una categoría. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getCategoriaProductoService().get( ((CategoriaProducto)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UICategoriaProductoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			CategoriaProductoCriteria coreCriteria = ((UICategoriaProductoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getCategoriaProductoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

}
