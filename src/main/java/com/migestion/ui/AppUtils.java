package com.migestion.ui;

import java.util.Date;

import com.migestion.swing.utils.FormatUtils;
import com.migestion.ui.swing.i18n.I18nMessages;


public class AppUtils {


	public static String formatMoneda(Float number){
		
		if( number != null )
			
			return FormatUtils.formatMoneda(number, "$", true);
		
		else
			
			return "";
	}
	
	public static String formatDate(Date fecha){
		if( fecha != null )
			return FormatUtils.format( fecha, I18nMessages.FORMATO_DATE );
		else
			return "";
	}
	
	public static String formatDatetime(Date fecha){
		if( fecha != null )
			return FormatUtils.format( fecha, I18nMessages.FORMATO_DATETIME );
		else
			return "";
	}	
}
