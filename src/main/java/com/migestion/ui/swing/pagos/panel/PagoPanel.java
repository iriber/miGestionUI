/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.pagos.panel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;

import com.migestion.model.Pago;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.pagos.UIDetalleFormaPagoCollection;
import com.migestion.ui.swing.pagos.UIDetallePagoCollection;
import com.migestion.ui.swing.pagos.panel.detalles.DetalleFormaPagoTableController;
import com.migestion.ui.swing.pagos.panel.detalles.DetallePagoTableController;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;

/**
 *
 * @author bernardo
 */
public class PagoPanel extends javax.swing.JPanel implements ISkinForm,Serializable, IDialogViewAdapter, IDialogDeleteAdapter, TableModelListener{

	private InputRequiredValidator required;
    
    private Pago pago;

    private DetallePagoTableController controllerDetallePago;
    private DetalleFormaPagoTableController controllerDetalleFormaPago;
    
    /**
     * Creates new form RemitoPanel
     */
    public PagoPanel() {
    	
    	initPago();
    	
        initComponents();
        
        SkinDecorator.getInstance().decorate(this);
        
        Dimension minimumSize = new Dimension(700, 400);
		setMinimumSize(minimumSize);
		
		loadCombos();
		
		initTableDetalles();

    }

    private void initPago() {
		
    	pago = new Pago();
    	
	}
    
    private void initTableDetalles(){
    
    	//detalles de pago
    	
    	UIDetallePagoCollection model = new UIDetallePagoCollection("Detalles", false);
		model.addTableModelListener(this);
		model.setElements(  pago.getDetallesPago() );

		controllerDetallePago = new DetallePagoTableController(model);
		model.addTableModelListener( tableDetallesPago );

		tableDetallesPago.setModel(model);
		TableCellRenderer renderer = model.getTableCellRenderer();
		TableCellRenderer headerRenderer = model.getTableHeaderRenderer();
		for(int columnIndex=0; columnIndex < model.getColumnCount(); columnIndex++){
			tableDetallesPago.setDefaultRenderer(model.getColumnClass(columnIndex), renderer);
			tableDetallesPago.getColumnModel().getColumn(columnIndex).setHeaderRenderer( headerRenderer );
		}
		
		model.initColumnsWidth( tableDetallesPago );

		
    	//detalles de forma de pago
    	
    	UIDetalleFormaPagoCollection modelFormaPago = new UIDetalleFormaPagoCollection("Detalles forma pago", false);
		modelFormaPago.addTableModelListener(this);
		modelFormaPago.setElements(  pago.getDetallesFormaPago() );

		controllerDetalleFormaPago = new DetalleFormaPagoTableController(modelFormaPago);
		modelFormaPago.addTableModelListener( tableDetallesFormaPago );

		tableDetallesFormaPago.setModel(modelFormaPago);
		for(int columnIndex=0; columnIndex < modelFormaPago.getColumnCount(); columnIndex++){
			tableDetallesFormaPago.setDefaultRenderer(modelFormaPago.getColumnClass(columnIndex), renderer);
			tableDetallesFormaPago.getColumnModel().getColumn(columnIndex).setHeaderRenderer( headerRenderer );
		}
		
		modelFormaPago.initColumnsWidth( tableDetallesFormaPago );

    }

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFecha = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();
        scrollObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        lblObservaciones = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtSucursal = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        tabbedDetalles = new javax.swing.JTabbedPane();
        panelDetallesPago = new javax.swing.JPanel();
        scrollDetallesPago = new javax.swing.JScrollPane();
        tableDetallesPago = new javax.swing.JTable();
        panelDetallesFormaPago = new javax.swing.JPanel();
        scrollDetallesFormaPago = new javax.swing.JScrollPane();
        tableDetallesFormaPago = new javax.swing.JTable();

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente");

        lblSucursal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSucursal.setText("Sucursal");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        scrollObservaciones.setViewportView(txtObservaciones);

        lblObservaciones.setText("Observaciones");

        txtCliente.setText("jTextField1");

        txtSucursal.setText("jTextField1");

        txtFecha.setText("jTextField1");

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total");

        txtTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("0.00");

        txtEstado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado.setText("PAGADA");
        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelDetallesPago.setLayout(new java.awt.BorderLayout());

        tableDetallesPago.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDetallesPago.setColumnSelectionAllowed(true);
        tableDetallesPago.getTableHeader().setReorderingAllowed(false);
        scrollDetallesPago.setViewportView(tableDetallesPago);
        tableDetallesPago.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelDetallesPago.add(scrollDetallesPago, java.awt.BorderLayout.CENTER);

        tabbedDetalles.addTab("Operaciones pagadas", panelDetallesPago);

        panelDetallesFormaPago.setLayout(new java.awt.BorderLayout());

        tableDetallesFormaPago.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDetallesFormaPago.getTableHeader().setReorderingAllowed(false);
        scrollDetallesFormaPago.setViewportView(tableDetallesFormaPago);
        tableDetallesFormaPago.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        panelDetallesFormaPago.add(scrollDetallesFormaPago, java.awt.BorderLayout.CENTER);

        tabbedDetalles.addTab("Formas de pago", panelDetallesFormaPago);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtSucursal)))
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrollObservaciones)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(548, 548, 548)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(175, 175, 175))
                                        .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabbedDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelDetallesFormaPago;
    private javax.swing.JPanel panelDetallesPago;
    private javax.swing.JScrollPane scrollDetallesFormaPago;
    private javax.swing.JScrollPane scrollDetallesPago;
    private javax.swing.JScrollPane scrollObservaciones;
    private javax.swing.JTabbedPane tabbedDetalles;
    private javax.swing.JTable tableDetallesFormaPago;
    private javax.swing.JTable tableDetallesPago;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtSucursal;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
    
    
    public Container getDeleteMsgPanel() {
		
		this.setEditable( false );
		
		return this;
	}

	public Container getViewPanel() {
		
		this.setEditable( false );
		
		return this;
	}
	

	public Container getInputPanel() {
		return this;
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

	}

	public void setEditable( Boolean editable ){
		
		txtFecha.setEditable( false );
		txtCliente.setEditable( false );
		txtSucursal.setEditable( false );
		txtObservaciones.setEditable( false );
		
	}

	public void clearInputs() {
		
		txtFecha.setText( "" ) ;
		txtCliente.setText( "" ) ;
		txtSucursal.setText( "" ) ;
		txtEstado.setText( "" );
		txtObservaciones.setText("");
		
		txtTotal.setText( "0.00" );
		
	}

	public void showObject(Object object) {

		clearInputs();
		
		pago = (Pago)object;
		txtFecha.setText( AppUtils.formatDate( pago.getFecha() ) );
		txtCliente.setText( pago.getCliente().toString() );
		
		txtSucursal.setText( "" ) ;
		txtObservaciones.setText( pago.getObservaciones() ) ;
		
		txtTotal.setText(AppUtils.formatMoneda( pago.getMonto() ) );
		
		txtEstado.setText( I18nMessages.locale( pago.getEstadoPago().getNombre() ) );
//		txtEstado.setBackground( pago.getEstadoPago().getBg() );
//		txtEstado.setForeground( pago.getEstadoPago().getFg() );
		initTableDetalles();
		
	}
	public List<JComponent> getFormLabels() {
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblFecha);
		labels.add(lblCliente);
		labels.add(lblSucursal);
		labels.add(lblObservaciones);
		return labels;
	}

	public List<JComponent> getFormInputs() {
		List<JComponent> inputs = new Vector<JComponent>();
		
		inputs.add(scrollObservaciones);
		inputs.add(scrollDetallesPago);
		inputs.add(txtObservaciones);
		inputs.add(txtFecha);
		inputs.add(txtCliente);
		inputs.add(txtSucursal);
		
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
	}

	public void tableChanged(TableModelEvent arg0) {
		
		// TODO actualizamos los totales.
		
	}
}