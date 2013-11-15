package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaPago;
import com.migestion.model.Pago;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.PagoCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIPagoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.UIPagoCollection;

/**
 * Controlador utilizado para las operaciones de los pagos.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 * 
 */
public class UIPagoService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIPagoService instance;

	
	// pedimos la �nica instancia.
	public static UIPagoService getInstance() {
		if (instance == null)
			instance = new UIPagoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIPagoCollection uiList = new UIPagoCollection( I18nMessages.PAGOS);

		uiList.setElements( new Vector<Pago>() );
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
		List<Pago> pagos;
//		Long totalSize;
		EstadisticaPago estadistica;
		try {
			PagoCriteria coreCriteria = ((UIPagoCriteria)criteria).buildToService();
			pagos = ServiceFactory.getPagoService().list( coreCriteria );
//			totalSize = ServiceFactory.getPagoService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getPagoService().getEstadisticaPago(coreCriteria);
			
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los pagos.
		UIPagoCollection uiList = new UIPagoCollection( I18nMessages.PAGOS);

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
			
			ServiceFactory.getPagoService().add( (Pago)object );
			
			PersistenceContext.getInstance().commit();
			
			//TODO avisar pagoobserver
			AppContext.getInstance().getPagoObserver().objectCreated((Pago)object);
			AppContext.getInstance().getVentaObserver().pagoVentaCreado((Pago)object);
			
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
			
			ServiceFactory.getPagoService().update( (Pago)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoObserver().objectUpdated((Pago)object);
			
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
			
			ServiceFactory.getPagoService().delete( ((Pago)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoObserver().objectDeleted((Pago)object);

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
			
			object = ServiceFactory.getPagoService().get( ((Pago)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIPagoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			PagoCriteria coreCriteria = ((UIPagoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getPagoService().getListSize(coreCriteria);
			
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
	public void anularPago(Pago pago) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getPagoService().anularPago( pago.getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoObserver().objectUpdated(pago);
			
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
