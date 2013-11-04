package com.migestion.ui.swing.skin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComponent;

import org.jdesktop.swingx.JXTaskPane;

/**
 * Para definir el skin de las pantallas.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 10/10/2013
 *
 */
public class SkinDecorator {

	private static SkinDecorator instance;
	
	//private static final Color BACKGOUNDCOLOR = new Color(0x23AAE1);
	private static final Color BACKGOUNDCOLOR = new Color(0xFFFFFF);
	
	private static final Font LABEL_FONT = new Font("Verdana", Font.BOLD, 14);
//	private static final Color LABEL_FOREGROUND = new Color(0xFFFFFF);
//	private static final Color LABEL_BACKGOUNDCOLOR = new Color(0x23AAE1);
	private static final Color LABEL_FOREGROUND = new Color(0x000000);
	private static final Color LABEL_BACKGOUNDCOLOR = new Color(0xFFFFFF);
	
	private static final Font INPUT_FONT = new Font("Verdana", Font.PLAIN, 14); 
	private static final Color INPUT_FOREGROUND = new Color(0x000000);
	private static final Color INPUT_BACKGOUNDCOLOR = new Color(0xFFFFFF);

	private static final Font MENU_FONT = new Font("Verdana", Font.BOLD, 11); 
	private static final Color MENU_FOREGROUND = new Color(0x000000);
	private static final Color MENU_BACKGOUNDCOLOR = new Color(0xFFFFFF);

	private SkinDecorator(){}
	
	public static SkinDecorator getInstance(){
		if(instance==null)
			instance = new SkinDecorator();
		
		return instance;
	}
	
	/**
	 * ajusta estilos en un form
	 * @param form
	 */
	public void decorate(ISkinForm form){


		this.skinPanel(form);

		this.skinFormLabels( form );
		
		this.skinFormInputs( form );
	}
	

	
	
	protected void skinPanel(ISkinForm form){
		form.setFormBackground(BACKGOUNDCOLOR);
	}
	
	protected void skinFormLabels(ISkinForm form){
		List<JComponent> labels = form.getFormLabels();
		Insets padding = new Insets(0, 10, 0, 10);	
		for (JComponent label : labels) {
			label.setFont(LABEL_FONT);
			label.setForeground(LABEL_FOREGROUND);
			label.setBackground(LABEL_BACKGOUNDCOLOR);
			form.setPadding(label, padding);
		}
	}
	
	protected void skinFormInputs(ISkinForm form){
		List<JComponent> inputs = form.getFormInputs();
		Insets padding = new Insets(0, 10, 0, 10);	
		for (JComponent input : inputs) {
			input.setFont(INPUT_FONT);
			input.setForeground(INPUT_FOREGROUND);
			input.setBackground(INPUT_BACKGOUNDCOLOR);
			form.setPadding(input, padding);
		}
	}

	public void decorate(JXTaskPane taskpane) {
		taskpane.setFont(MENU_FONT);
		taskpane.setBackground( MENU_BACKGOUNDCOLOR );
		taskpane.setForeground( MENU_FOREGROUND );
	}

}
