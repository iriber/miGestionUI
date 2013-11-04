package com.migestion.ui.swing.cajas.movimientos;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.migestion.model.ConceptoMovimiento;
import com.migestion.model.EstadisticaCaja;
import com.migestion.model.MovimientoCaja;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.model.UIFooterCollection;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * UICollection para movimientos de caja.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 30/10/2013
 * 
 */
public class UIMovimientoCajaCollection extends UIFooterCollection {

	private EstadisticaCaja estadistica;

	public UIMovimientoCajaCollection(String description) {
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
			return I18nMessages.MOVIMIENTO_CUENTA_CODIGO;
		case 1:
			return I18nMessages.MOVIMIENTO_CUENTA_FECHA_HORA;
		case 2:
			return I18nMessages.MOVIMIENTO_CUENTA_CONCEPTO;
		case 3:
			return I18nMessages.MOVIMIENTO_CUENTA_HABER;
		case 4:
			return I18nMessages.MOVIMIENTO_CUENTA_DEBE;
		case 5:
			return I18nMessages.MOVIMIENTO_CUENTA_SALDO;
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

		// no es editable.
	}


//	public TableCellRenderer getTableCellRenderer() {
//		return new VentaTableRenderer();
//	}

	/**
	 * @return the estadistica
	 */
	public EstadisticaCaja getEstadistica() {
		return estadistica;
	}

	/**
	 * @param estadistica
	 *            the estadistica to set
	 */
	public void setEstadistica(EstadisticaCaja estadistica) {
		this.estadistica = estadistica;
	}

	@Override
	protected void setFooter(UICollection items) {
		
		this.setEstadistica(((UIMovimientoCajaCollection) items).getEstadistica());
		
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
			return AppUtils.formatMoneda( getEstadistica().getImporteTotalHaber() );
		case 4:
			return AppUtils.formatMoneda( getEstadistica().getImporteTotalDebe() );
		case 5:
			return AppUtils.formatMoneda( getEstadistica().getSaldo() );
		default:
			return "";
		}

	}

	@Override
	protected Object getEntityValueAt(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		MovimientoCaja movimiento = (MovimientoCaja) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return movimiento.getOid();
		case 1:
			return movimiento.getFechaHora();
		case 2:
			return movimiento.getConcepto();
		case 3:
			return movimiento.getHaber();
		case 4:
			return movimiento.getDebe();
		case 5:
			return movimiento.getSaldo();
		default:
			return "";
		}
	}
	
	@Override
	protected Object getEntityValueAtShow(int rowIndex, int columnIndex) {

		// Se obtiene el dato de la fila indicada
		MovimientoCaja movimiento = (MovimientoCaja) (getElements().get(rowIndex));
		
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return movimiento.getOid();
		case 1:
			return AppUtils.formatDatetime( movimiento.getFechaHora() );
		case 2:
			return movimiento.getConcepto().toString();
		case 3:
			return AppUtils.formatMoneda( movimiento.getHaber() );
		case 4:
			return AppUtils.formatMoneda( movimiento.getDebe() );
		case 5:
			return AppUtils.formatMoneda( movimiento.getSaldo() );
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