package com.migestion.ui.swing.operaciones.ordenesCompra;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.EstadisticaOperacion;
import com.migestion.model.OrdenCompra;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ordenesCompra.renderers.OrdenCompraTableRenderer;

/**
 * UICollection para órdenes de compra.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 22/11/2013
 * 
 */
public class UIOrdenCompraCollection extends UIFooterCollection {

	private EstadisticaOperacion estadistica;

	public UIOrdenCompraCollection(String description) {
		super(description);
		setElements(new Vector());
	}

	public int getColumnCount() {
		return 6;
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
		case 4:
			return Float.class;
		case 5:
			return Float.class;
		default:
			return Object.class;
		}
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return I18nMessages.OPERACION_CODIGO;
		case 1:
			return I18nMessages.OPERACION_FECHA;
		case 2:
			return I18nMessages.ORDEN_COMPRA_PROVEEDOR;
		case 3:
			return I18nMessages.ORDEN_COMPRA_MONTO_PAGADO;
		case 4:
			return I18nMessages.ORDEN_COMPRA_MONTO_DEBE;
		case 5:
			return I18nMessages.OPERACION_MONTO;
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
		case 4:
			return SwingConstants.RIGHT;
		case 5:
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
		case 4:
			return 100;
		case 5:
			return 100;
		default:
			return super.getColumnWidth(columnIndex);
		}
	}

	// --------------------------------------------------
	// Se definen los valores por defecto para imprimir.
	// Ser�n los mismos que se muestran en pantalla.
	// --------------------------------------------------

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.migestion.swing.model.UICollection#getColumnCountToPrint()
	 */
	public int getColumnCountToPrint() {
		return getColumnCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.migestion.swing.model.UICollection#getColumnClassToPrint(int)
	 */
	public Class getColumnClassToPrint(int columnIndex) {
		return getColumnClass(columnIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.migestion.swing.model.UICollection#getColumnNameToPrint(int)
	 */
	public String getColumnNameToPrint(int columnIndex) {
		return getColumnName(columnIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.migestion.swing.model.UICollection#getValueAtToPrint(int, int)
	 */
	public Object getValueAtToPrint(int rowIndex, int columnIndex) {

		return getValueAt(rowIndex, columnIndex);
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
		case 4:
			return false;
		case 5:
			return false;
		default:
			return false;
		}
	}

	@Override
	protected void setEntityValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Se obtiene el dato de la fila indicada
		OrdenCompra ordenCompra = (OrdenCompra) (getElements().get(rowIndex));

		// no es editable.
	}


	public TableCellRenderer getTableCellRenderer() {
		return new OrdenCompraTableRenderer();
	}

	/**
	 * @return the estadistica
	 */
	public EstadisticaOperacion getEstadistica() {
		return estadistica;
	}

	/**
	 * @param estadistica
	 *            the estadistica to set
	 */
	public void setEstadistica(EstadisticaOperacion estadistica) {
		this.estadistica = estadistica;
	}

	@Override
	protected void setFooter(UICollection items) {
		
		this.setEstadistica(((UIOrdenCompraCollection) items).getEstadistica());
		
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
			return AppUtils.formatMoneda( getEstadistica().getImporteTotalPagado() );
		case 4:
			return AppUtils.formatMoneda( getEstadistica().getImporteTotalDebe() );
		case 5:
			return AppUtils.formatMoneda( getEstadistica().getImporteTotal() );
		default:
			return "";
		}

	}

	@Override
	protected Object getEntityValueAt(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		OrdenCompra ordenCompra = (OrdenCompra) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return ordenCompra.getOid();
		case 1:
			return ordenCompra.getFecha();
		case 2:
			return ordenCompra.getProveedor();
		case 3:
			return ordenCompra.getMontoPagado();
		case 4:
			return ordenCompra.getMontoDebe();
		case 5:
			return ordenCompra.getMonto();
		default:
			return "";
		}
	}
	
	@Override
	protected Object getEntityValueAtShow(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		OrdenCompra ordenCompra = (OrdenCompra) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return ordenCompra.getOid();
		case 1:
			return AppUtils.formatDate( ordenCompra.getFecha() );
		case 2:
			return ordenCompra.getProveedor();
		case 3:
			return AppUtils.formatMoneda( ordenCompra.getMontoPagado() );
		case 4:
			return AppUtils.formatMoneda( ordenCompra.getMontoDebe() );
		case 5:
			return AppUtils.formatMoneda( ordenCompra.getMonto() );
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