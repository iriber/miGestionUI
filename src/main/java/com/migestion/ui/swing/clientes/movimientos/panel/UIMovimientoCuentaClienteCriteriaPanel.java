/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.clientes.movimientos.panel;

import java.util.Date;

import javax.swing.JPanel;

import com.migestion.model.Cliente;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.criteria.UIMovimientoCuentaClienteCriteria;
import com.migestion.ui.swing.finder.FinderFactory;

/**
 *
 * @author bernardo
 */
public class UIMovimientoCuentaClienteCriteriaPanel extends javax.swing.JPanel  implements ICriteriaPanel{


	private Cliente cliente;
	
    /**
     * Creates new form UIPagoCriteriaPanel
     */
    public UIMovimientoCuentaClienteCriteriaPanel() {

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
        lblFecha = new javax.swing.JLabel();
        criteriaFechaRangoPanel = new com.migestion.swing.custom.CriteriaFechaRangoPanel();
        findCliente = FinderFactory.getFindCliente( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                cliente =  (Cliente)objectFinded ;
            }
        });

        lblCliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCliente.setText("Cliente");

        lblFecha.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFecha)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(criteriaFechaRangoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(findCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(criteriaFechaRangoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.migestion.swing.custom.CriteriaFechaRangoPanel criteriaFechaRangoPanel;
    private com.migestion.swing.custom.JFindObjectPanel findCliente;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFecha;
    // End of variables declaration//GEN-END:variables
	
    
    
	public UICriteria getCriteria() throws ViewException{
		
		UIMovimientoCuentaClienteCriteria criteria = new UIMovimientoCuentaClienteCriteria();

		if( cliente == null )
			throw new ViewException("Debe seleccionar un cliente");
		
		criteria.setCliente( cliente );
		Date[] fechas = criteriaFechaRangoPanel.getFechas();
		criteria.setFechaDesde( fechas[0] );
		criteria.setFechaHasta( fechas[1] );
	
		criteria.setPaginable(true);
		return criteria;

	}

	public void setCriteria(UICriteria criteria) {
		
		criteriaFechaRangoPanel.setFechaDesde( ((UIMovimientoCuentaClienteCriteria)criteria).getFechaDesde() );
		criteriaFechaRangoPanel.setFechaHasta( ((UIMovimientoCuentaClienteCriteria)criteria).getFechaHasta() );
		cliente = ((UIMovimientoCuentaClienteCriteria)criteria).getCliente();
	}


	public JPanel getPanel() {
		return this;
	}

}
