package com.migestion.ui.swing.gastos;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.ConceptoMovimiento;
import com.migestion.model.EstadisticaGasto;
import com.migestion.model.FormaPago;
import com.migestion.model.Gasto;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para gastos.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 12/11/2013
 * 
 */
public class UIGastoCollection extends UIFooterCollection {

	private EstadisticaGasto estadistica;

	public UIGastoCollection(String description) {
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
			return ConceptoMovimiento.class;
		case 3:
			return Float.class;
		case 4:
			return FormaPago.class;
		case 5:
			return String.class;
		default:
			return Object.class;
		}
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return I18nMessages.GASTO_CODIGO;
		case 1:
			return I18nMessages.GASTO_FECHA;
		case 2:
			return I18nMessages.GASTO_CONCEPTO;
		case 3:
			return I18nMessages.GASTO_MONTO;
		case 4:
			return I18nMessages.GASTO_FORMA_PAGO;
		case 5:
			return I18nMessages.GASTO_OBSERVACIONES;
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
			return SwingConstants.LEFT;
		case 5:
			return SwingConstants.LEFT;
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
			return 150;
		case 3:
			return 100;
		case 4:
			return 70;
		case 5:
			return 200;
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
		Gasto gasto = (Gasto) (getElements().get(rowIndex));

		// no es editable.
	}

//
//	public TableCellRenderer getTableCellRenderer() {
//		return new GastoTableRenderer();
//	}

	/**
	 * @return the estadistica
	 */
	public EstadisticaGasto getEstadistica() {
		return estadistica;
	}

	/**
	 * @param estadistica
	 *            the estadistica to set
	 */
	public void setEstadistica(EstadisticaGasto estadistica) {
		this.estadistica = estadistica;
	}

	@Override
	protected void setFooter(UICollection items) {
		
		this.setEstadistica(((UIGastoCollection) items).getEstadistica());
		
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
		case 4:
			return null;
		case 5:
			return null;
		default:
			return "";
		}

	}

	@Override
	protected Object getEntityValueAt(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		Gasto gasto = (Gasto) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return gasto.getOid();
		case 1:
			return gasto.getFecha();
		case 2:
			return gasto.getMovimiento().getConcepto();
		case 3:
			return gasto.getMonto();
		case 4:
			return gasto.getFormaPago();
		case 5:
			return gasto.getObservaciones();
		default:
			return "";
		}
	}
	
	@Override
	protected Object getEntityValueAtShow(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		Gasto gasto = (Gasto) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return gasto.getOid();
		case 1:
			return AppUtils.formatDatetime( gasto.getFecha() );
		case 2:
			return gasto.getMovimiento().getConcepto().toString();
		case 3:
			return AppUtils.formatMoneda( gasto.getMonto() );
		case 4:
			return I18nMessages.locale( gasto.getFormaPago().getNombre() );
		case 5:
			return gasto.getObservaciones();
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