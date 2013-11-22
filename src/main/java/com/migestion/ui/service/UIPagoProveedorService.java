package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaPago;
import com.migestion.model.PagoProveedor;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.PagoProveedorCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIPagoProveedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.UIPagoProveedorCollection;

/**
 * Controlador utilizado para las operaciones de los pagos
 * a proveedores.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 * 
 */
public class UIPagoProveedorService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIPagoProveedorService instance;

	
	// pedimos la �nica instancia.
	public static UIPagoProveedorService getInstance() {
		if (instance == null)
			instance = new UIPagoProveedorService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIPagoProveedorCollection uiList = new UIPagoProveedorCollection( I18nMessages.PAGOS);

		uiList.setElements( new Vector<PagoProveedor>() );
		//uiList.setEstadistica(new EstadisticaPago());
		
		return uiList;
		
		//return list(new UIPagoCriteria());
	}

	/**
	 * se listan los pagos dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<PagoProveedor> pagos;
//		Long totalSize;
		EstadisticaPago estadistica;
		try {
			PagoProveedorCriteria coreCriteria = ((UIPagoProveedorCriteria)criteria).buildToService();
			pagos = ServiceFactory.getPagoProveedorService().list( coreCriteria );
//			totalSize = ServiceFactory.getPagoProveedorService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getPagoProveedorService().getEstadisticaPago(coreCriteria);
			
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los pagos.
		UIPagoProveedorCollection uiList = new UIPagoProveedorCollection( I18nMessages.PAGOS);

		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setTotalSize( estadistica.getCantidad() );
		uiList.setEstadistica(estadistica);
		uiList.setElements( pagos );
				
		return uiList;
	}

	/**
	 * se agrega un pago. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getPagoProveedorService().add( (PagoProveedor)object );
			
			PersistenceContext.getInstance().commit();
			
			//TODO avisar pagoobserver
			AppContext.getInstance().getPagoProveedorObserver().objectCreated((PagoProveedor)object);
			AppContext.getInstance().getOrdenCompraObserver().pagoOrdenCompraCreado((PagoProveedor)object);
			
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
	 * se modifica un pago. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getPagoProveedorService().update( (PagoProveedor)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoProveedorObserver().objectUpdated((PagoProveedor)object);
			
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
	 * se elimina un pago. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getPagoProveedorService().delete( ((PagoProveedor)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoProveedorObserver().objectDeleted((PagoProveedor)object);

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
	 * se obtiene un pago del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getPagoProveedorService().get( ((PagoProveedor)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIPagoProveedorCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			PagoProveedorCriteria coreCriteria = ((UIPagoProveedorCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getPagoProveedorService().getListSize(coreCriteria);
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

	/**
	 * se anula una pago
	 */
	public void anularPago(PagoProveedor pago) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getPagoProveedorService().anularPago( pago.getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoProveedorObserver().objectUpdated(pago);
			
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
