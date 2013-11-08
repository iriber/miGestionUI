package com.migestion.ui.swing.productos;


import java.util.Vector;

import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.migestion.model.CategoriaProducto;
import com.migestion.model.NotaCredito;
import com.migestion.model.Producto;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.ui.AppUtils;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.i18n.utils.EnumUtils;

/**
 * UICollection para productos. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class UIProductoCollection extends UICollection{


	public UIProductoCollection(String description) {
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
	    	   return Float.class;
	       case 3:
	    	   return Integer.class;
	       case 4:
	    	   return String.class;
	       case 5:
	    	   return CategoriaProducto.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.PRODUCTO_CODIGO;
        case 1:
            return I18nMessages.PRODUCTO_NOMBRE;
        case 2:
        	return I18nMessages.PRODUCTO_PRECIO;
        case 3:
        	return I18nMessages.PRODUCTO_STOCK;
        case 4:
        	return I18nMessages.PRODUCTO_ESTADO;
        case 5:
        	return I18nMessages.PRODUCTO_CATEGORIA;
		default:
			return "";
        }
    }

	public Object getValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Producto producto = (Producto)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
        	case 2:
        		return AppUtils.formatMoneda( producto.getPrecio() );
            default:
                return getValueAt(rowIndex, columnIndex);
        }
    }

	public Object getValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		Producto producto = (Producto)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return producto.getOid();
            case 1:
                return producto.getNombre();
            case 2:
            	return producto.getPrecio();
            case 3:
            	return producto.getStockActual();
            case 4:
            	return EnumUtils.getLabelFor(producto.getEstadoProducto());
            case 5:
            	return producto.getCategoria();
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
			return SwingConstants.RIGHT;
		case 3:
			return SwingConstants.RIGHT;
		case 4:
			return SwingConstants.CENTER;
		case 5:
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
            	return false;
            case 5:
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
		Producto producto = (Producto)(getElements().get(rowIndex));
    	
		try {
			
	        switch (columnIndex)
	        {
	            case 0:
	                break;
	            case 1:
	                 producto.setNombre( (String)aValue ); 
				
					 UIServiceFactory.getUIProductoService().updateObject(producto);
					 this.updateElement(producto);
				     break;
	            case 2:
	            	producto.setPrecio( (Float)aValue ); 
					
					UIServiceFactory.getUIProductoService().updateObject(producto);
					
					this.updateElement(producto);
					
	            	break;
	            case 3:
	            	
	            	producto.setStockActual( (Integer)aValue ); 
					
					UIServiceFactory.getUIProductoService().updateObject(producto);
	            	
					this.updateElement(producto);
					
					break;
	            case 4:
	            	break;
	            case 5:
	            	producto.setCategoria( (CategoriaProducto)aValue ); 
					
	            	UIServiceFactory.getUIProductoService().updateObject(producto);
	            	
	            	//this.updateElement(producto);
	            	
	            	break;
	            default:
	            	break;
	        }

		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage( I18nMessages.PRODUCTO_ACCION_MODIFICAR, e.getMessage());

		}
        
    }
    
    public void initCellEditorsRenderers(JTable table){
		super.initCellEditorsRenderers(table);
		//table.setDefaultEditor( CategoriaProducto.class,  new CategoriaProductoEditor());
	}
    
}