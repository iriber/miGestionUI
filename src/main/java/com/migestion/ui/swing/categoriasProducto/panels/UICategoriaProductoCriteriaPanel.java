package com.migestion.ui.swing.categoriasProducto.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.ui.criteria.UICategoriaProductoCriteria;

/**
 * Panel para el criteria de búsqueda de categorías de productos.
 *  
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 11/10/2013
 *
 */
public class UICategoriaProductoCriteriaPanel extends JPanel implements ICriteriaPanel{
	
	private JTextField txtNombre;

	/**
	 * Create the panel.
	 */
	public UICategoriaProductoCriteriaPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{225, 225, 20};
		gridBagLayout.rowHeights = new int[]{23, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 10, 0, 10);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		
		//setPreferredSize(new Dimension(400,200));

	}

	public UICriteria getCriteria() {
		
		UICategoriaProductoCriteria criteria = new UICategoriaProductoCriteria();

		criteria.setNombre( txtNombre.getText() );	

		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		txtNombre.setText( ((UICategoriaProductoCriteria)criteria).getNombre() );
	}

	public JPanel getPanel() {
		return this;		
	}

}
