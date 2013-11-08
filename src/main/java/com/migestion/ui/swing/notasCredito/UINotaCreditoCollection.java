package com.migestion.ui.swing.notasCredito;


import java.util.Date;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.Cliente;
import com.migestion.model.NotaCredito;
import com.migestion.swing.model.UICollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para notas de crédito. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 08/11/2013
 *
 */
public class UINotaCreditoCollection extends UICollection{


	public UINotaCreditoCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {		
		return 6;
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
	    	   return Float.class;
	       case 4:
	    	   return Cliente.class;
	       case 5:
	    	   return Date.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.NOTA_CREDITO_CODIGO;
        case 1:
            return I18nMessages.NOTA_CREDITO_FECHA;
        case 2:
        	return I18nMessages.NOTA_CREDITO_NUMERO;
        case 3:
        	return I18nMessages.NOTA_CREDITO_MONTO;
        case 4:
        	return I18nMessages.NOTA_CREDITO_CLIENTE;
        case 5:
        	return I18nMessages.CHEQUE_FECHA_VENCIMIENTO;
		default:
			return "";
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		NotaCredito notaCredito = (NotaCredito)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return notaCredito.getOid();
            case 1:
                return notaCredito.getFecha();
            case 2:
            	return notaCredito.getNumero();
            case 3:
            	return notaCredito.getMonto();
            case 4:
            	return notaCredito.getCliente();
            case 5:
            	return notaCredito.getFechaVencimiento();
            default:
                return "";
        }
    }
	
	@Override
	public Object getValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		NotaCredito notaCredito = (NotaCredito)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
        	case 1:
        		return AppUtils.formatDate( notaCredito.getFecha() );
        	case 3:
        		return AppUtils.formatMoneda( notaCredito.getMonto() );
        	case 4:
            	return notaCredito.getCliente().toString();
            case 5:
                return AppUtils.formatDate( notaCredito.getFechaVencimiento() );
            default:
                return getValueAt(rowIndex, columnIndex);
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
			return SwingConstants.CENTER;
		case 2:
			return SwingConstants.LEFT;
		case 3:
			return SwingConstants.RIGHT;
		case 4:
			return SwingConstants.CENTER;
		case 5:
			return SwingConstants.CENTER;
		case 6:
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
            case 3:
            	return false;
            case 4:
            	return false;
            case 5:
            	return false;
            default:
                return false;
        }
    }


    /**
     * setea el valor de un "campo" de la tabla.
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
		// Se obtiene el dato de la fila indicada
		NotaCredito notaCredito = (NotaCredito)(getElements().get(rowIndex));
    	
		
    }
    
}