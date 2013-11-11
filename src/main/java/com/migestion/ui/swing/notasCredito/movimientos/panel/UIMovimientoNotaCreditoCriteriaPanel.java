/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.notasCredito.movimientos.panel;

import java.util.Date;

import javax.swing.JPanel;

import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.criteria.UIMovimientoNotaCreditoCriteria;

/**
 *
 * @author bernardo
 */
public class UIMovimientoNotaCreditoCriteriaPanel extends javax.swing.JPanel  implements ICriteriaPanel{

	
    /**
     * Creates new form UIPagoCriteriaPanel
     */
    public UIMovimientoNotaCreditoCriteriaPanel() {

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

        criteriaFechaRangoPanel = new com.migestion.swing.custom.CriteriaFechaRangoPanel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(criteriaFechaRangoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(criteriaFechaRangoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.migestion.swing.custom.CriteriaFechaRangoPanel criteriaFechaRangoPanel;
    // End of variables declaration//GEN-END:variables
	
    
    
	public UICriteria getCriteria() throws ViewException{
		
		UIMovimientoNotaCreditoCriteria criteria = new UIMovimientoNotaCreditoCriteria();

		Date[] fechas = criteriaFechaRangoPanel.getFechas();
		criteria.setFechaDesde( fechas[0] );
		criteria.setFechaHasta( fechas[1] );
		
		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		criteriaFechaRangoPanel.setFechaDesde(((UIMovimientoNotaCreditoCriteria)criteria).getFechaDesde());
		criteriaFechaRangoPanel.setFechaHasta(((UIMovimientoNotaCreditoCriteria)criteria).getFechaHasta());
		
	}


	public JPanel getPanel() {
		return this;
	}

	
}