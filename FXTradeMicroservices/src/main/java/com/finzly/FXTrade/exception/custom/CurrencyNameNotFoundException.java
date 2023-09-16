package com.finzly.FXTrade.exception.custom;

public class CurrencyNameNotFoundException extends RuntimeException{
	
	public CurrencyNameNotFoundException() {
		
	}
	
	public CurrencyNameNotFoundException(String message) {
		super(message);
	}

}
