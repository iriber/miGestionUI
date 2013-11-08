/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.notasCredito.panel;

import javax.swing.JPanel;

import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.ui.criteria.UINotaCreditoCriteria;

/**
 *
 * @author bernardo
 */
public class UINotaCreditoCriteriaPanel extends javax.swing.JPanel   implements ICriteriaPanel{

    /**
     * Creates new form UICajaCriteriaPanel
     */
    public UINotaCreditoCriteriaPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFechaVencimiento = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        pickerFechaVencimiento = new com.toedter.calendar.JDateChooser();
        txtNumero = new javax.swing.JTextField();
        lblBanco = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();

        lblFechaVencimiento.setText("Fecha vencimiento");

        lblNumero.setText("Número");

        lblBanco.setText("Banco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblBanco)
                    .addComponent(lblNumero)
                    .addComponent(lblFechaVencimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pickerFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 221, Short.MAX_VALUE))
                    .addComponent(txtBanco)
                    .addComponent(txtNumero))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaVencimiento)
                    .addComponent(pickerFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBanco)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblFechaVencimiento;
    private javax.swing.JLabel lblNumero;
    private com.toedter.calendar.JDateChooser pickerFechaVencimiento;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables


	public UICriteria getCriteria() {
		
		UINotaCreditoCriteria criteria = new UINotaCreditoCriteria();

		criteria.setNumero( txtNumero.getText() );
		criteria.setFecha( pickerFechaVencimiento.getDate() );
		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		txtNumero.setText( ((UINotaCreditoCriteria)criteria).getNumero() );
		pickerFechaVencimiento.setDate( ((UINotaCreditoCriteria)criteria).getFecha() );
		
	}

	public JPanel getPanel() {
		return this;
	}
}
