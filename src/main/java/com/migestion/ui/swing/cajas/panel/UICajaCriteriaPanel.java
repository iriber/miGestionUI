/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.cajas.panel;

import java.util.Date;

import javax.swing.JPanel;

import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.ui.criteria.UICajaCriteria;
import com.migestion.ui.criteria.UIVentaCriteria;

/**
 *
 * @author bernardo
 */
public class UICajaCriteriaPanel extends javax.swing.JPanel   implements ICriteriaPanel{

    /**
     * Creates new form UICajaCriteriaPanel
     */
    public UICajaCriteriaPanel() {
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

        lblFecha = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        pickerFecha = new com.toedter.calendar.JDateChooser();
        txtNumero = new javax.swing.JTextField();

        lblFecha.setText("Fecha");

        lblNumero.setText("Número");

        txtNumero.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumero)
                    .addComponent(lblFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pickerFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtNumero))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(pickerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumero;
    private com.toedter.calendar.JDateChooser pickerFecha;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables


	public UICriteria getCriteria() {
		
		UICajaCriteria criteria = new UICajaCriteria();

		criteria.setNumero( txtNumero.getText() );
		
		criteria.setFecha( pickerFecha.getDate() );
		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		txtNumero.setText( ((UICajaCriteria)criteria).getNumero() );
		//fecha
	}

	public JPanel getPanel() {
		return this;
	}
}