package com.finzly.FXTrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrade.entity.Trade;
import com.finzly.FXTrade.service.TradeService;

@RestController
@RequestMapping("trade")
public class TradeController {

	private final TradeService tradeService;

	@Autowired
	public TradeController(TradeService tradeService) {
		this.tradeService = tradeService;
	}

	@GetMapping("/get-all-trades")
	public ResponseEntity<Object> getTrades() {
		return tradeService.getTrades();
	}

	@PostMapping("/book-trade")
	public String bookTrade(@RequestBody Trade trade) {
		return tradeService.addNewTrade(trade);
	}

	@PostMapping("/trade-rate")
	public String getRate(@RequestBody Trade trade) {
		return tradeService.getRate(trade);
	}

}
