package com.migestion.ui.swing.cajas;


import java.util.Date;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.Caja;
import com.migestion.model.Vendedor;
import com.migestion.swing.model.UICollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para cajas. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 *
 */
public class UICajaCollection extends UICollection{


	public UICajaCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {		
		return 5;
	}

	public Class getColumnClass(int columnIndex) {
	     switch (columnIndex)
	     {
	       case 0:
	           return Long.class;
	       case 1:
	           return Date.class;
	       case 2:
	    	   return String.class;
	       case 3:
	    	   return Vendedor.class;
	       case 4:
	    	   return Float.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.CAJA_CODIGO;
        case 1:
            return I18nMessages.CAJA_FECHA;
        case 2:
        	return I18nMessages.CAJA_NUMERO;
        case 3:
        	return I18nMessages.CAJA_CAJERO;
        case 4:
        	return I18nMessages.CAJA_SALDO;
		default:
			return "";
        }
    }

	
	
	
	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Caja caja = (Caja)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return caja.getOid();
            case 1:
                return caja.getFecha();
            case 2:
            	return caja.getNumero();
            case 3:
            	return caja.getCajero();
            case 4:
            	return caja.getSaldo();
            default:
                return "";
        }
    }

	@Override
	public Object getValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Caja caja = (Caja)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return caja.getOid();
            case 1:
                return AppUtils.formatDate( caja.getFecha() );
            case 2:
            	return caja.getNumero();
            case 3:
            	return caja.getCajero().toString();
            case 4:
            	return AppUtils.formatMoneda( caja.getSaldo() );
            default:
                return "";
        }
    }

    /**
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
			return SwingConstants.CENTER;
		case 2:
			return SwingConstants.LEFT;
		case 3:
			return SwingConstants.LEFT;
		case 4:
			return SwingConstants.RIGHT;
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
            case 3:
            	return false;
            case 4:
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