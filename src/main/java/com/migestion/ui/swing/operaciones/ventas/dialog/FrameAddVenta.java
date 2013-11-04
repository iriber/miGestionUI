/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.operaciones.ventas.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.Cliente;
import com.migestion.model.DetalleVenta;
import com.migestion.model.Producto;
import com.migestion.model.Sucursal;
import com.migestion.model.TipoDocumento;
import com.migestion.model.Vendedor;
import com.migestion.model.Venta;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.ComboEnumElement;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.i18n.buttons.ButtonImagesBundle;
import com.migestion.swing.i18n.buttons.ButtonLabelsBundle;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.listeners.LinkAddListener;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.utils.FormatUtils;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JDateChooserInspector;
import com.migestion.swing.view.inputs.JFindObjectInspector;
import com.migestion.ui.AppUtils;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UISucursalCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.finder.FinderFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.operaciones.ventas.UIDetalleVentaCollection;
import com.migestion.ui.swing.operaciones.ventas.panel.detalles.DetalleVentaTableController;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;

/**
 * Ventana para agregar una venta.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 18/10/2013
 * 
 */
public class FrameAddVenta extends javax.swing.JInternalFrame implements  TableModelListener, ISkinForm, ListSelectionListener{

	//variable para determinar si el usuario aceptó o canceló
	//la operación
	private InputRequiredValidator required;
    
    private Venta venta;

    private DetalleVentaTableController detallesController;
    private UIDetalleVentaCollection detallesModel;	

    private DetalleVenta detalleSeleccionado;
    
    private Integer filaSeleccionada;
    
	//objetos listeners que ser�n informados cuando
	//se cree el nuevo objeto
	private Vector listeners;
	
	
    /**
     * Creates new form FrameAddVenta
     */
    public FrameAddVenta() {
        
    	super(I18nMessages.VENTA_DIALOG_AGREGAR_TITULO, true, false, true, true);
    	
    	initComponents();
    	
    	Dimension minimumSize = new Dimension(700, 400);
 		setMinimumSize(minimumSize);
 		
    	initVenta();
    	
    	initValidators();
         
        SkinDecorator.getInstance().decorate(this);
        
 		loadCombos();
 		
 		initTableDetalles();

 		//this.pack();
 		//setExtendedState(JFrame.MAXIMIZED_BOTH);
 		
 		this.listeners = new Vector();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        panelDatosVenta = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        pickerFecha = new com.toedter.calendar.JDateChooser();
        lblCliente = new javax.swing.JLabel();
        findCliente = FinderFactory.getFindCliente( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                venta.setCliente( (Cliente)objectFinded );
            }
        });
        lblVendedor = new javax.swing.JLabel();
        findVendedor = FinderFactory.getFindVendedor(new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                venta.setVendedor( (Vendedor) objectFinded);
            }
        });
        lblFormaEntrega = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();
        cmbFormaEntrega = new javax.swing.JComboBox();
        lblObservaciones = new javax.swing.JLabel();
        scrollObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        panelTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelFooter = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        panelButtons = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelCenter = new javax.swing.JPanel();
        panelAddProducto = new javax.swing.JPanel();
        lblProductos = new javax.swing.JLabel();
        findProducto = FinderFactory.getFindProducto(new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

            }
        });
        lblAgregarProducto = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        scrollDetalles = new javax.swing.JScrollPane();
        tableDetalles = new javax.swing.JTable();

        panelHeader.setBackground(new java.awt.Color(190, 188, 187));
        panelHeader.setLayout(new java.awt.BorderLayout());

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente");

        findCliente.setMinimumSize(new java.awt.Dimension(71, 28));
        findCliente.setPreferredSize(new java.awt.Dimension(75, 28));

        lblVendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVendedor.setText("Vendedor");

        findVendedor.setMinimumSize(new java.awt.Dimension(16, 28));
        findVendedor.setPreferredSize(new java.awt.Dimension(75, 28));

        lblFormaEntrega.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormaEntrega.setText("Forma entrega");

        lblSucursal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSucursal.setText("Sucursal");

        cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbFormaEntrega.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblObservaciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblObservaciones.setText("Observaciones");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        scrollObservaciones.setViewportView(txtObservaciones);

        javax.swing.GroupLayout panelDatosVentaLayout = new javax.swing.GroupLayout(panelDatosVenta);
        panelDatosVenta.setLayout(panelDatosVentaLayout);
        panelDatosVentaLayout.setHorizontalGroup(
            panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVendedor)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha)
                    .addComponent(lblObservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pickerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatosVentaLayout.createSequentialGroup()
                        .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(findCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(findVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFormaEntrega)
                            .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbSucursal, 0, 120, Short.MAX_VALUE)
                            .addComponent(cmbFormaEntrega, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scrollObservaciones))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        panelDatosVentaLayout.setVerticalGroup(
            panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosVentaLayout.createSequentialGroup()
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pickerFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(findCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFormaEntrega)
                        .addComponent(cmbFormaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelDatosVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosVentaLayout.createSequentialGroup()
                        .addComponent(lblObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(scrollObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        panelHeader.add(panelDatosVenta, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Nueva venta");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHeader.add(panelTitulo, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelFooter.setBackground(new java.awt.Color(233, 180, 182));
        panelFooter.setLayout(new java.awt.BorderLayout());

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total");
        panelFooter.add(lblTotal, java.awt.BorderLayout.PAGE_START);

        txtTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("0.00");
        panelFooter.add(txtTotal, java.awt.BorderLayout.CENTER);

        btnAceptar.setText(ButtonLabelsBundle.btn_Ok);
        btnAceptar.setFont(new Font("Dialog", Font.PLAIN, 10));
        btnAceptar.setMinimumSize(new Dimension(100, 23));
        btnAceptar.setToolTipText(ButtonLabelsBundle.btn_Ok_ToolTipText);

        //btnAceptar.setIcon(new ImageIcon(ButtonImagesBundle.btn_Ok));
        btnAceptar.setIcon(new ImageIcon(ButtonImagesBundle.btn_Ok));

        btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAceptar.setMnemonic(java.awt.event.KeyEvent.VK_ENTER);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelButtons.add(btnAceptar);

        btnCancelar.setText(ButtonLabelsBundle.btn_Cancel);
        btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 10));
        btnCancelar.setMinimumSize(new Dimension(110, 23));
        btnCancelar.setToolTipText(ButtonLabelsBundle.btn_Cancel_ToolTipText);
        btnCancelar.setIcon(new ImageIcon(ButtonImagesBundle.btn_Cancel));
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setMnemonic(java.awt.event.KeyEvent.VK_ESCAPE);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        panelButtons.add(btnCancelar);

        panelFooter.add(panelButtons, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panelFooter, java.awt.BorderLayout.PAGE_END);

        panelCenter.setBackground(new java.awt.Color(170, 170, 9));
        panelCenter.setLayout(new java.awt.BorderLayout());

        lblProductos.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblProductos.setText("Productos");

        lblAgregarProducto.setText("Seleccione un producto");

        btnAgregar.setText("Agregarlo a la venta");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddProductoLayout = new javax.swing.GroupLayout(panelAddProducto);
        panelAddProducto.setLayout(panelAddProductoLayout);
        panelAddProductoLayout.setHorizontalGroup(
            panelAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddProductoLayout.createSequentialGroup()
                .addGroup(panelAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddProductoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblAgregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(findProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAgregar))
                    .addGroup(panelAddProductoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProductos)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        panelAddProductoLayout.setVerticalGroup(
            panelAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductos)
                .addGap(18, 18, 18)
                .addGroup(panelAddProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        panelCenter.add(panelAddProducto, java.awt.BorderLayout.PAGE_START);

        tableDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio Unitario", "Cantidad", "Descuento", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDetalles.setColumnSelectionAllowed(true);
        tableDetalles.getTableHeader().setReorderingAllowed(false);
        scrollDetalles.setViewportView(tableDetalles);

        panelCenter.add(scrollDetalles, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 768, 530);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    	
    	doOk();
    	
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
    	 
         Producto producto = (Producto)findProducto.getObjectFound();
         
         if( producto != null ){
        	 
        	 DetalleVenta detalle = new DetalleVenta();
        	 detalle.setProducto( producto );
             detalle.setCantidad(1);
             detalle.setDescuento(0F);
             detalle.setPrecioUnitario( producto.getPrecio()  );
             detallesController.addElement(detalle);
         }
         
    	
    	
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        doCancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameAddVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAddVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAddVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAddVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAddVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbFormaEntrega;
    private javax.swing.JComboBox cmbSucursal;
    private com.migestion.swing.custom.JFindObjectPanel findCliente;
    private com.migestion.swing.custom.JFindObjectPanel findProducto;
    private com.migestion.swing.custom.JFindObjectPanel findVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAgregarProducto;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFormaEntrega;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JPanel panelAddProducto;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelDatosVenta;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelTitulo;
    private com.toedter.calendar.JDateChooser pickerFecha;
    private javax.swing.JScrollPane scrollDetalles;
    private javax.swing.JScrollPane scrollObservaciones;
    private javax.swing.JTable tableDetalles;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
	

	public void open() {

		show();
		setVisible(true);
		clearInputs();
		
		moveToFront();
		
		try {
			setSelected(true);
			setIcon(false);
			setMaximum(true);
		} catch (PropertyVetoException e) {			
			e.printStackTrace();
		}
	}
	
	/**
	 * se acepta la operación.
	 * si hay algún error, se informa el mismo.
	 * si todo está ok, la operación se concluye y se
	 * cierra la ventana.
	 */
	protected void doOk(){		
		try {			
			//se valida la informaci�n cargada.
			validateInput();
			
			//creamos el objeto con la info de la ui.
			Venta venta = getObjectFromUI();
			
			UIServiceFactory.getUIVentaService().addObject(venta);
			
			alertListeners();
			
			setVisible(false);
			//this.dispose();
		}catch(ViewException ex){
			//se informa del error al usuario
			DialogMessage.showErrorMessage(getTitle(), ex.getMessage());			
		} catch (ControllerException e) {
			//se informa del error al usuario
			DialogMessage.showErrorMessage(getTitle(), e.getMessage());
		}
	}

	private void validateInput() throws ViewException {
		
		List<InputValidator> validators = getValidators( );

		for (InputValidator validator : validators) {
			validator.clean();
		}

		for (InputValidator validator : validators) {
			if( !validator.validate() )				
				throw new ViewException( validator.getMessage() );
		}
	}

	private Venta getObjectFromUI() {
		
		venta.setFecha( pickerFecha.getDate() );
		venta.setObservaciones( txtObservaciones.getText() );
		
		for (DetalleVenta detalle: detallesController.getDetalles()) {
			
			venta.addDetalle(detalle);
		}
		
		venta.setSucursal( (Sucursal)cmbSucursal.getSelectedItem() );
		return venta;
	}
	
	
	public List<InputValidator> getValidators() {

		List<InputValidator> validators = new ArrayList<InputValidator>();
		
		validators.add( required );
		
		return validators;
	}

	public void clearInputs() {
		findCliente.objectFound(null);
		findVendedor.objectFound(null);
		findProducto.objectFound(null);
		initVenta();
		initTableDetalles();
		txtObservaciones.setText("");
		pickerFecha.setDate( new Date());
	}



	private void initVenta() {
		
    	venta = new Venta();
    	
    	pickerFecha.setDateFormatString( I18nMessages.FORMATO_DATE );
    	
    	venta.setCliente(AppContext.getInstance().getClienteDefault() );
    	findCliente.objectFound( venta.getCliente() );
    	
    	venta.setVendedor( AppContext.getInstance().getVendedorDefault() );
    	findVendedor.objectFound( venta.getVendedor() );
    	
    	findProducto.objectFound( null );
	}

	private void initValidators() {
		
		required = new InputRequiredValidator(); 
		required.put(lblFecha, pickerFecha, new JDateChooserInspector());
		required.put(lblCliente, findCliente, new JFindObjectInspector());
		required.setMessage(I18nMessages.INGRESE_REQUERIDOS);
		required.initialize();
		
	}

    private void initTableDetalles(){
    	
    	detallesModel = new UIDetalleVentaCollection("Detalles", true);
		detallesModel.addTableModelListener(this);

		detallesController = new DetalleVentaTableController(detallesModel);
		detallesModel.addTableModelListener( tableDetalles );

		tableDetalles.setModel(detallesModel);
		TableCellRenderer renderer = detallesModel.getTableCellRenderer();
		TableCellRenderer headerRenderer = detallesModel.getTableHeaderRenderer();
		for(int columnIndex=0; columnIndex < detallesModel.getColumnCount(); columnIndex++){
			tableDetalles.setDefaultRenderer(detallesModel.getColumnClass(columnIndex), renderer);
			tableDetalles.getColumnModel().getColumn(columnIndex).setHeaderRenderer( headerRenderer );
		}
		
		detallesModel.initCellEditorsRenderers(tableDetalles);
		detallesModel.initColumnsWidth( tableDetalles );
		
		tableDetalles.setAutoscrolls(true);
		tableDetalles.setSelectionMode(0);
		tableDetalles.setRowHeight(30);		

		tableDetalles.getSelectionModel().addListSelectionListener(this);
		
		this.initRightClickMenu();
		
		tableDetalles.addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent event) {
				// TODO Auto-generated method stub
			
				//DialogMessage.showErrorMessage("typed", event.getKeyText( event.getKeyCode() ));
			}
			
			public void keyReleased(KeyEvent event) {
				// TODO Auto-generated method stub
				
				//DialogMessage.showErrorMessage("released", event.getKeyText( event.getKeyCode() ));
			}
			
			public void keyPressed(KeyEvent event) {
				
				if( event.getKeyCode() == KeyEvent.VK_DELETE ){
					
					detallesController.deleteElement( filaSeleccionada );
				}
				
			}
		});
		
    }

    public List<JComponent> getFormLabels() {
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblFecha);
		labels.add(lblCliente);
		labels.add(lblVendedor);
		labels.add(lblObservaciones);
		labels.add(lblAgregarProducto);
		
		//TODO
		return labels;
	}

	public List<JComponent> getFormInputs() {
		List<JComponent> inputs = new Vector<JComponent>();
		
		inputs.add(txtObservaciones);
		inputs.add(findVendedor);
		inputs.add(findCliente);
		inputs.add(findProducto);
		inputs.add(txtObservaciones);
		inputs.add(txtTotal);
		inputs.add(pickerFecha);
		inputs.add(findCliente);
		inputs.add(findVendedor);
		//TODO
		return inputs;
	}

	public void setPadding(JComponent component, Insets padding) {
		/*
		GridBagConstraints gbc = ((GridBagLayout)getLayout()).getConstraints(component);
		gbc.insets = padding;
		((GridBagLayout)getLayout()).setConstraints(component, gbc);
		*/
	}

	public void setFormBackground(Color bg) {
		this.setBackground(bg);
		panelDatosVenta.setBackground(bg);
		panelCenter.setBackground(bg);
		panelAddProducto.setBackground(bg);
    	panelHeader.setBackground(bg);
    	panelTitulo.setBackground(bg);
    	
	}

	public void tableChanged(TableModelEvent arg0) {
		
		//actualizamos los totales.
		
		Float montoTotal = 0F;
		for (DetalleVenta detalle: detallesController.getDetalles()) {
			montoTotal += detalle.getSubtotal();
		}
		
		txtTotal.setText( AppUtils.formatMoneda( montoTotal ) );
		venta.setMonto(montoTotal);
		
	}

	public void loadCombos(){
        //cargar tipos de documentos
//        List tipos = new ArrayList();
//       	for (TipoDocumento object : TipoDocumento.values()){
//       		
//       		ComboEnumElement tipo = new ComboEnumElement(object, I18nMessages.locale( object.getNombre() ));
//			tipos.add(tipo);	
//       	}
//       	
//        ComboModel model = new ComboModel();
//        model.setElementos(tipos);
//        cmbTipoDoc.setModel(model);
//        cmbTipoDoc.setSelectedIndex(0);

        //cargar sucursales

		try {

			UICollection sucursales = UIServiceFactory.getUISucursalService().list(new UISucursalCriteria());
			ComboModel model = new ComboModel();
	        model.setElementos(sucursales.getElements());
	        cmbSucursal.setModel(model);
	        cmbSucursal.setSelectedItem( AppContext.getInstance().getSucursalDefault() );
	        
		} catch (ControllerException e) {
			e.printStackTrace();
		}
        

	}

	public void initRightClickMenu(){
		
		tableDetalles.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        	
	            int r = tableDetalles.rowAtPoint(e.getPoint());
	            if (r >= 0 && r < tableDetalles.getRowCount()) {
	            	tableDetalles.setRowSelectionInterval(r, r);
	            } else {
	            	tableDetalles.clearSelection();
	            }

	            int rowindex = tableDetalles.getSelectedRow();
	            if (rowindex < 0)
	                return;
	            Component c = e.getComponent();
	            if (e.getButton() == 3 && e.getComponent() instanceof JTable ) {
	                JPopupMenu rightClick = new JPopupMenu();
	                JMenuItem item = new JMenuItem(I18nMessages.BTN_ELIMINAR);
	                item.setIcon( new ImageIcon(ButtonImagesBundle.btn_Cancel));
	                item.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							
							if(filaSeleccionada!=null)
								detallesController.deleteElement( filaSeleccionada );
							
						}
					});
	        		rightClick.add( item);
	        		rightClick.show(e.getComponent(), e.getX(), e.getY());
	            }
	        	/*
	        	Component c = e.getComponent();
	        	System.out.println("e=" + e + ", component=" + c);
	        	
	        	if (e.getButton() == 3) {
	        	      System.out.println("isPopup");
	        	      JPopupMenu popup = getRightClickPopup();
	        	      popup.show(c, c.getSize().width / 2, c.getSize().height / 2);
	        	}*/
	        }
		});
	}
	
		
	private void doCancelar(){
		//this.dispose();
		setVisible(false);
	}

	public void valueChanged(ListSelectionEvent e) {
		// extra messages.
		if (e.getValueIsAdjusting()) {
			return;
		}

		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		if (!lsm.isSelectionEmpty()) {
			//tomo el elemento actual.
			filaSeleccionada = tableDetalles.getSelectedRow();
			//avisamos a los listeners.
			//alertListenersSelectionChange(selectedObject);
		}else{
			//avisamos a los listeners.
			filaSeleccionada = null;
		}

	}

	/**
	 * @return the venta
	 */
	public Venta getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public void addListener(LinkAddListener listener){
		
		listeners.add( listener );
	}
	
	/*
	 * se avisa a los listener que el objeto
	 * fue creado.  
	 */
	private void alertListeners(){
		Iterator iter = listeners.iterator();
		while (iter.hasNext()) {
			//le avisamos a cada listener
			LinkAddListener element = (LinkAddListener) iter.next();
			element.objectCreated( getVenta() );			
		}
	}


}