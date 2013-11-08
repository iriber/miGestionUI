package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.model.NotaCredito;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.NotaCreditoCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UINotaCreditoCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.notasCredito.UINotaCreditoCollection;

/**
 * Controlador utilizado para las operaciones de notas de crédito.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 * 
 */
public class UINotaCreditoService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UINotaCreditoService instance;

	
	// pedimos la �nica instancia.
	public static UINotaCreditoService getInstance() {
		if (instance == null)
			instance = new UINotaCreditoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UINotaCreditoCollection uiList = new UINotaCreditoCollection( I18nMessages.NOTAS_CREDITO);

		uiList.setElements( new Vector<NotaCredito>() );
		
		return uiList;
		
		//return list(new UINotaCreditoCriteria());
	}

	/**
	 * se listan los notasCredito dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<NotaCredito> notasCredito;
		Long totalSize;
		try {
			NotaCreditoCriteria coreCriteria = ((UINotaCreditoCriteria)criteria).buildToService();
			notasCredito = ServiceFactory.getNotaCreditoService().list( coreCriteria );
			totalSize = ServiceFactory.getNotaCreditoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las notasCredito.
		UINotaCreditoCollection uiList = new UINotaCreditoCollection( I18nMessages.CHEQUES);

		uiList.setElements( notasCredito );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un notaCredito. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
//		//invocar al servicio
//		try {
//			
//			PersistenceContext.getInstance().beginTransaction();
//			
//			ServiceFactory.getNotaCreditoService().add( (NotaCredito)object );
//			
//			PersistenceContext.getInstance().commit();
//			
//		} catch (ServiceException e) {
//			
//			try {
//				PersistenceContext.getInstance().rollback();
//			} catch (PersistenceContextException e1) {
//				throw new ControllerException( e.getMessage() );
//			}
//			
//			throw new ControllerException( e.getMessage() );
//			
//		} catch (PersistenceContextException e) {
//			throw new ControllerException( e.getMessage() );
//		}		
	}

	/**
	 * se modifica un notaCredito. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

//		try {
//			
//			PersistenceContext.getInstance().beginTransaction();
//			
//			ServiceFactory.getNotaCreditoService().update( (NotaCredito)object );
//			
//			PersistenceContext.getInstance().commit();
//			
//		} catch (ServiceException e) {
//			
//			try {
//				PersistenceContext.getInstance().rollback();
//			} catch (PersistenceContextException e1) {
//				throw new ControllerException( e.getMessage() );
//			}
//			
//			throw new ControllerException( e.getMessage() );
//			
//		} catch (PersistenceContextException e) {
//			throw new ControllerException( e.getMessage() );
//		}		
	}

	/**
	 * se elimina un notaCredito. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
//		try {
//			
//			PersistenceContext.getInstance().beginTransaction();
//			
//			ServiceFactory.getNotaCreditoService().delete( ((NotaCredito)object).getOid() );
//			
//			PersistenceContext.getInstance().commit();
//			
//		} catch (ServiceException e) {
//			
//			try {
//				PersistenceContext.getInstance().rollback();
//			} catch (PersistenceContextException e1) {
//				throw new ControllerException( e.getMessage() );
//			}
//			
//			throw new ControllerException( e.getMessage() );
//			
//		} catch (PersistenceContextException e) {
//			throw new ControllerException( e.getMessage() );
//		}
		
	}

	/**
	 * se obtiene un notaCredito del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getNotaCreditoService().get( ((NotaCredito)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UINotaCreditoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			NotaCreditoCriteria coreCriteria = ((UINotaCreditoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getNotaCreditoService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
