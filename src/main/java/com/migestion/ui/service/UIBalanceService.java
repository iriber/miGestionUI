package com.migestion.ui.service;

import java.util.Date;

import com.migestion.model.Balance;
import com.migestion.services.ServiceFactory;
import com.migestion.services.exception.ServiceException;
import com.migestion.swing.controller.exception.ControllerException;



/**
 * Controlador utilizado para las operaciones de balances.
 * 
 * 
 * @author Bernardo Iribarne (ber.iribarne@gmail.com)
 * @since 07/11/2013
 * 
 */
public class UIBalanceService  {

	// instancia del manager (lo hacemos singleton).
	private static UIBalanceService instance;

	
	// pedimos la �nica instancia.
	public static UIBalanceService getInstance() {
		if (instance == null)
			instance = new UIBalanceService();
		return instance;
	}

	public Balance getBalanceCajas(Date fecha) throws ControllerException{
		
		try {
			
			Balance balance = ServiceFactory.getBalanceService().getBalanceCajas(fecha);
			
			return balance;
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}
		
	}
	
	public Balance getBalanceBancos(Date fecha) throws ControllerException{
		
		try {
			
			Balance balance = ServiceFactory.getBalanceService().getBalanceBancos(fecha);
			
			return balance;
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}
		
	}
	
	
	public Balance getBalanceCheques(Date fecha) throws ControllerException{
		
		try {
			
			Balance balance = ServiceFactory.getBalanceService().getBalanceCheques(fecha);
			
			return balance;
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}
		
	}
	
	public Balance getBalanceNotasCredito(Date fecha) throws ControllerException{
		
		try {
			
			Balance balance = ServiceFactory.getBalanceService().getBalanceNotasCredito(fecha);
			
			return balance;
			
		} catch (ServiceException e) {
			
			throw new ControllerException( e.getMessage() );
		}
		
	}
}
