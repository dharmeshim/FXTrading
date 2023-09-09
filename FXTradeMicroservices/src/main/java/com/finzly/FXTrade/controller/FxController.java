package com.finzly.FXTrade.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrade.entity.Trade;
import com.finzly.FXTrade.services.FxServices;

@RestController
@RequestMapping("home")
public class FxController {

	private final FxServices fxServices;

	@Autowired
	public FxController(FxServices fxServices) {
		this.fxServices = fxServices;
	}

	@GetMapping("/trades")
	public ResponseEntity<Object> getTrades() {
		return fxServices.getTrades();
	}

	@PostMapping("/book")
	public String bookTrade(@RequestBody Trade trade) {
		return fxServices.addNewTrade(trade);
	}

}
