package com.finzly.FXTrade.exception;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.finzly.FXTrade.controller.CurrencyController;
import com.finzly.FXTrade.exception.custom.CurrencyNameNotFoundException;
import com.finzly.FXTrade.exception.custom.CurrencyPairAlreadyExistsException;
import com.finzly.FXTrade.exception.custom.CurrencyPairNotFoundException;
import com.finzly.FXTrade.exception.custom.CurrencyRateNotValidException;
import com.finzly.FXTrade.exception.custom.InvalidCurrencyPairException;
import com.finzly.FXTrade.exception.custom.NoCurrencyPairException;
import com.finzly.FXTrade.exception.custom.RequestBodyMissingException;
import com.finzly.FXTrade.exception.custom.CustomerNameNotFoundException;
import com.finzly.FXTrade.exception.custom.AmountNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);

	@ExceptionHandler(InvalidCurrencyPairException.class)
	public ResponseEntity<String> handleInvalidCurrencyPairException(InvalidCurrencyPairException ex) {

		String message = "Not valid currency Entered";
		logger.error(message);

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CurrencyNameNotFoundException.class)
	public ResponseEntity<String> handleCurrencyNameNotFoundException(CurrencyNameNotFoundException e) {

		String message = "Currency Name Not Entered!";
		logger.error(message);

		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CurrencyRateNotValidException.class)
	public ResponseEntity<String> handleCurrencyRateNotValidException(CurrencyRateNotValidException e) {
		
		String message = "Currency Rate Not Valid or Not Found!";
		logger.error(message);

		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CurrencyPairNotFoundException.class)
	public ResponseEntity<String> handleCurrencyPairNotFoundException(CurrencyPairNotFoundException e) {

		String message = "Currency Pair Not Found!";
		logger.error(message);
		
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CurrencyPairAlreadyExistsException.class)
	public ResponseEntity<String> handleCurrencyPairAlreadyExistsException(CurrencyPairAlreadyExistsException e) {
		String message = "Currency Pair already exists!";
		logger.error(message);
		return new ResponseEntity<>(message, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(RequestBodyMissingException.class)
	public ResponseEntity<String> handleRequestBodyMissingException(RequestBodyMissingException e) {

		String message = "Input Missing!";
		logger.error(message);
		
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerNameNotFoundException.class)
	public ResponseEntity<String> handleCustomerNameNotFoundException(CustomerNameNotFoundException e) {
		
		String message = "Customer Name Not Entered!";
		logger.error(message);

		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoCurrencyPairException.class)
	public ResponseEntity<String> handleNoCurrencyPairException(NoCurrencyPairException e) {

		String message = "Currency Pair Not Entered!";
		logger.error(message);
		
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AmountNotValidException.class)
	public ResponseEntity<String> AmountNotValidException(AmountNotValidException e) {

		String message = "Amount is not provided rightly!";
		logger.error(message);
		
		return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
	}

}
