/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.pagos.dialog;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.ConceptoMovimiento;
import com.migestion.model.DetalleFormaPago;
import com.migestion.model.DetalleFormaPagoCheque;
import com.migestion.model.DetalleFormaPagoEfectivo;
import com.migestion.model.FormaPago;
import com.migestion.model.MovimientoCaja;
import com.migestion.model.Pago;
import com.migestion.model.Sucursal;
import com.migestion.model.Venta;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.i18n.buttons.ButtonImagesBundle;
import com.migestion.swing.i18n.buttons.ButtonLabelsBundle;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.interfaces.ILinkWindowAddRelated;
import com.migestion.swing.navigation.listeners.LinkAddListener;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.utils.UbicacionVentana;
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
import com.migestion.ui.swing.pagos.UIDetalleFormaPagoCollection;
import com.migestion.ui.swing.pagos.panel.detalles.DetalleFormaPagoTableController;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;

/**
 * Ventana para agregar un pago de venta.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 29/10/2013
 * 
 */
public class FrameAddPagoVenta extends JInternalFrame implements  TableModelListener, ISkinForm, ListSelectionListener, ILinkWindowAddRelated{

	private InputRequiredValidator required;
    
    private Pago pago;

    private Venta ventaPagar;
    
    private DetalleFormaPagoTableController detallesController;
    private UIDetalleFormaPagoCollection detallesModel;	

    private DetalleFormaPago detalleSeleccionado;
    
    private Integer filaSeleccionada;
    
	//objetos listeners que ser�n informados cuando
	//se cree el nuevo objeto
	private Vector listeners;

    /**
     * Creates new form FrameAddPagoVenta
     */
    public FrameAddPagoVenta() {
        initComponents();
        
        initPago();
    	
    	initValidators();
         
        SkinDecorator.getInstance().decorate(this);
        
 		loadCombos();
 		
 		initTableDetalles();

 		//this.pack();
 		//setExtendedState(JFrame.MAXIMIZED_BOTH);
 		
 		this.listeners = new Vector();
    }

    private void initTableDetalles() {
    	
    	detallesModel = new UIDetalleFormaPagoCollection("Detalles", true);
		detallesModel.addTableModelListener(this);

		detallesController = new DetalleFormaPagoTableController(detallesModel);
		detallesModel.addTableModelListener( tableDetallesFormaPago );

		tableDetallesFormaPago.setModel(detallesModel);
		TableCellRenderer renderer = detallesModel.getTableCellRenderer();
		TableCellRenderer headerRenderer = detallesModel.getTableHeaderRenderer();
		for(int columnIndex=0; columnIndex < detallesModel.getColumnCount(); columnIndex++){
			tableDetallesFormaPago.setDefaultRenderer(detallesModel.getColumnClass(columnIndex), renderer);
			tableDetallesFormaPago.getColumnModel().getColumn(columnIndex).setHeaderRenderer( headerRenderer );
		}
		
		detallesModel.initCellEditorsRenderers(tableDetallesFormaPago);
		detallesModel.initColumnsWidth( tableDetallesFormaPago );
		
		tableDetallesFormaPago.setAutoscrolls(true);
		tableDetallesFormaPago.setSelectionMode(0);
		tableDetallesFormaPago.setRowHeight(30);		

		tableDetallesFormaPago.getSelectionModel().addListSelectionListener(this);
		
		this.initRightClickMenu();
		
		tableDetallesFormaPago.addKeyListener(new KeyListener() {
			
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

	public void loadCombos(){
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

	private void initValidators() {
		required = new InputRequiredValidator(); 
		required.put(lblFecha, pickerFecha, new JDateChooserInspector());
		required.put(lblVenta, findVenta, new JFindObjectInspector());
		//required.put(lbl, findVenta, new JFindObjectInspector());
		required.setMessage(I18nMessages.INGRESE_REQUERIDOS);
		required.initialize();
	}

	private void clearInputs(){
		findVenta.objectFound(null);
		initTableDetalles();
		txtObservaciones.setText("");
		pickerFecha.setDate( new Date());
		txtCliente.setText("");
		txtDebe.setText("");
		txtTotalPagar.setText("");
		txtTotalVenta.setText("");
		
		initPago();
		
	}
	
	private void initPago() {
    		
    	pago = new Pago();
    	
    	pickerFecha.setDateFormatString( I18nMessages.FORMATO_DATE );
    	pickerFecha.setDate( new Date() );

    	if( ventaPagar != null ){
    		
    		findVenta.objectFound( ventaPagar );
        	
        	txtCliente.setText( ventaPagar.getCliente().toString() );
        	
        	txtTotalVenta.setText( AppUtils.formatMoneda( ventaPagar.getMonto() ));
        	
        	txtDebe.setText( AppUtils.formatMoneda( ventaPagar.getMontoDebe() ));
        	
        	txtPagado.setText( AppUtils.formatMoneda( ventaPagar.getMontoPagado() ));
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

        panelCenter = new javax.swing.JPanel();
        panelTable = new javax.swing.JPanel();
        panelFooter = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTotalPagar = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JLabel();
        scrollDetallesFormaPago = new javax.swing.JScrollPane();
        tableDetallesFormaPago = new javax.swing.JTable();
        panelBoton = new javax.swing.JPanel();
        btnAgregarFormaPago = new javax.swing.JButton();
        panelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        pickerFecha = new com.toedter.calendar.JDateChooser();
        cmbSucursal = new javax.swing.JComboBox();
        lblSucursal = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        scrollObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        findVenta = FinderFactory.getFindVendedor(new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                //venta.setVendedor( (Vendedor) objectFinded);
            }
        });
        lblVenta = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblTotalVenta = new javax.swing.JLabel();
        lblPagado = new javax.swing.JLabel();
        txtPagado = new javax.swing.JLabel();
        txtDebe = new javax.swing.JLabel();
        lblDebe = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCenter.setLayout(new java.awt.BorderLayout());

        panelTable.setLayout(new java.awt.BorderLayout());
        panelCenter.add(panelTable, java.awt.BorderLayout.CENTER);

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

        lblTotalPagar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalPagar.setText("Total a pagar");

        txtTotalPagar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtTotalPagar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalPagar.setText("0.00");

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFooterLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPagar)
                    .addComponent(txtTotalPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)))
        );

        tableDetallesFormaPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollDetallesFormaPago.setViewportView(tableDetallesFormaPago);

        btnAgregarFormaPago.setText("Agregar forma de pago");
        btnAgregarFormaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFormaPagoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("Registrar pago");

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSucursal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSucursal.setText("Sucursal");

        lblObservaciones.setText("Observaciones");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        scrollObservaciones.setViewportView(txtObservaciones);

        findVenta.setMinimumSize(new java.awt.Dimension(16, 28));
        findVenta.setPreferredSize(new java.awt.Dimension(75, 28));

        lblVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVenta.setText("Venta");

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente");

        txtCliente.setText("jTextField1");

        lblTotalVenta.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotalVenta.setText("Total Venta");

        lblPagado.setText("Pagado");

        txtPagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtPagado.setText("0.00");

        txtDebe.setForeground(new java.awt.Color(225, 25, 27));
        txtDebe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDebe.setText("0.00");

        lblDebe.setForeground(new java.awt.Color(226, 37, 37));
        lblDebe.setText("Debe");

        txtTotalVenta.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalVenta.setText("0.00");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVenta)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObservaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(findVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pickerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(cmbSucursal, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTotalVenta)
                            .addComponent(lblPagado)
                            .addComponent(lblDebe))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTotalVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtPagado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDebe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(scrollObservaciones))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pickerFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalVenta)
                    .addComponent(txtTotalVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(findVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPagado)
                            .addComponent(lblPagado))
                        .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblDebe))
                            .addGroup(panelHeaderLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtDebe)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservaciones)
                    .addComponent(scrollObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBotonLayout = new javax.swing.GroupLayout(panelBoton);
        panelBoton.setLayout(panelBotonLayout);
        panelBotonLayout.setHorizontalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarFormaPago)
                    .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotonLayout.setVerticalGroup(
            panelBotonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarFormaPago))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(scrollDetallesFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollDetallesFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(panelCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarFormaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFormaPagoActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        //TODO llamar al diálogo para seleccionar una forma de pago
        //y luego abrir la ventana de acuerdo a la forma de pago
        //que sea modal así a la vuelta tengo el detalle creado
        //para agregar al listado.
       DialogSeleccionarFormaPago dialogFormaPago = new DialogSeleccionarFormaPago(new Frame(), true);
       UbicacionVentana.centrar(dialogFormaPago, false);
       dialogFormaPago.setVisible(true);
       
       if( dialogFormaPago.getReturnStatus() == DialogSeleccionarFormaPago.RET_OK ){
       
           FormaPago formaPago = dialogFormaPago.getFormaPago();
           
           DetalleFormaPago detalle = null;
           ConceptoMovimiento conceptoVentas = null;
           
           try {
        	   conceptoVentas = UIServiceFactory.getUIConceptoMovimientoService().getConceptoVentas();
           } catch (ControllerException e) {
        	   // TODO mostrar mensaje
        	   e.printStackTrace();
           }
           
           //vemos a cuál ventana llamar.
           if( formaPago.equals( FormaPago.EFECTIVO) ){
           
               //creamos la forma de pago efectivo con el monto total
               detalle = new DetalleFormaPagoEfectivo();
               detalle.setMonto( 30F );
               ((DetalleFormaPagoEfectivo)detalle).setCaja( AppContext.getInstance().getCajaDefault() );
               
           }else if( formaPago.equals( FormaPago.CHEQUE) ){
            
               DialogAddFormaPagoCheque dialogFormaPagoCheque = new DialogAddFormaPagoCheque(new Frame(), true);
               UbicacionVentana.centrar(dialogFormaPagoCheque, false);
               dialogFormaPagoCheque.setVisible( true );               
               if( dialogFormaPagoCheque.getReturnStatus() == DialogAddFormaPagoCheque.RET_OK ){
               
                   detalle = dialogFormaPagoCheque.getDetalleFormaPago();
                		   
               }
            
           }else if( formaPago.equals( FormaPago.TARJETA) ){
            
           }else if( formaPago.equals( FormaPago.DEPOSITO) ){
           
           }else if( formaPago.equals( FormaPago.TRANSFERENCIA) ){
           
           }else if( formaPago.equals( FormaPago.NOTA_CREDITO) ){
               
           }
           
           if( detalle != null ){

        	   Float monto = detalle.getMonto();
        	   detalle.buildMovimiento(conceptoVentas, monto);
        	   detallesController.addElement(detalle);
           }
           
       }
    }//GEN-LAST:event_btnAgregarFormaPagoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:

        doOk();

    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameAddPagoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAddPagoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAddPagoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAddPagoVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAddPagoVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarFormaPago;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cmbSucursal;
    private com.migestion.swing.custom.JFindObjectPanel findVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDebe;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPagado;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lblTotalVenta;
    private javax.swing.JLabel lblVenta;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelTable;
    private com.toedter.calendar.JDateChooser pickerFecha;
    private javax.swing.JScrollPane scrollDetallesFormaPago;
    private javax.swing.JScrollPane scrollObservaciones;
    private javax.swing.JTable tableDetallesFormaPago;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JLabel txtDebe;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JLabel txtPagado;
    private javax.swing.JLabel txtTotalPagar;
    private javax.swing.JLabel txtTotalVenta;
    // End of variables declaration//GEN-END:variables


    public List<JComponent> getFormLabels() {
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblFecha);
		labels.add(lblCliente);
		labels.add(lblVenta);
		labels.add(lblObservaciones);
		
		//TODO
		return labels;
	}

	public List<JComponent> getFormInputs() {
		List<JComponent> inputs = new Vector<JComponent>();
		
		inputs.add(txtObservaciones);
		inputs.add(findVenta);
		inputs.add(txtCliente);
		inputs.add(txtObservaciones);
		inputs.add(txtTotalVenta);
		inputs.add(pickerFecha);
		inputs.add(findVenta);
		//TODO
		return inputs;
	}
	public void setPadding(JComponent component, Insets padding) {
		// TODO Auto-generated method stub
		
	}

	public void setFormBackground(Color bg) {
		// TODO Auto-generated method stub
		
	}

	public void tableChanged(TableModelEvent arg0) {
		
		//actualizamos el monto a pagar con el total de las formas de pago.
		Float montoPagar = 0F;
		for (Object item : detallesModel.getElements() ) {
			DetalleFormaPago detalle = (DetalleFormaPago)item;
			montoPagar += detalle.getMonto();
		}
		
		txtTotalPagar.setText( AppUtils.formatMoneda( montoPagar ) );
		
		//si total pagar es mayor a lo que se debe en la venta, avisamos con un mensajes.
		
		
	}

	public Object getObjectCreated() {
		
		return pago;
	}

	public boolean isAcepted() {
		// TODO Auto-generated method stub
		return false;
	}

	public void open(Object relatedObject) {
		
		this.ventaPagar = (Venta)relatedObject;
		
		clearInputs();
		
		show();
		setVisible(true);
		//clearInputs();
		
		moveToFront();
		
		try {
			setSelected(true);
			setIcon(false);
			//setMaximum(true);
		} catch (PropertyVetoException e) {			
			e.printStackTrace();
		}

    	
    	
	}


	public void initRightClickMenu(){
		
		tableDetallesFormaPago.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        	
	            int r = tableDetallesFormaPago.rowAtPoint(e.getPoint());
	            if (r >= 0 && r < tableDetallesFormaPago.getRowCount()) {
	            	tableDetallesFormaPago.setRowSelectionInterval(r, r);
	            } else {
	            	tableDetallesFormaPago.clearSelection();
	            }

	            int rowindex = tableDetallesFormaPago.getSelectedRow();
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
	
		
	public void valueChanged(ListSelectionEvent e) {
		// extra messages.
		if (e.getValueIsAdjusting()) {
			return;
		}

		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		if (!lsm.isSelectionEmpty()) {
			//tomo el elemento actual.
			filaSeleccionada = tableDetallesFormaPago.getSelectedRow();
			//avisamos a los listeners.
			//alertListenersSelectionChange(selectedObject);
		}else{
			//avisamos a los listeners.
			filaSeleccionada = null;
		}

	}

	private void doCancelar(){
		//this.dispose();
		setVisible(false);
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
			Pago pago = getObjectFromUI();
			
			UIServiceFactory.getUIPagoService().addObject(pago);
			
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

	private Pago getObjectFromUI() {
		
		pago.setFecha( pickerFecha.getDate() );
		pago.setObservaciones( txtObservaciones.getText() );
		
		//agregamos los detalles de forma de pago.
		Float monto = 0F;
		for (DetalleFormaPago detalle: detallesController.getDetalles()) {
			monto += detalle.getMonto();
			pago.addDetalle(detalle);
		}
		
		pago.setSucursal( (Sucursal)cmbSucursal.getSelectedItem() );
		pago.setCliente( ventaPagar.getCliente() );
		pago.setMonto( monto );
		
		//agregamos el detalle del pago con la venta a pagar.
		pago.addDetalle( ventaPagar.pagate( monto ) );
		
		return pago;
	}


	public List<InputValidator> getValidators() {

		List<InputValidator> validators = new ArrayList<InputValidator>();
		
		validators.add( required );
		
		return validators;
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
			element.objectCreated( getPago() );			
		}
	}

	/**
	 * @return the pago
	 */
	public Pago getPago() {
		return pago;
	}

	/**
	 * @param pago the pago to set
	 */
	public void setPago(Pago pago) {
		this.pago = pago;
	}
}
