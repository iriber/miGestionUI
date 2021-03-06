package com.migestion.ui.swing.clientes;


import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.Cliente;
import com.migestion.model.Producto;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.AppUtils;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para clientes. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class UIClienteCollection extends UICollection{


	public UIClienteCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {		
		return 7;
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
	    	   return Float.class;
	       default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.CLIENTE_CODIGO;
        case 1:
        	return I18nMessages.CLIENTE_NOMBRE;
        case 2:
            return I18nMessages.CLIENTE_CONTACTO;
        case 3:
        	return I18nMessages.CLIENTE_TELEFONO_FIJO;
        case 4:
        	return I18nMessages.CLIENTE_TELEFONO_CELULAR;
        case 5:
        	return I18nMessages.CLIENTE_EMAIL;
        case 6:
        	return I18nMessages.CLIENTE_SALDO;
		default:
			return "";
        }
    }

	public Object getValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Cliente cliente = (Cliente)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
        	case 6:
        		return AppUtils.formatMoneda( cliente.getSaldo() );
            default:
                return getValueAt(rowIndex, columnIndex);
        }
    }
	
	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Cliente cliente = (Cliente)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return cliente.getOid();
	        case 1:
	        	return cliente.getNombre();
	        case 2:
	            return cliente.getContacto();
	        case 3:
	        	return cliente.getTelefonoFijo();
	        case 4:
	        	return cliente.getTelefonoMovil();
	        case 5:
	        	return cliente.getEmail();
	        case 6:
	        	return cliente.getSaldo();
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
		case 5:
			return SwingConstants.LEFT;
		case 6:
			return SwingConstants.RIGHT;
		default:
			return SwingConstants.LEFT;
		}
	}
    
	
	//--------------------------------------------------
	// Se definen los valores por defecto para imprimir.
	// Ser�n los mismos que se muestran en pantalla.
	//--------------------------------------------------

	/*
	 * (non-Javadoc)
	 * @see com.migestion.swing.model.UICollection#getColumnCountToPrint()
	 */
	public int getColumnCountToPrint() {
		return getColumnCount();
	}

	/*
	 * (non-Javadoc)
	 * @see com.migestion.swing.model.UICollection#getColumnClassToPrint(int)
	 */
	public Class getColumnClassToPrint(int columnIndex) {
		return getColumnClass(columnIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.migestion.swing.model.UICollection#getColumnNameToPrint(int)
	 */
	public String getColumnNameToPrint(int columnIndex) {
        return getColumnName(columnIndex);
	}

	/*
	 * (non-Javadoc)
	 * @see com.migestion.swing.model.UICollection#getValueAtToPrint(int, int)
	 */
	public Object getValueAtToPrint(int rowIndex, int columnIndex) {
        
		return getValueAt(rowIndex, columnIndex);
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
		Cliente cliente = (Cliente)(getElements().get(rowIndex));

		Boolean cambio = false;
		try {
			
	        switch (columnIndex)
	        {
	            case 0:
	                break;
	            case 1:
	            	cliente.setNombre( (String)aValue ); 
					cambio = true;break;
		        case 2:
		        	cliente.setContacto( (String)aValue );
		        	cambio = true;break;
		        case 3:
		        	cliente.setTelefonoFijo( (String)aValue );
		        	cambio = true;break;
		        case 4:
		        	cliente.setTelefonoMovil( (String)aValue );
		        	cambio = true;break;
		        case 5:
		        	cliente.setEmail( (String)aValue );
		        	cambio = true;break;
		        
	            default:
	            	break;
	        }

	        if(cambio){
	        	
				 UIServiceFactory.getUIClienteService().updateObject(cliente);
				 this.updateElement(cliente);

	        }
	        
		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage( I18nMessages.CLIENTE_ACCION_MODIFICAR, e.getMessage());

		}
        
    }
    
}