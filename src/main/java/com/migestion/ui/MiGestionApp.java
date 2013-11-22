package com.migestion.ui;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import com.migestion.dao.PersistenceContext;
import com.migestion.model.Caja;
import com.migestion.model.CategoriaProducto;
import com.migestion.model.Cliente;
import com.migestion.model.EstadoCaja;
import com.migestion.model.Sucursal;
import com.migestion.model.ValoresPredefinidos;
import com.migestion.model.Vendedor;
import com.migestion.swing.model.UICollection;
import com.migestion.swing.utils.UbicacionVentana;
import com.migestion.swing.view.dialogs.ProgressDialog;
import com.migestion.ui.context.AppContext;
import com.migestion.ui.criteria.UICajaCriteria;
import com.migestion.ui.service.UIServiceFactory;
import com.migestion.ui.swing.cajas.dialog.DialogSeleccionarCaja;
import com.migestion.ui.swing.i18n.I18nImages;
import com.migestion.ui.swing.i18n.I18nMessages;

public class MiGestionApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//	                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (Exception ex) {
	                }

	                SwingWorker worker = new SwingWorker() {
	                    @Override
	                    protected Object doInBackground() throws Exception {
	                        //for (int index = 0; index < 100; index++) {
	                            //Thread.sleep(50);
	                    		int index = 0;
	                            PersistenceContext.getInstance().getEntityManager();
	                            index += 50;
	                            setProgress(index);
	                            
	                            AppContext.getInstance().setVendedorDefault( (Vendedor) UIServiceFactory.getUIVendedorService().getVendedorTitularComercio() );
	                            index += 10;
	                            setProgress(index);
	                            
	                            //cliente default
	                            AppContext.getInstance().setClienteDefault( (Cliente) UIServiceFactory.getUIClienteService().getClienteMostrador());
	                            index += 10;
	                            setProgress(index);
	                            
	                			//sucursal default
	                			Sucursal sucursal = new Sucursal();
	                			sucursal.setOid(ValoresPredefinidos.SUCURSAL_CASA_MATRIZ);
	                			AppContext.getInstance().setSucursalDefault( (Sucursal) UIServiceFactory.getUISucursalService().getObject(sucursal));
	                			index += 10;
	                        	setProgress(index);
	                            
	                			//categoría producto default
	                			CategoriaProducto categoriaProducto = new CategoriaProducto();
	                			categoriaProducto.setOid(ValoresPredefinidos.CATEGORIA_PRODUCTO_GENERAL);
	                			AppContext.getInstance().setCategoriaProductoDefault( (CategoriaProducto) UIServiceFactory.getUICategoriaProductoService().getObject(categoriaProducto));
	                			index += 10;
	                        	setProgress(index);

	                            //caja default
	                        	UICajaCriteria criteria = new UICajaCriteria();
	                			criteria.addEstado( EstadoCaja.ABIERTA );
	                			UICollection cajasAbiertas = UIServiceFactory.getUICajaService().list( criteria );
	                			if(cajasAbiertas.getRowCount()>0)
	                				AppContext.getInstance().setCajaDefault( (Caja) cajasAbiertas.getElement(0) );
	                            index += 10;
	                            setProgress(index);

	                            AppContext.getInstance().setConceptoVenta( UIServiceFactory.getUIConceptoMovimientoService().getConceptoVentas() );
	                            AppContext.getInstance().setConceptoOrdenCompra( UIServiceFactory.getUIConceptoMovimientoService().getConceptoOrdenCompra() );
	                            index += 10;
	                            setProgress(index);
	                            setProgress(100);
	                       // }
	                        
	                        
	                        return null;
	                    }

	                };

	                ProgressDialog.showProgress(null, worker,I18nMessages.TITULO_MAIN, "Inicializando el sistema...", "Espere unos segundos", new ImageIcon(I18nImages.LOGO_ICON).getImage());

	                //System.exit(0);

	                DialogSeleccionarCaja dialogCaja = new DialogSeleccionarCaja(new Frame(), true);
	                dialogCaja.setIconImage(new ImageIcon(I18nImages.LOGO_ICON).getImage());
	                UbicacionVentana.centrar(dialogCaja, false);
            		dialogCaja.setVisible(true);
            		
            		

	            }

	        });

	   
		
	}

}
