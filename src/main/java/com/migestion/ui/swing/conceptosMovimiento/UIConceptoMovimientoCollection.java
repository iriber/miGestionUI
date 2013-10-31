package com.migestion.ui.swing.conceptosMovimiento;


import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.ConceptoMovimiento;
import com.migestion.swing.model.UICollection;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para conceptos de caja. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class UIConceptoMovimientoCollection extends UICollection{


	public UIConceptoMovimientoCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {		
		return 3;
	}

	public Class getColumnClass(int columnIndex) {
	     switch (columnIndex)
	     {
	       case 0:
	           return Long.class;
	       case 1:
	           return String.class;
	       case 2:
	    	   return String.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.CONCEPTO_MOVIMIENTO_CODIGO;
        case 1:
            return I18nMessages.CONCEPTO_MOVIMIENTO_NOMBRE;
        case 2:
        	return I18nMessages.CONCEPTO_MOVIMIENTO_DESCRIPCION;
		default:
			return "";
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		ConceptoMovimiento concepto = (ConceptoMovimiento)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return concepto.getOid();
            case 1:
                return concepto.getNombre();
            case 2:
            	return concepto.getDescripcion();
            default:
                return "";
        }
    }

    /**
     * redefinimos para que no haga nada, ya que
     * las cuentas se borran l�gicamente.
     * @param fila
     */
    public void deleteElement (Object element){
    	//no hacemos nada.
    }

	public Integer getColumnTextAlign(int columnIndex) {
		switch (columnIndex){
		case 0:
			return SwingConstants.CENTER;
		case 1:
			return SwingConstants.LEFT;
		case 2:
			return SwingConstants.LEFT;
		default:
			return SwingConstants.LEFT;
		}
	}
    
	/**
     * define si una celda es editable o no.
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
            	return false;
            default:
                return false;
        }
    }


    /**
     * setea el valor de un "campo" de la tabla.
     * (no se utilizar� este m�todo)
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
    }
    
}