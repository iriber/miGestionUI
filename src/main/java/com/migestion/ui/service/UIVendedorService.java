package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Cliente;
import com.migestion.model.Vendedor;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.VendedorCriteria;
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
import com.migestion.ui.criteria.UIVendedorCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.vendedores.UIVendedorCollection;

/**
 * Controlador utilizado para las operaciones de los vendedores.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 * 
 */
public class UIVendedorService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIVendedorService instance;

	
	// pedimos la �nica instancia.
	public static UIVendedorService getInstance() {
		if (instance == null)
			instance = new UIVendedorService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIVendedorCollection uiList = new UIVendedorCollection( I18nMessages.CLIENTES);

		uiList.setElements( new Vector<Vendedor>() );
		
		return uiList;
		
		//return list(new UIVendedorCriteria());
	}

	/**
	 * se listan los vendedores dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Vendedor> vendedores;
		Long totalSize;
		try {
			VendedorCriteria coreCriteria = ((UIVendedorCriteria)criteria).buildToService();
			vendedores = ServiceFactory.getVendedorService().list( coreCriteria );
			totalSize = ServiceFactory.getVendedorService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los vendedores.
		UIVendedorCollection uiList = new UIVendedorCollection( I18nMessages.CLIENTES);

		uiList.setElements( vendedores );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un vendedor. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVendedorService().add( (Vendedor)object );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getVendedorObserver().objectCreated((Vendedor)object);
			
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
	 * se modifica un vendedor. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVendedorService().update( (Vendedor)object );
			
			PersistenceContext.getInstance().commit();

			AppContext.getInstance().getVendedorObserver().objectUpdated((Vendedor)object);
			
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
	 * se elimina un vendedor. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getVendedorService().delete( ((Vendedor)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
			AppContext.getInstance().getVendedorObserver().objectDeleted((Vendedor)object);
			
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
	 * se obtiene un vendedor del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getVendedorService().get( ((Vendedor)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIVendedorCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			VendedorCriteria coreCriteria = ((UIVendedorCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getVendedorService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	


	/**
	 * se obtiene el vendedor titular comercio (default)
	 */
	public Vendedor getVendedorTitularComercio() throws ControllerException {
		Vendedor vendedor=null;
		try {
			
			vendedor = ServiceFactory.getVendedorService().getTitularComercio();
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return vendedor;
	}
}
