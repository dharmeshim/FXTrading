package com.finzly.FXTrade.exception.custom;

public class NoCurrencyPairException extends RuntimeException {

	public NoCurrencyPairException() {

	}

	public NoCurrencyPairException(String message) {
		super(message);
	}
}
