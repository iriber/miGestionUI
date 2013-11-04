package com.migestion.ui.swing.skin;

import java.awt.Color;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComponent;

public interface ISkinForm {

	
	public List<JComponent> getFormLabels();

	public List<JComponent> getFormInputs();

	public void setPadding(JComponent component, Insets padding);

	public void setFormBackground(Color bg);

	
}
