package com.migestion.ui.swing.i18n.utils;


import java.util.HashMap;
import java.util.Map;

import com.migestion.model.EstadoOrdenCompra;
import com.migestion.model.EstadoProducto;
import com.migestion.model.EstadoVenta;
import com.migestion.ui.swing.i18n.I18nMessages;

/**
 * Colabora con los labels de los enumerados.
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 09/10/2013
 *
 */
public class EnumUtils {

	public static String getLabelFor(EstadoProducto estado) {
		Map<EstadoProducto, String> estadosLabel = new HashMap<EstadoProducto, String>();
		estadosLabel.put(EstadoProducto.ACTIVO, I18nMessages.ESTADO_PRODUCTO_ACTIVO);
		estadosLabel.put(EstadoProducto.INACTIVO, I18nMessages.ESTADO_PRODUCTO_INACTIVO);
		estadosLabel.put(EstadoProducto.AGOTADO, I18nMessages.ESTADO_PRODUCTO_AGOTADO);
		estadosLabel.put(EstadoProducto.ELIMINADO, I18nMessages.ESTADO_PRODUCTO_ELIMINADO);
		
		if( estadosLabel.containsKey(estado) )
			return estadosLabel.get(estado);
		else return "";
	}

	public static String getLabelFor(EstadoVenta estado) {
		
//		Map<EstadoVenta, String> estadosLabel = new HashMap<EstadoVenta, String>();
//		
//		for (EstadoVenta item : EstadoVenta.values()) {
//		
//			estadosLabel.put( item, I18nMessages.locale( item.getNombre() ));
//		}
//		if( estadosLabel.containsKey(estado) )
//			return estadosLabel.get(estado);
//		else return "";
		
		return I18nMessages.locale( estado.getNombre() );
	}


	public static String getLabelFor(EstadoOrdenCompra estado) {
		
		return I18nMessages.locale( estado.getNombre() );
	}
}
