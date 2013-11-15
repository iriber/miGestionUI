package com.migestion.ui.swing;

import javax.swing.KeyStroke;

public interface LinkHelper {

	/**
	 * key stroke genéricos
	 */
	public KeyStroke LINK_ADD_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_UPDATE_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_DELETE_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	/**
	 * key stroke para los listados
	 */
	
	
	public KeyStroke LINK_CAJAS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_CATEGORIAS_PRODUCTOS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_CHEQUES_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_CLIENTES_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_CUENTAS_BANCARIAS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	public KeyStroke LINK_BALANCE_DIARIO_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	public KeyStroke LINK_GASTOS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	public KeyStroke LINK_MOVIMIENTOS_CAJA_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_MOVIMIENTOS_CUENTA_BANCARIA_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_MOVIMIENTOS_NOTA_CREDITO_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	public KeyStroke LINK_NOTAS_CREDITO_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	
	public KeyStroke LINK_VENDEDORES_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_VENTAS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK);
	
	public KeyStroke LINK_PAGOS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_PRODUCTOS_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK);
	public KeyStroke LINK_PROVEEDORES_KEY_STROKE = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.ALT_DOWN_MASK);
}
