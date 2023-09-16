package com.finzly.FXTrade.exception.custom;

public class CurrencyPairNotFoundException extends RuntimeException {
	
	public CurrencyPairNotFoundException() {
		
	}

	public CurrencyPairNotFoundException(String message) {
		super(message);
	}

}
