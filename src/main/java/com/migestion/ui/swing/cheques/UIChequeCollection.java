package com.migestion.ui.swing.cheques;


import java.util.Date;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.Caja;
import com.migestion.model.Cheque;
import com.migestion.model.Cheque;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.AppUtils;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para cheques. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 07/11/2013
 *
 */
public class UIChequeCollection extends UICollection{


	public UIChequeCollection(String description) {
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
	           return String.class;
	       case 2:
	    	   return String.class;
	       case 3:
	    	   return Float.class;
	       case 4:
	    	   return Date.class;
	       case 5:
	    	   return String.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.CHEQUE_CODIGO;
        case 1:
            return I18nMessages.CHEQUE_NUMERO;
        case 2:
        	return I18nMessages.CHEQUE_BANCO;
        case 3:
        	return I18nMessages.CHEQUE_MONTO;
        case 4:
        	return I18nMessages.CHEQUE_FECHA_VENCIMIENTO;
        case 5:
        	return I18nMessages.CHEQUE_OBSERVACIONES;
		default:
			return "";
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Cheque cheque = (Cheque)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return cheque.getOid();
            case 1:
                return cheque.getNumero();
            case 2:
            	return cheque.getBanco();
            case 3:
            	return cheque.getMonto();
            case 4:
            	return cheque.getFechaVencimiento();
            case 5:
            	return cheque.getObservaciones();
            default:
                return "";
        }
    }
	
	@Override
	public Object getValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Cheque cheque = (Cheque)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 3:
            	return AppUtils.formatMoneda( cheque.getMonto() );
            case 4:
                return AppUtils.formatDate( cheque.getFechaVencimiento() );
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
			return SwingConstants.LEFT;
		case 2:
			return SwingConstants.LEFT;
		case 3:
			return SwingConstants.RIGHT;
		case 4:
			return SwingConstants.CENTER;
		case 5:
			return SwingConstants.LEFT;
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
                return true;
            case 2:
            	return true;
            case 3:
            	return false;
            case 4:
            	return false;
            case 5:
            	return true;
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
		Cheque cheque = (Cheque)(getElements().get(rowIndex));
    	
		Boolean cambio = false;
		try {
			
	        switch (columnIndex)
	        {
	            case 0:
	                break;
	            case 1:
	            	cheque.setNumero( (String)aValue ); 
	                cambio = true;break;
	            case 2:
	            	cheque.setBanco( (String)aValue ); 
	            	cambio = true;break;
	            case 3:
	            	break;
	            case 4:
	            	break;
	            case 5:
	            	cheque.setObservaciones( (String)aValue ); 
	            	cambio = true;break;
	            default:
	            	break;
	        }
	        
	        if(cambio){
	        	
	        	UIServiceFactory.getUIChequeService().updateObject(cheque);
	        	this.updateElement(cheque);

	        }

		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage( I18nMessages.CUENTA_BANCARIA_ACCION_MODIFICAR, e.getMessage());

		}
        
		
		
		
    }
    
}