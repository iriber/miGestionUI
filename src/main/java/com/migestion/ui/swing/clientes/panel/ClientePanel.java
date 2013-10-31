/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.migestion.ui.swing.clientes.panel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;

import com.migestion.model.Cliente;
import com.migestion.model.CondicionIVA;
import com.migestion.model.TipoCliente;
import com.migestion.model.TipoDocumento;
import com.migestion.swing.custom.ComboEnumElement;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.view.dialogs.adapters.IDialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogUpdateAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JTextFieldInspector;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.i18n.utils.EnumUtils;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author bernardo
 */
public class ClientePanel extends javax.swing.JPanel  implements ISkinForm,Serializable, IDialogAddAdapter, IDialogUpdateAdapter, IDialogViewAdapter, IDialogDeleteAdapter{

    private InputRequiredValidator required;
    
    private Cliente cliente;

    /**
     * Creates new form ClientePanel
     */
    public ClientePanel() {
    	
    	initCliente();
    	
        initComponents();
        
        initValidators();
        
        SkinDecorator.getInstance().decorate(this);
        
        Dimension minimumSize = new Dimension(1200, 400);
		setMinimumSize(minimumSize);
		setPreferredSize(minimumSize);
		loadCombos();
		
    }

    private void initCliente() {
		this.cliente = new Cliente();
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelDatosPersonales = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFijo = new javax.swing.JLabel();
        txtTelefonoFijo = new javax.swing.JTextField();
        txtMovil = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDomicilio = new javax.swing.JTextArea();
        lblTipoDoc = new javax.swing.JLabel();
        cmbTipoDoc = new javax.swing.JComboBox();
        lblNroDoc = new javax.swing.JLabel();
        txtNroDoc = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContacto = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTipoCliente = new javax.swing.JLabel();
        cmbTipoCliente = new javax.swing.JComboBox();
        pickerNacimiento = new com.toedter.calendar.JDateChooser();
        jPanelFacturacion = new javax.swing.JPanel();
        lblCUIT = new javax.swing.JLabel();
        txtCUIT = new javax.swing.JTextField();
        lblCondicionIVA = new javax.swing.JLabel();
        cmbCondicionIVA = new javax.swing.JComboBox();
        lblDomicilioFacturacion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDomicilioFacturacion = new javax.swing.JTextArea();
        jPanelSocial = new javax.swing.JPanel();
        lblFacebook = new javax.swing.JLabel();
        txtFacebook = new javax.swing.JTextField();
        lblWeb = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        txtTwitter = new javax.swing.JTextField();
        txtLinkedin = new javax.swing.JTextField();
        lblTwitter = new javax.swing.JLabel();
        lblLinkedin = new javax.swing.JLabel();
        jPanelObservaciones = new javax.swing.JPanel();
        jScrollPaneObservaciones = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(596, 400));
        setPreferredSize(new java.awt.Dimension(700, 450));
        setLayout(new java.awt.GridLayout(1, 0));

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {20, 50, 334, 20};
        jPanelDatosPersonales.setLayout(jPanel1Layout);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanelDatosPersonales.add(lblNombre, gridBagConstraints);

        txtNombre.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(txtNombre, gridBagConstraints);

        lblFijo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFijo.setText("Teléfono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblFijo, gridBagConstraints);

        txtTelefonoFijo.setText("jTextField2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(txtTelefonoFijo, gridBagConstraints);

        txtMovil.setText("jTextField3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(txtMovil, gridBagConstraints);

        lblCelular.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCelular.setText("Celular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblCelular, gridBagConstraints);

        lblDomicilio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDomicilio.setText("Domicilio");
        lblDomicilio.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.4;
        jPanelDatosPersonales.add(lblDomicilio, gridBagConstraints);

        txtDomicilio.setColumns(20);
        txtDomicilio.setRows(5);
        jScrollPane1.setViewportView(txtDomicilio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.4;
        jPanelDatosPersonales.add(jScrollPane1, gridBagConstraints);

        lblTipoDoc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipoDoc.setText("Tipo documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblTipoDoc, gridBagConstraints);

        cmbTipoDoc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoDoc.setMinimumSize(new java.awt.Dimension(50, 28));
        cmbTipoDoc.setPreferredSize(new java.awt.Dimension(50, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(cmbTipoDoc, gridBagConstraints);

        lblNroDoc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNroDoc.setText("Nro Documento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblNroDoc, gridBagConstraints);

        txtNroDoc.setText("jTextField1");
        txtNroDoc.setMinimumSize(new java.awt.Dimension(100, 28));
        txtNroDoc.setPreferredSize(new java.awt.Dimension(100, 28));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(txtNroDoc, gridBagConstraints);

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblEmail, gridBagConstraints);

        txtEmail.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(txtEmail, gridBagConstraints);

        lblContacto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContacto.setText("Contacto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblContacto, gridBagConstraints);

        txtContacto.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(txtContacto, gridBagConstraints);

        lblFechaNacimiento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFechaNacimiento.setText("Fecha de nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblFechaNacimiento, gridBagConstraints);

        lblTipoCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTipoCliente.setText("Tipo de cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(lblTipoCliente, gridBagConstraints);

        cmbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(cmbTipoCliente, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelDatosPersonales.add(pickerNacimiento, gridBagConstraints);

        jTabbedPane.addTab("Datos personales", jPanelDatosPersonales);

        java.awt.GridBagLayout jPanel3Layout = new java.awt.GridBagLayout();
        jPanel3Layout.columnWidths = new int[] {20, 137, 334, 20};
        jPanelFacturacion.setLayout(jPanel3Layout);

        lblCUIT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCUIT.setText("CUIT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelFacturacion.add(lblCUIT, gridBagConstraints);

        txtCUIT.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelFacturacion.add(txtCUIT, gridBagConstraints);

        lblCondicionIVA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCondicionIVA.setText("Condición IVA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelFacturacion.add(lblCondicionIVA, gridBagConstraints);

        cmbCondicionIVA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCondicionIVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCondicionIVAActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelFacturacion.add(cmbCondicionIVA, gridBagConstraints);

        lblDomicilioFacturacion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDomicilioFacturacion.setText("Domicilio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelFacturacion.add(lblDomicilioFacturacion, gridBagConstraints);

        txtDomicilioFacturacion.setColumns(20);
        txtDomicilioFacturacion.setRows(5);
        jScrollPane2.setViewportView(txtDomicilioFacturacion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelFacturacion.add(jScrollPane2, gridBagConstraints);

        jTabbedPane.addTab("Facturación", jPanelFacturacion);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {20, 137, 334, 20};
        jPanelSocial.setLayout(jPanel2Layout);

        lblFacebook.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFacebook.setText("Facebook");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(lblFacebook, gridBagConstraints);

        txtFacebook.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(txtFacebook, gridBagConstraints);

        lblWeb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWeb.setText("Página web");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(lblWeb, gridBagConstraints);

        txtWeb.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(txtWeb, gridBagConstraints);

        txtTwitter.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(txtTwitter, gridBagConstraints);

        txtLinkedin.setText("jTextField1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(txtLinkedin, gridBagConstraints);

        lblTwitter.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTwitter.setText("Twitter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(lblTwitter, gridBagConstraints);

        lblLinkedin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLinkedin.setText("Linkedin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelSocial.add(lblLinkedin, gridBagConstraints);

        jTabbedPane.addTab("Social media", jPanelSocial);

        jPanelObservaciones.setLayout(new java.awt.BorderLayout());

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        jScrollPaneObservaciones.setViewportView(txtObservaciones);

        jPanelObservaciones.add(jScrollPaneObservaciones, java.awt.BorderLayout.CENTER);

        jTabbedPane.addTab("Observaciones", jPanelObservaciones);

        add(jTabbedPane);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCondicionIVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCondicionIVAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCondicionIVAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbCondicionIVA;
    private javax.swing.JComboBox cmbTipoCliente;
    private javax.swing.JComboBox cmbTipoDoc;
    private javax.swing.JPanel jPanelDatosPersonales;
    private javax.swing.JPanel jPanelFacturacion;
    private javax.swing.JPanel jPanelObservaciones;
    private javax.swing.JPanel jPanelSocial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneObservaciones;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel lblCUIT;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCondicionIVA;
    private javax.swing.JLabel lblContacto;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblDomicilioFacturacion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFacebook;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFijo;
    private javax.swing.JLabel lblLinkedin;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNroDoc;
    private javax.swing.JLabel lblTipoCliente;
    private javax.swing.JLabel lblTipoDoc;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblWeb;
    private com.toedter.calendar.JDateChooser pickerNacimiento;
    private javax.swing.JTextField txtCUIT;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextArea txtDomicilio;
    private javax.swing.JTextArea txtDomicilioFacturacion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFacebook;
    private javax.swing.JTextField txtLinkedin;
    private javax.swing.JTextField txtMovil;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNroDoc;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtTelefonoFijo;
    private javax.swing.JTextField txtTwitter;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables

	public Container getDeleteMsgPanel() {
		
		this.setEditable( false );
		
		return this;
	}

	public Container getViewPanel() {
		
		this.setEditable( false );
		
		return this;
	}
	
	public void setEditable( Boolean editable ){
		
		txtNombre.setEditable( false );
		
	}

	public void showObject(Object object) {
		
		clearInputs();
		
		cliente = (Cliente)object;
		txtNombre.setText( cliente.getNombre() );
		
		txtDomicilio.setText( cliente.getDomicilio() );
		txtEmail.setText( cliente.getEmail() );
		txtContacto.setText( cliente.getContacto() );

		ComboEnumElement tipoCliente = new ComboEnumElement(cliente.getTipoCliente(), I18nMessages.locale(cliente.getTipoCliente().getNombre()));
		cmbTipoCliente.setSelectedItem( tipoCliente );
		
		txtTelefonoFijo.setText( cliente.getTelefonoFijo() );
		txtMovil.setText( cliente.getTelefonoMovil() );
		
		pickerNacimiento.setDate( cliente.getFechaNacimiento() );
		
		ComboEnumElement tipoDoc = new ComboEnumElement(cliente.getTipoDocumento(), I18nMessages.locale(cliente.getTipoDocumento().getNombre()));
		cmbTipoDoc.setSelectedItem( tipoDoc );
		if( cliente.getNroDocumento()!=null)
			txtNroDoc.setText( cliente.getNroDocumento().toString() );
		else
			txtNroDoc.setText("");

		txtCUIT.setText( cliente.getCuit() );
		ComboEnumElement condicion = new ComboEnumElement(cliente.getCondicionIVA(), I18nMessages.locale(cliente.getCondicionIVA().getNombre()));
		cmbCondicionIVA.setSelectedItem( condicion );
		txtDomicilioFacturacion.setText( cliente.getDomicilioFacturacion() );
		txtObservaciones.setText( cliente.getObservaciones() );
		
		txtFacebook.setText( cliente.getFacebook() );
		txtTwitter.setText( cliente.getTwitter() );
		txtLinkedin.setText( cliente.getLinkedin() );
		txtWeb.setText( cliente.getPaginaWeb() );
		
		
	}

	public Container getInputPanel() {
		return this;
	}

	public Object getObjectFromUI() throws ViewException {
		
		cliente.setNombre( txtNombre.getText() );
		cliente.setTelefonoFijo( txtTelefonoFijo.getText() );
		cliente.setTelefonoMovil( txtMovil.getText() );
		cliente.setDomicilio( txtDomicilio.getText() );
		cliente.setContacto( txtContacto.getText() );
		cliente.setEmail( txtEmail.getText() );
		
		//TODO chequear que sea un número.
		if(txtNroDoc.getText().length()>0)
			cliente.setNroDocumento( new Long(txtNroDoc.getText()) );

		cliente.setTipoDocumento( (TipoDocumento)(((ComboEnumElement)cmbTipoDoc.getSelectedItem()).getItem()) );
		cliente.setTipoCliente( (TipoCliente)(((ComboEnumElement)cmbTipoCliente.getSelectedItem()).getItem()) );
		cliente.setFechaNacimiento( pickerNacimiento.getDate() );
		
		cliente.setCondicionIVA( (CondicionIVA)(((ComboEnumElement)cmbCondicionIVA.getSelectedItem()).getItem()) );
		cliente.setCuit( txtCUIT.getText() );
		cliente.setDomicilioFacturacion( txtDomicilioFacturacion.getText() );
		cliente.setObservaciones( txtObservaciones.getText() );
		
		cliente.setFacebook( txtFacebook.getText() );
		cliente.setTwitter( txtTwitter.getText() );
		cliente.setLinkedin( txtLinkedin.getText() );
		cliente.setPaginaWeb( txtWeb.getText() );
		
		return cliente;
	}

	public void loadCombos(){
        //cargar tipos de documentos
        List tipos = new ArrayList();
       	for (TipoDocumento object : TipoDocumento.values()){
       		
       		ComboEnumElement tipo = new ComboEnumElement(object, I18nMessages.locale( object.getNombre() ));
			tipos.add(tipo);	
       	}
       	
        ComboModel model = new ComboModel();
        model.setElementos(tipos);
        cmbTipoDoc.setModel(model);
        cmbTipoDoc.setSelectedIndex(0);

        //cargar condiciones de iva
        List condiciones = new ArrayList();
       	for (CondicionIVA object : CondicionIVA.values()){
       		ComboEnumElement condicion = new ComboEnumElement(object, I18nMessages.locale( object.getNombre() ));
       		condiciones.add(condicion);	
       	
       	}
       	
        model = new ComboModel();
        model.setElementos(condiciones);
        cmbCondicionIVA.setModel(model);
        cmbCondicionIVA.setSelectedIndex(0);

        //cargar tipos de cliente
        List tiposCliente = new ArrayList();
       	for (TipoCliente object : TipoCliente.values()){
       		ComboEnumElement tipoCliente = new ComboEnumElement(object, I18nMessages.locale( object.getNombre() ));
       		tiposCliente.add(tipoCliente);	
       	
       	}
       	
        model = new ComboModel();
        model.setElementos(tiposCliente);
        cmbTipoCliente.setModel(model);
        cmbTipoCliente.setSelectedIndex(0);


    }
	private void initValidators() {
		
		required = new InputRequiredValidator(); 
		required.put(lblNombre, txtNombre, new JTextFieldInspector());
		required.setMessage(I18nMessages.INGRESE_REQUERIDOS);
		required.initialize();
		
	}

	
	public List<InputValidator> getValidators() {
		
		List<InputValidator> validators = new ArrayList<InputValidator>();
		
		validators.add( required );
		
		return validators;
	}

	public void clearInputs() {
		txtNombre.setText( "" );
		txtDomicilio.setText( "" );
		txtTelefonoFijo.setText( "" );
		txtMovil.setText( "" );
		txtNroDoc.setText( "" );
		txtEmail.setText( "" );
		txtContacto.setText( "" );
		txtCUIT.setText( "" );
		txtDomicilioFacturacion.setText( "" );
		txtObservaciones.setText( "" );
		txtFacebook.setText( "" );
		txtTwitter.setText( "" );
		txtLinkedin.setText( "" );
		txtWeb.setText( "" );
		pickerNacimiento.setDate( null );
		
		jTabbedPane.setSelectedIndex(0);
	}

	public List<JComponent> getFormLabels(){
		
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblNombre);
		labels.add(lblDomicilio);
		labels.add(lblFijo);
		labels.add(lblCelular);
		labels.add(lblTipoDoc);
		labels.add(lblNroDoc);
		labels.add(lblEmail);
		labels.add(lblTipoCliente);
		labels.add(lblFechaNacimiento);
		labels.add(lblCondicionIVA);
		labels.add(lblContacto);
		labels.add(lblCUIT);
		labels.add(lblDomicilioFacturacion);
		labels.add(lblFacebook);
		labels.add(lblTwitter);
		labels.add(lblLinkedin);
		labels.add(lblWeb);
		return labels;
	}
	
	public List<JComponent> getFormInputs(){
		
		List<JComponent> inputs = new Vector<JComponent>();
		inputs.add(txtNombre);
		inputs.add(txtDomicilio);
		inputs.add(jScrollPaneObservaciones);
		inputs.add(jScrollPane2);
		inputs.add(jScrollPane1);
		inputs.add(txtTelefonoFijo);
		inputs.add(txtMovil);
		inputs.add(cmbTipoDoc);
		inputs.add(txtNroDoc);
		inputs.add(txtEmail);
		inputs.add(cmbCondicionIVA);
		inputs.add(txtContacto);
		inputs.add(txtCUIT);
		inputs.add(txtDomicilioFacturacion);
		inputs.add(txtFacebook);
		inputs.add(txtTwitter);
		inputs.add(txtLinkedin);
		inputs.add(txtWeb);
		inputs.add(pickerNacimiento);
		inputs.add(cmbTipoCliente);
		
		
		return inputs;
	}
	

	public void setPadding(JComponent component, Insets padding) {
	
		
		GridBagConstraints gbc = ((GridBagLayout)jPanelDatosPersonales.getLayout()).getConstraints(component);
		gbc.insets = padding;
		((GridBagLayout)jPanelDatosPersonales.getLayout()).setConstraints(component, gbc);
		
		gbc = ((GridBagLayout)jPanelFacturacion.getLayout()).getConstraints(component);
		gbc.insets = padding;
		((GridBagLayout)jPanelFacturacion.getLayout()).setConstraints(component, gbc);
		
		
		gbc = ((GridBagLayout)jPanelSocial.getLayout()).getConstraints(component);
		gbc.insets = padding;
		((GridBagLayout)jPanelSocial.getLayout()).setConstraints(component, gbc);
	}

	public void setFormBackground(Color bg) {
		//this.setBackground(bg);
		jPanelDatosPersonales.setBackground(bg);
		jPanelFacturacion.setBackground(bg);
		jPanelSocial.setBackground(bg);
		jPanelObservaciones.setBackground(bg);
	}
}
