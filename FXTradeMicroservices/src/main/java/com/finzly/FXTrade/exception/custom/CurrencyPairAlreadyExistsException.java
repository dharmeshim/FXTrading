package com.finzly.FXTrade.exception.custom;

public class CurrencyPairAlreadyExistsException extends RuntimeException {

	public CurrencyPairAlreadyExistsException(String message) {
		super(message);
	}

	public CurrencyPairAlreadyExistsException() {
	
	}

}
