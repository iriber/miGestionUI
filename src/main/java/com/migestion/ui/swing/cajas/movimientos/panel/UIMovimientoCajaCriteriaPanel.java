/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.migestion.ui.swing.cajas.movimientos.panel;

import javax.swing.JPanel;

import com.migestion.model.Caja;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.swing.search.criteria.UICriteria;
import com.migestion.swing.view.dialogs.ICriteriaPanel;
import com.migestion.swing.view.exceptions.ViewException;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UIMovimientoCajaCriteria;
import com.migestion.ui.swing.finder.FinderFactory;

/**
 *
 * @author bernardo
 */
public class UIMovimientoCajaCriteriaPanel extends javax.swing.JPanel  implements ICriteriaPanel{

	private Caja caja;
	
    /**
     * Creates new form UIPagoCriteriaPanel
     */
    public UIMovimientoCajaCriteriaPanel() {
        initComponents();

        caja = AppContext.getInstance().getCajaDefault() ;
        findCaja.objectFound( caja);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCaja = new javax.swing.JLabel();
        findCaja = FinderFactory.getFindCaja( new LinkFindObjectListener() {

            public void objectFound(Object objectFinded) {

                caja =  (Caja)objectFinded ;
            }
        });

        lblCaja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCaja.setText("Caja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(findCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(findCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.migestion.swing.custom.JFindObjectPanel findCaja;
    private javax.swing.JLabel lblCaja;
    // End of variables declaration//GEN-END:variables
	
    
    
	public UICriteria getCriteria() throws ViewException{
		
		UIMovimientoCajaCriteria criteria = new UIMovimientoCajaCriteria();


		if( caja == null )
			throw new ViewException("Debe seleccionar la caja");
		
		criteria.setCaja( caja );
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
