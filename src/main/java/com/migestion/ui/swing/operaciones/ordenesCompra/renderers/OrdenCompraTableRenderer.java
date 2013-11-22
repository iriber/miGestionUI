package com.migestion.ui.swing.operaciones.ordenesCompra.renderers;

import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;

import com.migestion.model.EstadoOrdenCompra;
import com.migestion.model.OrdenCompra;
import com.migestion.swing.view.renderers.EntityFooterTableRenderer;

/**
 * Define la visualización de un objeto en la tabla que se mostrará en el
 * listado de órdenes de compra
 * 
 * @author Bernardo Iribarne
 * @since 22/11/2013
 * 
 */
public class OrdenCompraTableRenderer extends EntityFooterTableRenderer {

	@Override
	protected Font getFont(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column, Object entity) {

		Font font;
		if (isLastRow(table, row)) {
			font = getFontFooter();
		} else {
			
			font = super.getFont(table, value, isSelected, hasFocus, row,
					column, entity);
			
			OrdenCompra ordenCompra = (OrdenCompra) entity;
			// si la ordenCompra está anulada muestro la ordenCompra tachada y como
			// deshabilitada la fila
			if (ordenCompra.getEstadoOrdenCompra().equals(EstadoOrdenCompra.ANULADA)) {
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

			OrdenCompra ordenCompra = (OrdenCompra) entity;

			// chequeamos que la ordenCompra no esté anulada

			if (! (ordenCompra.getEstadoOrdenCompra().equals(EstadoOrdenCompra.ANULADA) || (ordenCompra.getEstadoOrdenCompra().equals(EstadoOrdenCompra.PAGADA)))) {
				switch (column) {
				case 4:
					// en la columna del monto debe indicamos con un color el
					// estado de la ordenCompra
					entityLbl.setForeground(ordenCompra.getEstadoOrdenCompra().getFg());
					entityLbl.setBackground(ordenCompra.getEstadoOrdenCompra().getBg());
					break;
				default:
					break;
				}
			}

		}
	}


}