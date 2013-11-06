package com.migestion.ui.swing.categoriasProducto.panels;

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

import com.migestion.model.CategoriaProducto;
import com.migestion.swing.custom.JFindObjectPanel;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.view.dialogs.adapters.IDialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogUpdateAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JTextFieldInspector;
import com.migestion.ui.swing.finder.FinderFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;

/**
 * Panel para categoría de producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class CategoriaProductoPanel extends JPanel implements ISkinForm,Serializable, IDialogAddAdapter, IDialogUpdateAdapter, IDialogViewAdapter, IDialogDeleteAdapter{
	
	private JTextField txtNombre;
	private JLabel lblNombre;
	
    private JTextField txtDescripcion;
    
    private InputRequiredValidator required;
    
    private CategoriaProducto categoriaProducto;

    private JLabel lblDescripcion;
    
    private JFindObjectPanel findPadre;
    private JLabel lblPadre;
    
    private GridBagLayout gridBagLayout;
  
    
	/**
	 * Create the panel.
	 */
	public CategoriaProductoPanel() {
	
		initCategoriaProducto();
		
		gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{137, 334, 20};
		gridBagLayout.rowHeights = new int[]{20,20, 21, 19, 19, 0, 0, 0, 0, 0, 0, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0,0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		
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
		
		lblDescripcion = new JLabel(I18nMessages.PRODUCTO_DESCRIPCION);
		lblDescripcion.setFont(new Font("Verdana", Font.BOLD, 14));
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.SOUTH;
		gbc_lblDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 2;
		add(lblDescripcion, gbc_lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtDescripcion.setColumns(10);
		GridBagConstraints gbc_txtDescripcion = new GridBagConstraints();
		gbc_txtDescripcion.anchor = GridBagConstraints.NORTH;
		gbc_txtDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescripcion.gridx = 1;
		gbc_txtDescripcion.gridy = 2;
		add(txtDescripcion, gbc_txtDescripcion);
		
		
		lblPadre = new JLabel(I18nMessages.PRODUCTO_CATEGORIA);
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 10;
		add(lblPadre, gbc_lblCategoria);
		
		findPadre = FinderFactory.getFindCategoriaProducto( new LinkFindObjectListener() {
			
			public void objectFound(Object objectFinded) {
				if( objectFinded != null ){
					categoriaProducto.setPadre((CategoriaProducto)objectFinded);
				}
			}
		});
		findPadre.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		GridBagConstraints gbc_txtCategoria = new GridBagConstraints();
		gbc_txtCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_txtCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategoria.gridx = 1;
		gbc_txtCategoria.gridy = 10;
		add(findPadre, gbc_txtCategoria);
		
		
		Dimension minimumSize = new Dimension(700, 300);
		setMinimumSize(minimumSize);
		
		SkinDecorator.getInstance().decorate(this);
		
		initValidators();
	}
	


	private void initCategoriaProducto() {
		this.categoriaProducto = new CategoriaProducto();
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
		txtDescripcion.setEditable( false );
		findPadre.setEditable(false);
		
	}

	public void showObject(Object object) {
		
		categoriaProducto = (CategoriaProducto)object;
		
		txtNombre.setText( categoriaProducto.getNombre() );
		txtDescripcion.setText( categoriaProducto.getDescripcion() );
		
		findPadre.objectFound( categoriaProducto.getPadre() );
	}

	public Container getInputPanel() {
		return this;
	}

	public Object getObjectFromUI() throws ViewException {
		
		categoriaProducto.setNombre( txtNombre.getText() );
		categoriaProducto.setDescripcion( txtDescripcion.getText() );
		
		return categoriaProducto;
	}

	private void initValidators() {
		
		required = new InputRequiredValidator(); 
		required.put(lblNombre, txtNombre, new JTextFieldInspector());
		//required.put(lblPadre, findPadre, new JFindObjectInspector());
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
		txtDescripcion.setText( "" );
		findPadre.objectFound(null);
	}

	public List<JComponent> getFormLabels(){
		
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblNombre);
		labels.add(lblDescripcion);
		labels.add(lblPadre);
		
		return labels;
	}
	
	public List<JComponent> getFormInputs(){
		
		List<JComponent> inputs = new Vector<JComponent>();
		inputs.add(txtNombre);
		inputs.add(txtDescripcion);
		inputs.add(findPadre);
		
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
