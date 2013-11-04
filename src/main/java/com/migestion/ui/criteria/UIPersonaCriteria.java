package com.migestion.ui.criteria;


/**
 * Criteria de personas para construir los filtros desde la ui.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public abstract class UIPersonaCriteria extends UICustomCriteria{

	//nombre del cliente.
	private String nombre;
	
	//----------------------
	//CONSTRUCTORES
	//----------------------
	
	public UIPersonaCriteria() {
		
	}
	
	public UIPersonaCriteria(String nombre) {
		this.nombre = nombre;
	}

	//-----------------------
	//M�TODOS P�BLICOS
	//-----------------------
	
	//-----------------------
	//GETTERS y SETTERS
	//-----------------------


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}