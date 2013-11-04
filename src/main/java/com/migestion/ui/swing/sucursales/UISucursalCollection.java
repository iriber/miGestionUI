package com.migestion.ui.swing.sucursales;


import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.Sucursal;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para sucursales. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class UISucursalCollection extends UICollection{


	public UISucursalCollection(String description) {
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
	           return String.class;
	       case 2:
	    	   return String.class;
	       case 3:
	    	   return String.class;
	       case 4:
	    	   return String.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.SUCURSAL_CODIGO;
        case 1:
            return I18nMessages.SUCURSAL_NOMBRE;
        case 2:
        	return I18nMessages.SUCURSAL_NUMERO;
        case 3:
        	return I18nMessages.SUCURSAL_TELEFENO;
        case 4:
        	return I18nMessages.SUCURSAL_DOMICILIO;
		default:
			return "";
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Sucursal sucursal = (Sucursal)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return sucursal.getOid();
            case 1:
                return sucursal.getNombre();
            case 2:
            	return sucursal.getNumero();
            case 3:
            	return sucursal.getTelefono();
            case 4:
            	return sucursal.getDomicilio();
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
		case 3:
			return SwingConstants.LEFT;
		case 4:
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
            	return true;
            case 4:
            	return true;
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
		Sucursal sucursal = (Sucursal)(getElements().get(rowIndex));
    	
		Boolean cambio = false;
		try {
			
	        switch (columnIndex)
	        {
	            case 0:
	                break;
	            case 1:
	            	sucursal.setNombre( (String)aValue ); 
	                cambio = true;break;
	            case 2:
	            	sucursal.setNumero( (String)aValue ); 
	            	cambio = true;break;
	            case 3:
	            	sucursal.setTelefono( (String)aValue ); 
	            	cambio = true;break;
	            case 4:
	            	sucursal.setDomicilio( (String)aValue ); 
	            	cambio = true;break;
	            default:
	            	break;
	        }
	        
	        if(cambio){
	        	
	        	UIServiceFactory.getUISucursalService().updateObject(sucursal);
	        	this.updateElement(sucursal);

	        }

		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage( I18nMessages.SUCURSAL_ACCION_MODIFICAR, e.getMessage());

		}
        
    }
    
}