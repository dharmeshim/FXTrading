package com.finzly.FXTrade.exception.custom;

public class AmountNotValidException extends RuntimeException{
	
	public AmountNotValidException() {
		
	}
	
	public AmountNotValidException(String message) {
		super(message);
	}
}
