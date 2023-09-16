package com.finzly.FXTrade.exception.custom;

public class RequestBodyMissingException extends RuntimeException {

	public RequestBodyMissingException() {

	}

	public RequestBodyMissingException(String message) {
		super(message);
	}

}
