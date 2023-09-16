package com.finzly.FXTrade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrade.entity.CurrencyPair;
import com.finzly.FXTrade.service.CurrencyService;

@RestController
@RequestMapping("currency")
public class CurrencyController {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	private final CurrencyService currencyService;

	@Autowired
	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@PostMapping("/add-currency-pair")
	public String addCurrencyPair(@RequestBody CurrencyPair currencyPair) {

		return currencyService.addCurrencyPair(currencyPair);

	}

}
