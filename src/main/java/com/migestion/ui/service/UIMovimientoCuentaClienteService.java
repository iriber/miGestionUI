package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Balance;
import com.migestion.model.MovimientoCuentaCliente;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.MovimientoCuentaClienteCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIMovimientoCuentaClienteCriteria;
import com.migestion.ui.swing.clientes.movimientos.UIMovimientoCuentaClienteCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de movimientos de cuentas de 
 * clientes
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 * 
 */
public class UIMovimientoCuentaClienteService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIMovimientoCuentaClienteService instance;

	
	// pedimos la �nica instancia.
	public static UIMovimientoCuentaClienteService getInstance() {
		if (instance == null)
			instance = new UIMovimientoCuentaClienteService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIMovimientoCuentaClienteCollection uiList = new UIMovimientoCuentaClienteCollection( I18nMessages.MOVIMIENTOS_CUENTA_PROVEEDOR);

		uiList.setElements( new Vector<MovimientoCuentaCliente>() );

		uiList.setBalance( new Balance() );
		
		return uiList;
		
		//return list(new UIMovimientoCuentaClienteCriteria());
	}

	/**
	 * se listan los cajas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<MovimientoCuentaCliente> movimientos;
//		Long totalSize;
		Balance balance = null;
		try {
			MovimientoCuentaClienteCriteria coreCriteria = ((UIMovimientoCuentaClienteCriteria)criteria).buildToService();
			movimientos = ServiceFactory.getMovimientoCuentaClienteService().list( coreCriteria );
			//totalSize = ServiceFactory.getMovimientoCuentaClienteService().getListSize(coreCriteria);
			balance = ServiceFactory.getMovimientoCuentaClienteService().getBalance(coreCriteria);
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cajas.
		UIMovimientoCuentaClienteCollection uiList = new UIMovimientoCuentaClienteCollection( I18nMessages.MOVIMIENTOS_CUENTA_CLIENTE);

		uiList.setElements( movimientos );
		
		//uiList.setTotalSize( totalSize.intValue()  );
		uiList.setBalance(balance);
		uiList.setTotalSize( balance.getCantidadMovimientos() );
		return uiList;
	}

	/**
	 * se agrega un sucursal. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getMovimientoCuentaClienteService().add( (MovimientoCuentaCliente)object );
			
			PersistenceContext.getInstance().commit();
			
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
	 * se modifica un sucursal. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getMovimientoCuentaClienteService().update( (MovimientoCuentaCliente)object );
			
			PersistenceContext.getInstance().commit();
			
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
	 * se elimina un sucursal. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getMovimientoCuentaClienteService().delete( ((MovimientoCuentaCliente)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
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
	 * se obtiene un sucursal del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getMovimientoCuentaClienteService().get( ((MovimientoCuentaCliente)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIMovimientoCuentaClienteCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			MovimientoCuentaClienteCriteria coreCriteria = ((UIMovimientoCuentaClienteCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getMovimientoCuentaClienteService().getListSize(coreCriteria);
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
