package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.dao.exception.PersistenceContextException;
import com.migestion.model.Cheque;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.ChequeCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIChequeCriteria;
import com.migestion.ui.swing.cheques.UIChequeCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de cheques.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 * 
 */
public class UIChequeService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIChequeService instance;

	
	// pedimos la �nica instancia.
	public static UIChequeService getInstance() {
		if (instance == null)
			instance = new UIChequeService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIChequeCollection uiList = new UIChequeCollection( I18nMessages.CHEQUES);

		uiList.setElements( new Vector<Cheque>() );
		
		return uiList;
		
		//return list(new UIChequeCriteria());
	}

	/**
	 * se listan los cheques dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<Cheque> cheques;
		Long totalSize;
		try {
			ChequeCriteria coreCriteria = ((UIChequeCriteria)criteria).buildToService();
			cheques = ServiceFactory.getChequeService().list( coreCriteria );
			totalSize = ServiceFactory.getChequeService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con las cheques.
		UIChequeCollection uiList = new UIChequeCollection( I18nMessages.CHEQUES);

		uiList.setElements( cheques );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un cheque. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
//		//invocar al servicio
//		try {
//			
//			PersistenceContext.getInstance().beginTransaction();
//			
//			ServiceFactory.getChequeService().add( (Cheque)object );
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
	 * se modifica un cheque. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getChequeService().update( (Cheque)object );
			
			PersistenceContext.getInstance().commit();
			
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
	 * se elimina un cheque. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
//		try {
//			
//			PersistenceContext.getInstance().beginTransaction();
//			
//			ServiceFactory.getChequeService().delete( ((Cheque)object).getOid() );
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
	 * se obtiene un cheque del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getChequeService().get( ((Cheque)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIChequeCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			ChequeCriteria coreCriteria = ((UIChequeCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getChequeService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	

}
