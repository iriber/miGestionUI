/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.operaciones.ventas.panel;

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

import com.migestion.model.Venta;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.ui.AppUtils;
import com.migestion.ui.swing.i18n.utils.EnumUtils;
import com.migestion.ui.swing.operaciones.ventas.UIDetalleVentaCollection;
import com.migestion.ui.swing.operaciones.ventas.panel.detalles.DetalleVentaTableController;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;

/**
 *
 * @author bernardo
 */
public class VentaPanel extends javax.swing.JPanel implements ISkinForm,Serializable, IDialogViewAdapter, IDialogDeleteAdapter, TableModelListener{

	private InputRequiredValidator required;
    
    private Venta venta;

    private DetalleVentaTableController controller;
    
    /**
     * Creates new form RemitoPanel
     */
    public VentaPanel() {
    	
    	initVenta();
    	
        initComponents();
        
        SkinDecorator.getInstance().decorate(this);
        
        Dimension minimumSize = new Dimension(700, 400);
		setMinimumSize(minimumSize);
		
		loadCombos();
		
		initTableProductos();

    }

    private void initVenta() {
		
    	venta = new Venta();
    	
	}
    
    private void initTableProductos(){
    	
    	
    	UIDetalleVentaCollection model = new UIDetalleVentaCollection("Detalles", false);
		model.addTableModelListener(this);
		model.setElements(  venta.getDetalles() );

		controller = new DetalleVentaTableController(model);
		model.addTableModelListener( tableProductos );

		tableProductos.setModel(model);
		TableCellRenderer renderer = model.getTableCellRenderer();
		TableCellRenderer headerRenderer = model.getTableHeaderRenderer();
		for(int columnIndex=0; columnIndex < model.getColumnCount(); columnIndex++){
			tableProductos.setDefaultRenderer(model.getColumnClass(columnIndex), renderer);
			tableProductos.getColumnModel().getColumn(columnIndex).setHeaderRenderer( headerRenderer );
		}
		
		model.initColumnsWidth( tableProductos );
		
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
        lblVendedor = new javax.swing.JLabel();
        lblProductos = new javax.swing.JLabel();
        lblFormaEntrega = new javax.swing.JLabel();
        scrollProductos = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        lblDebe = new javax.swing.JLabel();
        txtDebe = new javax.swing.JLabel();
        lblSucursal = new javax.swing.JLabel();
        scrollObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        lblObservaciones = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtFormaEntrega = new javax.swing.JTextField();
        txtSucursal = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        lblPagado = new javax.swing.JLabel();
        txtPagado = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente");

        lblVendedor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVendedor.setText("Vendedor");

        lblProductos.setText("Productos");

        lblFormaEntrega.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFormaEntrega.setText("Forma entrega");

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tableProductos.setColumnSelectionAllowed(true);
        tableProductos.getTableHeader().setReorderingAllowed(false);
        scrollProductos.setViewportView(tableProductos);
        tableProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblDebe.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblDebe.setForeground(new java.awt.Color(243, 28, 28));
        lblDebe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDebe.setText("Debe");

        txtDebe.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtDebe.setForeground(new java.awt.Color(243, 28, 28));
        txtDebe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDebe.setText("0.00");

        lblSucursal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSucursal.setText("Sucursal");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        scrollObservaciones.setViewportView(txtObservaciones);

        lblObservaciones.setText("Observaciones");

        txtVendedor.setText("jTextField1");

        txtCliente.setText("jTextField1");

        txtFormaEntrega.setText("jTextField1");

        txtSucursal.setText("jTextField1");

        txtFecha.setText("jTextField1");

        lblTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total");

        txtTotal.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotal.setText("0.00");

        lblPagado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblPagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPagado.setText("Pagado");

        txtPagado.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtPagado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtPagado.setText("0.00");

        txtEstado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado.setText("PAGADA");
        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblPagado)))
                                .addGap(18, 18, 18)
                                .addComponent(txtPagado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblProductos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFormaEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtFormaEntrega, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFormaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFormaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVendedor)
                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSucursal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal)
                            .addComponent(txtTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPagado)
                            .addComponent(txtPagado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDebe)
                            .addComponent(txtDebe)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDebe;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFormaEntrega;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPagado;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JScrollPane scrollObservaciones;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JLabel txtDebe;
    private javax.swing.JLabel txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFormaEntrega;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JLabel txtPagado;
    private javax.swing.JTextField txtSucursal;
    private javax.swing.JLabel txtTotal;
    private javax.swing.JTextField txtVendedor;
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
		txtVendedor.setEditable( false );
		txtSucursal.setEditable( false );
		txtFormaEntrega.setEditable( false );
		txtObservaciones.setEditable( false );
		
	}

	public void clearInputs() {
		
		txtFecha.setText( "" ) ;
		txtCliente.setText( "" ) ;
		txtVendedor.setText( "" ) ;
		txtSucursal.setText( "" ) ;
		txtFormaEntrega.setText( "" ) ;
		txtEstado.setText( "" );
		txtObservaciones.setText("");
		
		txtDebe.setText( "0.00" );
		txtDebe.setText( "0.00" );
		txtTotal.setText( "0.00" );
		
	}

	public void showObject(Object object) {

		clearInputs();
		
		venta = (Venta)object;
		txtFecha.setText( AppUtils.formatDate( venta.getFecha() ) );
		txtCliente.setText( venta.getCliente().toString() );
		
		if(venta.getVendedor() != null)
			txtVendedor.setText( venta.getVendedor().toString() );
		
		
		if(venta.getSucursal() != null)
			txtSucursal.setText( venta.getSucursal().toString() ) ;
			
		txtFormaEntrega.setText( "" ) ;
		txtObservaciones.setText( venta.getObservaciones() ) ;
		
		txtTotal.setText(AppUtils.formatMoneda( venta.getMonto() ) );
		
		if( venta.getMontoDebe() != null)
		txtDebe.setText(AppUtils.formatMoneda( venta.getMontoDebe() ) );
		
		if( venta.getMontoPagado() != null)
		txtPagado.setText(AppUtils.formatMoneda( venta.getMontoPagado() ) );
		
		txtEstado.setText( EnumUtils.getLabelFor( venta.getEstadoVenta() ) );
//		txtEstado.setBackground( venta.getEstadoVenta().getBg() );
//		txtEstado.setForeground( venta.getEstadoVenta().getFg() );
		initTableProductos();
		
	}
	public List<JComponent> getFormLabels() {
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblFecha);
		labels.add(lblCliente);
		labels.add(lblVendedor);
		labels.add(lblSucursal);
		labels.add(lblFormaEntrega);
		labels.add(lblObservaciones);
		labels.add(lblProductos);
		return labels;
	}

	public List<JComponent> getFormInputs() {
		List<JComponent> inputs = new Vector<JComponent>();
		
		inputs.add(scrollObservaciones);
		inputs.add(scrollProductos);
		inputs.add(txtObservaciones);
		inputs.add(txtFecha);
		inputs.add(txtCliente);
		inputs.add(txtVendedor);
		inputs.add(txtFormaEntrega);
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
