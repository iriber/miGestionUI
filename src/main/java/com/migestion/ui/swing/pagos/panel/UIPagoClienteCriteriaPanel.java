/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.pagos.panel;

import java.util.Date;

import javax.swing.JPanel;

import com.migestion.model.Cliente;
import com.migestion.model.Vendedor;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.ui.criteria.UIPagoClienteCriteria;
import com.migestion.ui.swing.finder.FinderFactory;

/**
 *
 * @author bernardo
 */
public class UIPagoClienteCriteriaPanel extends javax.swing.JPanel  implements ICriteriaPanel{

	private Cliente cliente;
	private Vendedor vendedor;
	
    /**
     * Creates new form UIPagoCriteriaPanel
     */
    public UIPagoClienteCriteriaPanel() {
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

        lblCliente = new javax.swing.JLabel();
        findCliente = FinderFactory.getFindCliente( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                cliente =  (Cliente)objectFinded ;
            }
        });
        criteriaFechaPanel = new com.migestion.swing.custom.CriteriaFechaRangoPanel();

        lblCliente.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(findCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(criteriaFechaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(criteriaFechaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.migestion.swing.custom.CriteriaFechaRangoPanel criteriaFechaPanel;
    private com.migestion.swing.custom.JFindObjectPanel findCliente;
    private javax.swing.JLabel lblCliente;
    // End of variables declaration//GEN-END:variables
	
    
    
	public UICriteria getCriteria() {
		
		UIPagoClienteCriteria criteria = new UIPagoClienteCriteria();

		Date[] fechas = criteriaFechaPanel.getFechas();
		criteria.setFechaDesde( fechas[0] );
		criteria.setFechaHasta( fechas[1] );

		criteria.setCliente( this.cliente );
		//criteria.setVendedor( this.vendedor );
	
		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		//txtNombre.setText( ((UIPagoCriteria)criteria).getNombre() );
	}


	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}
}
