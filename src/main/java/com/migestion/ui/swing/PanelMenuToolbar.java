/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

import com.migestion.model.EstadoCaja;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.factories.MenuFactory;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.Link;
import com.migestion.swing.navigation.LinkListCollection;
import com.migestion.swing.navigation.LinkSystemExit;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UICajaCriteria;
import com.migestion.ui.criteria.UISucursalCriteria;
import com.migestion.ui.criteria.UIVendedorCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cajas.movimientos.factories.LinkMovimientoCajaFactory;
import com.migestion.ui.swing.categoriasProducto.factories.LinkCategoriaProductoFactory;
import com.migestion.ui.swing.clientes.factories.LinkClienteFactory;
import com.migestion.ui.swing.operaciones.ventas.factories.LinkVentaFactory;
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
		// TODO Auto-generated method stub
		
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

    	
    	
    	menuInicioPopup = new JPopupMenu();
    	
		JMenu menuCuentas = new JMenu("Ingresos/Egresos");
		

		menuInicioPopup.add( MenuFactory.getJMenuItem(linkProductos) );
		
		menuInicioPopup.add( MenuFactory.getJMenuItem(linkCategoriasProducto));
		menuInicioPopup.add( MenuFactory.getJMenuItem(linkClientes));
		menuInicioPopup.add( MenuFactory.getJMenuItem(linkVendedores));
		
		
		menuInicioPopup.addSeparator();
		
		menuCuentas.add( MenuFactory.getJMenuItem(linkVentas));
		menuCuentas.add( MenuFactory.getJMenuItem(linkPagos));
		menuCuentas.add( MenuFactory.getJMenuItem(linkMovimientosCaja));
		menuInicioPopup.add(menuCuentas);
		
		menuInicioPopup.addSeparator();
		menuInicioPopup.add( MenuFactory.getJMenuItem(linkExit));

		
	}

	private void loadCombos() {
		try {

			UISucursalCriteria criteria = new UISucursalCriteria();
			UICollection sucursales = UIServiceFactory.getUISucursalService().list( criteria );
			ComboModel model = new ComboModel();
	        model.setElementos(sucursales.getElements());
	        cmbSucursal.setModel(model);
	        cmbSucursal.setSelectedItem( AppContext.getInstance().getSucursalDefault() );
	        
		} catch (ControllerException e) {
			e.printStackTrace();
		}
		
		try {

			UIVendedorCriteria criteria = new UIVendedorCriteria();
			UICollection vendedores = UIServiceFactory.getUIVendedorService().list( criteria );
			ComboModel model = new ComboModel();
	        model.setElementos(vendedores.getElements());
	        cmbVendedor.setModel(model);
	        cmbVendedor.setSelectedItem( AppContext.getInstance().getVendedorDefault() );
	        
		} catch (ControllerException e) {
			e.printStackTrace();
		}

		try {

			UICajaCriteria criteria = new UICajaCriteria();
			criteria.addEstado( EstadoCaja.ABIERTA );
			UICollection cajasAbiertas = UIServiceFactory.getUICajaService().list( criteria );
			ComboModel model = new ComboModel();
	        model.setElementos(cajasAbiertas.getElements());
	        cmbCaja.setModel(model);
	        cmbCaja.setSelectedItem( AppContext.getInstance().getCajaDefault() );
	        
		} catch (ControllerException e) {
			e.printStackTrace();
		}

	}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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

        cmbCaja.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelCombos.add(cmbCaja, new java.awt.GridBagConstraints());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Vendedor");
        jLabel2.setPreferredSize(new java.awt.Dimension(90, 18));
        panelCombos.add(jLabel2, new java.awt.GridBagConstraints());

        cmbVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        panelCombos.add(cmbVendedor, new java.awt.GridBagConstraints());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Sucursal");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 18));
        panelCombos.add(jLabel3, new java.awt.GridBagConstraints());

        cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        // TODO add your handling code here:
 
         JPopupMenu popup = getMenuInicioPopup();
         popup.show(btnInicio, btnInicio.getX(), btnInicio.getY());
         
        
    }//GEN-LAST:event_btnInicioActionPerformed


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
	 * @param rightClickPopup the rightClickPopup to set
	 */
	public void setMenuInicioPopup(JPopupMenu rightClickPopup) {
		this.menuInicioPopup = rightClickPopup;
	}

}
