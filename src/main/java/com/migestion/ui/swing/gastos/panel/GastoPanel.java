/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.gastos.panel;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;

import com.migestion.model.Cheque;
import com.migestion.model.ConceptoMovimiento;
import com.migestion.model.CuentaBancaria;
import com.migestion.model.Gasto;
import com.migestion.model.GastoCheque;
import com.migestion.model.GastoCuentaBancaria;
import com.migestion.model.GastoEfectivo;
import com.migestion.model.Sucursal;
import com.migestion.model.TipoFactura;
import com.migestion.model.Vendedor;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.ComboEnumElement;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.view.dialogs.adapters.IDialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JComboBoxInspector;
import com.migestion.swing.view.inputs.JDateChooserInspector;
import com.migestion.swing.view.inputs.JFindObjectInspector;
import com.migestion.swing.view.inputs.JTextFieldInspector;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIConceptoMovimientoCriteria;
import com.migestion.ui.criteria.UISucursalCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.finder.FinderFactory;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 *
 * @author bernardo
 */
public class GastoPanel extends javax.swing.JPanel implements IDialogAddAdapter, IDialogViewAdapter, IDialogDeleteAdapter{

	private InputRequiredValidator required;
    
    private Gasto gasto;
    
    /**
     * Creates new form GastoPanel
     */
    public GastoPanel() {

        initComponents();
        
    	initGasto();

    	initValidators();
        
		loadCombos();
    }
    
    private void loadCombos() {
    	
		 try {
		
			 UIConceptoMovimientoCriteria criteria = new UIConceptoMovimientoCriteria();
			 UICollection conceptos = UIServiceFactory.getUIConceptoMovimientoService().list( criteria );
			 ComboModel model = new ComboModel();
			 model.setElementos(conceptos.getElements());
			 cmbConcepto.setModel(model);

		 } catch (ControllerException e) {
			 e.printStackTrace();
		 }

		 try {

			 UISucursalCriteria criteria = new UISucursalCriteria();
			 UICollection sucursales =
			 UIServiceFactory.getUISucursalService().list( criteria );
			 ComboModel model = new ComboModel();
			 model.setElementos(sucursales.getElements());
			 cmbSucursal.setModel(model);
			 
		} catch (ControllerException e) {
			 e.printStackTrace();
		}
		 
		 
		 
	}

	private void initGasto() {
		
		this.gasto = new GastoEfectivo();
		
//		if( rdBtnEfectivo.isSelected() ){
//			
//			this.gasto = new GastoEfectivo();
//	        findCuenta.setEditable(false);
//	        findCheque.setEditable(false);
//	        
//		}else if( rdBtnCuentaBancaria.isSelected() ){
//			
//			this.gasto = new GastoCuentaBancaria();
//	        findCuenta.setEditable(true);
//	        findCheque.setEditable(false);
//	        
//		}else if( rdBtnCheque.isSelected() ){
//			
//			this.gasto = new GastoCuentaBancaria();
//	        findCuenta.setEditable(false);
//	        findCheque.setEditable(true);
//	        
//		}
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFormaPago = new javax.swing.ButtonGroup();
        lblFecha = new javax.swing.JLabel();
        pickerFecha = new com.toedter.calendar.JDateChooser();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        lblConcepto = new javax.swing.JLabel();
        cmbConcepto = new javax.swing.JComboBox();
        lblObservaciones = new javax.swing.JLabel();
        scrollObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        lblFormaPago = new javax.swing.JLabel();
        rdBtnEfectivo = new javax.swing.JRadioButton();
        rdBtnCheque = new javax.swing.JRadioButton();
        rdBtnCuentaBancaria = new javax.swing.JRadioButton();
        findCuenta = FinderFactory.getFindCuentaBancaria( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

            }
        });
        findCheque = FinderFactory.getFindCheque( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

            }
        });
        lblSucursal = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();
        lblVendedor = new javax.swing.JLabel();
        findVendedor = FinderFactory.getFindVendedor( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

            }
        });
        lblIva = new javax.swing.JLabel();
        txtIva = new javax.swing.JFormattedTextField();
        lblRetencionIIBB = new javax.swing.JLabel();
        txtRetencionIIBB = new javax.swing.JFormattedTextField();
        lblTipoFactura = new javax.swing.JLabel();
        cmbTipoFactura = new javax.swing.JComboBox();

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblMonto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMonto.setText("Monto");

        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblConcepto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConcepto.setText("Concepto");

        cmbConcepto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblObservaciones.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblObservaciones.setText("Observaciones");

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        scrollObservaciones.setViewportView(txtObservaciones);

        lblFormaPago.setText("Forma de pago");

        buttonGroupFormaPago.add(rdBtnEfectivo);
        rdBtnEfectivo.setText("Efectivo");
        rdBtnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnEfectivoActionPerformed(evt);
            }
        });
        rdBtnEfectivo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rdBtnEfectivoPropertyChange(evt);
            }
        });

        buttonGroupFormaPago.add(rdBtnCheque);
        rdBtnCheque.setText("Cheque");
        rdBtnCheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnChequeActionPerformed(evt);
            }
        });
        rdBtnCheque.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rdBtnChequePropertyChange(evt);
            }
        });

        buttonGroupFormaPago.add(rdBtnCuentaBancaria);
        rdBtnCuentaBancaria.setText("Cuenta bancaria");
        rdBtnCuentaBancaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnCuentaBancariaActionPerformed(evt);
            }
        });
        rdBtnCuentaBancaria.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                rdBtnCuentaBancariaPropertyChange(evt);
            }
        });

        lblSucursal.setText("Sucursal");

        cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblVendedor.setText("Vendedor");

        lblIva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIva.setText("Iva");

        txtIva.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblRetencionIIBB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRetencionIIBB.setText("Retención IIBB");

        txtRetencionIIBB.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtRetencionIIBB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lblTipoFactura.setText("Tipo Factura");

        cmbTipoFactura.setModel( getTipoFacturasModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdBtnCuentaBancaria)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(rdBtnCheque)
                                .addComponent(rdBtnEfectivo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(findCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(findCheque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFormaPago)
                            .addComponent(lblObservaciones)
                            .addComponent(lblConcepto)
                            .addComponent(lblFecha)
                            .addComponent(lblSucursal)
                            .addComponent(lblVendedor)
                            .addComponent(lblMonto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(findVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbSucursal, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbConcepto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pickerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblTipoFactura)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblRetencionIIBB)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRetencionIIBB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollObservaciones, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(lblFecha))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoFactura)))
                    .addComponent(pickerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto)
                    .addComponent(lblIva)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRetencionIIBB)
                    .addComponent(txtRetencionIIBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConcepto)
                    .addComponent(cmbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSucursal)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblVendedor)
                    .addComponent(findVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservaciones)
                    .addComponent(scrollObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(lblFormaPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdBtnEfectivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rdBtnCheque)
                    .addComponent(findCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rdBtnCuentaBancaria)
                    .addComponent(findCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private ComboBoxModel getTipoFacturasModel() {
        //cargar tipos de facturas
        List tipos = new ArrayList();
       	for (TipoFactura object : TipoFactura.values()){
       		
       		ComboEnumElement tipo = new ComboEnumElement(object, I18nMessages.locale( object.getNombre() ));
			tipos.add(tipo);	
       	}
       	
        ComboModel model = new ComboModel();
        model.setElementos(tipos);

		return model;
	}

	private void rdBtnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnEfectivoActionPerformed
        
    }//GEN-LAST:event_rdBtnEfectivoActionPerformed

    private void rdBtnChequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnChequeActionPerformed
        
    }//GEN-LAST:event_rdBtnChequeActionPerformed

    private void rdBtnCuentaBancariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnCuentaBancariaActionPerformed
        
    }//GEN-LAST:event_rdBtnCuentaBancariaActionPerformed

    private void rdBtnChequePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rdBtnChequePropertyChange
        initGasto();
    }//GEN-LAST:event_rdBtnChequePropertyChange

    private void rdBtnEfectivoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rdBtnEfectivoPropertyChange
        initGasto();
    }//GEN-LAST:event_rdBtnEfectivoPropertyChange

    private void rdBtnCuentaBancariaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_rdBtnCuentaBancariaPropertyChange
        initGasto();
    }//GEN-LAST:event_rdBtnCuentaBancariaPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFormaPago;
    private javax.swing.JComboBox cmbConcepto;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JComboBox cmbTipoFactura;
    private com.migestion.swing.custom.JFindObjectPanel findCheque;
    private com.migestion.swing.custom.JFindObjectPanel findCuenta;
    private com.migestion.swing.custom.JFindObjectPanel findVendedor;
    private javax.swing.JLabel lblConcepto;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFormaPago;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblRetencionIIBB;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTipoFactura;
    private javax.swing.JLabel lblVendedor;
    private com.toedter.calendar.JDateChooser pickerFecha;
    private javax.swing.JRadioButton rdBtnCheque;
    private javax.swing.JRadioButton rdBtnCuentaBancaria;
    private javax.swing.JRadioButton rdBtnEfectivo;
    private javax.swing.JScrollPane scrollObservaciones;
    private javax.swing.JFormattedTextField txtIva;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JFormattedTextField txtRetencionIIBB;
    // End of variables declaration//GEN-END:variables
    
	public Container getInputPanel() {
		initGasto();
		clearInputs();
		return this;
	}

	public Object getObjectFromUI() throws ViewException {
		
		
		if( rdBtnEfectivo.isSelected() ){
			gasto = new GastoEfectivo();
			((GastoEfectivo)gasto).setCaja( AppContext.getInstance().getCajaDefault() );
			
		}else if( rdBtnCuentaBancaria.isSelected() ){
			gasto = new GastoCuentaBancaria();
			((GastoCuentaBancaria)gasto).setCuentaBancaria( (CuentaBancaria)findCuenta.getObjectFound() );
			
		}else if( rdBtnCheque.isSelected() ){
			gasto = new GastoCheque();
			((GastoCheque)gasto).setCheque( (Cheque)findCheque.getObjectFound() );
			
		}
		gasto.setVendedor( (Vendedor)findVendedor.getObjectFound() );
		gasto.setSucursal( (Sucursal)cmbSucursal.getSelectedItem() );
		gasto.setMonto( ((Number)txtMonto.getValue()).floatValue()  );
		gasto.setFecha( pickerFecha.getDate() );
		gasto.setObservaciones( txtObservaciones.getText() );
		gasto.setConcepto( (ConceptoMovimiento)cmbConcepto.getSelectedItem() );
		
		return gasto;
	}

	public List<InputValidator> getValidators() {

		initValidators();
		
		List<InputValidator> validators = new ArrayList<InputValidator>();
		
		validators.add( required );
		
		return validators;
	}

	public void clearInputs() {

		txtMonto.setValue(null);
		txtObservaciones.setText("");
		pickerFecha.setDate(new Date());
		
		//rdBtnEfectivo.setSelected(true);
		
		cmbTipoFactura.setSelectedItem( TipoFactura.C );
		
		txtIva.setValue(21F);
		txtRetencionIIBB.setValue(0F);
		
	}

	private void initValidators() {
		
		if( required!=null)
			required.reset();
		
		required = new InputRequiredValidator(); 
		required.put(lblFecha, pickerFecha, new JDateChooserInspector());
		required.put(lblMonto, txtMonto, new JTextFieldInspector());
		required.put(lblConcepto, cmbConcepto, new JComboBoxInspector());
		required.put(lblRetencionIIBB, txtRetencionIIBB, new JTextFieldInspector());
		required.put(lblIva, txtIva, new JTextFieldInspector());
		required.put(lblTipoFactura, cmbTipoFactura, new JComboBoxInspector());
		
		if( rdBtnCheque.isSelected() ){
			required.put(lblFormaPago, findCheque, new JFindObjectInspector());
				
		}
		
		if( rdBtnCuentaBancaria.isSelected() ){
			required.put(lblFormaPago, findCuenta, new JFindObjectInspector());
				
		}
		
		required.setMessage(I18nMessages.INGRESE_REQUERIDOS);
		required.initialize();
		
	}

	public Container getViewPanel() {
		
		setEditable(false);
		return this;
	}

	public void setEditable( Boolean editable ){
		
		txtMonto.setEditable( false );
		txtIva.setEditable( false );
		txtRetencionIIBB.setEditable( false );
		txtObservaciones.setEditable( false );
		findCuenta.setEditable( false );
		findCheque.setEditable( false );
		findVendedor.setEditable( false );
		cmbSucursal.setEditable( false );
		pickerFecha.setEnabled( false );
		cmbConcepto.setEditable( false );
		rdBtnEfectivo.setEnabled( false );
		rdBtnCuentaBancaria.setEnabled( false );
		rdBtnCheque.setEnabled( false );
		
	}

	public void showObject(Object object) {
		
		clearInputs();
		
		gasto = (Gasto)object;
		
		
		txtMonto.setValue( gasto.getMonto() );
		txtIva.setValue( gasto.getIva() );
		txtRetencionIIBB.setValue( gasto.getRentencionIIBB() );
		txtObservaciones.setText( gasto.getObservaciones() );
		
		rdBtnEfectivo.setSelected(true);
		
		try {
			findCuenta.objectFound( ((GastoCuentaBancaria)gasto).getCuentaBancaria() );
			rdBtnCuentaBancaria.setSelected(true);
		} catch (Exception e) {
		}

		try{
			findCheque.objectFound( ((GastoCheque)gasto).getCheque() );
			rdBtnCheque.setSelected(true);
		} catch (Exception e) {
		}

		
		findVendedor.objectFound( gasto.getVendedor() );
		cmbSucursal.setSelectedItem( gasto.getSucursal());
		pickerFecha.setDate( gasto.getFecha() );
		cmbConcepto.setSelectedItem( gasto.getMovimiento().getConcepto() );
	}

	public Container getDeleteMsgPanel() {
		this.setEditable( false );
		return this;
	}
}
