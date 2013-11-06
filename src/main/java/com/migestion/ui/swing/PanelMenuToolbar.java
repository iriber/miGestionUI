/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import com.migestion.model.Caja;
import com.migestion.model.Sucursal;
import com.migestion.model.Vendedor;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.factories.MenuFactory;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkSystemExit;
import com.migestion.swing.view.dialogs.ProgressDialog;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.swing.cajas.factories.LinkCajaFactory;
import com.migestion.ui.swing.cajas.movimientos.factories.LinkMovimientoCajaFactory;
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
import com.migestion.ui.swing.operaciones.ventas.links.LinkAddVenta;
import com.migestion.ui.swing.pagos.factories.LinkPagoFactory;
import com.migestion.ui.swing.productos.factories.LinkProductoFactory;
import com.migestion.ui.swing.vendedores.factories.LinkVendedorFactory;

/**
 * 
 * @author bernardo
 */
public class PanelMenuToolbar extends javax.swing.JPanel {

	/**
	 * Creates new form PanelMenuToolbar
	 */
	public PanelMenuToolbar() {
		initComponents();

		initMenuInicio();

		loadCombos();
	}

	private void initMenuInicio() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (Exception ex) {
				}

				SwingWorker worker = new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						int index = 0;
						// link productos.
						LinkListCollection linkProductos = LinkProductoFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link categorías de producto.
						LinkListCollection linkCategoriasProducto = LinkCategoriaProductoFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link clientes.
						LinkListCollection linkClientes = LinkClienteFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link vendedores.
						LinkListCollection linkVendedores = LinkVendedorFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link ventas.
						LinkListCollection linkVentas = LinkVentaFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link pagos.
						LinkListCollection linkPagos = LinkPagoFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link movimientos de caja.
						LinkListCollection linkMovimientosCaja = LinkMovimientoCajaFactory
								.getLinkList();
						index += 10;
						setProgress(index);

						// link exit.
						Link linkExit = new LinkSystemExit();
						index += 10;
						setProgress(index);

						menuInicioPopup = new JPopupMenu();

						JMenu menuCuentas = new JMenu("Ingresos/Egresos");

						menuInicioPopup.add(MenuFactory
								.getJMenuItem(linkProductos));

						menuInicioPopup.add(MenuFactory
								.getJMenuItem(linkCategoriasProducto));
						menuInicioPopup.add(MenuFactory
								.getJMenuItem(linkClientes));
						menuInicioPopup.add(MenuFactory
								.getJMenuItem(linkVendedores));

						menuInicioPopup.addSeparator();

						menuCuentas.add(MenuFactory.getJMenuItem(linkVentas));
						// menuCuentas.add(
						// MenuFactory.getJMenuItem(linkAddVenta));
						menuCuentas.add(MenuFactory.getJMenuItem(linkPagos));
						// menuCuentas.add(
						// MenuFactory.getJMenuItem(linkCajas));
						menuCuentas.add(MenuFactory
								.getJMenuItem(linkMovimientosCaja));
						menuInicioPopup.add(menuCuentas);

						menuInicioPopup.addSeparator();
						menuInicioPopup.add(MenuFactory.getJMenuItem(linkExit));

						setProgress(100);

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

	private void loadCombos() {
		// try {

		// UISucursalCriteria criteria = new UISucursalCriteria();
		// UICollection sucursales =
		// UIServiceFactory.getUISucursalService().list( criteria );
//		ComboModel model = new ComboModel();
//		 model.setElementos(sucursales.getElements());
//		cmbSucursal.setModel(model);
//		cmbSucursal.setSelectedIndex(0);

		// } catch (ControllerException e) {
		// e.printStackTrace();
		// }

		// try {
		//
		// UIVendedorCriteria criteria = new UIVendedorCriteria();
		// UICollection vendedores =
		// UIServiceFactory.getUIVendedorService().list( criteria );
		// ComboModel model = new ComboModel();
		// model.setElementos(vendedores.getElements());
		// cmbVendedor.setModel(model);
		// cmbVendedor.setSelectedItem(
		// AppContext.getInstance().getVendedorDefault() );
		//
		// } catch (ControllerException e) {
		// e.printStackTrace();
		// }
		ComboModel model = new ComboModel();
		// model.setElementos(sucursales.getElements());
		List<Sucursal> elements = new ArrayList<Sucursal>();
		elements.add(AppContext.getInstance().getSucursalDefault());
		model.setElementos(elements);
		cmbSucursal.setModel(model);
		cmbSucursal.setSelectedIndex(0);

		model = new ComboModel();
		List<Vendedor> modelVendedores = new ArrayList<Vendedor>();
		modelVendedores.add(AppContext.getInstance().getVendedorDefault());
		model.setElementos(modelVendedores);
		cmbVendedor.setModel(model);
		cmbVendedor.setSelectedIndex(0);

		// try {
		//
		// UICajaCriteria criteria = new UICajaCriteria();
		// criteria.addEstado( EstadoCaja.ABIERTA );
		// UICollection cajasAbiertas =
		// UIServiceFactory.getUICajaService().list( criteria );
		// ComboModel model = new ComboModel();
		// model.setElementos(cajasAbiertas.getElements());
		// cmbCaja.setModel(model);
		// cmbCaja.setSelectedItem( AppContext.getInstance().getCajaDefault() );
		//
		// } catch (ControllerException e) {
		// e.printStackTrace();
		// }

		model = new ComboModel();
		List<Caja> modelCajas = new ArrayList<Caja>();
		modelCajas.add(AppContext.getInstance().getCajaDefault());
		model.setElementos(modelCajas);
		cmbCaja.setModel(model);
		cmbCaja.setSelectedIndex(0);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		panelCombos = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		cmbCaja = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		cmbVendedor = new javax.swing.JComboBox();
		jLabel3 = new javax.swing.JLabel();
		cmbSucursal = new javax.swing.JComboBox();
		panelInicio = new javax.swing.JPanel();
		btnInicio = new javax.swing.JButton();

		setLayout(new java.awt.BorderLayout());

		panelCombos.setLayout(new java.awt.GridBagLayout());

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel1.setText("Caja");
		jLabel1.setPreferredSize(new java.awt.Dimension(50, 18));
		panelCombos.add(jLabel1, new java.awt.GridBagConstraints());

		cmbCaja.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		cmbCaja.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				cmbCajaPropertyChange(evt);
			}
		});
		panelCombos.add(cmbCaja, new java.awt.GridBagConstraints());

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel2.setText("Vendedor");
		jLabel2.setPreferredSize(new java.awt.Dimension(90, 18));
		panelCombos.add(jLabel2, new java.awt.GridBagConstraints());

		cmbVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		cmbVendedor.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cmbVendedorActionPerformed(evt);
			}
		});
		cmbVendedor
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						cmbVendedorPropertyChange(evt);
					}
				});
		panelCombos.add(cmbVendedor, new java.awt.GridBagConstraints());

		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabel3.setText("Sucursal");
		jLabel3.setPreferredSize(new java.awt.Dimension(80, 18));
		panelCombos.add(jLabel3, new java.awt.GridBagConstraints());

		cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		cmbSucursal
				.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
					public void propertyChange(
							java.beans.PropertyChangeEvent evt) {
						cmbSucursalPropertyChange(evt);
					}
				});
		panelCombos.add(cmbSucursal, new java.awt.GridBagConstraints());

		add(panelCombos, java.awt.BorderLayout.LINE_END);

		panelInicio.setLayout(new java.awt.BorderLayout());

		btnInicio.setMnemonic(java.awt.event.KeyEvent.VK_I);
		btnInicio.setText("Inicio");
		btnInicio.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnInicioActionPerformed(evt);
			}
		});
		panelInicio.add(btnInicio, java.awt.BorderLayout.CENTER);

		add(panelInicio, java.awt.BorderLayout.LINE_START);
	}// </editor-fold>//GEN-END:initComponents

	private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnInicioActionPerformed
		// TODO add your handling code here:

		JPopupMenu popup = getMenuInicioPopup();
		popup.show(btnInicio, btnInicio.getX(), btnInicio.getY());

	}// GEN-LAST:event_btnInicioActionPerformed

	private void cmbCajaPropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_cmbCajaPropertyChange
		// TODO add your handling code here:
		AppContext.getInstance().setCajaDefault(
				(Caja) cmbCaja.getSelectedItem());
	}// GEN-LAST:event_cmbCajaPropertyChange

	private void cmbVendedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cmbVendedorActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_cmbVendedorActionPerformed

	private void cmbVendedorPropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_cmbVendedorPropertyChange
		AppContext.getInstance().setVendedorDefault(
				(Vendedor) cmbVendedor.getSelectedItem());
	}// GEN-LAST:event_cmbVendedorPropertyChange

	private void cmbSucursalPropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_cmbSucursalPropertyChange
		AppContext.getInstance().setSucursalDefault(
				(Sucursal) cmbSucursal.getSelectedItem());
	}// GEN-LAST:event_cmbSucursalPropertyChange

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnInicio;
	private javax.swing.JComboBox cmbCaja;
	private javax.swing.JComboBox cmbSucursal;
	private javax.swing.JComboBox cmbVendedor;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel panelCombos;
	private javax.swing.JPanel panelInicio;
	// End of variables declaration//GEN-END:variables

	private JPopupMenu menuInicioPopup;

	/**
	 * @return the rightClickPopup
	 */
	public JPopupMenu getMenuInicioPopup() {
		return menuInicioPopup;
	}

	/**
	 * @param rightClickPopup
	 *            the rightClickPopup to set
	 */
	public void setMenuInicioPopup(JPopupMenu rightClickPopup) {
		this.menuInicioPopup = rightClickPopup;
	}

}
