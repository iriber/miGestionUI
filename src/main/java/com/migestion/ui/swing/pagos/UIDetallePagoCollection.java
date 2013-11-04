package com.migestion.ui.swing.pagos;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.Cliente;
import com.migestion.model.DetalleFormaPago;
import com.migestion.model.DetallePago;
import com.migestion.model.DetalleVenta;
import com.migestion.model.Operacion;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.swing.view.renderers.EntityTableRenderer;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para detalles de pago. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 28/10/2013
 *
 */
public class UIDetallePagoCollection extends UIFooterCollection{

	private Boolean editable;

	private HashMap<Integer, Object> footer;
	
	public UIDetallePagoCollection(String description, Boolean editable) {
		super(description);
		footer = new HashMap<Integer, Object>();
		setElements(new Vector());
		setEditable(editable);
		
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
	           return Date.class;
	       case 2:
	           return String.class;
	       case 3:
	           return Cliente.class;
	       case 4:
	           return Float.class;
	        default:
	             return Object.class;
	     }
	}

	public String getColumnName(int columnIndex) {
        switch (columnIndex)
        {
        case 0:
            return I18nMessages.OPERACION_CODIGO;
        case 1:
            return I18nMessages.OPERACION_FECHA;
        case 2:
        	return I18nMessages.OPERACION;
        case 3:
        	return I18nMessages.OPERACION_CLIENTE;
        case 4:
        	return I18nMessages.DETALLEPAGO_MONTO;
		default:
			return "";
        }
    }

	public Object getEntityValueAt(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		DetallePago detalle = (DetallePago)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
	        case 0:
	            return detalle.getOperacion().getOid();
	        case 1:
	        	return detalle.getOperacion().getFecha();
	        case 2:
	        	return detalle.getOperacion().getDescripcion();
	        case 3:
	        	return detalle.getOperacion().getCliente();
	        case 4:
	        	return detalle.getMonto();
            default:
                return "";
        }
    }

	public Object getEntityValueAtShow(int rowIndex, int columnIndex) {
        
		// Se obtiene el dato de la fila indicada
		DetallePago detalle = (DetallePago)(getElements().get(rowIndex));

        // Se obtiene el campo apropiado según el valor de columnIndex
        switch (columnIndex)
        {
        	case 0:
        		return detalle.getOperacion().getOid();
	        case 1:
	            return AppUtils.formatDate( detalle.getOperacion().getFecha() );
	        case 2:
	            return I18nMessages.locale( detalle.getOperacion().getDescripcion() ) ;
	        case 3:
	            return detalle.getOperacion().getCliente() ;
	        case 4:
	        	return AppUtils.formatMoneda( detalle.getMonto() );
            default:
                return "";
        }
    }
    
	public Integer getColumnWidth(int columnIndex) {
		switch (columnIndex){
			case 0:
				return 50;
			case 1:
				return 50;
			case 2:
				return 50;
			case 3:
				return 200;
			case 4:
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
			return SwingConstants.CENTER;
		case 2:
			return SwingConstants.LEFT;
		case 3:
			return SwingConstants.LEFT;
		case 4:
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
                return false;
            case 3:
                return false;
            case 4:
                return false;
            default:
                return false;
        }
    }


    @Override
    public void setEntityValueAt(Object aValue, int rowIndex, int columnIndex)
    {
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
			
			DetallePago detalle = (DetallePago)item;
			
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
			
			DetallePago detalle = (DetallePago)item;
			
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
	        case 4:
	        	return AppUtils.formatMoneda( (Float)footer.get(1) );
            default:
                return "";
        }
    }
}