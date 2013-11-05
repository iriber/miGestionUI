package com.migestion.ui.swing.productos.panel;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.migestion.model.CategoriaProducto;
import com.migestion.model.Producto;
import com.migestion.swing.custom.JFindObjectPanel;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.view.dialogs.adapters.IDialogAddAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogDeleteAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogUpdateAdapter;
import com.migestion.swing.view.dialogs.adapters.IDialogViewAdapter;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.swing.view.inputs.InputFloatValidator;
import com.migestion.swing.view.inputs.InputIntegerValidator;
import com.migestion.swing.view.inputs.InputRequiredValidator;
import com.migestion.swing.view.inputs.InputValidator;
import com.migestion.swing.view.inputs.JFindObjectInspector;
import com.migestion.swing.view.inputs.JTextFieldInspector;
import com.migestion.ui.swing.finder.FinderFactory;
import com.migestion.ui.swing.i18n.I18nMessages;
import com.migestion.ui.swing.skin.ISkinForm;
import com.migestion.ui.swing.skin.SkinDecorator;

/**
 * Panel para un producto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class ProductoPanel extends JPanel implements ISkinForm,Serializable, IDialogAddAdapter, IDialogUpdateAdapter, IDialogViewAdapter, IDialogDeleteAdapter{
	
	private JTextField txtNombre;
	private JLabel lblNombre;
	
    private JTextField txtDescripcion;
    
    private JTextField txtPrecio;
    private JLabel lblPrecio;
    
    private JTextField txtIva;
    private JLabel lblIva;
    
    private InputRequiredValidator required;
    private InputFloatValidator floatFormat;
    private InputIntegerValidator integerFormat;
    
    private Producto producto;
    private JLabel lblStock;
    private JLabel lblStockMnimo;
    private JLabel lblStockMximo;
    private JLabel lblObservaciones;
    private JLabel lblDescripcion;
    private JTextField txtStockMinimo;
    private JTextField txtStockMaximo;
    private JTextField txtStock;
    private JTextField txtCodigoBarras;
    private JLabel lblCodigoBarras;
    private JTextArea txtObservaciones;
    private JFindObjectPanel findCategoriaProducto;
    private JLabel lblCategoria;
    private GridBagLayout gridBagLayout;
  
    
	/**
	 * Create the panel.
	 */
	public ProductoPanel() {
	
		initProducto();
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
		
		lblPrecio = new JLabel(I18nMessages.PRODUCTO_PRECIO);
		lblPrecio.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 3;
		add(lblPrecio, gbc_lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecio.setColumns(10);
		GridBagConstraints gbc_txtPrecio = new GridBagConstraints();
		gbc_txtPrecio.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecio.gridx = 1;
		gbc_txtPrecio.gridy = 3;
		add(txtPrecio, gbc_txtPrecio);
		
		lblIva = new JLabel(I18nMessages.PRODUCTO_IVA);
		lblIva.setFont(new Font("Verdana", Font.BOLD, 14));
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIva = new GridBagConstraints();
		gbc_lblIva.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIva.insets = new Insets(0, 0, 5, 5);
		gbc_lblIva.gridx = 0;
		gbc_lblIva.gridy = 4;
		add(lblIva, gbc_lblIva);
		
		txtIva = new JTextField();
		txtIva.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtIva.setHorizontalAlignment(SwingConstants.RIGHT);
		txtIva.setColumns(10);
		GridBagConstraints gbc_txtIva = new GridBagConstraints();
		gbc_txtIva.insets = new Insets(0, 0, 5, 5);
		gbc_txtIva.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtIva.gridx = 1;
		gbc_txtIva.gridy = 4;
		add(txtIva, gbc_txtIva);
		
		lblStock = new JLabel(I18nMessages.PRODUCTO_STOCK);
		lblStock.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblStock = new GridBagConstraints();
		gbc_lblStock.anchor = GridBagConstraints.EAST;
		gbc_lblStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblStock.gridx = 0;
		gbc_lblStock.gridy = 5;
		add(lblStock, gbc_lblStock);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtStock = new GridBagConstraints();
		gbc_txtStock.insets = new Insets(0, 0, 5, 5);
		gbc_txtStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStock.gridx = 1;
		gbc_txtStock.gridy = 5;
		add(txtStock, gbc_txtStock);
		txtStock.setColumns(10);
		
		lblStockMnimo = new JLabel(I18nMessages.PRODUCTO_STOCK_MINIMO);
		lblStockMnimo.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblStockMnimo = new GridBagConstraints();
		gbc_lblStockMnimo.anchor = GridBagConstraints.EAST;
		gbc_lblStockMnimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblStockMnimo.gridx = 0;
		gbc_lblStockMnimo.gridy = 6;
		add(lblStockMnimo, gbc_lblStockMnimo);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtStockMinimo = new GridBagConstraints();
		gbc_txtStockMinimo.insets = new Insets(0, 0, 5, 5);
		gbc_txtStockMinimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStockMinimo.gridx = 1;
		gbc_txtStockMinimo.gridy = 6;
		add(txtStockMinimo, gbc_txtStockMinimo);
		txtStockMinimo.setColumns(10);
		
		lblStockMximo = new JLabel(I18nMessages.PRODUCTO_STOCK_MAXIMO);
		lblStockMximo.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblStockMximo = new GridBagConstraints();
		gbc_lblStockMximo.anchor = GridBagConstraints.EAST;
		gbc_lblStockMximo.insets = new Insets(0, 0, 5, 5);
		gbc_lblStockMximo.gridx = 0;
		gbc_lblStockMximo.gridy = 7;
		add(lblStockMximo, gbc_lblStockMximo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtStockMaximo = new GridBagConstraints();
		gbc_txtStockMaximo.insets = new Insets(0, 0, 5, 5);
		gbc_txtStockMaximo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStockMaximo.gridx = 1;
		gbc_txtStockMaximo.gridy = 7;
		add(txtStockMaximo, gbc_txtStockMaximo);
		txtStockMaximo.setColumns(10);
		
		lblCodigoBarras = new JLabel(I18nMessages.PRODUCTO_CODIGO_BARRAS);
		lblCodigoBarras.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblCodigoBarras = new GridBagConstraints();
		gbc_lblCodigoBarras.insets = new Insets(0,15, 5, 15);
		gbc_lblCodigoBarras.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoBarras.gridx = 0;
		gbc_lblCodigoBarras.gridy = 8;
		add(lblCodigoBarras, gbc_lblCodigoBarras);
		
		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_txtCodigoBarras = new GridBagConstraints();
		gbc_txtCodigoBarras.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoBarras.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigoBarras.gridx = 1;
		gbc_txtCodigoBarras.gridy = 8;
		add(txtCodigoBarras, gbc_txtCodigoBarras);
		txtCodigoBarras.setColumns(10);
		
		lblObservaciones = new JLabel(I18nMessages.PRODUCTO_OBSEVACIONES);
		lblObservaciones.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblObservaciones = new GridBagConstraints();
		gbc_lblObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_lblObservaciones.gridx = 0;
		gbc_lblObservaciones.gridy = 9;
		add(lblObservaciones, gbc_lblObservaciones);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtObservaciones.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtObservaciones.setRows(10);
		GridBagConstraints gbc_txtObservaciones = new GridBagConstraints();
		gbc_txtObservaciones.insets = new Insets(0, 0, 5, 5);
		gbc_txtObservaciones.fill = GridBagConstraints.BOTH;
		gbc_txtObservaciones.gridx = 1;
		gbc_txtObservaciones.gridy = 9;
		add(txtObservaciones, gbc_txtObservaciones);
		
		lblCategoria = new JLabel(I18nMessages.PRODUCTO_CATEGORIA);
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 10;
		add(lblCategoria, gbc_lblCategoria);
		
		findCategoriaProducto = FinderFactory.getFindCategoriaProducto( new LinkFindObjectListener() {
			
			public void objectFound(Object objectFinded) {
				if( objectFinded != null ){
					producto.setCategoria((CategoriaProducto)objectFinded);
				}
			}
		});
		findCategoriaProducto.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		GridBagConstraints gbc_txtCategoria = new GridBagConstraints();
		gbc_txtCategoria.insets = new Insets(0, 0, 0, 5);
		gbc_txtCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCategoria.gridx = 1;
		gbc_txtCategoria.gridy = 10;
		add(findCategoriaProducto, gbc_txtCategoria);
		
		
		Dimension minimumSize = new Dimension(700, 300);
		setMinimumSize(minimumSize);
		
		SkinDecorator.getInstance().decorate(this);
		
		initValidators();
	}
	


	private void initProducto() {
		this.producto = new Producto();
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
		txtObservaciones.setEditable( false );
		txtCodigoBarras.setEditable( false );
		txtIva.setEditable( false );
		txtPrecio.setEditable( false );
		txtStock.setEditable( false );
		txtStockMaximo.setEditable( false );
		txtStockMinimo.setEditable( false );
		findCategoriaProducto.setEditable(false);
		
	}

	public void showObject(Object object) {
		
		producto = (Producto)object;
		txtNombre.setText( producto.getNombre() );
		txtDescripcion.setText( producto.getDescripcion() );
		txtObservaciones.setText( producto.getObservaciones() );
		txtCodigoBarras.setText( producto.getCodigoBarras() );
		
		if( producto.getPrecio()!=null)
			txtPrecio.setText( producto.getPrecio().toString() );
		
		if( producto.getIva()!=null)
			txtIva.setText( producto.getIva().toString() );
		
		if( producto.getStockActual()!=null)
			txtStock.setText( producto.getStockActual().toString() );
		
		if( producto.getStockMinimo()!=null)
			txtStockMinimo.setText( producto.getStockMinimo().toString() );
		
		if( producto.getStockMaximo()!=null)
			txtStockMaximo.setText( producto.getStockMaximo().toString() );
		
		
		findCategoriaProducto.objectFound( producto.getCategoria() );
	}

	public Container getInputPanel() {
		return this;
	}

	public Object getObjectFromUI() throws ViewException {
		
		producto.setNombre( txtNombre.getText() );
		producto.setDescripcion( txtDescripcion.getText() );
		producto.setObservaciones( txtObservaciones.getText() );
		producto.setCodigoBarras( txtCodigoBarras.getText() );
		
		//TODO chequear que sea un número.
		if(txtPrecio.getText().length()>0)
			producto.setPrecio( new Float(txtPrecio.getText()) );
		else
			producto.setPrecio(null);
		
		if(txtIva.getText().length()>0)
			producto.setIva( new Float(txtIva.getText()) );
		else
			producto.setIva(null);

		//TODO chequear que sea un número.
		if(txtStock.getText().length()>0)
			producto.setStockActual(new Integer(txtStock.getText()) );
		else
			producto.setStockActual(null);

		//TODO chequear que sea un número.
		if(txtStockMinimo.getText().length()>0)
			producto.setStockMinimo(new Integer(txtStockMinimo.getText()) );
		else
			producto.setStockMinimo(null);
		
		//TODO chequear que sea un número.
		if(txtStockMaximo.getText().length()>0)
			producto.setStockMaximo(new Integer(txtStockMaximo.getText()) );
		else
			producto.setStockMaximo(null);
		
		return producto;
	}

	private void initValidators() {
		
		required = new InputRequiredValidator(); 
		required.put(lblNombre, txtNombre, new JTextFieldInspector());
		required.put(lblPrecio, txtPrecio, new JTextFieldInspector());
		required.put(lblIva, txtIva, new JTextFieldInspector());
		required.put(lblCategoria, findCategoriaProducto, new JFindObjectInspector());
		required.setMessage(I18nMessages.INGRESE_REQUERIDOS);
		required.initialize();
		
		floatFormat = new InputFloatValidator();
		floatFormat.put(lblPrecio, txtPrecio, new JTextFieldInspector());
		floatFormat.put(lblIva, txtIva, new JTextFieldInspector());
		floatFormat.setMessage(I18nMessages.FORMATO_FLOAT_INVALIDO);
		floatFormat.initialize();
		
		integerFormat = new InputIntegerValidator();
		integerFormat.put(lblStock, txtStock, new JTextFieldInspector());
		integerFormat.put(lblStockMnimo, txtStockMinimo, new JTextFieldInspector());
		integerFormat.put(lblStockMximo, txtStockMaximo, new JTextFieldInspector());
		integerFormat.setMessage(I18nMessages.FORMATO_INTEGER_INVALIDO);
		integerFormat.initialize();

	}

	
	public List<InputValidator> getValidators() {
		
		List<InputValidator> validators = new ArrayList<InputValidator>();
		
		validators.add( required );
		validators.add( floatFormat );
		validators.add( integerFormat );
		
		return validators;
	}

	public void clearInputs() {
		txtNombre.setText( "" );
		txtIva.setText( "" );
		txtDescripcion.setText( "" );
		txtPrecio.setText( "" );
		txtObservaciones.setText( "" );
		txtCodigoBarras.setText( "" );
		txtStock.setText( "" );
		txtStockMaximo.setText( "" );
		txtStockMinimo.setText( "" );
		findCategoriaProducto.objectFound(null);
		
	}

	public List<JComponent> getFormLabels(){
		
		List<JComponent> labels = new Vector<JComponent>();
		labels.add(lblNombre);
		labels.add(lblDescripcion);
		labels.add(lblCategoria);
		labels.add(lblIva);
		labels.add(lblObservaciones);
		labels.add(lblCodigoBarras);
		labels.add(lblPrecio);
		labels.add(lblStock);
		labels.add(lblStockMnimo);
		labels.add(lblStockMximo);
		
		return labels;
	}
	
	public List<JComponent> getFormInputs(){
		
		List<JComponent> inputs = new Vector<JComponent>();
		inputs.add(txtNombre);
		inputs.add(txtDescripcion);
		inputs.add(findCategoriaProducto);
		inputs.add(txtIva);
		inputs.add(txtObservaciones);
		inputs.add(txtCodigoBarras);
		inputs.add(txtPrecio);
		inputs.add(txtStock);
		inputs.add(txtStockMinimo);
		inputs.add(txtStockMaximo);
		
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
