package com.migestion.ui.swing.i18n;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Manejará la internacionaliación de imágenes
 * 
 * @author bernardo
 * @since 19/05/2012
 */
public class I18nImages {

  private static ResourceBundle properties = ResourceBundle.getBundle(I18nImages.class.getName()) ;

  //path de imágenes
  public static String PATH_IMAGES = properties.getString("imagePath");

  //logos
  public static URL LOGO = I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("logo") );
  public static URL LOGO_ICON = I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("logo.icon") );

  //botones comunes
  public static URL BOTON_LOGIN =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.login") ) ;
  /*
  public static URL BOTON_AGREGAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.agregar") ) ;
  public static URL BOTON_MODIFICAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.modificar") ) ;
  public static URL BOTON_ELIMINAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.eliminar") );
  public static URL BOTON_BUSCAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.buscar") );
  public static URL BOTON_VISUALIZAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.visualizar") );
  public static URL BOTON_ACEPTAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.aceptar") );
  public static URL BOTON_CANCELAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.cancelar") );
  public static URL BOTON_AYUDA =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.ayuda") );
  public static URL BOTON_EXAMINAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.examinar") );
  public static URL BOTON_SALIR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.salir") );
  public static URL BOTON_SALIR_SISTEMA =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.salir.sistema") );
  public static URL BOTON_CHART =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.chart") );
  public static URL BOTON_IMPRIMIR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.imprimir") );
  public static URL BOTON_BACKUP =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.backup") );
  public static URL BOTON_RESTAURAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.restaurar") );
  public static URL BOTON_EXCEL =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.excel") );
  public static URL BOTON_MAIL =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.mail") );
 */
  
  public static URL BOTON_FACTURAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.facturar") ) ;
  public static URL BOTON_PAGAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.pagar") ) ;
  
  public static URL BOTON_ACTIVAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.activar") ) ;
  public static URL BOTON_DESACTIVAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.desactivar") ) ;
  
  public static URL BOTON_ANULAR =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("boton.anular") ) ;

  //productos
  public static URL PRODUCTOS_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("productos.icon") );
		
  public static URL PRODUCTOS_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("productos.small.icon") );


  //categorías de producto
  public static URL CATEGORIAS_PRODUCTO_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("categoriasProducto.icon") );
		
  public static URL CATEGORIAS_PRODUCTO_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("categoriasProducto.small.icon") );


  //vendedores
  public static URL VENDEDORES_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("vendedores.icon") );
		
  public static URL VENDEDORES_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("vendedores.small.icon") );

  
  //clientes
  public static URL CLIENTES_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("clientes.icon") );
		
  public static URL CLIENTES_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("clientes.small.icon") );


  //movimientos de cuenta
  public static URL MOVIMIENTOS_CAJA_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("movimientos_ctacte.icon") );
		
  public static URL MOVIMIENTOS_CAJA_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("movimientos_ctacte.small.icon") );
  
  //ventas
  public static URL VENTAS_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("ventas.icon") );
		
  public static URL VENTAS_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("ventas.small.icon") );

  //pagos
  public static URL PAGOS_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("pagos.icon") );
		
  public static URL PAGOS_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("pagos.small.icon") );

  //cuentas bancarias
  public static URL CUENTAS_BANCARIAS_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("cuentasbancarias.icon") );
		
  public static URL CUENTAS_BANCARIAS_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("cuentasbancarias.small.icon") );
  
  
  
  
  
  
  
  
  
  
  
  //cuentas.
  public static URL CUENTAS_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("cuentas.icon") );
  
  public static URL CUENTAS_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("cuentas.small.icon") );
  

  //facturadores
  public static URL FACTURADORES_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("facturadores.icon") );
		
  public static URL FACTURADORES_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("facturadores.small.icon") );

  //facturas
  public static URL FACTURAS_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("facturas.icon") );
		
  public static URL FACTURAS_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/" + properties.getString("facturas.small.icon") );




  //formas de pago
  public static URL FORMAS_PAGO_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("formaspago.icon") );
		
  public static URL FORMAS_PAGO_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
			+ properties.getString("formaspago.small.icon") );
  
  //frame gastos.
  /*
  public static URL GASTOS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/" + properties.getString("gastos.icon") );
  
  //frame ingresos.
  public static URL INGRESOS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/" + properties.getString("gastos.icon") );
  
  //frame libro diario
  public static URL LIBRO_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/" + properties.getString("libro.icon") );
  
  //frame libro diario
  public static URL LIBRO_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/" + properties.getString("libro.small.icon") );
  
  //frame balances
  public static URL BALANCE_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/" + properties.getString("balance.icon") );
  

  
	public static URL FACTURAS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("facturas.icon") );
	
	public static URL FACTURAS_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("facturas.small.icon") );


	public static URL PAGOS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("pagos.icon") );
	
	public static URL PAGOS_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("pagos.small.icon") );  

	public static URL PRODUCTOS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("productos.icon") );

	public static URL CLIENTES_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
		+ properties.getString("clientes.icon") );
	
	public static URL CLIENTES_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
		+ properties.getString("clientes.small.icon") );


	public static URL VENTAS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("ventas.icon") );

	public static URL VENTAS_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("ventas.small.icon") );
	
	public static URL ABONOS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("abonos.icon") );
	
	public static URL ABONOS_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("abonos.small.icon") );
	
	public static URL PROCESAR_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("procesar.icon") );
	
	public static URL INDICADORES_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("indicadores.icon") );
	
	public static URL INDICADORES_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("indicadores.small.icon") );
	
	public static URL TAREAS_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("tareas.icon") );
	
	public static URL TAREAS_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("tareas.small.icon") );
	
	public static URL ADMIN_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("admin.small.icon") );
	
	
	public static URL ADMIN_ADD_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("admin.add.small.icon") );
	
	
	public static URL INGRESO_EGRESO_SMALL_ICON =  CuentasImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("ingreso.egreso.small.icon") );
	*/
	
	public static URL SESION_SMALL_ICON =  I18nImages.class.getResource( PATH_IMAGES + "/"
	+ properties.getString("sesion.small.icon") );
	

	//public static URL RESOURCE_BOTON_AGREGAR = PropertiesImages.class.getResource( BOTON_AGREGAR ));

}
