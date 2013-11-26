package com.migestion.ui.swing;


import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import com.migestion.swing.factories.MenuFactory;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkSystemExit;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.swing.balances.factories.LinkBalanceFactory;
import com.migestion.ui.swing.cajas.factories.LinkCajaFactory;
import com.migestion.ui.swing.cajas.movimientos.factories.LinkMovimientoCajaFactory;
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.cheques.factories.LinkChequeFactory;
import com.migestion.ui.swing.cheques.movimientos.factories.LinkMovimientoChequeFactory;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.clientes.movimientos.factories.LinkMovimientoCuentaClienteFactory;
import com.migestion.ui.swing.cuentasBancarias.factories.LinkCuentaBancariaFactory;
import com.migestion.ui.swing.cuentasBancarias.movimientos.factories.LinkMovimientoCuentaBancariaFactory;
import com.migestion.ui.swing.gastos.factories.LinkGastoFactory;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.notasCredito.factories.LinkNotaCreditoFactory;
import com.migestion.ui.swing.notasCredito.movimientos.factories.LinkMovimientoNotaCreditoFactory;
import com.migestion.ui.swing.operaciones.ordenesCompra.factories.LinkOrdenCompraFactory;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
import com.migestion.ui.swing.proveedores.factories.LinkProveedorFactory;
import com.migestion.ui.swing.proveedores.movimientos.factories.LinkMovimientoCuentaProveedorFactory;
import com.migestion.ui.swing.vendedores.factories.LinkVendedorFactory;

/**
 * Frame principal de la app
 *  
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 * 
 */

public class FrameMenuInicial extends JFrameContainer {

	// men�
	protected JMenuBar menuBar;
	
	private JMenu menuAdmin;

	private JMenu menuInventario;
	
	private JMenu menuEmpresa;

	private JMenu menuMovimientos;

	private JMenu menuContable;

	private JMenu menuVentas;

	public FrameMenuInicial() {
		super( I18nMessages.TITULO_MAIN );
		inicializar();
	}

	
	private void inicializar() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AppContext.getInstance().setMainContainer(this);
		
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
////				try {
////					UIManager.setLookAndFeel(UIManager
////							.getSystemLookAndFeelClassName());
////				} catch (Exception ex) {
////				}
//
//				SwingWorker worker = new SwingWorker() {
//					@Override
//					protected Object doInBackground() throws Exception {
//						int index = 0;
//						int cantidad = 22;
//						int incrementar = 100 / cantidad;
//						
//						setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());
//						toogleTaskPane();
//						setSize(850, 700);
//						setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//						menuBar = new JMenuBar();
//						setJMenuBar(menuBar);
//						menuBar.setForeground( Color.WHITE );
//						menuAdmin = new JMenu("Administración");
//						menuBar.add(menuAdmin);
//						
//						menuInventario = new JMenu("Inventario");
//						menuBar.add(menuInventario);
//						
//						menuEmpresa = new JMenu("Empresa");
//						menuBar.add(menuEmpresa);
//
//						menuVentas = new JMenu("Ventas");
//						menuBar.add(menuVentas);
//						
//						menuContable = new JMenu("Contable");
//						menuBar.add(menuContable);
//
//						menuMovimientos = new JMenu("Movimientos");
//						menuBar.add(menuMovimientos);
//						
//						index += incrementar;
//						setProgress(index);
//						
//						PanelMenuToolbar toolbar = new PanelMenuToolbar();
//						replaceToolbar(toolbar);
//						
//						index += incrementar;
//						setProgress(index);
//						
//						// link balance diario.
//						Link linkBalanceDiario = LinkBalanceFactory
//								.getLinkBalanceDiario();
//						index += incrementar;
//						setProgress(index);
//
//						// link productos.
//						LinkListCollection linkProductos = LinkProductoFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link categorías de producto.
//						LinkListCollection linkCategoriasProducto = LinkCategoriaProductoFactory
//								.getLinkListTree();
//						index += incrementar;
//						setProgress(index);
//
//						// link clientes.
//						LinkListCollection linkClientes = LinkClienteFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link proveedores.
//						LinkListCollection linkProveedores = LinkProveedorFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link vendedores.
//						LinkListCollection linkVendedores = LinkVendedorFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link ventas.
//						LinkListCollection linkVentas = LinkVentaFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link pagos.
//						LinkListCollection linkPagos = LinkPagoFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link movimientos de caja.
//						LinkListCollection linkMovimientosCaja = LinkMovimientoCajaFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link cheques.
//						LinkListCollection linkCheques = LinkChequeFactory.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link notas de crédito.
//						LinkListCollection linkNotasCredito = LinkNotaCreditoFactory.getLinkList();
//						index += incrementar;
//						setProgress(index);
//						
//						// link cuentas bancarias.
//						LinkListCollection linkCuentasBancarias = LinkCuentaBancariaFactory.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link movimientos de cuentas bancarias.
//						LinkListCollection linkMovimientosCuentaBancaria = LinkMovimientoCuentaBancariaFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link movimientos de cheques.
//						LinkListCollection linkMovimientosCheque = LinkMovimientoChequeFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//
//						// link movimientos de notas de crédito.
//						LinkListCollection linkMovimientosNotaCredito = LinkMovimientoNotaCreditoFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//						
//						// link gastos
//						LinkListCollection linkGastos = LinkGastoFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//						
//						// link cajas
//						LinkListCollection linkCajas = LinkCajaFactory
//								.getLinkList();
//						index += incrementar;
//						setProgress(index);
//						
//						// link exit.
//						Link linkExit = new LinkSystemExit();
//						linkExit.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
//						index += incrementar;
//						setProgress(index);
//						
//						
//						menuInventario.add(MenuFactory.getJMenuItem(linkProductos));
//						menuInventario.add(MenuFactory.getJMenuItem(linkCategoriasProducto));
//						menuInventario.addSeparator();
//						menuInventario.add(MenuFactory.getJMenuItem(linkProveedores));
//						
//						menuEmpresa.add(MenuFactory.getJMenuItem(linkVendedores));
//						//TODO menuEmpresa.add(MenuFactory.getJMenuItem(linkSucursales));
//						menuEmpresa.addSeparator();
//						menuEmpresa.add(MenuFactory.getJMenuItem(linkCuentasBancarias));
//						menuEmpresa.addSeparator();
//						menuEmpresa.add(MenuFactory.getJMenuItem(linkClientes));
//						
//						menuAdmin.addSeparator();
//						menuAdmin.add(MenuFactory.getJMenuItem(linkExit));
//						
//						index += incrementar;
//						setProgress(index);
//						
//						menuVentas.add(MenuFactory.getJMenuItem(linkVentas));
//						menuVentas.add(MenuFactory.getJMenuItem(linkPagos));
//						
//						menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCaja));
//						menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCuentaBancaria));
//						menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCheque));
//						menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosNotaCredito));
//						menuMovimientos.addSeparator();
//						menuMovimientos.add(MenuFactory.getJMenuItem(linkBalanceDiario));
//						
//						menuContable.add(MenuFactory.getJMenuItem(linkCajas));
//						menuContable.addSeparator();
//						menuContable.add(MenuFactory.getJMenuItem(linkGastos));
//						menuContable.addSeparator();
//						menuContable.add(MenuFactory.getJMenuItem(linkNotasCredito));
//						menuContable.add(MenuFactory.getJMenuItem(linkCheques));
//						
//						index += incrementar;
//						setProgress(index);
//						
//
//						setProgress(100);
//
//						pack();
//						return null;
//					}
//
//				};
//
//				ProgressDialog
//						.showProgress(null, worker, I18nMessages.TITULO_MAIN,
//								"Inicializando las ventanas...",
//								"Espere unos segundos", new ImageIcon(I18nImages.LOGO_ICON).getImage());
//
//				// System.exit(0);
//
//			}
//
//		});
//

		
		setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());
		toogleTaskPane();
		setSize(850, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//		
//		
//		menuAdmin = new JMenu("Administración");
//		menuBar.add(menuAdmin);
//		Link linkExit = new LinkSystemExit();
//		linkExit.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
//		menuAdmin.add(MenuFactory.getJMenuItem(linkExit));		
//		
//		// link productos.
//		LinkListCollection linkProductos = LinkProductoFactory
//				.getLinkList();
//		menuAdmin.add(MenuFactory.getJMenuItem(linkProductos));
//		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setForeground( Color.WHITE );
		menuAdmin = new JMenu("Administración");
		menuBar.add(menuAdmin);
		
		menuInventario = new JMenu("Inventario");
		menuBar.add(menuInventario);
		
		menuEmpresa = new JMenu("Empresa");
		menuBar.add(menuEmpresa);

		menuVentas = new JMenu("Ventas");
		menuBar.add(menuVentas);
		
		menuContable = new JMenu("Contable");
		menuBar.add(menuContable);

		menuMovimientos = new JMenu("Movimientos");
		//menuBar.add(menuMovimientos);
		
		
		PanelMenuToolbar toolbar = new PanelMenuToolbar();
		replaceToolbar(toolbar);
		
		
		// link balance diario.
		Link linkBalanceDiario = LinkBalanceFactory
				.getLinkBalanceDiario();

		// link productos.
		LinkListCollection linkProductos = LinkProductoFactory
				.getLinkList();

		// link categorías de producto.
		LinkListCollection linkCategoriasProducto = LinkCategoriaProductoFactory
				.getLinkListTree();

		// link clientes.
		LinkListCollection linkClientes = LinkClienteFactory
				.getLinkList();

		// link proveedores.
		LinkListCollection linkProveedores = LinkProveedorFactory
				.getLinkList();

		// link vendedores.
		LinkListCollection linkVendedores = LinkVendedorFactory
				.getLinkList();

		// link ventas.
		LinkListCollection linkVentas = LinkVentaFactory
				.getLinkList();

		// link pagos de clientes.
		LinkListCollection linkPagosCliente = LinkPagoFactory
				.getLinkPagosCliente();

		// link pagos a proveedores.
		LinkListCollection linkPagosProveedor = LinkPagoFactory
				.getLinkPagosProveedor();

		// link órdenes de compra.
		LinkListCollection linkOrdenesCompra = LinkOrdenCompraFactory
				.getLinkList();

		// link movimientos de caja.
		LinkListCollection linkMovimientosCaja = LinkMovimientoCajaFactory
				.getLinkList();

		// link cheques.
		LinkListCollection linkCheques = LinkChequeFactory.getLinkList();

		// link notas de crédito.
		LinkListCollection linkNotasCredito = LinkNotaCreditoFactory.getLinkList();
		
		// link cuentas bancarias.
		LinkListCollection linkCuentasBancarias = LinkCuentaBancariaFactory.getLinkList();

		// link movimientos de cuentas bancarias.
		LinkListCollection linkMovimientosCuentaBancaria = LinkMovimientoCuentaBancariaFactory
				.getLinkList();

		// link movimientos de cheques.
		LinkListCollection linkMovimientosCheque = LinkMovimientoChequeFactory
				.getLinkList();

		// link movimientos de notas de crédito.
		LinkListCollection linkMovimientosNotaCredito = LinkMovimientoNotaCreditoFactory
				.getLinkList();


		// link movimientos de clientes
		LinkListCollection linkMovimientosCliente = LinkMovimientoCuentaClienteFactory
				.getLinkList();
		
		// link movimientos de proveedores.
		LinkListCollection linkMovimientosProveedor = LinkMovimientoCuentaProveedorFactory
				.getLinkList();

//		// link gastos
		LinkListCollection linkGastos = LinkGastoFactory
				.getLinkList();
//		index += incrementar;
//		setProgress(index);
		
		// link cajas
		LinkListCollection linkCajas = LinkCajaFactory
				.getLinkList();
//		index += incrementar;
//		setProgress(index);
		
		// link exit.
		Link linkExit = new LinkSystemExit();
		linkExit.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
////		index += incrementar;
////		setProgress(index);
		
		
		menuInventario.add(MenuFactory.getJMenuItem(linkProductos));
		menuInventario.add(MenuFactory.getJMenuItem(linkCategoriasProducto));
		menuInventario.addSeparator();
		menuInventario.add(MenuFactory.getJMenuItem(linkProveedores));
		menuInventario.add(MenuFactory.getJMenuItem(linkOrdenesCompra));
		menuInventario.add(MenuFactory.getJMenuItem(linkPagosProveedor));
		
		menuEmpresa.add(MenuFactory.getJMenuItem(linkVendedores));
		//TODO menuEmpresa.add(MenuFactory.getJMenuItem(linkSucursales));
		menuEmpresa.addSeparator();
		menuEmpresa.add(MenuFactory.getJMenuItem(linkCuentasBancarias));
		menuEmpresa.addSeparator();
		menuEmpresa.add(MenuFactory.getJMenuItem(linkClientes));
		
		menuAdmin.addSeparator();
		menuAdmin.add(MenuFactory.getJMenuItem(linkExit));
//		
////		index += incrementar;
////		setProgress(index);
////		
		menuVentas.add(MenuFactory.getJMenuItem(linkVentas));
		menuVentas.add(MenuFactory.getJMenuItem(linkPagosCliente));
		menuVentas.addSeparator();
		
		menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCaja));
		menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCuentaBancaria));
		menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCheque));
		menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosNotaCredito));
		menuMovimientos.addSeparator();
		menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosCliente));
		menuMovimientos.add(MenuFactory.getJMenuItem(linkMovimientosProveedor));
		menuMovimientos.addSeparator();
		menuMovimientos.add(MenuFactory.getJMenuItem(linkBalanceDiario));
		
		menuContable.add(MenuFactory.getJMenuItem(linkCajas));
		menuContable.addSeparator();
		menuContable.add(MenuFactory.getJMenuItem(linkGastos));
		menuContable.addSeparator();
		menuContable.add(MenuFactory.getJMenuItem(linkNotasCredito));
		menuContable.add(MenuFactory.getJMenuItem(linkCheques));
		menuContable.addSeparator();
		menuContable.add( menuMovimientos );
		
////		index += incrementar;
////		setProgress(index);
////		
////
////		setProgress(100);
		
		
	}
}
