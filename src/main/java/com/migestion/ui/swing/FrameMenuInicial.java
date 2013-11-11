package com.migestion.ui.swing;


import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

import com.migestion.swing.factories.MenuFactory;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkSystemExit;
import com.migestion.swing.view.dialogs.ProgressDialog;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.swing.balances.factories.LinkBalanceFactory;
import com.migestion.ui.swing.cajas.movimientos.factories.LinkMovimientoCajaFactory;
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.cheques.factories.LinkChequeFactory;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.cuentasBancarias.factories.LinkCuentaBancariaFactory;
import com.migestion.ui.swing.cuentasBancarias.movimientos.factories.LinkMovimientoCuentaBancariaFactory;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.notasCredito.factories.LinkNotaCreditoFactory;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
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
	
	private JMenu menuVentas;

	public FrameMenuInicial() {
		super( I18nMessages.TITULO_MAIN );
		inicializar();
	}

	
	private void inicializar() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AppContext.getInstance().setMainContainer(this);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					UIManager.setLookAndFeel(UIManager
//							.getSystemLookAndFeelClassName());
//				} catch (Exception ex) {
//				}

				SwingWorker worker = new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						int index = 0;
						int cantidad = 17;
						int incrementar = 100 / cantidad;
						
						setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());
						toogleTaskPane();
						setSize(850, 700);
						setExtendedState(JFrame.MAXIMIZED_BOTH);

						menuBar = new JMenuBar();
						setJMenuBar(menuBar);
						
						menuAdmin = new JMenu("Administración");
						menuBar.add(menuAdmin);
						
						menuVentas = new JMenu("Ventas");
						menuBar.add(menuVentas);
						index += incrementar;
						setProgress(index);
						
						PanelMenuToolbar toolbar = new PanelMenuToolbar();
						replaceToolbar(toolbar);
						
						index += incrementar;
						setProgress(index);
						
						// link balance diario.
						Link linkBalanceDiario = LinkBalanceFactory
								.getLinkBalanceDiario();
						index += incrementar;
						setProgress(index);

						// link productos.
						LinkListCollection linkProductos = LinkProductoFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link categorías de producto.
						LinkListCollection linkCategoriasProducto = LinkCategoriaProductoFactory
								.getLinkListTree();
						index += incrementar;
						setProgress(index);

						// link clientes.
						LinkListCollection linkClientes = LinkClienteFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link vendedores.
						LinkListCollection linkVendedores = LinkVendedorFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link ventas.
						LinkListCollection linkVentas = LinkVentaFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link pagos.
						LinkListCollection linkPagos = LinkPagoFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link movimientos de caja.
						LinkListCollection linkMovimientosCaja = LinkMovimientoCajaFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link cheques.
						LinkListCollection linkCheques = LinkChequeFactory.getLinkList();
						index += incrementar;
						setProgress(index);

						// link notas de crédito.
						LinkListCollection linkNotasCredito = LinkNotaCreditoFactory.getLinkList();
						index += incrementar;
						setProgress(index);
						
						// link cuentas bancarias.
						LinkListCollection linkCuentasBancarias = LinkCuentaBancariaFactory.getLinkList();
						index += incrementar;
						setProgress(index);

						// link movimientos de cuentas bancarias.
						LinkListCollection linkMovimientosCuentaBancaria = LinkMovimientoCuentaBancariaFactory
								.getLinkList();
						index += incrementar;
						setProgress(index);

						// link exit.
						Link linkExit = new LinkSystemExit();
						linkExit.setKeyStroke(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_DOWN_MASK));
						index += incrementar;
						setProgress(index);
						
						menuAdmin.add(MenuFactory.getJMenuItem(linkProductos));
						menuAdmin.add(MenuFactory.getJMenuItem(linkCategoriasProducto));
						menuAdmin.add(MenuFactory.getJMenuItem(linkClientes));
						menuAdmin.add(MenuFactory.getJMenuItem(linkVendedores));
						menuAdmin.addSeparator();
						menuAdmin.add(MenuFactory.getJMenuItem(linkExit));
						index += incrementar;
						setProgress(index);
						
						menuVentas.add(MenuFactory.getJMenuItem(linkVentas));
						menuVentas.add(MenuFactory.getJMenuItem(linkPagos));
						menuVentas.add(MenuFactory.getJMenuItem(linkCheques));
						menuVentas.add(MenuFactory.getJMenuItem(linkCuentasBancarias));
						menuVentas.add(MenuFactory.getJMenuItem(linkNotasCredito));
						menuVentas.add(MenuFactory.getJMenuItem(linkMovimientosCaja));
						menuVentas.add(MenuFactory.getJMenuItem(linkMovimientosCuentaBancaria));
						menuVentas.add(MenuFactory.getJMenuItem(linkBalanceDiario));
						index += incrementar;
						setProgress(index);
						

						setProgress(100);

						pack();
						return null;
					}

				};

				ProgressDialog
						.showProgress(null, worker, I18nMessages.TITULO_MAIN,
								"Inicializando las ventanas...",
								"Espere unos segundos");

				// System.exit(0);

			}

		});

	}
}
