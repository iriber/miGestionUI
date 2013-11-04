package com.migestion.ui.service;


import java.util.List;
import java.util.Vector;

import com.migestion.dao.PersistenceContext;
import com.migestion.model.ConceptoMovimiento;
import com.migestion.services.ServiceFactory;
import com.migestion.services.criteria.ConceptoMovimientoCriteria;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.IControllerAdd;
import com.migestion.swing.controller.IControllerDelete;
import com.migestion.swing.controller.IControllerList;
import com.migestion.swing.controller.IControllerUpdate;
import com.migestion.swing.controller.IControllerView;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.ui.criteria.UIConceptoMovimientoCriteria;
import com.migestion.ui.swing.conceptosMovimiento.UIConceptoMovimientoCollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Controlador utilizado para las operaciones de los conceptos de caja.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 25/10/2013
 * 
 */
public class UIConceptoMovimientoService implements IControllerList, IControllerAdd,
		IControllerUpdate, IControllerDelete, IControllerView {

	// instancia del manager (lo hacemos singleton).
	private static UIConceptoMovimientoService instance;

	
	// pedimos la �nica instancia.
	public static UIConceptoMovimientoService getInstance() {
		if (instance == null)
			instance = new UIConceptoMovimientoService();
		return instance;
	}


	public UICollection list() throws ControllerException {
		
		
		UIConceptoMovimientoCollection uiList = new UIConceptoMovimientoCollection( I18nMessages.PRODUCTOS);

		uiList.setElements( new Vector<ConceptoMovimiento>() );
		
		return uiList;
		
		//return list(new UIConceptoCajaCriteria());
	}

	/**
	 * se listan los conceptos dado un criterio de búsqueda. (implementación de la
	 * interface IControllerList).
	 */
	public UICollection list(UICriteria criteria) throws ControllerException {
		
		//invocar al servicio para obtener las entities.
		List<ConceptoMovimiento> conceptos;
		Long totalSize;
		try {
			ConceptoMovimientoCriteria coreCriteria = ((UIConceptoMovimientoCriteria)criteria).buildToService();
			conceptos = ServiceFactory.getConceptoCajaService().list( coreCriteria );
			totalSize = ServiceFactory.getConceptoCajaService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {

			throw new ControllerException( e.getMessage() ); 
		}
		
		// creamos una ui collection con los conceptos.
		UIConceptoMovimientoCollection uiList = new UIConceptoMovimientoCollection( I18nMessages.CONCEPTOS_MOVIMIENTO);

		uiList.setElements( conceptos );
		
		uiList.setTotalSize( totalSize.intValue()  );
		
		return uiList;
	}

	/**
	 * se agrega un concepto. (implementación de la interface IControllerAdd).
	 */
	public void addObject(Object object) throws ControllerException {
		
		
		//invocar al servicio
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getConceptoCajaService().add( (ConceptoMovimiento)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			throw new ControllerException( e.getMessage() );
			
		}
		
	}

	/**
	 * se modifica un concepto. (implementación de la interface IControllerUpdate).
	 */
	public void updateObject(Object object) throws ControllerException {

		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getConceptoCajaService().update( (ConceptoMovimiento)object );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {

			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
		
	}

	/**
	 * se elimina un concepto. (implementación de la interface IControllerDelete).
	 */
	public void deleteObject(Object object) throws ControllerException {
		
		try {
			
			PersistenceContext.getInstance().beginTransaction();
			
			ServiceFactory.getConceptoCajaService().delete( ((ConceptoMovimiento)object).getOid() );
			
			PersistenceContext.getInstance().commit();
			
		} catch (ServiceException e) {
			
			PersistenceContext.getInstance().rollback();
			
			throw new ControllerException( e.getMessage() );
		}
	}

	/**
	 * se obtiene un concepto del modelo. (implementación de la interface
	 * IControllerView).
	 */
	public Object getObject(Object object) throws ControllerException {
		
		try {
			
			object = ServiceFactory.getConceptoCajaService().get( ((ConceptoMovimiento)object).getOid() );
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return object;
	}
	
	public int totalSize() throws ControllerException {
		
		return totalSize(new UIConceptoMovimientoCriteria());
	}

	public int totalSize(UICriteria criteria) throws ControllerException {

		boolean paginable = criteria.isPaginable();
		criteria.setPaginable(false);
		
		Long totalSize = 0L;
		
		try {
			
			ConceptoMovimientoCriteria coreCriteria = ((UIConceptoMovimientoCriteria)criteria).buildToService();
			totalSize = ServiceFactory.getConceptoCajaService().getListSize(coreCriteria);
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
			
		}finally{
			criteria.setPaginable(paginable);
		}


		return totalSize.intValue();
	}	

	
	/**
	 * se obtiene el concepto de caja utilizado para ventas.
	 */
	public ConceptoMovimiento getConceptoVentas() throws ControllerException {
		ConceptoMovimiento concepto=null;
		try {
			
			concepto = ServiceFactory.getConceptoCajaService().getConceptoVentas();
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}

		return concepto;
	}

}
