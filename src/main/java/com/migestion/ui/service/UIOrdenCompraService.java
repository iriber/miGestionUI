package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaOperacion;
import com.migestion.model.OrdenCompra;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.OrdenCompraCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIOrdenCompraCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.UIOrdenCompraCollection;

/**
 * Controlador utilizado para las operaciones de las órdenes de compra.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 * 
 */
public class UIOrdenCompraService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIOrdenCompraService instance;

	
	// pedimos la �nica instancia.
	public static UIOrdenCompraService getInstance() {
		if (instance == null)
			instance = new UIOrdenCompraService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIOrdenCompraCollection uiList = new UIOrdenCompraCollection( I18nMessages.ORDENES_COMPRA);

		uiList.setElements( new Vector<OrdenCompra>() );
		uiList.setEstadistica(new EstadisticaOperacion());
		
		return uiList;
		
		//return list(new UIOrdenCompraCriteria());
	}

	/**
	 * se listan los ordenCompras dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<OrdenCompra> ordenCompras;
//		Long totalSize;
		EstadisticaOperacion estadistica ;
		try {
			OrdenCompraCriteria coreCriteria = ((UIOrdenCompraCriteria)criteria).buildToService();
			ordenCompras = ServiceFactory.getOrdenCompraService().list( coreCriteria );
			//totalSize = ServiceFactory.getOrdenCompraService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getOrdenCompraService().getEstadistica(coreCriteria);
			
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los ordenCompras.
		UIOrdenCompraCollection uiList = new UIOrdenCompraCollection( I18nMessages.ORDENES_COMPRA);

		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setTotalSize( estadistica.getCantidad() );
		uiList.setEstadistica(estadistica);
		uiList.setElements( ordenCompras );
				
		return uiList;
	}

	/**
	 * se agrega un ordenCompra. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getOrdenCompraService().add( (OrdenCompra)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getOrdenCompraObserver().objectCreated( (OrdenCompra)object );
			
			AppContext.getInstance().getProductoObserver().ordenCompraChange( (OrdenCompra)object );

			//TODO para actualizar el saldo del proveedor. AppContext.getInstance().getProveedorObserver().ordenCompraChange( (OrdenCompra)object );
			
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
	 * se modifica un ordenCompra. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getOrdenCompraService().update( (OrdenCompra)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getOrdenCompraObserver().objectUpdated( (OrdenCompra)object );
			
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
	 * se elimina un ordenCompra. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getOrdenCompraService().delete( ((OrdenCompra)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getOrdenCompraObserver().objectDeleted( (OrdenCompra)object );
			
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
	 * se obtiene un ordenCompra del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getOrdenCompraService().get( ((OrdenCompra)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIOrdenCompraCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			OrdenCompraCriteria coreCriteria = ((UIOrdenCompraCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getOrdenCompraService().getListSize(coreCriteria);
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

	/**
	 * se anula una ordenCompra
	 */
	public void anularOrdenCompra(OrdenCompra ordenCompra) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getOrdenCompraService().anularOrdenCompra( ordenCompra.getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getOrdenCompraObserver().objectUpdated( ordenCompra );
			
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
