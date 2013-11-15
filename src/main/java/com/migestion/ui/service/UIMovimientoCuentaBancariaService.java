package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Balance;
import com.migestion.model.MovimientoCuentaBancaria;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.MovimientoCuentaBancariaCriteria;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIMovimientoCuentaBancariaCriteria;
import com.migestion.ui.swing.cuentasBancarias.movimientos.UIMovimientoCuentaBancariaCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de movimientos de cuentas bancarias
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 * 
 */
public class UIMovimientoCuentaBancariaService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIMovimientoCuentaBancariaService instance;

	
	// pedimos la �nica instancia.
	public static UIMovimientoCuentaBancariaService getInstance() {
		if (instance == null)
			instance = new UIMovimientoCuentaBancariaService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIMovimientoCuentaBancariaCollection uiList = new UIMovimientoCuentaBancariaCollection( I18nMessages.MOVIMIENTOS_CUENTA_BANCARIA);

		uiList.setElements( new Vector<MovimientoCuentaBancaria>() );

		uiList.setBalance( new Balance() );
		
		return uiList;
		
		//return list(new UIMovimientoCuentaBancariaCriteria());
	}

	/**
	 * se listan los cajas dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<MovimientoCuentaBancaria> movimientos;
//		Long totalSize;
		Balance balance = null;
		try {
			MovimientoCuentaBancariaCriteria coreCriteria = ((UIMovimientoCuentaBancariaCriteria)criteria).buildToService();
			movimientos = ServiceFactory.getMovimientoCuentaBancariaService().list( coreCriteria );
			//totalSize = ServiceFactory.getMovimientoCuentaBancariaService().getListSize(coreCriteria);
			balance = ServiceFactory.getMovimientoCuentaBancariaService().getBalance(coreCriteria);
		} catch (Exception e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cajas.
		UIMovimientoCuentaBancariaCollection uiList = new UIMovimientoCuentaBancariaCollection( I18nMessages.MOVIMIENTOS_CUENTA_BANCARIA);

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
			
			ServiceFactory.getMovimientoCuentaBancariaService().add( (MovimientoCuentaBancaria)object );
			
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
			
			ServiceFactory.getMovimientoCuentaBancariaService().update( (MovimientoCuentaBancaria)object );
			
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
			
			ServiceFactory.getMovimientoCuentaBancariaService().delete( ((MovimientoCuentaBancaria)object).getOid() );
			
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
			
			object = ServiceFactory.getMovimientoCuentaBancariaService().get( ((MovimientoCuentaBancaria)object).getOid() );
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIMovimientoCuentaBancariaCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			MovimientoCuentaBancariaCriteria coreCriteria = ((UIMovimientoCuentaBancariaCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getMovimientoCuentaBancariaService().getListSize(coreCriteria);
			
		} catch (Exception e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
