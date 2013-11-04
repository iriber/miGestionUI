package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.model.Cliente;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.ClienteCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIClienteCriteria;
import com.migestion.ui.swing.clientes.UIClienteCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de los clientes.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 * 
 */
public class UIClienteService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del servicio (lo hacemos singleton).
	private static UIClienteService instance;

	
	// pedimos la �nica instancia.
	public static UIClienteService getInstance() {
		if (instance == null)
			instance = new UIClienteService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIClienteCollection uiList = new UIClienteCollection( I18nMessages.CLIENTES);

		uiList.setElements( new Vector<Cliente>() );
		
		return uiList;
		
		//return list(new UIClienteCriteria());
	}

	/**
	 * se listan los clientes dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Cliente> clientes;
		Long totalSize;
		try {
			ClienteCriteria coreCriteria = ((UIClienteCriteria)criteria).buildToService();
			clientes = ServiceFactory.getClienteService().list( coreCriteria );
			totalSize = ServiceFactory.getClienteService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los clientes.
		UIClienteCollection uiList = new UIClienteCollection( I18nMessages.CLIENTES);

		uiList.setElements( clientes );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un cliente. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getClienteService().add( (Cliente)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			throw new ControllerException( e.getMessage() );
			
		}
		
	}

	/**
	 * se modifica un cliente. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getClienteService().update( (Cliente)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {

			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
		
	}

	/**
	 * se elimina un cliente. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getClienteService().delete( ((Cliente)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
	}

	/**
	 * se obtiene un cliente del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getClienteService().get( ((Cliente)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIClienteCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			ClienteCriteria coreCriteria = ((UIClienteCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getClienteService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	
	/**
	 * se obtiene el cliente de mostrador (default)
	 */
	public Cliente getClienteMostrador() throws ControllerException {
		Cliente cliente=null;
		try {
			
			cliente = ServiceFactory.getClienteService().getClienteMostrador();
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return cliente;
	}
}
