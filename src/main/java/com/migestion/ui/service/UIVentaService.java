package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaVenta;
import com.migestion.model.Venta;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.VentaCriteria;
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
import com.migestion.ui.criteria.UIVentaCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.UIVentaCollection;

/**
 * Controlador utilizado para las operaciones de los ventas.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 * 
 */
public class UIVentaService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIVentaService instance;

	
	// pedimos la �nica instancia.
	public static UIVentaService getInstance() {
		if (instance == null)
			instance = new UIVentaService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIVentaCollection uiList = new UIVentaCollection( I18nMessages.VENTAS);

		uiList.setElements( new Vector<Venta>() );
		uiList.setEstadistica(new EstadisticaVenta());
		
		return uiList;
		
		//return list(new UIVentaCriteria());
	}

	/**
	 * se listan los ventas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Venta> ventas;
		Long totalSize;
		EstadisticaVenta estadistica ;
		try {
			VentaCriteria coreCriteria = ((UIVentaCriteria)criteria).buildToService();
			ventas = ServiceFactory.getVentaService().list( coreCriteria );
			//totalSize = ServiceFactory.getVentaService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getVentaService().getEstadisticaVenta(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los ventas.
		UIVentaCollection uiList = new UIVentaCollection( I18nMessages.VENTAS);

		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setTotalSize( estadistica.getCantidad() );
		uiList.setEstadistica(estadistica);
		uiList.setElements( ventas );
				
		return uiList;
	}

	/**
	 * se agrega un venta. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVentaService().add( (Venta)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getVentaObserver().objectCreated( object );
			
			AppContext.getInstance().getProductoObserver().ventaChange( (Venta)object );
			
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
	 * se modifica un venta. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVentaService().update( (Venta)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getVentaObserver().objectUpdated( object );
			
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
	 * se elimina un venta. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVentaService().delete( ((Venta)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getVentaObserver().objectDeleted( object );
			
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
	 * se obtiene un venta del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getVentaService().get( ((Venta)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIVentaCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			VentaCriteria coreCriteria = ((UIVentaCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getVentaService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

	/**
	 * se anula una venta
	 */
	public void anularVenta(Venta venta) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVentaService().anularVenta( venta.getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getVentaObserver().objectUpdated( venta );
			
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

}
