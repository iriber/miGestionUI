package com.migestion.ui.swing.pagos;


import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.DetalleFormaPago;
import com.migestion.model.FormaPago;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para detalles de forma de pago. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 29/10/2013
 *
 */
public class UIDetalleFormaPagoCollection extends UIFooterCollection{

	private Boolean editable;

	private HashMap<Integer, Object> footer;
	
	public UIDetalleFormaPagoCollection(String description, Boolean editable) {
		super(description);
		footer = new HashMap<Integer, Object>();
		setElements(new Vector());
		setEditable(editable);
		
	}

	
	public int getColumnCount() {		
		return 3;
	}

	public Class getColumnClass(int columnIndex) {
	     switch (columnIndex)
	     {
	       case 0:
	           return FormaPago.class;
	       case 1:
	           return String.class;
	       case 2:
	           return Float.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.DETALLE_FORMA_PAGO_FORMAPAGO;
        case 1:
        	return I18nMessages.DETALLE_FORMA_PAGO_OBSERVACIONES;
        case 2:
        	return I18nMessages.DETALLE_FORMA_PAGO_MONTO;
		default:
			return "";
        }
    }

	public Object getEntityValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		DetalleFormaPago detalle = (DetalleFormaPago)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return detalle.getFormaPago();
	        case 1:
	        	return detalle.getObservaciones();
	        case 2:
	        	return detalle.getMonto();
            default:
                return "";
        }
    }

	public Object getEntityValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		DetalleFormaPago detalle = (DetalleFormaPago)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return detalle.toString( new I18nMessages() );
	        case 1:
	            return detalle.getObservaciones();
	        case 2:
	        	return AppUtils.formatMoneda( detalle.getMonto() );
            default:
                return "";
        }
    }
    
	public Integer getColumnWidth(int columnIndex) {
		switch (columnIndex){
		case 0:
			return 400;
		case 1:
			return 200;
		case 2:
			return 50;
		default:
			return super.getColumnWidth(columnIndex);
		}
	}

	public Integer getColumnTextAlign(int columnIndex) {
		switch (columnIndex){
		case 0:
			return SwingConstants.LEFT;
		case 1:
			return SwingConstants.LEFT;
		case 2:
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
                return true;
            default:
                return false;
        }
    }


    @Override
    public void setEntityValueAt(Object aValue, int rowIndex, int columnIndex)
    {
		// Se obtiene el dato de la fila indicada
		DetalleFormaPago detalle = (DetalleFormaPago)(getElements().get(rowIndex));
		
		Boolean cambio = false;
		
		switch (columnIndex)
        {
	        case 0:
	            break;
	        case 1:
	        	break;
	        case 2:
	        	detalle.setMonto( (Float)aValue );
	        	cambio = true;
	        	break;
            default:
            	break;
        }
		
		if( cambio ){
			
			updateElement(aValue);
		}

    }
    
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
		Float monto = 0F;
		for (Object item : items) {
			
			DetalleFormaPago detalle = (DetalleFormaPago)item;
			
			cantidad += 1;
			monto += detalle.getMonto();
		}
		
		footer.put( 0 , cantidad );
		footer.put( 1 , monto );
	}
	
	@Override
	protected void setFooter(Vector items) {
		
		//calculamos los totales.
		Integer cantidad = 0;
		Float monto = 0F;
		for (Object item : items) {
			
			DetalleFormaPago detalle = (DetalleFormaPago)item;
			
			cantidad += 1;
			monto += detalle.getMonto();
		}
		
		footer.put( 0 , cantidad );
		footer.put( 1 , monto );
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
	        	return "# Total " + footer.get(0);
	        case 2:
	        	return AppUtils.formatMoneda( (Float)footer.get(1) );
            default:
                return "";
        }
    }
}