/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.operaciones.ventas.panel;

import java.util.Date;

import javax.swing.JPanel;

import com.migestion.model.Cliente;
import com.migestion.model.Vendedor;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.ui.criteria.UIVentaCriteria;
import com.migestion.ui.swing.finder.FinderFactory;

/**
 *
 * @author bernardo
 */
public class UIVentaCriteriaPanel extends javax.swing.JPanel  implements ICriteriaPanel{

	private Cliente cliente;
	private Vendedor vendedor;
	
    /**
     * Creates new form UIVentaCriteriaPanel
     */
    public UIVentaCriteriaPanel() {
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
        lblVendedor = new javax.swing.JLabel();
        findVendedor = FinderFactory.getFindVendedor(new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                vendedor =  (Vendedor) objectFinded;
            }
        });
        criteriaFechaPanel = new com.migestion.swing.custom.CriteriaFechaRangoPanel();

        lblCliente.setText("Cliente");

        lblVendedor.setText("Vendedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(criteriaFechaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCliente)
                            .addComponent(lblVendedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(findVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 327, Short.MAX_VALUE)
                            .addComponent(findCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(criteriaFechaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.migestion.swing.custom.CriteriaFechaRangoPanel criteriaFechaPanel;
    private com.migestion.swing.custom.JFindObjectPanel findCliente;
    private com.migestion.swing.custom.JFindObjectPanel findVendedor;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblVendedor;
    // End of variables declaration//GEN-END:variables
	
    
    
	public UICriteria getCriteria() {
		
		UIVentaCriteria criteria = new UIVentaCriteria();

		Date[] fechas = criteriaFechaPanel.getFechas();
		criteria.setFechaDesde( fechas[0] );
		criteria.setFechaHasta( fechas[1] );

		criteria.setCliente( this.cliente );
		criteria.setVendedor( this.vendedor );
	
		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		//txtNombre.setText( ((UIVentaCriteria)criteria).getNombre() );
	}


	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}
}