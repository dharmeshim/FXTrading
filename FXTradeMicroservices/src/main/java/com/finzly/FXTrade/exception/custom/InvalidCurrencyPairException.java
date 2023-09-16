package com.finzly.FXTrade.exception.custom;

public class InvalidCurrencyPairException extends RuntimeException {

	public InvalidCurrencyPairException(String message) {
		super(message);
	}
	
	public InvalidCurrencyPairException() {
		
	}
}
