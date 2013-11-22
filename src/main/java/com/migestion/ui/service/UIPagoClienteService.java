package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.EstadisticaPago;
import com.migestion.model.PagoCliente;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.PagoClienteCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIPagoClienteCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.UIPagoClienteCollection;

/**
 * Controlador utilizado para las operaciones de los pagos.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 * 
 */
public class UIPagoClienteService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIPagoClienteService instance;

	
	// pedimos la �nica instancia.
	public static UIPagoClienteService getInstance() {
		if (instance == null)
			instance = new UIPagoClienteService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIPagoClienteCollection uiList = new UIPagoClienteCollection( I18nMessages.PAGOS);

		uiList.setElements( new Vector<PagoCliente>() );
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
		List<PagoCliente> pagos;
//		Long totalSize;
		EstadisticaPago estadistica;
		try {
			PagoClienteCriteria coreCriteria = ((UIPagoClienteCriteria)criteria).buildToService();
			pagos = ServiceFactory.getPagoClienteService().list( coreCriteria );
//			totalSize = ServiceFactory.getPagoClienteService().getListSize(coreCriteria);
			estadistica = ServiceFactory.getPagoClienteService().getEstadisticaPago(coreCriteria);
			
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los pagos.
		UIPagoClienteCollection uiList = new UIPagoClienteCollection( I18nMessages.PAGOS);

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
			
			ServiceFactory.getPagoClienteService().add( (PagoCliente)object );
			
			PersistenceContext.getInstance().commit();
			
			//TODO avisar pagoobserver
			AppContext.getInstance().getPagoClienteObserver().objectCreated((PagoCliente)object);
			AppContext.getInstance().getVentaObserver().pagoVentaCreado((PagoCliente)object);
			
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
			
			ServiceFactory.getPagoClienteService().update( (PagoCliente)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoClienteObserver().objectUpdated((PagoCliente)object);
			
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
			
			ServiceFactory.getPagoClienteService().delete( ((PagoCliente)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoClienteObserver().objectDeleted((PagoCliente)object);

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
			
			object = ServiceFactory.getPagoClienteService().get( ((PagoCliente)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIPagoClienteCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			PagoClienteCriteria coreCriteria = ((UIPagoClienteCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getPagoClienteService().getListSize(coreCriteria);
			
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
	public void anularPago(PagoCliente pago) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getPagoClienteService().anularPago( pago.getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getPagoClienteObserver().objectUpdated(pago);
			
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
