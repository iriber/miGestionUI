package com.migestion.ui.swing.pagos;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.EstadisticaPago;
import com.migestion.model.PagoProveedor;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.renderers.PagoTableRenderer;

/**
 * UICollection para pagos a proveedores.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 * 
 */
public class UIPagoProveedorCollection extends UIFooterCollection {

	private EstadisticaPago estadistica;

	public UIPagoProveedorCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {
		return 4;
	}

	public Class getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Long.class;
		case 1:
			return Date.class;
		case 2:
			return String.class;
		case 3:
			return Float.class;
		default:
			return Object.class;
		}
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return I18nMessages.PAGO_CODIGO;
		case 1:
			return I18nMessages.PAGO_FECHA;
		case 2:
			return I18nMessages.PAGO_PROVEEDOR;
		case 3:
			return I18nMessages.PAGO_MONTO;
		default:
			return "";
		}
	}



	public Integer getColumnTextAlign(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return SwingConstants.CENTER;
		case 1:
			return SwingConstants.CENTER;
		case 2:
			return SwingConstants.LEFT;
		case 3:
			return SwingConstants.RIGHT;
		default:
			return SwingConstants.LEFT;
		}
	}

	public Integer getColumnWidth(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return 50;
		case 1:
			return 30;
		case 2:
			return 200;
		case 3:
			return 100;
		default:
			return super.getColumnWidth(columnIndex);
		}
	}

	@Override
	protected boolean isEntityCellEditable(int rowIndex, int columnIndex) {
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return false;
		case 1:
			return false;
		case 2:
			return false;
		case 3:
			return false;
		default:
			return false;
		}
	}

	@Override
	protected void setEntityValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Se obtiene el dato de la fila indicada
		PagoProveedor pago = (PagoProveedor) (getElements().get(rowIndex));

		// no es editable.
	}


	public TableCellRenderer getTableCellRenderer() {
		return new PagoTableRenderer();
	}

	/**
	 * @return the estadistica
	 */
	public EstadisticaPago getEstadistica() {
		return estadistica;
	}

	/**
	 * @param estadistica
	 *            the estadistica to set
	 */
	public void setEstadistica(EstadisticaPago estadistica) {
		this.estadistica = estadistica;
	}

	@Override
	protected void setFooter(UICollection items) {
		
		this.setEstadistica(((UIPagoProveedorCollection) items).getEstadistica());
		
	}

	@Override
	protected Object getObjectFooter() {

		return getEstadistica();
	}

	@Override
	protected Object getFooterValueAt(int columnIndex) {

		switch (columnIndex) {
		case 0:
			return "# Total " + getEstadistica().getCantidad();
		case 1:
			return null;
		case 2:
			return null;
		case 3:
			return AppUtils.formatMoneda( getEstadistica().getImporteTotal() );
		default:
			return "";
		}

	}

	@Override
	protected Object getEntityValueAt(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		PagoProveedor pago = (PagoProveedor) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return pago.getOid();
		case 1:
			return pago.getFecha();
		case 2:
			return pago.getProveedor();
		case 3:
			return pago.getMonto();
		default:
			return "";
		}
	}
	
	@Override
	protected Object getEntityValueAtShow(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		PagoProveedor pago = (PagoProveedor) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return pago.getOid();
		case 1:
			return AppUtils.formatDate( pago.getFecha() );
		case 2:
			return pago.getProveedor();
		case 3:
			return AppUtils.formatMoneda( pago.getMonto() );
		default:
			return "";
		}
	}

	@Override
	protected void setFooter(Vector items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setFooter(List items) {
		// TODO Auto-generated method stub
		
	}

}