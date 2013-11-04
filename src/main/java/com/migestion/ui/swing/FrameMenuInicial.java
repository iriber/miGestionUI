package com.migestion.ui.swing;


import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jdesktop.swingx.JXTaskPane;

import com.migestion.model.Caja;
import com.migestion.model.Vendedor;
import com.migestion.swing.custom.JFindObjectPanel;
import com.migestion.swing.factories.MenuFactory;
import com.migestion.swing.i18n.buttons.ButtonImagesBundle;
import com.migestion.swing.i18n.buttons.ButtonLabelsBundle;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkSystemExit;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.view.frames.JFrameContainer;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.swing.cajas.movimientos.factories.LinkMovimientoCajaFactory;
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.finder.FinderFactory;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
import com.migestion.ui.swing.skin.SkinDecorator;
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
	
	

	public FrameMenuInicial() {
		super( I18nMessages.TITULO_MAIN );
		inicializar();
	}

	private void inicializar() {

		AppContext.getInstance().setMainContainer(this);

		// link productos.
		LinkListCollection linkProductos = LinkProductoFactory.getLinkList();
		
		
		// link categorías de producto.
		LinkListCollection linkCategoriasProducto = LinkCategoriaProductoFactory.getLinkList();
		
		
		// link clientes.
		LinkListCollection linkClientes = LinkClienteFactory.getLinkList();
		
		// link vendedores.
		LinkListCollection linkVendedores = LinkVendedorFactory.getLinkList();

		// link ventas.
		LinkListCollection linkVentas = LinkVentaFactory.getLinkList();

		// link pagos.
		LinkListCollection linkPagos = LinkPagoFactory.getLinkList();

		// link movimientos de caja.
		LinkListCollection linkMovimientosCaja = LinkMovimientoCajaFactory.getLinkList();

		// link exit.
		Link linkExit = new LinkSystemExit();

		
		setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());

//		// vamos a crear una barra de men�.
//		JMenuBar menuBar = new JMenuBar();
//
//		JMenu menuCuentas = new JMenu("Ingresos/Egresos");
//		
//		JMenu menuAdministracion = new JMenu("Administración");
//		menuAdministracion.add(linkClientes);
//		menuAdministracion.add(((CRUDFrame) linkClientes.getDialog()).getLinkAdd());
//		menuAdministracion.addSeparator();
//		menuAdministracion.add(linkProductos);
//		//menuAdministracion.add(((CRUDFrame) linkProductos.getDialog()).getLinkAdd());
//		menuAdministracion.addSeparator();		
//
//		JMenu menuVentas = new JMenu("Ventas/Pagos");
//		menuVentas.add(linkVentas);
//		//menuVentas.add(((CRUDFrame) linkVentas.getDialog()).getLinkAdd());
//		menuVentas.addSeparator();
//		menuVentas.addSeparator();
//		menuVentas.add(linkPagos);
//		//menuVentas.add(((CRUDFrame) linkPagos.getDialog()).getLinkAdd());
//		
//		JMenu menuFinalizar = new JMenu("Finalizar");
//		menuFinalizar.add(linkExit);
//
//		menuBar.add(menuAdministracion);
//		menuBar.add(menuCuentas);
//		menuBar.add(menuVentas);
//		menuBar.add(menuFinalizar);
//
//		this.setJMenuBar(menuBar);

		//inicializamos la toolbar.
		
	    toolbar.setLayout(new GridLayout());
//	    addLink(linkProductos);
//	    addLink(linkClientes);
//		this.toolbar.addSeparator();
////		addLink(linkBalances);
////		this.toolbar.addSeparator();
////		addLink( linkVentas );
////		this.toolbar.addSeparator();
//		addLink( linkVentas );
//		addLink( linkPagos );
		
		
	    JButton btnMenu = new JButton("Inicio");
	    btnMenu.setFont(new Font("Dialog", Font.PLAIN, 10));
	    btnMenu.setMinimumSize(new Dimension(100, 23));
	    btnMenu.setToolTipText(ButtonLabelsBundle.btn_Ok_ToolTipText);
		
		//btnOk.setIcon(new ImageIcon(ButtonImagesBundle.btn_Ok));
	    btnMenu.setIcon(new ImageIcon(ButtonImagesBundle.btn_Ok));
		
	    btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    //btnMenu.setMnemonic(java.awt.event.KeyEvent.VK_ENTER);
	    btnMenu.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	             toogleTaskPane();
	            
	          }
	        });

	    this.toolbar.add( btnMenu );
	    //this.toolbar.addSeparator();
	    
	    //this.toolbar.add(getPanelSucursal() );
	    this.toolbar.add(getPanelCaja() );
		this.toolbar.add(getPanelVendedor());

		
		this.replaceToolbar( new PanelMenuToolbar() );
		
//		this.toolbar.addSeparator();
//		addLink(linkExit);
		
//		taskpanecontainer.setLayout(new GridLayout());
		
		
		JXTaskPane taskpaneAdmin = new JXTaskPane();
		taskpaneAdmin.setTitle( I18nMessages.MENU_ADMIN );
		//taskpane.setIcon(new ImageIcon(PropertiesImages.ADMIN_SMALL_ICON) );
		
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkProductos));
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkCategoriasProducto));
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkClientes));
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkVendedores));
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkVentas));
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkPagos));
		taskpaneAdmin.add( MenuFactory.getJMenuItem(linkMovimientosCaja));
		
		
		taskpaneAdmin.setCollapsed( false );
		SkinDecorator.getInstance().decorate(taskpaneAdmin);
		
		taskpanecontainer.add(taskpaneAdmin);
		
		
		JXTaskPane taskpaneContable = new JXTaskPane();
		taskpaneContable.setTitle(I18nMessages.MENU_CONTABLE );
		
		taskpaneContable.setCollapsed( false );
		SkinDecorator.getInstance().decorate(taskpaneContable);
		taskpanecontainer.add(taskpaneContable);
		
		
		JXTaskPane taskpaneSession = new JXTaskPane();
		taskpaneSession.setTitle(I18nMessages.MENU_SESION );
		//taskpane.setIcon(new ImageIcon(PropertiesImages.SESION_SMALL_ICON) );
		taskpaneSession.add(linkExit);
		
		
		taskpaneSession.setCollapsed( false );
		SkinDecorator.getInstance().decorate(taskpaneSession);
		taskpanecontainer.add(taskpaneSession);

		toogleTaskPane();
		
		setSize(850, 700);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
	}

	public static void main(String[] args) {
		
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException ex) {
			
		} catch (IllegalAccessException ex) {
		} catch (InstantiationException ex) {
		} catch (ClassNotFoundException ex) {
		}
		


		//archivos de configuraci�n de hibernate.
//		String i18n_hibernate_cfg = Config.getInstance().getProperties().getProperty("i18n_hibernate_cfg_key");
//		String cuentas_hibernate_cfg = Config.getInstance().getProperties().getProperty("cuentas_hibernate_cfg_key");
		
		
		Locale.setDefault( Locale.ROOT);
		Locale locale = Locale.getDefault();
				
		FrameMenuInicial frame = new FrameMenuInicial();
		frame.open();

		
//		ContextoAplicacion.getInstance().setFramePrincipal( frame );
		
		/*
		//procesamos los abonos.
		try {
			ProcesadorAbonos.procesar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	
	private JPanel getPanelVendedor(){
		return new PanelVendedorDefault();
	}
	
	private JPanel getPanelSucursal(){
		return new PanelSucursalDefault();		
	}
	
	private JPanel getPanelCaja(){
		
//		JFindObjectPanel findCaja = FinderFactory.getFindCaja(new LinkFindObjectListener() {
//			
//			public void objectFound(Object objectFinded) {
//				AppContext.getInstance().setCajaDefault((Caja)objectFinded);
//			}
//		});
//		findCaja.hideCode();
//		findCaja.objectFound( AppContext.getInstance().getCajaDefault() );
//		JLabel lblCaja = new JLabel(I18nMessages.MOVIMIENTO_CAJA_CAJA);
//		lblCaja.setHorizontalAlignment( JLabel.RIGHT );
//	
//		lblCaja.setFont(new Font("Dialog", Font.PLAIN, 10));
//		
//				
//		JPanel panelVendedor = new JPanel();
//		panelVendedor.setLayout(new BorderLayout());
//		panelVendedor.add(lblCaja, BorderLayout.WEST);
//		panelVendedor.add(findCaja, BorderLayout.CENTER);
//		return panelVendedor;
		return new PanelCajaDefault();
	}
	
}