package com.migestion.ui.swing.proveedores;


import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.Proveedor;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.AppUtils;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para proveedores. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/11/2013
 *
 */
public class UIProveedorCollection extends UICollection{


	public UIProveedorCollection(String description) {
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
            return I18nMessages.PROVEEDOR_CODIGO;
        case 1:
        	return I18nMessages.PROVEEDOR_NOMBRE;
        case 2:
            return I18nMessages.PROVEEDOR_CONTACTO;
        case 3:
        	return I18nMessages.PROVEEDOR_TELEFONO_FIJO;
        case 4:
        	return I18nMessages.PROVEEDOR_TELEFONO_CELULAR;
        case 5:
        	return I18nMessages.PROVEEDOR_EMAIL;
        case 6:
        	return I18nMessages.PROVEEDOR_SALDO;
		default:
			return "";
        }
    }

	public Object getValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Proveedor proveedor = (Proveedor)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
        	case 6:
        		return AppUtils.formatMoneda( proveedor.getSaldo() );
            default:
                return getValueAt(rowIndex, columnIndex);
        }
    }
	
	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Proveedor proveedor = (Proveedor)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return proveedor.getOid();
	        case 1:
	        	return proveedor.getNombre();
	        case 2:
	            return proveedor.getContacto();
	        case 3:
	        	return proveedor.getTelefonoFijo();
	        case 4:
	        	return proveedor.getTelefonoMovil();
	        case 5:
	        	return proveedor.getEmail();
	        case 6:
	        	return proveedor.getSaldo();
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
		Proveedor proveedor = (Proveedor)(getElements().get(rowIndex));

		Boolean cambio = false;
		try {
			
	        switch (columnIndex)
	        {
	            case 0:
	                break;
	            case 1:
	            	proveedor.setNombre( (String)aValue ); 
					cambio = true;break;
		        case 2:
		        	proveedor.setContacto( (String)aValue );
		        	cambio = true;break;
		        case 3:
		        	proveedor.setTelefonoFijo( (String)aValue );
		        	cambio = true;break;
		        case 4:
		        	proveedor.setTelefonoMovil( (String)aValue );
		        	cambio = true;break;
		        case 5:
		        	proveedor.setEmail( (String)aValue );
		        	cambio = true;break;
		        
	            default:
	            	break;
	        }

	        if(cambio){
	        	
				 UIServiceFactory.getUIProveedorService().updateObject(proveedor);
				 this.updateElement(proveedor);

	        }
	        
		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage( I18nMessages.PROVEEDOR_ACCION_MODIFICAR, e.getMessage());

		}
        
    }
    
}