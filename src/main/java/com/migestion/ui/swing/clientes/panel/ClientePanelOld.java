package com.migestion.ui.swing.clientes.panel;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.migestion.model.Cliente;
import com.migestion.swing.view.dialogs.adapters.IDialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogUpdateAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JTextFieldInspector;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

/**
 * Panel para un cliente
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013
 *
 */
public class ClientePanelOld extends JPanel implements ISkinForm,Serializable, IDialogAddAdapter, IDialogUpdateAdapter, IDialogViewAdapter, IDialogDeleteAdapter{
	
	private JTextField txtNombre;
	private JLabel lblNombre;
	
    private InputRequiredValidator required;
    
    private Cliente cliente;
    private GridBagLayout gridBagLayout;
    private JTextField txtTelefonoFijo;
    private JTextField txtTelefonoMovil;
    private JTextField txtEmail;
    private JTextField txtNroDoc;
    private JTextField txtCuit;
    private JTextField txtContacto;
  
	/**
	 * Create the panel.
	 */
	public ClientePanelOld() {
	
		initCliente();
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{137, 334, 20};
		gridBagLayout.rowHeights = new int[]{20,20, 21, 19, 19, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0,0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		setLayout(gridBagLayout);
		
		lblNombre = new JLabel( I18nMessages.PRODUCTO_NOMBRE);
		lblNombre.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.SOUTH;
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		add(txtNombre, gbc_txtNombre);
		
		
		Dimension minimumSize = new Dimension(700, 300);
		setMinimumSize(minimumSize);
		
		SkinDecorator.getInstance().decorate(this);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		GridBagConstraints gbc_lblDomicilio = new GridBagConstraints();
		gbc_lblDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDomicilio.gridx = 0;
		gbc_lblDomicilio.gridy = 2;
		add(lblDomicilio, gbc_lblDomicilio);
		
		JTextArea txtDomicilio = new JTextArea();
		GridBagConstraints gbc_txtDomicilio = new GridBagConstraints();
		gbc_txtDomicilio.insets = new Insets(0, 0, 5, 5);
		gbc_txtDomicilio.fill = GridBagConstraints.BOTH;
		gbc_txtDomicilio.gridx = 1;
		gbc_txtDomicilio.gridy = 2;
		add(txtDomicilio, gbc_txtDomicilio);
		
		JLabel lblFijo = new JLabel("Fijo");
		GridBagConstraints gbc_lblFijo = new GridBagConstraints();
		gbc_lblFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFijo.anchor = GridBagConstraints.EAST;
		gbc_lblFijo.gridx = 0;
		gbc_lblFijo.gridy = 3;
		add(lblFijo, gbc_lblFijo);
		
		txtTelefonoFijo = new JTextField();
		GridBagConstraints gbc_txtTelefonoFijo = new GridBagConstraints();
		gbc_txtTelefonoFijo.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefonoFijo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefonoFijo.gridx = 1;
		gbc_txtTelefonoFijo.gridy = 3;
		add(txtTelefonoFijo, gbc_txtTelefonoFijo);
		txtTelefonoFijo.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		GridBagConstraints gbc_lblCelular = new GridBagConstraints();
		gbc_lblCelular.insets = new Insets(0, 0, 5, 5);
		gbc_lblCelular.anchor = GridBagConstraints.EAST;
		gbc_lblCelular.gridx = 0;
		gbc_lblCelular.gridy = 4;
		add(lblCelular, gbc_lblCelular);
		
		txtTelefonoMovil = new JTextField();
		GridBagConstraints gbc_txtTelefonoMovil = new GridBagConstraints();
		gbc_txtTelefonoMovil.insets = new Insets(0, 0, 5, 5);
		gbc_txtTelefonoMovil.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefonoMovil.gridx = 1;
		gbc_txtTelefonoMovil.gridy = 4;
		add(txtTelefonoMovil, gbc_txtTelefonoMovil);
		txtTelefonoMovil.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 5;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblTipoDoc = new JLabel("Tipo Doc");
		GridBagConstraints gbc_lblTipoDoc = new GridBagConstraints();
		gbc_lblTipoDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDoc.anchor = GridBagConstraints.EAST;
		gbc_lblTipoDoc.gridx = 0;
		gbc_lblTipoDoc.gridy = 6;
		add(lblTipoDoc, gbc_lblTipoDoc);
		
		JComboBox cmbTipoDocumento = new JComboBox();
		GridBagConstraints gbc_cmbTipoDocumento = new GridBagConstraints();
		gbc_cmbTipoDocumento.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTipoDocumento.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTipoDocumento.gridx = 1;
		gbc_cmbTipoDocumento.gridy = 6;
		add(cmbTipoDocumento, gbc_cmbTipoDocumento);
		
		JLabel lblNroDoc = new JLabel("Nro Doc");
		GridBagConstraints gbc_lblNroDoc = new GridBagConstraints();
		gbc_lblNroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroDoc.anchor = GridBagConstraints.EAST;
		gbc_lblNroDoc.gridx = 0;
		gbc_lblNroDoc.gridy = 7;
		add(lblNroDoc, gbc_lblNroDoc);
		
		txtNroDoc = new JTextField();
		GridBagConstraints gbc_txtNroDoc = new GridBagConstraints();
		gbc_txtNroDoc.insets = new Insets(0, 0, 5, 5);
		gbc_txtNroDoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroDoc.gridx = 1;
		gbc_txtNroDoc.gridy = 7;
		add(txtNroDoc, gbc_txtNroDoc);
		txtNroDoc.setColumns(10);
		
		JLabel lblCuit = new JLabel("Cuit");
		GridBagConstraints gbc_lblCuit = new GridBagConstraints();
		gbc_lblCuit.anchor = GridBagConstraints.EAST;
		gbc_lblCuit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuit.gridx = 0;
		gbc_lblCuit.gridy = 8;
		add(lblCuit, gbc_lblCuit);
		
		txtCuit = new JTextField();
		GridBagConstraints gbc_txtCuit = new GridBagConstraints();
		gbc_txtCuit.insets = new Insets(0, 0, 5, 5);
		gbc_txtCuit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCuit.gridx = 1;
		gbc_txtCuit.gridy = 8;
		add(txtCuit, gbc_txtCuit);
		txtCuit.setColumns(10);
		
		JLabel lblCondicionIva = new JLabel("Condicion Iva");
		GridBagConstraints gbc_lblCondicionIva = new GridBagConstraints();
		gbc_lblCondicionIva.anchor = GridBagConstraints.EAST;
		gbc_lblCondicionIva.insets = new Insets(0, 0, 5, 5);
		gbc_lblCondicionIva.gridx = 0;
		gbc_lblCondicionIva.gridy = 9;
		add(lblCondicionIva, gbc_lblCondicionIva);
		
		JComboBox cmbCondicionIVA = new JComboBox();
		GridBagConstraints gbc_cmbCondicionIVA = new GridBagConstraints();
		gbc_cmbCondicionIVA.insets = new Insets(0, 0, 5, 5);
		gbc_cmbCondicionIVA.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbCondicionIVA.gridx = 1;
		gbc_cmbCondicionIVA.gridy = 9;
		add(cmbCondicionIVA, gbc_cmbCondicionIVA);
		
		JLabel lblContacto = new JLabel("Contacto");
		GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.anchor = GridBagConstraints.EAST;
		gbc_lblContacto.insets = new Insets(0, 0, 0, 5);
		gbc_lblContacto.gridx = 0;
		gbc_lblContacto.gridy = 10;
		add(lblContacto, gbc_lblContacto);
		
		txtContacto = new JTextField();
		GridBagConstraints gbc_txtContacto = new GridBagConstraints();
		gbc_txtContacto.insets = new Insets(0, 0, 0, 5);
		gbc_txtContacto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContacto.gridx = 1;
		gbc_txtContacto.gridy = 10;
		add(txtContacto, gbc_txtContacto);
		txtContacto.setColumns(10);
		
		initValidators();
	}
	


	private void initCliente() {
		this.cliente = new Cliente();
	}



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
		
		cliente = (Cliente)object;
		txtNombre.setText( cliente.getNombre() );
		
	}

	public Container getInputPanel() {
		return this;
	}

	public Object getObjectFromUI() throws ViewException {
		
		cliente.setNombre( txtNombre.getText() );
		
		return cliente;
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
		
	}

	public List<JComponent> getFormLabels(){
		
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblNombre);
		
		return labels;
	}
	
	public List<JComponent> getFormInputs(){
		
		List<JComponent> inputs = new Vector<JComponent>();
		inputs.add(txtNombre);
		
		return inputs;
	}
	

	public void setPadding(JComponent component, Insets padding) {
		GridBagConstraints gbc = gridBagLayout.getConstraints(component);
		gbc.insets = padding;
		remove(component);
		add(component, gbc);
	}

	public void setFormBackground(Color bg) {
		this.setBackground(bg);
	}
	
}
