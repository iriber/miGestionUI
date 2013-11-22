package com.migestion.ui.criteria;

import java.util.ArrayList;
import java.util.Collection;

import com.migestion.model.EstadoOrdenCompra;
import com.migestion.model.Proveedor;
import com.migestion.services.criteria.Criteria;
import com.migestion.services.criteria.OrdenCompraCriteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de órdenes de compra para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 *
 */
public class UIOrdenCompraCriteria extends UIOperacionCriteria{

	/**
	 * estados posibles.
	 */
	private Collection<EstadoOrdenCompra> estados;

	/**
	 * estados a excluir
	 */
	private Collection<EstadoOrdenCompra> estadosExcluir;

	private Proveedor proveedor;
	
	public UIOrdenCompraCriteria() {

		super();
		
		estadosExcluir = new ArrayList<EstadoOrdenCompra>();
		estados = new ArrayList<EstadoOrdenCompra>();
	}
	
	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {

		String desc = I18nMessages.ORDENES_COMPRA;
		return desc;
	}

	
		
	/**
	 * @return the estadosExcluir
	 */
	public Collection<EstadoOrdenCompra> getEstadosExcluir() {
		return estadosExcluir;
	}

	/**
	 * @param estadosExcluir the estadosExcluir to set
	 */
	public void setEstadosExcluir(Collection<EstadoOrdenCompra> estadosExcluir) {
		this.estadosExcluir = estadosExcluir;
	}
	
	public void addEstadoExcluir(EstadoOrdenCompra estado){
		
		this.estadosExcluir.add(estado);
	}

	/**
	 * @return the estados
	 */
	public Collection<EstadoOrdenCompra> getEstados() {
		return estados;
	}

	/**
	 * @param estados the estados to set
	 */
	public void setEstados(Collection<EstadoOrdenCompra> estados) {
		this.estados = estados;
	}

	public OrdenCompraCriteria buildToService(){
		
		OrdenCompraCriteria criteria = new OrdenCompraCriteria();
		
		criteria.setProveedor( getProveedor() );
		criteria.setVendedor( getVendedor() );
		criteria.setFechaDesde( getFechaDesde() );
		criteria.setFechaHasta( getFechaHasta() );
		criteria.setEstados( getEstados() );
		criteria.setEstadosExcluir(getEstadosExcluir());
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.orderByFecha( Criteria.ORDER_DESC );
		criteria.orderByCodigo( Criteria.ORDER_DESC );
		return criteria;
	}


	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}


	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}	
}
