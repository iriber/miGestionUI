package com.migestion.ui.swing.operaciones.ventas;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.DetalleVenta;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.swing.view.renderers.EntityTableRenderer;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para detalles de venta. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 17/10/2013
 *
 */
public class UIDetalleVentaCollection extends UIFooterCollection{

	private Boolean editable;

	private HashMap<Integer, Object> footer;
	
	public UIDetalleVentaCollection(String description, Boolean editable) {
		super(description);
		footer = new HashMap<Integer, Object>();
		setElements(new Vector());
		setEditable(editable);
		
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
	    	   return Float.class;
	       case 5:
	    	   return Float.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.OPERACION_DETALLE_PRODUCTO;
        case 1:
        	return I18nMessages.PRODUCTO_DESCRIPCION;
        case 2:
            return I18nMessages.OPERACION_DETALLE_PRECIO_UNITARIO;
        case 3:
        	return I18nMessages.OPERACION_DETALLE_CANTIDAD;
        case 4:
        	return I18nMessages.OPERACION_DETALLE_DESCUENTO;
        case 5:
        	return I18nMessages.OPERACION_DETALLE_SUBTOTAL;
		default:
			return "";
        }
    }

	public Object getEntityValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		DetalleVenta detalle = (DetalleVenta)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return detalle.getProducto().getOid();
	        case 1:
	        	return detalle.getProducto().getNombre();
	        case 2:
	        	return detalle.getPrecioUnitario();
	        case 3:
	        	return detalle.getCantidad();
	        case 4:
	        	return detalle.getDescuento();
	        case 5:
	        	return detalle.getSubtotal();
            default:
                return "";
        }
    }

	public Object getEntityValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		DetalleVenta detalle = (DetalleVenta)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return detalle.getProducto().getOid();
	        case 1:
	        	return detalle.getProducto().getNombre();
	        case 2:
	        	return AppUtils.formatMoneda( detalle.getPrecioUnitario() );
	        case 3:
	        	return detalle.getCantidad();
	        case 4:
	        	return AppUtils.formatMoneda( detalle.getDescuento() );
	        case 5:
	        	return AppUtils.formatMoneda( detalle.getSubtotal() );
            default:
                return "";
        }
    }
    
	public Integer getColumnWidth(int columnIndex) {
		switch (columnIndex){
		case 0:
			return 40;
		case 1:
			return 200;
		case 2:
			return 50;
		case 3:
			return 50;
		case 4:
			return 50;
		case 5:
			return 50;
		default:
			return super.getColumnWidth(columnIndex);
		}
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
			return SwingConstants.RIGHT;
		case 5:
			return SwingConstants.RIGHT;
		default:
			return SwingConstants.LEFT;
		}
	}
    
	@Override
    public boolean isEntityCellEditable(int rowIndex, int columnIndex) {
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
            	return getEditable() && true;
            case 3:
            	return getEditable() && true;
            case 4:
            	return getEditable() && true;
            case 5:
            	return false;
            default:
                return false;
        }
    }


    @Override
    public void setEntityValueAt(Object aValue, int rowIndex, int columnIndex)
    {
		// Se obtiene el dato de la fila indicada
		DetalleVenta detalle = (DetalleVenta)(getElements().get(rowIndex));
		
		Boolean cambio = false;
		
		switch (columnIndex)
        {
	        case 0:
	            break;
	        case 1:
	        	break;
	        case 2:
	        	detalle.setPrecioUnitario( (Float)aValue );
	        	cambio = true;
	        	break;
	        case 3:
	        	detalle.setCantidad( (Integer)aValue );
	        	cambio = true;
	        	break;
	        case 4:
	        	detalle.setDescuento( (Float)aValue );
	        	cambio = true;
	        	break;
	        case 5:
	        	break;
            default:
            	break;
        }
		
		if( cambio ){
			
			updateElement(aValue);
		}
    }
    
//    public void initCellEditorsRenderers(JTable table){
//		
//		table.setDefaultEditor( Integer.class,  new IntegerEditor(0, null));
//		table.setDefaultEditor( Float.class,  new FloatEditor(0,null, new DecimalFormat( I18nMessages.FORMATO_MONTO )));
//		
//	}

	/**
	 * @return the editable
	 */
	public Boolean getEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	@Override
	protected void setFooter(List items) {
		
		//calculamos los totales.
		Integer cantidad = 0;
		Float descuento = 0F;
		Float monto = 0F;
		for (Object item : items) {
			
			DetalleVenta detalle = (DetalleVenta)item;
			
			cantidad += detalle.getCantidad();
			descuento += detalle.getDescuento();
			monto += detalle.getSubtotal();
		}
		
		footer.put( 0 , cantidad );
		footer.put( 1 , descuento );
		footer.put( 2 , monto );
	}
	
	@Override
	protected void setFooter(Vector items) {
		
		//calculamos los totales.
		Integer cantidad = 0;
		Float descuento = 0F;
		Float monto = 0F;
		for (Object item : items) {
			
			DetalleVenta detalle = (DetalleVenta)item;
			
			cantidad += detalle.getCantidad();
			descuento += detalle.getDescuento();
			monto += detalle.getSubtotal();
		}
		
		footer.put( 0 , cantidad );
		footer.put( 1 , descuento );
		footer.put( 2 , monto );
	}
	
	@Override
	protected void setFooter(UICollection items) {
		
		this.setFooter(items.getElements());
	}

	@Override
	protected Object getObjectFooter() {
		
		return footer;
	}

	@Override
	protected Object getFooterValueAt(int columnIndex) {
        
        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return null;
	        case 1:
	        	return null;
	        case 2:
	        	return null;
	        case 3:
	        	return footer.get(0);
	        case 4:
	        	return AppUtils.formatMoneda( (Float)footer.get(1) );
	        case 5:
	        	return AppUtils.formatMoneda( (Float)footer.get(2) );
            default:
                return "";
        }
    }
}