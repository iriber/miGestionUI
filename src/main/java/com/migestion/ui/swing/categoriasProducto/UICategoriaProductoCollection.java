package com.migestion.ui.swing.categoriasProducto;


import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.CategoriaProducto;
import com.migestion.model.Producto;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.utils.FormatUtils;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.i18n.utils.EnumUtils;

/**
 * UICollection para categorías de productos. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class UICategoriaProductoCollection extends UICollection{


	public UICategoriaProductoCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {		
		return 4;
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
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.CATEGORIA_PRODUCTO_CODIGO;
        case 1:
            return I18nMessages.CATEGORIA_PRODUCTO_NOMBRE;
        case 2:
        	return I18nMessages.CATEGORIA_PRODUCTO_DESCRIPCION;
        case 3:
        	return I18nMessages.CATEGORIA_PRODUCTO_PADRE;
		default:
			return "";
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		CategoriaProducto categoria = (CategoriaProducto)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return categoria.getOid();
            case 1:
                return categoria.getNombre();
            case 2:
            	return categoria.getDescripcion();
            case 3:
            	return categoria.getPadre();
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
	
}
