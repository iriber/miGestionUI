package com.migestion.ui.criteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.migestion.model.EstadoCaja;
import com.migestion.model.EstadoVenta;
import com.migestion.services.criteria.CajaCriteria;
import com.migestion.services.criteria.Criteria;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Criteria de cajas para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class UICajaCriteria extends UICustomCriteria{

	//numero
	private String numero;
	
	private Date fecha;
	
	/**
	 * estados posibles.
	 */
	private Collection<EstadoCaja> estados;

	/**
	 * estados a excluir
	 */
	private Collection<EstadoCaja> estadosExcluir;

	
	public UICajaCriteria() {
		
		super();
		estadosExcluir = new ArrayList<EstadoCaja>();
		estados = new ArrayList<EstadoCaja>();
	}
	
	/**
	 * @return the estadosExcluir
	 */
	public Collection<EstadoCaja> getEstadosExcluir() {
		return estadosExcluir;
	}

	/**
	 * @param estadosExcluir the estadosExcluir to set
	 */
	public void setEstadosExcluir(Collection<EstadoCaja> estadosExcluir) {
		this.estadosExcluir = estadosExcluir;
	}
	
	public void addEstadoExcluir(EstadoCaja estado){
		
		this.estadosExcluir.add(estado);
	}

	public void addEstado(EstadoCaja estado){
		
		this.estados.add(estado);
	}

	/**
	 * @return the estados
	 */
	public Collection<EstadoCaja> getEstados() {
		return estados;
	}

	/**
	 * @param estados the estados to set
	 */
	public void setEstados(Collection<EstadoCaja> estados) {
		this.estados = estados;
	}

	
	/**
	 * descripción del criteria
	 */
	public String getDescription() {
		
		String desc = I18nMessages.CAJAS ;
		
		if(StringUtils.isEmpty(getNumero()))
			desc +=  " | " + I18nMessages.CAJA_NUMERO + ": '" + getNumero() + "'";
		
		return desc;
	}


	public CajaCriteria buildToService(){
		
		CajaCriteria criteria = new CajaCriteria();
		criteria.setMaxResult(getMaxResult());
		criteria.setOffset(getOffset());
		criteria.setNumero(getNumero());
		criteria.setFecha(getFecha());
		criteria.setEstados( getEstados() );
		criteria.setEstadosExcluir(getEstadosExcluir());
		criteria.orderByFecha( Criteria.ORDER_DESC );
		criteria.orderByNumero( Criteria.ORDER_DESC );
		return criteria;
	}


	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}


	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	
}
