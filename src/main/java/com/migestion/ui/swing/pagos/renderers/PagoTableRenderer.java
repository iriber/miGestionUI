package com.migestion.ui.swing.pagos.renderers;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JTable;

import com.migestion.model.EstadoPago;
import com.migestion.model.Pago;
import com.migestion.swing.view.renderers.EntityFooterTableRenderer;

/**
 * Define la visualización de un objeto en la tabla que se mostrará en el
 * listado de pagos
 * 
 * @author Bernardo Iribarne
 * @since 28/10/2013
 * 
 */
public class PagoTableRenderer extends EntityFooterTableRenderer {

	@Override
	protected Font getFont(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column, Object entity) {

		Font font;
		if (isLastRow(table, row)) {
			font = getFontFooter();
		} else {
			
			font = super.getFont(table, value, isSelected, hasFocus, row,
					column, entity);
			
			Pago pago = (Pago) entity;
			// si el pago está anulado muestro la venta tachada y como
			// deshabilitada la fila
			if (pago.getEstadoPago().equals(EstadoPago.ANULADO)) {
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.STRIKETHROUGH,
						TextAttribute.STRIKETHROUGH_ON);
				font = new Font(attributes);
			}
			
		}
		return font;

	}
}