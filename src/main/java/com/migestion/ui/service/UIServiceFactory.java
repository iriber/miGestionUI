package com.migestion.ui.service;


/**
 * Factory de servicios de ui
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class UIServiceFactory {

	/**
	 * servicio para categorías de producto
	 * @return
	 */
	public static UICategoriaProductoService getUICategoriaProductoService(){
		return UICategoriaProductoService.getInstance();
	}

	/**
	 * servicio para productos
	 * @return
	 */
	public static UIProductoService getUIProductoService(){
		return UIProductoService.getInstance();
	}
	
	/**
	 * servicio para clientes
	 * @return
	 */
	public static UIClienteService getUIClienteService(){
		return UIClienteService.getInstance();
	}
	
	/**
	 * servicio para vendedores
	 * @return
	 */
	public static UIVendedorService getUIVendedorService(){
		return UIVendedorService.getInstance();
	}
	
	/**
	 * servicio para ventas
	 * @return
	 */
	public static UIVentaService getUIVentaService(){
		return UIVentaService.getInstance();
	}
	
	/**
	 * servicio para cuentas bancarias
	 * @return
	 */
	public static UICuentaBancariaService getUICuentaBancariaService(){
		return UICuentaBancariaService.getInstance();
	}
	
	/**
	 * servicio para sucursales
	 * @return
	 */
	public static UISucursalService getUISucursalService(){
		return UISucursalService.getInstance();
	}
	
	/**
	 * servicio para pagos de clientes
	 * @return
	 */
	public static UIPagoClienteService getUIPagoClienteService(){
		return UIPagoClienteService.getInstance();
	}
	
	/**
	 * servicio para cajas
	 * @return
	 */
	public static UICajaService getUICajaService(){
		return UICajaService.getInstance();
	}
	/**
	 * servicio para conceptos de movimientos
	 * @return
	 */
	public static UIConceptoMovimientoService getUIConceptoMovimientoService(){
		return UIConceptoMovimientoService.getInstance();
	}
	
	/**
	 * servicio para movimientos de caja
	 * @return
	 */
	public static UIMovimientoCajaService getUIMovimientoCajaService(){
		return UIMovimientoCajaService.getInstance();
	}
	
	/**
	 * servicio para movimientos de cuentas bancarias
	 * @return
	 */
	public static UIMovimientoCuentaBancariaService getUIMovimientoCuentaBancariaService(){
		return UIMovimientoCuentaBancariaService.getInstance();
	}
	
	/**
	 * servicio para movimientos de cuentas de proveedores
	 * @return
	 */
	public static UIMovimientoCuentaProveedorService getUIMovimientoCuentaProveedorService(){
		return UIMovimientoCuentaProveedorService.getInstance();
	}
	
	/**
	 * servicio para movimientos de cuentas de clientes
	 * @return
	 */
	public static UIMovimientoCuentaClienteService getUIMovimientoCuentaClienteService(){
		return UIMovimientoCuentaClienteService.getInstance();
	}

	/**
	 * servicio para movimientos de cheques
	 * @return
	 */
	public static UIMovimientoChequeService getUIMovimientoChequeService(){
		return UIMovimientoChequeService.getInstance();
	}
	
	/**
	 * servicio para movimientos de notas de crédito
	 * @return
	 */
	public static UIMovimientoNotaCreditoService getUIMovimientoNotaCreditoService(){
		return UIMovimientoNotaCreditoService.getInstance();
	}
	/**
	 * servicio para balances
	 * @return
	 */
	public static UIBalanceService getUIBalanceService(){
		return UIBalanceService.getInstance();
	}
	
	/**
	 * servicio para cheques
	 * @return
	 */
	public static UIChequeService getUIChequeService(){
		return UIChequeService.getInstance();
	}
	
	/**
	 * servicio para notas de crédito
	 * @return
	 */
	public static UINotaCreditoService getUINotaCreditoService(){
		return UINotaCreditoService.getInstance();
	}

	/**
	 * servicio para gastos
	 * @return
	 */
	public static UIGastoService getUIGastoService(){
		return UIGastoService.getInstance();
	}

	/**
	 * servicio para proveedores
	 * @return
	 */
	public static UIProveedorService getUIProveedorService(){
		return UIProveedorService.getInstance();
	}

	/**
	 * servicio para órdenes de compra
	 * @return
	 */
	public static UIOrdenCompraService getUIOrdenCompraService(){
		return UIOrdenCompraService.getInstance();
	}
	
	/**
	 * servicio para pagos a proveedores
	 * @return
	 */
	public static UIPagoProveedorService getUIPagoProveedorService(){
		return UIPagoProveedorService.getInstance();
	}

}