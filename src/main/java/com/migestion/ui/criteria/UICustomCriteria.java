package com.migestion.ui.criteria;

import com.migestion.swing.search.criteria.UICriteria;


/**
 * UICriteria genérico para que todos usen paginación.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 * 
 */
public abstract class UICustomCriteria implements UICriteria{

	//cantidad de filas a retornar si es paginable.
	private Integer rowCount;
	//offset para la paginación.
	private Integer offset;
	//para determinar si es paginable
	private boolean paginable;
	
	public Integer getOffset() {
		return offset;
	}
	public boolean isPaginable() {
		return paginable;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public void setPaginable(boolean paginable) {
		this.paginable = paginable;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	

	public Integer getMaxResult() {
		return getRowCount();
	}

	
}
