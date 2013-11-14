package com.migestion.ui.criteria;


/**
 * Criteria de personas para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public abstract class UIPersonaCriteria extends UICustomCriteria{

	//nombre.
	private String nombre;

	private Long nroDocumento;
	
	public UIPersonaCriteria() {
		
	}
	
	public UIPersonaCriteria(String nombre) {
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Long nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

}