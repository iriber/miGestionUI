/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing;

import com.migestion.model.Vendedor;
import com.migestion.swing.controller.exception.ControllerException;
import com.migestion.swing.custom.ComboModel;
import com.migestion.swing.model.UICollection;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIVendedorCriteria;
import com.migestion.ui.service.UIServiceFactory;

/**
 *
 * @author bernardo
 */
public class PanelVendedorDefault extends javax.swing.JPanel {

    /**
     * Creates new form PanelVendedorDefault
     */
    public PanelVendedorDefault() {
        initComponents();
        
        
        loadCombo();
    }

    private void loadCombo() {
		try {

			UIVendedorCriteria criteria = new UIVendedorCriteria();
			UICollection vendedores = UIServiceFactory.getUIVendedorService().list( criteria );
			ComboModel model = new ComboModel();
	        model.setElementos(vendedores.getElements());
	        cmbVendedores.setModel(model);
	        cmbVendedores.setSelectedItem( AppContext.getInstance().getVendedorDefault() );
	        
		} catch (ControllerException e) {
			e.printStackTrace();
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelVendedor = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        cmbVendedores = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        java.awt.GridBagLayout jPanelDatosPersonalesLayout = new java.awt.GridBagLayout();
        jPanelDatosPersonalesLayout.columnWidths = new int[] {20, 50, 334, 20};
        jPanelVendedor.setLayout(jPanelDatosPersonalesLayout);

        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Vendedor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanelVendedor.add(lblNombre, gridBagConstraints);

        cmbVendedores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVendedores.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbVendedoresPropertyChange(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanelVendedor.add(cmbVendedores, gridBagConstraints);

        add(jPanelVendedor, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbVendedoresPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbVendedoresPropertyChange
        // TODO add your handling code here:
        
        Vendedor vendedor = (Vendedor)cmbVendedores.getSelectedItem();
        if( vendedor != null )
            AppContext.getInstance().setVendedorDefault(vendedor);
        
    }//GEN-LAST:event_cmbVendedoresPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbVendedores;
    private javax.swing.JPanel jPanelVendedor;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
