package com.migestion.ui.swing.finder;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.migestion.model.Caja;
import com.migestion.model.CategoriaProducto;
import com.migestion.model.Cheque;
import com.migestion.model.Cliente;
import com.migestion.model.CuentaBancaria;
import com.migestion.model.GenericEntity;
import com.migestion.model.OrdenCompra;
import com.migestion.model.Producto;
import com.migestion.model.Proveedor;
import com.migestion.model.Vendedor;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.IFinderObjectByCode;
import com.migestion.swing.custom.IObjectFoundInspector;
import com.migestion.swing.custom.JFindObjectPanel;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cajas.factories.WindowCajaFactory;
import com.migestion.ui.swing.categoriasProducto.factories.WindowCategoriaProductoFactory;
import com.migestion.ui.swing.cheques.factories.WindowChequeFactory;
import com.migestion.ui.swing.clientes.factories.WindowClienteFactory;
import com.migestion.ui.swing.cuentasBancarias.factories.WindowCuentaBancariaFactory;
import com.migestion.ui.swing.operaciones.ordenesCompra.factories.WindowOrdenCompraFactory;
import com.migestion.ui.swing.operaciones.ventas.factories.WindowVentaFactory;
import com.migestion.ui.swing.productos.factories.WindowProductoFactory;
import com.migestion.ui.swing.proveedores.factories.WindowProveedorFactory;
import com.migestion.ui.swing.vendedores.factories.WindowVendedorFactory;

/**
 * Factory para construir los findobjects. 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class FinderFactory {

	/**
	 * construye un findobject panel para buscar categoria de producto.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindCategoriaProducto(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	CategoriaProducto cp = new CategoriaProducto();
                	cp.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUICategoriaProductoService().getObject(cp);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        //findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowCategoriaProductoFactory.getWindowFindTree());
        findobject.setListener( listener );
        findobject.repaint();
        return findobject;
	}
	
	/**
	 * construye un findobject panel para buscar un producto.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindProducto(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Producto cp = new Producto();
                	cp.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIProductoService().getObject(cp);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowProductoFactory.getWindowFind());
        findobject.setListener( listener );
        findobject.repaint();
        return findobject;
	}
	
	/**
	 * construye un findobject panel para buscar un cliente.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindCliente(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Cliente cp = new Cliente();
                	cp.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIClienteService().getObject(cp);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowClienteFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}
	
	/**
	 * construye un findobject panel para buscar un vendedor.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindVendedor(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Vendedor cp = new Vendedor();
                	cp.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIVendedorService().getObject(cp);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowVendedorFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}		
	
	
	/**
	 * construye un findobject panel para buscar una venta.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindVenta(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Caja caja = new Caja();
                	caja.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIVentaService().getObject(caja);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowVentaFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}
	
	
	/**
	 * construye un findobject panel para buscar una caja.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindCaja(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Caja caja = new Caja();
                	caja.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUICajaService().getObject(caja);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowCajaFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}
	
	/**
	 * construye un findobject panel para buscar un cheque.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindCheque(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Cheque cheque = new Cheque();
                	cheque.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIChequeService().getObject(cheque);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
            	if( ((GenericEntity)object).getOid() != null )
            		return ((GenericEntity)object).getOid() + "";
            	else
            		return "-";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowChequeFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}	
	
	/**
	 * construye un findobject panel para buscar una cuenta bancaria.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindCuentaBancaria(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	CuentaBancaria cuentaBancaria = new CuentaBancaria();
                	cuentaBancaria.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUICuentaBancariaService().getObject(cuentaBancaria);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowCuentaBancariaFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}
	
	/**
	 * construye un findobject panel para buscar un proveedor.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindProveedor(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	Proveedor proveedor= new Proveedor();
                	proveedor.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIProveedorService().getObject(proveedor);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowProveedorFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}
	
	/**
	 * construye un findobject panel para buscar una orden de compra.
	 * @param listener listener para cuando se encuentra el objecto
	 * @return
	 */
	public static JFindObjectPanel getFindOrdenCompra(LinkFindObjectListener listener){

		JFindObjectPanel findobject = new JFindObjectPanel();
		
		findobject.setCodeWidth(50);
		findobject.setFinderByCode(new IFinderObjectByCode() {
            public Object getObject(String code) {
                Object result = null;
                try {
                	OrdenCompra ordenCompra= new OrdenCompra();
                	ordenCompra.setOid(Long.valueOf(code));
                	result = UIServiceFactory.getUIOrdenCompraService().getObject(ordenCompra);

                } catch (ControllerException ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }catch (Exception ex) {
                    Logger.getLogger(FinderFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
                return result;
            }
        });
        
        findobject.setInspector(new IObjectFoundInspector() {

            public String getCode(Object object) {
                return ((GenericEntity)object).getOid() + "";
            }

            public String getDescription(Object object) {
            	if(object!=null)
                return object.toString();
            	else return "";
            }
        });
        
        findobject.setTextWidth(200);
        findobject.setWindowFindObject(WindowOrdenCompraFactory.getWindowFind());
        findobject.setListener( listener );

        return findobject;
	}
}