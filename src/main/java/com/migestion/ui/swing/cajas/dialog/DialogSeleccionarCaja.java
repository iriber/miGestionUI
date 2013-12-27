/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.cajas.dialog;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.migestion.model.Caja;
import com.migestion.model.EstadoCaja;
import com.migestion.model.Sucursal;
import com.migestion.model.ValoresPredefinidos;
import com.migestion.model.Vendedor;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.i18n.buttons.ButtonImagesBundle;
import com.migestion.swing.i18n.buttons.ButtonLabelsBundle;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.utils.FormatUtils;
import com.migestion.swing.view.dialogs.DialogMessage;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputFloatValidator;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JComboBoxInspector;
import com.migestion.swing.view.inputs.JDateChooserInspector;
import com.migestion.swing.view.inputs.JTextFieldInspector;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UICajaCriteria;
import com.migestion.ui.criteria.UISucursalCriteria;
import com.migestion.ui.criteria.UIVendedorCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.FrameMenuInicial;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 *
 * @author bernardo
 */
public class DialogSeleccionarCaja extends javax.swing.JDialog {

	private InputRequiredValidator required;
    private InputFloatValidator floatFormat;
    private Caja cajaSeleccionada;
	
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form DialogSeleccionarCaja
     */
    public DialogSeleccionarCaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
                
            }
        });
        
       
        initCustom();
    }

    private void initCustom() {
    	 
    	setTitle( I18nMessages.TITULO_MAIN );
    	initValidators();
         
    	loadCombos();
        
    	clearInputs();
    	
    	txtNumero.setText("1");
    	txtSaldoInicial.setValue( ValoresPredefinidos.CAJA_SALDO_INICIAL);
    	
    	//si no hay cajas abiertas seteamos default el tab para agregar una nueva.
    	if( cmbCajas.getModel().getSize() == 0 ){
    		
    		jTabbedPane1.setSelectedIndex(1);
    		
    	}else{
    		jTabbedPane1.setSelectedIndex(0);
    	}
    	
    	lblLogo.setImage(new ImageIcon( I18nImages.LOGO ), true);
    	
    	pack();
        
    	Date fecha = new Date();
    	String diaNumero = FormatUtils.format( fecha, "d" );
    	String diaNombre = FormatUtils.format( fecha, "EEEE" );
    	String mesNombre = FormatUtils.format( fecha, "MMMM" );
    	String anio = FormatUtils.format( fecha, "yyyy" );
    	
    	lblDia.setText( diaNombre + " " + diaNumero );
    	lblMesAnio.setText( mesNombre + " " + anio );
    	
//    	DateFormat formatFull = DateFormat.getDateInstance(DateFormat.FULL);
//    	lblDia.setText( formatFull.format(fecha) );
	}

	private void loadCombos() {
		
//    	//cargo las cajas abiertas en la sucursal del contexto.
//    	try {
//
//    		//TODO filtrar por sucursal.
//			UICajaCriteria criteria = new UICajaCriteria();
//			criteria.addEstado( EstadoCaja.ABIERTA );
//			UICollection cajasAbiertas = UIServiceFactory.getUICajaService().list( criteria );
//			ComboModel model = new ComboModel();
//	        model.setElementos(cajasAbiertas.getElements());
//	        cmbCajas.setModel(model);
//	        cmbCajas.setSelectedItem( AppContext.getInstance().getCajaDefault() );
//	        
//		} catch (ControllerException e) {
//			e.printStackTrace();
//		}
//    	
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
	        cmbCajero.setModel(model);
	        cmbCajero.setSelectedItem( AppContext.getInstance().getVendedorDefault() );
	        
		} catch (ControllerException e) {
			e.printStackTrace();
		}
    	
    	
	}

	/**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cmbCajas = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pickerDate = new com.toedter.calendar.JDateChooser();
        lblFecha = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        lblSucursal = new javax.swing.JLabel();
        cmbSucursal = new javax.swing.JComboBox();
        lblCajero = new javax.swing.JLabel();
        cmbCajero = new javax.swing.JComboBox();
        lblSaldoInicial = new javax.swing.JLabel();
        txtSaldoInicial = new javax.swing.JFormattedTextField();
        btnAgregar = new javax.swing.JButton();
        cancelButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLogo = new com.migestion.swing.custom.JImageLabel();
        lblDia = new javax.swing.JLabel();
        lblMesAnio = new javax.swing.JLabel();

        setTitle("Mi Gestión / Iniciando sistema");
        setBackground(new java.awt.Color(201, 229, 246));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Elija una caja para operar");

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        cmbCajas.setModel( getCajasModel() );
        cmbCajas.setSelectedItem( AppContext.getInstance().getCajaDefault() );
        cmbCajas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbCajasPropertyChange(evt);
            }
        });

        okButton.setText(ButtonLabelsBundle.btn_Ok);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(ButtonLabelsBundle.btn_Cancel);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(cmbCajas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(323, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);
        okButton.setToolTipText(ButtonLabelsBundle.btn_Ok_ToolTipText);
        okButton.setIcon(new ImageIcon(ButtonImagesBundle.btn_Ok));
        okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        okButton.setMnemonic(java.awt.event.KeyEvent.VK_ENTER);
        cancelButton.setToolTipText(ButtonLabelsBundle.btn_Cancel_ToolTipText);
        cancelButton.setIcon(new ImageIcon(ButtonImagesBundle.btn_Cancel));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.setMnemonic(java.awt.event.KeyEvent.VK_ESCAPE);

        jTabbedPane1.addTab("Cajas abiertas", jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pickerDate.setDate(new Date());
        pickerDate.setNextFocusableComponent(txtNumero);

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha");

        lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumero.setText("Número");

        lblSucursal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSucursal.setText("Sucursal");

        cmbSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCajero.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCajero.setText("Cajero");

        cmbCajero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSaldoInicial.setText("Saldo inicial");

        txtSaldoInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtSaldoInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnAgregar.setText(ButtonLabelsBundle.btn_Ok);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cancelButton1.setText(ButtonLabelsBundle.btn_Cancel);
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSaldoInicial)
                            .addComponent(lblCajero)
                            .addComponent(lblSucursal)
                            .addComponent(lblFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                            .addComponent(cmbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCajero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSaldoInicial))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblFecha)
                    .addComponent(pickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCajero)
                    .addComponent(cmbCajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSaldoInicial)
                    .addComponent(txtSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(cancelButton1))
                .addContainerGap())
        );

        btnAgregar.setToolTipText(ButtonLabelsBundle.btn_Ok_ToolTipText);
        btnAgregar.setIcon(new ImageIcon(ButtonImagesBundle.btn_Ok));
        btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregar.setMnemonic(java.awt.event.KeyEvent.VK_ENTER);
        cancelButton1.setToolTipText(ButtonLabelsBundle.btn_Cancel_ToolTipText);
        cancelButton1.setIcon(new ImageIcon(ButtonImagesBundle.btn_Cancel));
        cancelButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton1.setMnemonic(java.awt.event.KeyEvent.VK_ESCAPE);

        jTabbedPane1.addTab("Nueva caja", jPanel1);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Software de gestión para PYMES y Autónomos");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Mi Gestión");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblDia.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        lblDia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDia.setText("Miércoles 11");

        lblMesAnio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMesAnio.setText("Diciembre 2013");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMesAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMesAnio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ComboBoxModel getCajasModel() {
    	
		ComboModel model = new ComboModel();
		try {
			UICajaCriteria criteria = new UICajaCriteria();
			criteria.addEstado( EstadoCaja.ABIERTA );
			criteria.setFecha( new Date() );
			UICollection cajasAbiertas= UIServiceFactory.getUICajaService().list( criteria );
			model.setElementos(cajasAbiertas.getElements());	
		} catch (ControllerException e) {
			e.printStackTrace();
		}
        return model;
	}

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        seleccionarDelCombo();
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        seleccionarCajaNueva();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbCajasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbCajasPropertyChange
        // TODO add your handling code here:
        
        cajaSeleccionada = (Caja)cmbCajas.getSelectedItem();
        
    }//GEN-LAST:event_cmbCajasPropertyChange

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        // TODO add your handling code here:
    	 doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButton1ActionPerformed
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        
        if( getReturnStatus() == DialogSeleccionarCaja.RET_OK ){
    		
        	if(cajaSeleccionada!=null){
        		
        		AppContext.getInstance().setCajaDefault(cajaSeleccionada);	
        		AppContext.getInstance().setVendedorDefault(cajaSeleccionada.getCajero());
        		AppContext.getInstance().setSucursalDefault(cajaSeleccionada.getSucursal());
        		//pasar a ventana para seleccionar sucursal y vendedor.
            	//TODO la caja ya tiene sucursal y vendedor!
        				
        		FrameMenuInicial frame = new FrameMenuInicial();
        		frame.open();		

        		setVisible(false);
                dispose();

        	}else{
        		
        		DialogMessage.showErrorMessage(getTitle(), "Debe seleccionar una caja para continuar");
        	}
        	
        	
	    }else{
			
			System.exit(0);
			
		}
    }
    
    private void seleccionarDelCombo(){
    	cajaSeleccionada = (Caja)cmbCajas.getSelectedItem();    	
    }
    
    private void seleccionarCajaNueva(){
    	
    	//creamos la caja
    	try {
			
			validateInput();
			
			Caja caja = new Caja();
			caja.setCajero( (Vendedor) cmbCajero.getSelectedItem() );
			caja.setSucursal( (Sucursal) cmbSucursal.getSelectedItem() );
			caja.setNumero( txtNumero.getText() );
			caja.setFecha( pickerDate.getDate() );
			caja.setSaldoInicial( ((Number)txtSaldoInicial.getValue()).floatValue() );
			
			UIServiceFactory.getUICajaService().addObject(caja);
			
			UICajaCriteria criteria = new UICajaCriteria();
			criteria.addEstado( EstadoCaja.ABIERTA );
			UICollection cajasAbiertas = UIServiceFactory.getUICajaService().list( criteria );
			ComboModel model = new ComboModel();
	        model.setElementos(cajasAbiertas.getElements());
	        cmbCajas.setModel(model);
	        cmbCajas.setSelectedItem( caja );
			
	        cajaSeleccionada = caja;
	        
	        doClose(RET_OK);
	        
		} catch (ViewException ex) {
		
			DialogMessage.showErrorMessage(getTitle(), ex.getMessage());
			
		} catch (ControllerException ex) {
			
			DialogMessage.showErrorMessage(getTitle(), ex.getMessage());
		}
    }

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
            java.util.logging.Logger.getLogger(DialogSeleccionarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogSeleccionarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogSeleccionarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogSeleccionarCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogSeleccionarCaja dialog = new DialogSeleccionarCaja(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JComboBox cmbCajas;
    private javax.swing.JComboBox cmbCajero;
    private javax.swing.JComboBox cmbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCajero;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private com.migestion.swing.custom.JImageLabel lblLogo;
    private javax.swing.JLabel lblMesAnio;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblSaldoInicial;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JButton okButton;
    private com.toedter.calendar.JDateChooser pickerDate;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtSaldoInicial;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;


    private void initValidators() {
		
		required = new InputRequiredValidator(); 
		required.put(lblNumero, txtNumero, new JTextFieldInspector());
		required.put(lblSaldoInicial, txtSaldoInicial, new JTextFieldInspector());
		required.put(lblSucursal, cmbSucursal, new JComboBoxInspector());
		required.put(lblCajero, cmbCajero, new JComboBoxInspector());
		required.put(lblFecha, pickerDate, new JDateChooserInspector());
		required.setMessage(I18nMessages.INGRESE_REQUERIDOS);
		required.initialize();
		
		floatFormat = new InputFloatValidator();
		floatFormat.put(lblSaldoInicial, txtSaldoInicial, new JTextFieldInspector());
		floatFormat.setMessage(I18nMessages.FORMATO_FLOAT_INVALIDO);
		floatFormat.initialize();
		
	}

	
	public List<InputValidator> getValidators() {
		
		List<InputValidator> validators = new ArrayList<InputValidator>();
		
		validators.add( required );
		validators.add( floatFormat );
		
		return validators;
	}

	public void clearInputs() {
		txtNumero.setText( "" );
		txtSaldoInicial.setText( "" );
		pickerDate.setDate( new Date() );
		
		
	}

	protected void validateInput() throws ViewException {
		
		List<InputValidator> validators = getValidators( );

		for (InputValidator validator : validators) {
			validator.clean();
		}

		for (InputValidator validator : validators) {
			if( !validator.validate() )				
				throw new ViewException( validator.getMessage() );
		}
	}

}
