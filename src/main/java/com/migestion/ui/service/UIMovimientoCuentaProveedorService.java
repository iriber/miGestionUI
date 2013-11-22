package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Balance;
import com.migestion.model.MovimientoCuentaProveedor;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.MovimientoCuentaProveedorCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIMovimientoCuentaProveedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.proveedores.movimientos.UIMovimientoCuentaProveedorCollection;

/**
 * Controlador utilizado para las operaciones de movimientos de cuentas de 
 * proveedores
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 * 
 */
public class UIMovimientoCuentaProveedorService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIMovimientoCuentaProveedorService instance;

	
	// pedimos la �nica instancia.
	public static UIMovimientoCuentaProveedorService getInstance() {
		if (instance == null)
			instance = new UIMovimientoCuentaProveedorService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIMovimientoCuentaProveedorCollection uiList = new UIMovimientoCuentaProveedorCollection( I18nMessages.MOVIMIENTOS_CUENTA_PROVEEDOR);

		uiList.setElements( new Vector<MovimientoCuentaProveedor>() );

		uiList.setBalance( new Balance() );
		
		return uiList;
		
		//return list(new UIMovimientoCuentaProveedorCriteria());
	}

	/**
	 * se listan los cajas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<MovimientoCuentaProveedor> movimientos;
//		Long totalSize;
		Balance balance = null;
		try {
			MovimientoCuentaProveedorCriteria coreCriteria = ((UIMovimientoCuentaProveedorCriteria)criteria).buildToService();
			movimientos = ServiceFactory.getMovimientoCuentaProveedorService().list( coreCriteria );
			//totalSize = ServiceFactory.getMovimientoCuentaProveedorService().getListSize(coreCriteria);
			balance = ServiceFactory.getMovimientoCuentaProveedorService().getBalance(coreCriteria);
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cajas.
		UIMovimientoCuentaProveedorCollection uiList = new UIMovimientoCuentaProveedorCollection( I18nMessages.MOVIMIENTOS_CUENTA_PROVEEDOR);

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
			
			ServiceFactory.getMovimientoCuentaProveedorService().add( (MovimientoCuentaProveedor)object );
			
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
			
			ServiceFactory.getMovimientoCuentaProveedorService().update( (MovimientoCuentaProveedor)object );
			
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
			
			ServiceFactory.getMovimientoCuentaProveedorService().delete( ((MovimientoCuentaProveedor)object).getOid() );
			
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
			
			object = ServiceFactory.getMovimientoCuentaProveedorService().get( ((MovimientoCuentaProveedor)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIMovimientoCuentaProveedorCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			MovimientoCuentaProveedorCriteria coreCriteria = ((UIMovimientoCuentaProveedorCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getMovimientoCuentaProveedorService().getListSize(coreCriteria);
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
