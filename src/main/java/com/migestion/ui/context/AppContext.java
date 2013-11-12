package com.migestion.ui.context;


import java.awt.Component;

import com.migestion.model.Caja;
import com.migestion.model.CategoriaProducto;
import com.migestion.model.Cliente;
import com.migestion.model.ConceptoMovimiento;
import com.migestion.model.CuentaBancaria;
import com.migestion.model.Gasto;
import com.migestion.model.Sucursal;
import com.migestion.model.Vendedor;
import com.migestion.swing.context.ContextObserver;
import com.migestion.swing.navigation.interfaces.ILinkWindowList;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.context.observers.PagoObserver;
import com.migestion.ui.context.observers.ProductoObserver;
import com.migestion.ui.context.observers.VentaObserver;

/**
 * En el contexto se guardará información
 * de utilidad para el usuario así como también
 * búsquedas realizadas por el mismo.
 * 
 * Además, es el responsable de alertar cambios
 * del contexto.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 *
 */
public class AppContext {

	
	public CategoriaProducto getCategoriaProductoDefault() {
		return categoriaProductoDefault;
	}

	public void setCategoriaProductoDefault(
			CategoriaProducto categoriaProductoDefault) {
		this.categoriaProductoDefault = categoriaProductoDefault;
	}

	//singleton.
	private static AppContext instance;

	/**
	 * observer para ventas.
	 */
	private VentaObserver ventaObserver;

	private PagoObserver pagoObserver;
	
	private ProductoObserver productoObserver;
	
	private ContextObserver<CuentaBancaria> cuentaBancariaObserver;
	
	private ContextObserver<CategoriaProducto> categoriaProductoObserver;
	
	private ContextObserver<Gasto> gastoObserver;
	
	
	
//	/**
//	 * observer para cliente.
//	 */
//	private ContextObserver<ICliente> clienteObserver;
//
//	/**
//	 * usuario logueado.
//	 */
//	private IUsuario usuario;
	

	/**
	 * contenedor principal de ventanas.
	 */
	private JFrameContainer mainContainer;
	
	private Cliente clienteDefault;
	
	private CategoriaProducto categoriaProductoDefault;

	private ConceptoMovimiento conceptoVenta;
	
	/**
	 * vendedor, sucursal y caja deberíamos
	 * setearlo en una pantalla inicial (login)
	 */
	private Vendedor vendedorDefault;

	private Sucursal sucursalDefault;

	private Caja cajaDefault;

	private AppContext(){
		//inicializamos los listeners
		ventaObserver = new VentaObserver();
		pagoObserver = new PagoObserver();
		productoObserver = new ProductoObserver();
		cuentaBancariaObserver = new ContextObserver<CuentaBancaria>();
		categoriaProductoObserver = new ContextObserver<CategoriaProducto>();
		gastoObserver = new ContextObserver<Gasto>();
		
//		clienteObserver = new ContextObserver<ICliente>();
//		usuario = null;

//		try {
//			//caja default
//			Caja caja = new Caja();
//			caja.setOid(1L);
//			setCajaDefault( (Caja) UIServiceFactory.getUICajaService().getObject(caja));
//		} catch (ControllerException e) {
//			e.printStackTrace();
//		}

		
	}
	
	public ProductoObserver getProductoObserver() {
		return productoObserver;
	}

	public PagoObserver getPagoObserver() {
		return pagoObserver;
	}

	public static AppContext getInstance(){
		if(instance==null)
			instance = new AppContext();
		return instance;
	}

//	public void login( IUsuario usuario){
//		this.usuario = usuario;
//		
//	}
//	
//	public void initSecurityContext(){
//		if( usuario != null ){
//			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario.getUsername(),usuario.getPassword());
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//		}
//	}
//	


	/**
	 * @return the mainContainer
	 */
	public JFrameContainer getMainContainer() {
		return mainContainer;
	}

	/**
	 * @param mainContainer the mainContainer to set
	 */
	public void setMainContainer(JFrameContainer mainContainer) {
		this.mainContainer = mainContainer;
	}

	public void addToContainer(Component component) {
		getMainContainer().addToDesktop(component);
	}
	
	public void addToContainer(ILinkWindowList dialog) {
		dialog.addToJFrameContainer(getMainContainer());
	}

	/**
	 * @return the clienteDefault
	 */
	public Cliente getClienteDefault() {
		return clienteDefault;
	}

	/**
	 * @param clienteDefault the clienteDefault to set
	 */
	public void setClienteDefault(Cliente clienteDefault) {
		this.clienteDefault = clienteDefault;
	}

	/**
	 * @return the vendedorDefault
	 */
	public Vendedor getVendedorDefault() {
		return vendedorDefault;
	}

	/**
	 * @param vendedorDefault the vendedorDefault to set
	 */
	public void setVendedorDefault(Vendedor vendedorDefault) {
		this.vendedorDefault = vendedorDefault;
	}

	/**
	 * @return the sucursalDefault
	 */
	public Sucursal getSucursalDefault() {
		return sucursalDefault;
	}

	/**
	 * @param sucursalDefault the sucursalDefault to set
	 */
	public void setSucursalDefault(Sucursal sucursalDefault) {
		this.sucursalDefault = sucursalDefault;
	}

	/**
	 * @return the cajaDefault
	 */
	public Caja getCajaDefault() {
		return cajaDefault;
	}

	/**
	 * @param cajaDefault the cajaDefault to set
	 */
	public void setCajaDefault(Caja cajaDefault) {
		this.cajaDefault = cajaDefault;
	}

	/**
	 * @return the conceptoVenta
	 */
	public ConceptoMovimiento getConceptoVenta() {
		return conceptoVenta;
	}

	/**
	 * @param conceptoVenta the conceptoVenta to set
	 */
	public void setConceptoVenta(ConceptoMovimiento conceptoVenta) {
		this.conceptoVenta = conceptoVenta;
	}

	public VentaObserver getVentaObserver() {
		return ventaObserver;
	}

	public ContextObserver<CuentaBancaria> getCuentaBancariaObserver() {
		return cuentaBancariaObserver;
	}

	public ContextObserver<CategoriaProducto> getCategoriaProductoObserver() {
		return categoriaProductoObserver;
	}

	public ContextObserver<Gasto> getGastoObserver() {
		return gastoObserver;
	}



}
