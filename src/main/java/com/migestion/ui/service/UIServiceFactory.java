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
	 * servicio para pagos
	 * @return
	 */
	public static UIPagoService getUIPagoService(){
		return UIPagoService.getInstance();
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
}