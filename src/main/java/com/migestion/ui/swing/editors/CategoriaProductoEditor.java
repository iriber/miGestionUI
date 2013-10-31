package com.migestion.ui.swing.editors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.migestion.model.CategoriaProducto;
import com.migestion.swing.custom.JFindObjectPanel;
import com.migestion.swing.navigation.listeners.LinkFindObjectListener;
import com.migestion.ui.swing.finder.FinderFactory;

/**
 * Implementamos para editar celdas que contengan categoriaProducto
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 15/10/2013 
 */
public class CategoriaProductoEditor extends  AbstractCellEditor  implements TableCellEditor{
    
	JFindObjectPanel findCategoria;

	CategoriaProducto currentCategoriaProducto;
	
	public CategoriaProductoEditor(){

		findCategoria = FinderFactory.getFindCategoriaProducto( new LinkFindObjectListener() {
			
			public void objectFound(Object objectFinded) {
				currentCategoriaProducto = (CategoriaProducto)objectFinded;
			}
		});
		
	}
	
	
	public Object getCellEditorValue() {
		return currentCategoriaProducto;
	}

	public Component getTableCellEditorComponent(JTable arg0, Object arg1,
			boolean arg2, int arg3, int arg4) {
		
		
		findCategoria.objectFound(arg1);
		
		return findCategoria;
	}
	
	

}