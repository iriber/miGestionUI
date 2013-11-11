package com.migestion.ui.swing.cuentasBancarias;


import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.CuentaBancaria;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.AppUtils;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para cuentasBancarias. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class UICuentaBancariaCollection extends UICollection{


	public UICuentaBancariaCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {		
		return 8;
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
	    	   return String.class;
	       case 4:
	    	   return String.class;
	       case 5:
	    	   return String.class;
	       case 6:
	    	   return String.class;
	       case 7:
	    	   return Float.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.CUENTA_BANCARIA_CODIGO;
        case 1:
            return I18nMessages.CUENTA_BANCARIA_BANCO;
        case 2:
        	return I18nMessages.CUENTA_BANCARIA_SUCURSAL;
        case 3:
        	return I18nMessages.CUENTA_BANCARIA_NRO_CUENTA;
        case 4:
        	return I18nMessages.CUENTA_BANCARIA_CBU;
        case 5:
        	return I18nMessages.CUENTA_BANCARIA_TITULAR;
        case 6:
        	return I18nMessages.CUENTA_BANCARIA_CUIT;
        case 7:
        	return I18nMessages.CUENTA_BANCARIA_SALDO;
		default:
			return "";
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		CuentaBancaria cuentaBancaria = (CuentaBancaria)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return cuentaBancaria.getOid();
            case 1:
                return cuentaBancaria.getNombre();
            case 2:
            	return cuentaBancaria.getSucursal();
            case 3:
            	return cuentaBancaria.getNroCuenta();
            case 4:
            	return cuentaBancaria.getCbu();
            case 5:
            	return cuentaBancaria.getTitular();
            case 6:
            	return cuentaBancaria.getCuit();
            case 7:
            	return cuentaBancaria.getSaldo();
            default:
                return "";
        }
    }

	public Object getValueAtShow(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		CuentaBancaria cuentaBancaria = (CuentaBancaria)(getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
			case 7:
				return AppUtils.formatMoneda( cuentaBancaria.getSaldo() );
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
			return SwingConstants.LEFT;
		case 4:
			return SwingConstants.LEFT;
		case 5:
			return SwingConstants.LEFT;
		case 6:
			return SwingConstants.LEFT;
		case 7:
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
                return true;
            case 2:
            	return true;
            case 3:
            	return true;
            case 4:
            	return true;
            case 5:
            	return true;
            case 6:
            	return true;
            case 7:
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
		// Se obtiene el dato de la fila indicada
		CuentaBancaria cuentaBancaria = (CuentaBancaria)(getElements().get(rowIndex));
    	
		Boolean cambio = false;
		try {
			
	        switch (columnIndex)
	        {
	            case 0:
	                break;
	            case 1:
	            	cuentaBancaria.setNombre( (String)aValue ); 
	                cambio = true;break;
	            case 2:
	            	cuentaBancaria.setSucursal( (String)aValue ); 
	            	cambio = true;break;
	            case 3:
	            	cuentaBancaria.setNroCuenta( (String)aValue ); 
	            	cambio = true;break;
	            case 4:
	            	cuentaBancaria.setCbu( (String)aValue ); 
	            	cambio = true;break;
	            case 5:
	            	cuentaBancaria.setTitular( (String)aValue ); 
	            	cambio = true;break;
	            case 6:
	            	cuentaBancaria.setCuit( (String)aValue ); 
	            	cambio = true;break;
	            default:
	            	break;
	        }
	        
	        if(cambio){
	        	
	        	UIServiceFactory.getUICuentaBancariaService().updateObject(cuentaBancaria);
	        	this.updateElement(cuentaBancaria);

	        }

		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage( I18nMessages.CUENTA_BANCARIA_ACCION_MODIFICAR, e.getMessage());

		}
        
		
		
		
    }
    
}