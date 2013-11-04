package com.migestion.ui.swing.operaciones.ventas.renderers;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;

import com.migestion.model.EstadoVenta;
import com.migestion.model.Venta;
import com.migestion.swing.view.renderers.EntityFooterTableRenderer;

/**
 * Define la visualización de un objeto en la tabla que se mostrará en el
 * listado de ventas
 * 
 * @author Bernardo Iribarne
 * @since 23/10/2013
 * 
 */
public class VentaTableRenderer extends EntityFooterTableRenderer {

	@Override
	protected Font getFont(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column, Object entity) {

		Font font;
		if (isLastRow(table, row)) {
			font = getFontFooter();
		} else {
			
			font = super.getFont(table, value, isSelected, hasFocus, row,
					column, entity);
			
			Venta venta = (Venta) entity;
			// si la venta está anulada muestro la venta tachada y como
			// deshabilitada la fila
			if (venta.getEstadoVenta().equals(EstadoVenta.ANULADA)) {
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.STRIKETHROUGH,
						TextAttribute.STRIKETHROUGH_ON);
				font = new Font(attributes);
			}
			
		}
		return font;

	}

	@Override
	protected void decorate(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column, JLabel entityLbl,
			Object entity) {

		super.decorate(table, value, isSelected, hasFocus, row, column,
				entityLbl, entity);

		if (!isLastRow(table, row)) {

			Venta venta = (Venta) entity;

			// chequeamos que la venta no esté anulada

			if (! (venta.getEstadoVenta().equals(EstadoVenta.ANULADA) || (venta.getEstadoVenta().equals(EstadoVenta.PAGADA)))) {
				switch (column) {
				case 4:
					// en la columna del monto debe indicamos con un color el
					// estado de la venta
					entityLbl.setForeground(venta.getEstadoVenta().getFg());
					entityLbl.setBackground(venta.getEstadoVenta().getBg());
					break;
				default:
					break;
				}
			}

		}
	}


}