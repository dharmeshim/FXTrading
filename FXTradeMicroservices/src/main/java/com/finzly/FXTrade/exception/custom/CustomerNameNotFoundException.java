package com.finzly.FXTrade.exception.custom;

public class CustomerNameNotFoundException extends RuntimeException{
	
	public CustomerNameNotFoundException() {
		
	}
	
	public CustomerNameNotFoundException(String message) {
		super(message);
	}

}
