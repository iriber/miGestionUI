package com.migestion.ui.swing.i18n;

import java.util.ResourceBundle;

import com.migestion.i18n.I18nLocale;


/**
 * Manejará la internacionalicación de los mensajes
 *  
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 */
public class I18nMessages implements I18nLocale{
	

	public String message(String key) {
		
		return locale(key);
	}
	
	public static String locale( String key){
		
		return properties.getString(key);
	}

	private static ResourceBundle properties = ResourceBundle.getBundle( I18nMessages.class.getName() );
	
	public static String EMPRESA_NOMBRE =locale("empresa");
	public static String TITULO_MAIN = properties.getString("titulo");
	public static String FRAME_MENUADMIN = properties.getString("frame.menuadmin");
	
	/**
	 * global
	 */
	public static String INGRESE_REQUERIDOS = properties.getString("ingrese.requeridos");
	public static String FORMATO_INTEGER_INVALIDO = properties.getString("formato.integer.invalido");
	public static String FORMATO_FLOAT_INVALIDO = properties.getString("formato.float.invalido");
	public static String MENU_ADMIN = properties.getString("menu.admin");
	public static String MENU_SESION = properties.getString("menu.sesion");
	public static String MENU_CONTABLE = properties.getString("menu.contable");
	
	public static String BTN_AGREGAR = properties.getString("btn.agregar");
	public static String BTN_ELIMINAR = properties.getString("btn.eliminar");
	
	
	public static String FILTRO_RANGO = properties.getString("filtro.rango");
	public static String FILTRO_SEMANA_ACTUAL = properties.getString("filtro.semana_actual");
	public static String FILTRO_MES_ACTUAL = properties.getString("filtro.mes_actual");
	public static String FILTRO_ANIO_ACTUAL = properties.getString("filtro.anio_actual");
	
	/**
	 * formatos
	 */
	public static String FORMATO_DATE = properties.getString("formato.date");
	public static String FORMATO_DATETIME = properties.getString("formato.datetime");
	public static String FORMATO_MONTO = properties.getString("formato.monto");
	
	/**
	 * estados de productos
	 */
	public static String ESTADO_PRODUCTO_ACTIVO= properties.getString("estadoProducto.activo");
	public static String ESTADO_PRODUCTO_INACTIVO = properties.getString("estadoProducto.inactivo");
	public static String ESTADO_PRODUCTO_AGOTADO = properties.getString("estadoProducto.agotado");
	public static String ESTADO_PRODUCTO_ELIMINADO = properties.getString("estadoProducto.eliminado");
	
	/**
	 * productos
	 */		
	public static String PRODUCTOS = properties.getString("productos");
	public static String PRODUCTO_NOMBRE = properties.getString("producto.nombre");
	public static String PRODUCTO_CODIGO = properties.getString("producto.codigo");
	public static String PRODUCTO_DESCRIPCION = properties.getString("producto.descripcion");
	public static String PRODUCTO_PRECIO = properties.getString("producto.precio");
	public static String PRODUCTO_IVA = properties.getString("producto.iva");
	public static String PRODUCTO_STOCK = properties.getString("producto.stock");
	public static String PRODUCTO_STOCK_MINIMO = properties.getString("producto.stockMinimo");
	public static String PRODUCTO_STOCK_MAXIMO = properties.getString("producto.stockMaximo");
	public static String PRODUCTO_OBSEVACIONES = properties.getString("producto.observaciones");
	public static String PRODUCTO_CATEGORIA = properties.getString("producto.categoria");
	public static String PRODUCTO_CODIGO_BARRAS = properties.getString("producto.codigoBarras");
	public static String PRODUCTO_ESTADO = properties.getString("producto.estado");
	
	public static String PRODUCTO_FRAME_TITULO = properties.getString("producto.frame.titulo");
	public static String PRODUCTO_FRAME_MENUADMIN = properties.getString("producto.frame.menuadmin");
	
	public static String PRODUCTO_DIALOG_AGREGAR_TITULO = properties.getString("producto.dialog.agregar.titulo");
	public static String PRODUCTO_DIALOG_MODIFICAR_TITULO = properties.getString("producto.dialog.modificar.titulo");
	public static String PRODUCTO_DIALOG_BUSCAR_TITULO = properties.getString("producto.dialog.buscar.titulo");
	public static String PRODUCTO_DIALOG_ELIMINAR_TITULO = properties.getString("producto.dialog.eliminar.titulo");
	public static String PRODUCTO_DIALOG_ACTIVAR_TITULO = properties.getString("producto.dialog.activar.titulo");
	public static String PRODUCTO_DIALOG_DESACTIVAR_TITULO = properties.getString("producto.dialog.desactivar.titulo");
	
	public static String PRODUCTO_ACCION_LISTAR = properties.getString("producto.accion.listar");
	public static String PRODUCTO_ACCION_AGREGAR = properties.getString("producto.accion.agregar");
	public static String PRODUCTO_ACCION_MODIFICAR = properties.getString("producto.accion.modificar");
	public static String PRODUCTO_ACCION_ELIMINAR = properties.getString("producto.accion.eliminar");
	public static String PRODUCTO_ACCION_BUSCAR = properties.getString("producto.accion.buscar");
	public static String PRODUCTO_ACCION_ACTIVAR = properties.getString("producto.accion.activar");
	public static String PRODUCTO_ACCION_DESACTIVAR = properties.getString("producto.accion.desactivar");
	
	public static String PRODUCTO_MSG_CONFIRMA_ELIMINAR = properties.getString("producto.msg.confirma_eliminar");	

	
	/**
	 * categorías de producto
	 */		
	public static String CATEGORIAS_PRODUCTO = properties.getString("categoriasProducto");
	public static String CATEGORIA_PRODUCTO_NOMBRE = properties.getString("categoriaProducto.nombre");
	public static String CATEGORIA_PRODUCTO_CODIGO = properties.getString("categoriaProducto.codigo");
	public static String CATEGORIA_PRODUCTO_DESCRIPCION = properties.getString("categoriaProducto.descripcion");
	public static String CATEGORIA_PRODUCTO_PADRE = properties.getString("categoriaProducto.padre");
	
	public static String CATEGORIA_PRODUCTO_FRAME_TITULO = properties.getString("categoriaProducto.frame.titulo");
	public static String CATEGORIA_PRODUCTO_FRAME_MENUADMIN = properties.getString("categoriaProducto.frame.menuadmin");
	
	public static String CATEGORIA_PRODUCTO_DIALOG_AGREGAR_TITULO = properties.getString("categoriaProducto.dialog.agregar.titulo");
	public static String CATEGORIA_PRODUCTO_DIALOG_MODIFICAR_TITULO = properties.getString("categoriaProducto.dialog.modificar.titulo");
	public static String CATEGORIA_PRODUCTO_DIALOG_BUSCAR_TITULO = properties.getString("categoriaProducto.dialog.buscar.titulo");
	public static String CATEGORIA_PRODUCTO_DIALOG_ELIMINAR_TITULO = properties.getString("categoriaProducto.dialog.eliminar.titulo");
	
	public static String CATEGORIA_PRODUCTO_ACCION_LISTAR = properties.getString("categoriaProducto.accion.listar");
	public static String CATEGORIA_PRODUCTO_ACCION_AGREGAR = properties.getString("categoriaProducto.accion.agregar");
	public static String CATEGORIA_PRODUCTO_ACCION_MODIFICAR = properties.getString("categoriaProducto.accion.modificar");
	public static String CATEGORIA_PRODUCTO_ACCION_ELIMINAR = properties.getString("categoriaProducto.accion.eliminar");
	public static String CATEGORIA_PRODUCTO_ACCION_BUSCAR = properties.getString("categoriaProducto.accion.buscar");
	
	/**
	 * clientes
	 */
	public static String CLIENTES = properties.getString("clientes");
	public static String CLIENTE_NOMBRE = properties.getString("cliente.nombre");
	public static String CLIENTE_CODIGO = properties.getString("cliente.codigo");
	public static String CLIENTE_OBSERVACIONES = properties.getString("cliente.observaciones");
	public static String CLIENTE_FECHA_CUMPLEANIOS = properties.getString("cliente.fecha.nacimiento");
	public static String CLIENTE_DOMICILIO_FACTURACION = properties.getString("cliente.domicilio.facturacion");
	public static String CLIENTE_TELEFONO_FIJO = properties.getString("cliente.telefono.fijo");
	public static String CLIENTE_TELEFONO_CELULAR = properties.getString("cliente.telefono.celular");
	public static String CLIENTE_EMAIL = properties.getString("cliente.email");
	public static String CLIENTE_CONTACTO = properties.getString("cliente.contacto");
	public static String CLIENTE_CUIT = properties.getString("cliente.cuit");
	public static String CLIENTE_DOMICILIO = properties.getString("cliente.domicilio");
	public static String CLIENTE_NRO_DOCUMENTO = properties.getString("cliente.nro_documento");
	public static String CLIENTE_TIPO_DOCUMENTO = properties.getString("cliente.tipo_documento");
	public static String CLIENTE_CONDICION_IVA = properties.getString("cliente.condicion_iva");
	public static String CLIENTE_TIPO_CLIENTE = properties.getString("cliente.tipoCliente");
	
	public static String CLIENTE_FRAME_TITULO = properties.getString("cliente.frame.titulo");
	public static String CLIENTE_FRAME_MENUADMIN = properties.getString("cliente.frame.menuadmin");
	
	public static String CLIENTE_DIALOG_AGREGAR_TITULO = properties.getString("cliente.dialog.agregar.titulo");
	public static String CLIENTE_DIALOG_MODIFICAR_TITULO = properties.getString("cliente.dialog.modificar.titulo");
	public static String CLIENTE_DIALOG_BUSCAR_TITULO = properties.getString("cliente.dialog.buscar.titulo");
	public static String CLIENTE_DIALOG_ELIMINAR_TITULO = properties.getString("cliente.dialog.eliminar.titulo");
	
	public static String CLIENTE_ACCION_LISTAR = properties.getString("cliente.accion.listar");
	public static String CLIENTE_ACCION_AGREGAR = properties.getString("cliente.accion.agregar");
	public static String CLIENTE_ACCION_MODIFICAR = properties.getString("cliente.accion.modificar");
	public static String CLIENTE_ACCION_ELIMINAR = properties.getString("cliente.accion.eliminar");
	public static String CLIENTE_ACCION_BUSCAR = properties.getString("cliente.accion.buscar");
	
	public static String CLIENTE_MSG_CONFIRMA_ELIMINAR = properties.getString("cliente.msg.confirma_eliminar");
	
	public static String TIPO_DOCUMENTO_DNI = properties.getString("tipo.documento.dni");
	public static String TIPO_DOCUMENTO_CF = properties.getString("tipo.documento.cf");
	public static String TIPO_DOCUMENTO_LE = properties.getString("tipo.documento.le");
	public static String TIPO_DOCUMENTO_LC = properties.getString("tipo.documento.lc");
	public static String TIPO_DOCUMENTO_PASAPORTE = properties.getString("tipo.documento.pasaporte");
	
	/*
	public static String CONDICION_IVA_EXENTO = properties.getString("condicion.iva.exento");
	public static String CONDICION_IVA_CONSUMIDOR_FINAL = properties.getString("condicion.iva.consumidor_final");
	public static String CONDICION_IVA_RESPONSABLE_INSCRIPTO = properties.getString("condicion.iva.responsable.inscripto");
	public static String CONDICION_IVA_RESPONSABLE_MONOTRIBUTO = properties.getString("condicion.iva.responsable.monotributo");
	public static String CONDICION_IVA_RESPONSABLE_NO_INSCRIPTO = properties.getString("condicion.iva.responsable.no.inscripto");
	*/
	
	/**
	 * vendedores
	 */
	public static String VENDEDORES = properties.getString("vendedores");
	public static String VENDEDOR_NOMBRE = properties.getString("vendedor.nombre");
	public static String VENDEDOR_CODIGO = properties.getString("vendedor.codigo");
	public static String VENDEDOR_OBSERVACIONES = properties.getString("vendedor.observaciones");
	public static String VENDEDOR_FECHA_CUMPLEANIOS = properties.getString("vendedor.fecha.nacimiento");
	public static String VENDEDOR_TELEFONO_FIJO = properties.getString("vendedor.telefono.fijo");
	public static String VENDEDOR_TELEFONO_CELULAR = properties.getString("vendedor.telefono.celular");
	public static String VENDEDOR_EMAIL = properties.getString("vendedor.email");
	public static String VENDEDOR_DOMICILIO = properties.getString("vendedor.domicilio");
	public static String VENDEDOR_NRO_DOCUMENTO = properties.getString("vendedor.nro_documento");
	public static String VENDEDOR_TIPO_DOCUMENTO = properties.getString("vendedor.tipo_documento");
	
	public static String VENDEDOR_FRAME_TITULO = properties.getString("vendedor.frame.titulo");
	public static String VENDEDOR_FRAME_MENUADMIN = properties.getString("vendedor.frame.menuadmin");
	
	public static String VENDEDOR_DIALOG_AGREGAR_TITULO = properties.getString("vendedor.dialog.agregar.titulo");
	public static String VENDEDOR_DIALOG_MODIFICAR_TITULO = properties.getString("vendedor.dialog.modificar.titulo");
	public static String VENDEDOR_DIALOG_BUSCAR_TITULO = properties.getString("vendedor.dialog.buscar.titulo");
	public static String VENDEDOR_DIALOG_ELIMINAR_TITULO = properties.getString("vendedor.dialog.eliminar.titulo");
	
	public static String VENDEDOR_ACCION_LISTAR = properties.getString("vendedor.accion.listar");
	public static String VENDEDOR_ACCION_AGREGAR = properties.getString("vendedor.accion.agregar");
	public static String VENDEDOR_ACCION_MODIFICAR = properties.getString("vendedor.accion.modificar");
	public static String VENDEDOR_ACCION_ELIMINAR = properties.getString("vendedor.accion.eliminar");
	public static String VENDEDOR_ACCION_BUSCAR = properties.getString("vendedor.accion.buscar");
	
	public static String VENDEDOR_MSG_CONFIRMA_ELIMINAR = properties.getString("vendedor.msg.confirma_eliminar");
	

	/**
	 * operaciones
	 */
	public static String OPERACION = properties.getString("operacion");
	public static String OPERACION_FECHA = properties.getString("operacion.fecha");
	public static String OPERACION_FECHA_DESDE = properties.getString("operacion.fecha.desde");
	public static String OPERACION_FECHA_HASTA = properties.getString("operacion.fecha.hasta");
	public static String OPERACION_CODIGO = properties.getString("operacion.codigo");
	public static String OPERACION_MONTO = properties.getString("operacion.monto");
	public static String OPERACION_DESCRIPCION = properties.getString("operacion.descripcion");
	public static String OPERACION_MONTO_TOTAL = properties.getString("operacion.monto.total");
	public static String OPERACION_TODAS = properties.getString("operacion.todas");
	public static String OPERACION_CLIENTE = properties.getString("operacion.cliente");
	public static String OPERACION_VENDEDOR = properties.getString("operacion.vendedor");
	public static String OPERACION_OBSERVACIONES = properties.getString("operacion.observaciones");
	public static String OPERACION_DETALLES = properties.getString("operacion.detalles");

	public static String OPERACION_DETALLE_PRODUCTO = properties.getString("operacion.detalle.producto");
	public static String OPERACION_DETALLE_CANTIDAD = properties.getString("operacion.detalle.cantidad");
	public static String OPERACION_DETALLE_PRECIO_UNITARIO = properties.getString("operacion.detalle.precioUnitario");
	public static String OPERACION_DETALLE_SUBTOTAL = properties.getString("operacion.detalle.subtotal");
	public static String OPERACION_DETALLE_DESCUENTO = properties.getString("operacion.detalle.descuento");
	
	
	/**
	 * ventas
	 */
	public static String VENTAS = properties.getString("ventas");
	public static String VENTA_MONTO_PAGADO = properties.getString("venta.montoPagado");
	public static String VENTA_MONTO_DEBE = properties.getString("venta.montoDebe");
	
	public static String VENTA_ESTADO = properties.getString("venta.estado");
	//public static String VENTA_PAGADAS = properties.getString("venta.pagadas");
	//public static String VENTA_IMPAGAS = properties.getString("venta.impagas");
	
	public static String VENTA_FRAME_TITULO = properties.getString("venta.frame.titulo");
	public static String VENTA_FRAME_MENUADMIN = properties.getString("venta.frame.menuadmin");
	
	public static String VENTA_DIALOG_AGREGAR_TITULO = properties.getString("venta.dialog.agregar.titulo");
	public static String VENTA_DIALOG_MODIFICAR_TITULO = properties.getString("venta.dialog.modificar.titulo");
	public static String VENTA_DIALOG_BUSCAR_TITULO = properties.getString("venta.dialog.buscar.titulo");
	public static String VENTA_DIALOG_ELIMINAR_TITULO = properties.getString("venta.dialog.eliminar.titulo");
	public static String VENTA_DIALOG_VER_TITULO = properties.getString("venta.dialog.ver.titulo");
	public static String VENTA_DIALOG_FACTURAR_TITULO = properties.getString("venta.dialog.facturar.titulo");
	public static String VENTA_DIALOG_PAGAR_TITULO = properties.getString("venta.dialog.pagar.titulo");
	public static String VENTA_DIALOG_ANULAR_TITULO = properties.getString("venta.dialog.anular.titulo");
	
	public static String VENTA_ACCION_LISTAR = properties.getString("venta.accion.listar");
	public static String VENTA_ACCION_AGREGAR = properties.getString("venta.accion.agregar");
	public static String VENTA_ACCION_MODIFICAR = properties.getString("venta.accion.modificar");
	public static String VENTA_ACCION_ELIMINAR = properties.getString("venta.accion.eliminar");
	public static String VENTA_ACCION_ANULAR = properties.getString("venta.accion.anular");
	public static String VENTA_ACCION_BUSCAR = properties.getString("venta.accion.buscar");
	public static String VENTA_ACCION_VER = properties.getString("venta.accion.ver");
	public static String VENTA_ACCION_FACTURAR = properties.getString("venta.accion.facturar");
	public static String VENTA_ACCION_PAGAR = properties.getString("venta.accion.pagar");
	
	public static String VENTA_ACCION_AGREGAR_DETALLE = properties.getString("venta.accion.agregar.detalle");
	public static String VENTA_ACCION_ELIMINAR_DETALLE = properties.getString("venta.accion.eliminar.detalle");
	
	public static String VENTA_MSG_CONFIRMA_ELIMINAR = properties.getString("venta.msg.confirma_eliminar");
	
	public static String VENTA_AGREGAR_DETALLE_REQUERIDOS = properties.getString("venta.msg.agregar.detalle.requeridos");
	public static String VENTA_AGREGAR_DETALLE_DATOS_INVALIDOS = properties.getString("venta.msg.agregar.detalle.datos.invalidos");

//	public static String ESTADO_VENTA_PAGADA = properties.getString("estado.venta.pagada");
//	public static String ESTADO_VENTA_IMPAGA = properties.getString("estado.venta.impaga");
//	public static String ESTADO_VENTA_PAGO_PARCIAL = properties.getString("estado.venta.pagada_parcialmente");
//	public static String ESTADO_VENTA_ANULADA = properties.getString("estado.venta.anulada");
	
	/**
	 * cuentas bancarias
	 */
	public static String CUENTAS_BANCARIAS = properties.getString("cuentasBancarias");
	public static String CUENTA_BANCARIA_CODIGO = properties.getString("cuentaBancaria.codigo");
	public static String CUENTA_BANCARIA_BANCO = properties.getString("cuentaBancaria.nombre");
	public static String CUENTA_BANCARIA_SUCURSAL = properties.getString("cuentaBancaria.sucursal");
	public static String CUENTA_BANCARIA_CBU = properties.getString("cuentaBancaria.cbu");
	public static String CUENTA_BANCARIA_TITULAR = properties.getString("cuentaBancaria.titular");
	public static String CUENTA_BANCARIA_CUIT = properties.getString("cuentaBancaria.cuit");
	public static String CUENTA_BANCARIA_NRO_CUENTA = properties.getString("cuentaBancaria.nrocuenta");
	public static String CUENTA_BANCARIA_SALDO_INICIAL = properties.getString("cuentaBancaria.saldoInicial");
	public static String CUENTA_BANCARIA_SALDO = properties.getString("cuentaBancaria.saldo");
	
	public static String CUENTA_BANCARIA_FRAME_TITULO = properties.getString("cuentaBancaria.frame.titulo");
	public static String CUENTA_BANCARIA_FRAME_MENUADMIN = properties.getString("cuentaBancaria.frame.menuadmin");
	
	public static String CUENTA_BANCARIA_DIALOG_AGREGAR_TITULO = properties.getString("cuentaBancaria.dialog.agregar.titulo");
	public static String CUENTA_BANCARIA_DIALOG_MODIFICAR_TITULO = properties.getString("cuentaBancaria.dialog.modificar.titulo");
	public static String CUENTA_BANCARIA_DIALOG_BUSCAR_TITULO = properties.getString("cuentaBancaria.dialog.buscar.titulo");
	public static String CUENTA_BANCARIA_DIALOG_ELIMINAR_TITULO = properties.getString("cuentaBancaria.dialog.eliminar.titulo");
	
	public static String CUENTA_BANCARIA_ACCION_LISTAR = properties.getString("cuentaBancaria.accion.listar");
	public static String CUENTA_BANCARIA_ACCION_AGREGAR = properties.getString("cuentaBancaria.accion.agregar");
	public static String CUENTA_BANCARIA_ACCION_MODIFICAR = properties.getString("cuentaBancaria.accion.modificar");
	public static String CUENTA_BANCARIA_ACCION_ELIMINAR = properties.getString("cuentaBancaria.accion.eliminar");
	public static String CUENTA_BANCARIA_ACCION_BUSCAR = properties.getString("cuentaBancaria.accion.buscar");
	
	public static String CUENTA_BANCARIA_MSG_CONFIRMA_ELIMINAR = properties.getString("cuentaBancaria.msg.confirma_eliminar");

	/**
	 * sucursales
	 */		
	public static String SUCURSALES = properties.getString("sucursales");
	public static String SUCURSAL_CODIGO = properties.getString("sucursal.codigo");
	public static String SUCURSAL_NOMBRE = properties.getString("sucursal.nombre");
	public static String SUCURSAL_NUMERO = properties.getString("sucursal.numero");
	public static String SUCURSAL_TELEFENO = properties.getString("sucursal.telefono");
	public static String SUCURSAL_DOMICILIO = properties.getString("sucursal.domicilio");
	
	public static String SUCURSAL_FRAME_TITULO = properties.getString("sucursal.frame.titulo");
	public static String SUCURSAL_FRAME_MENUADMIN = properties.getString("sucursal.frame.menuadmin");
	
	public static String SUCURSAL_DIALOG_AGREGAR_TITULO = properties.getString("sucursal.dialog.agregar.titulo");
	public static String SUCURSAL_DIALOG_MODIFICAR_TITULO = properties.getString("sucursal.dialog.modificar.titulo");
	public static String SUCURSAL_DIALOG_BUSCAR_TITULO = properties.getString("sucursal.dialog.buscar.titulo");
	public static String SUCURSAL_DIALOG_ELIMINAR_TITULO = properties.getString("sucursal.dialog.eliminar.titulo");
	
	public static String SUCURSAL_ACCION_LISTAR = properties.getString("sucursal.accion.listar");
	public static String SUCURSAL_ACCION_AGREGAR = properties.getString("sucursal.accion.agregar");
	public static String SUCURSAL_ACCION_MODIFICAR = properties.getString("sucursal.accion.modificar");
	public static String SUCURSAL_ACCION_ELIMINAR = properties.getString("sucursal.accion.eliminar");
	public static String SUCURSAL_ACCION_BUSCAR = properties.getString("sucursal.accion.buscar");

	
	/**
	 * pagos
	 */
	public static String PAGOS = properties.getString("pagos");
	public static String PAGO_FECHA = properties.getString("pago.fecha");
	public static String PAGO_CODIGO = properties.getString("pago.codigo");
	public static String PAGO_MONTO = properties.getString("pago.monto");
	public static String PAGO_CLIENTE = properties.getString("pago.cliente");
	public static String PAGO_SUCURSAL = properties.getString("pago.sucursal");
	public static String PAGO_OBSERVACIONES = properties.getString("pago.observaciones");
	public static String PAGO_VENTA = properties.getString("pago.venta");
	public static String PAGO_VENTAS_IMPAGAS = properties.getString("pago.ventas.impagas");

	public static String PAGO_FRAME_TITULO = properties.getString("pago.frame.titulo");
	public static String PAGO_FRAME_MENUADMIN = properties.getString("pago.frame.menuadmin");
	
	public static String PAGO_DIALOG_AGREGAR_TITULO = properties.getString("pago.dialog.agregar.titulo");
	public static String PAGO_DIALOG_MODIFICAR_TITULO = properties.getString("pago.dialog.modificar.titulo");
	public static String PAGO_DIALOG_BUSCAR_TITULO = properties.getString("pago.dialog.buscar.titulo");
	public static String PAGO_DIALOG_ELIMINAR_TITULO = properties.getString("pago.dialog.eliminar.titulo");
	public static String PAGO_DIALOG_VER_TITULO = properties.getString("pago.dialog.ver.titulo");
	public static String PAGO_DIALOG_ANULAR_TITULO = properties.getString("pago.dialog.anular.titulo");
	
	public static String PAGO_ACCION_LISTAR = properties.getString("pago.accion.listar");
	public static String PAGO_ACCION_AGREGAR = properties.getString("pago.accion.agregar");
	public static String PAGO_ACCION_MODIFICAR = properties.getString("pago.accion.modificar");
	public static String PAGO_ACCION_ELIMINAR = properties.getString("pago.accion.eliminar");
	public static String PAGO_ACCION_BUSCAR = properties.getString("pago.accion.buscar");
	public static String PAGO_ACCION_VER = properties.getString("pago.accion.ver");
	public static String PAGO_ACCION_ANULAR = properties.getString("pago.accion.anular");
	
	public static String PAGO_MSG_CONFIRMA_ELIMINAR = properties.getString("pago.msg.confirma_eliminar");


	public static String DETALLEPAGO_MONTO = properties.getString("pago.detalle.monto");
	public static String DETALLEPAGO_OPERACION = properties.getString("pago.detalle.operacion");
	public static String DETALLEPAGO_VENTA = properties.getString("pago.detalle.venta");
	
	public static String DETALLE_FORMA_PAGO_MONTO = properties.getString("pago.detalleFormaPago.monto");
	public static String DETALLE_FORMA_PAGO_OBSERVACIONES = properties.getString("pago.detalleFormaPago.observaciones");
	public static String DETALLE_FORMA_PAGO_FORMAPAGO = properties.getString("pago.detalleFormaPago.formaPago");
	

	public static String CHEQUES = properties.getString("cheques");
	public static String CHEQUE_CODIGO = properties.getString("cheque.codigo");
	public static String CHEQUE_BANCO = properties.getString("cheque.banco");
	public static String CHEQUE_MONTO = properties.getString("cheque.monto");
	public static String CHEQUE_FECHA_VENCIMIENTO = properties.getString("cheque.fechaVencimiento");
	public static String CHEQUE_NUMERO = properties.getString("cheque.numero");
	public static String CHEQUE_OBSERVACIONES = properties.getString("cheque.observaciones");
	
	public static String TARJETA_TARJETA = properties.getString("tarjeta.tarjeta");
	public static String TARJETA_BANCO = properties.getString("tarjeta.banco");
	public static String TARJETA_NUMERO = properties.getString("tarjeta.numero");
	public static String TARJETA_TITULAR = properties.getString("tarjeta.titular");
	public static String TARJETA_FECHA_VENCIMIENTO = properties.getString("tarjeta.fechaVencimiento");
	
	public static String TRANSFERENCIA_NRO_COMPROBANTE = properties.getString("transferencia.nroComprobante");
	public static String TRANSFERENCIA_BANCO = properties.getString("transferencia.banco");
	public static String TRANSFERENCIA_TITULAR = properties.getString("transferencia.titular");
	public static String TRANSFERENCIA_CBU = properties.getString("transferencia.cbu");
	public static String TRANSFERENCIA_CUIT = properties.getString("transferencia.cuit");
	public static String TRANSFERENCIA_NRO_CUENTA = properties.getString("transferencia.nroCuenta");
	public static String TRANSFERENCIA_ORIGEN = properties.getString("transferencia.origen");
	public static String TRANSFERENCIA_DESINO = properties.getString("transferencia.destino");
	
	public static String DEPOSITO_NRO_COMPROBANTE = properties.getString("deposito.nroComprobante");
	public static String DEPOSITO_CUENTA_BANCARIA = properties.getString("deposito.cuentaBancaria");
	

	/**
	 * cheques
	 */
	public static String CHEQUE_FRAME_TITULO = properties.getString("cheque.frame.titulo");
	public static String CHEQUE_FRAME_MENUADMIN = properties.getString("cheque.frame.menuadmin");
	
	public static String CHEQUE_DIALOG_VER_TITULO = properties.getString("cheque.dialog.ver.titulo");
	public static String CHEQUE_ACCION_VER = properties.getString("cheque.accion.ver");
	public static String CHEQUE_ACCION_LISTAR = properties.getString("cheque.accion.listar");
	
	/**
	 * cajas
	 */		
	public static String CAJAS = properties.getString("cajas");
	public static String CAJA_CODIGO = properties.getString("caja.codigo");
	public static String CAJA_NUMERO = properties.getString("caja.numero");
	public static String CAJA_FECHA = properties.getString("caja.fecha");
	public static String CAJA_CAJERO = properties.getString("caja.cajero");
	public static String CAJA_SALDO = properties.getString("caja.saldo");
	public static String CAJA_SALDO_INICIAL = properties.getString("caja.saldoInicial");
	
	
	public static String CAJA_FRAME_TITULO = properties.getString("caja.frame.titulo");
	public static String CAJA_FRAME_MENUADMIN = properties.getString("caja.frame.menuadmin");
	
	public static String CAJA_DIALOG_AGREGAR_TITULO = properties.getString("caja.dialog.agregar.titulo");
	public static String CAJA_DIALOG_MODIFICAR_TITULO = properties.getString("caja.dialog.modificar.titulo");
	public static String CAJA_DIALOG_ELIMINAR_TITULO = properties.getString("caja.dialog.eliminar.titulo");
	public static String CAJA_DIALOG_BUSCAR_TITULO = properties.getString("caja.dialog.buscar.titulo");
	
	public static String CAJA_ACCION_LISTAR = properties.getString("caja.accion.listar");
	public static String CAJA_ACCION_AGREGAR = properties.getString("caja.accion.agregar");
	public static String CAJA_ACCION_MODIFICAR = properties.getString("caja.accion.modificar");
	public static String CAJA_ACCION_ELIMINAR = properties.getString("caja.accion.eliminar");
	public static String CAJA_ACCION_BUSCAR = properties.getString("caja.accion.buscar");
	
	/**
	 * conceptos de movimientos
	 */		
	public static String CONCEPTOS_MOVIMIENTO = properties.getString("conceptosMovimiento");
	public static String CONCEPTO_MOVIMIENTO_CODIGO = properties.getString("conceptoMovimiento.codigo");
	public static String CONCEPTO_MOVIMIENTO_NOMBRE = properties.getString("conceptoMovimiento.nombre");
	public static String CONCEPTO_MOVIMIENTO_DESCRIPCION = properties.getString("conceptoMovimiento.descripcion");
	
	public static String CONCEPTO_MOVIMIENTO_FRAME_TITULO = properties.getString("conceptoMovimiento.frame.titulo");
	public static String CONCEPTO_MOVIMIENTO_FRAME_MENUADMIN = properties.getString("conceptoMovimiento.frame.menuadmin");
	
	public static String CONCEPTO_MOVIMIENTO_DIALOG_AGREGAR_TITULO = properties.getString("conceptoMovimiento.dialog.agregar.titulo");
	public static String CONCEPTO_MOVIMIENTO_DIALOG_MODIFICAR_TITULO = properties.getString("conceptoMovimiento.dialog.modificar.titulo");
	public static String CONCEPTO_MOVIMIENTO_DIALOG_BUSCAR_TITULO = properties.getString("conceptoMovimiento.dialog.buscar.titulo");
	public static String CONCEPTO_MOVIMIENTO_DIALOG_ELIMINAR_TITULO = properties.getString("conceptoMovimiento.dialog.eliminar.titulo");
	
	public static String CONCEPTO_MOVIMIENTO_ACCION_LISTAR = properties.getString("conceptoMovimiento.accion.listar");
	public static String CONCEPTO_MOVIMIENTO_ACCION_AGREGAR = properties.getString("conceptoMovimiento.accion.agregar");
	public static String CONCEPTO_MOVIMIENTO_ACCION_MODIFICAR = properties.getString("conceptoMovimiento.accion.modificar");
	public static String CONCEPTO_MOVIMIENTO_ACCION_ELIMINAR = properties.getString("conceptoMovimiento.accion.eliminar");
	public static String CONCEPTO_MOVIMIENTO_ACCION_BUSCAR = properties.getString("conceptoMovimiento.accion.buscar");

	/**
	 * movimientos de caja
	 */		
	public static String MOVIMIENTOS_CAJA = properties.getString("movimientosCaja");
	public static String MOVIMIENTO_CAJA_CAJA = properties.getString("movimientoCaja.caja");
	
	public static String MOVIMIENTO_CAJA_FRAME_TITULO = properties.getString("movimientoCaja.frame.titulo");
	public static String MOVIMIENTO_CAJA_FRAME_MENUADMIN = properties.getString("movimientoCaja.frame.menuadmin");


	/**
	 * movimientos de cuentas bancarias
	 */		
	public static String MOVIMIENTOS_CUENTA_BANCARIA = properties.getString("movimientosCuentaBancaria");
	public static String MOVIMIENTO_CUENTA_BANCARIA_CUENTA = properties.getString("movimientoCuentaBancaria.cuentaBancaria");
	
	public static String MOVIMIENTO_CUENTA_BANCARIA_FRAME_TITULO = properties.getString("movimientoCuentaBancaria.frame.titulo");
	public static String MOVIMIENTO_CUENTA_BANCARIA_FRAME_MENUADMIN = properties.getString("movimientoCuentaBancaria.frame.menuadmin");

	/**
	 * movimientos de cheques
	 */		
	public static String MOVIMIENTOS_CHEQUE = properties.getString("movimientosCheque");
	public static String MOVIMIENTO_CHEQUE_CHEQUE = properties.getString("movimientoCheque.cheque");
	
	public static String MOVIMIENTO_CHEQUE_FRAME_TITULO = properties.getString("movimientoCheque.frame.titulo");
	public static String MOVIMIENTO_CHEQUE_FRAME_MENUADMIN = properties.getString("movimientoCheque.frame.menuadmin");
	

	/**
	 * movimientos de notas de crédito
	 */		
	public static String MOVIMIENTOS_NOTA_CREDITO = properties.getString("movimientosNotaCredito");
	public static String MOVIMIENTO_NOTA_CREDITO_NOTA_CREDITO = properties.getString("movimientoNotaCredito.notaCredito");
	
	public static String MOVIMIENTO_NOTA_CREDITO_FRAME_TITULO = properties.getString("movimientoNotaCredito.frame.titulo");
	public static String MOVIMIENTO_NOTA_CREDITO_FRAME_MENUADMIN = properties.getString("movimientoNotaCredito.frame.menuadmin");
		
	/**
	 * movimientos de cuenta
	 */		
	public static String MOVIMIENTO_CUENTA_CODIGO = properties.getString("movimientoCuenta.codigo");
	public static String MOVIMIENTO_CUENTA_CONCEPTO = properties.getString("movimientoCuenta.concepto");
	public static String MOVIMIENTO_CUENTA_FECHA_HORA = properties.getString("movimientoCuenta.fechaHora");
	public static String MOVIMIENTO_CUENTA_DEBE = properties.getString("movimientoCuenta.debe");
	public static String MOVIMIENTO_CUENTA_HABER = properties.getString("movimientoCuenta.haber");
	public static String MOVIMIENTO_CUENTA_SALDO = properties.getString("movimientoCuenta.saldo");
	

	/**
	 * balances
	 */		
	public static String BALANCE_DIARIO_DIALOG_VER_TITULO = properties.getString("balance.diario.dialog.ver.titulo");
	public static String BALANCE_DIARIO_ACCION_CONSULTAR = properties.getString("balance.diario.accion.consultar");


	/**
	 * notas de crédito
	 */
	public static String NOTAS_CREDITO = properties.getString("notasCredito");
	public static String NOTA_CREDITO_CODIGO = properties.getString("notaCredito.codigo");
	public static String NOTA_CREDITO_FECHA = properties.getString("notaCredito.fecha");
	public static String NOTA_CREDITO_MONTO = properties.getString("notaCredito.monto");
	public static String NOTA_CREDITO_FECHA_VENCIMIENTO = properties.getString("notaCredito.fechaVencimiento");
	public static String NOTA_CREDITO_NUMERO = properties.getString("notaCredito.numero");
	public static String NOTA_CREDITO_OBSERVACIONES = properties.getString("notaCredito.observaciones");
	public static String NOTA_CREDITO_CLIENTE = properties.getString("notaCredito.cliente");
	public static String NOTA_CREDITO_SUCURSAL = properties.getString("notaCredito.sucursal");
	public static String NOTA_CREDITO_VENDEDOR = properties.getString("notaCredito.vendedor");
	
	public static String NOTA_CREDITO_FRAME_TITULO = properties.getString("notaCredito.frame.titulo");
	public static String NOTA_CREDITO_FRAME_MENUADMIN = properties.getString("notaCredito.frame.menuadmin");
	
	public static String NOTA_CREDITO_DIALOG_VER_TITULO = properties.getString("notaCredito.dialog.ver.titulo");
	public static String NOTA_CREDITO_ACCION_VER = properties.getString("notaCredito.accion.ver");
	public static String NOTA_CREDITO_ACCION_LISTAR = properties.getString("notaCredito.accion.listar");

}