package com.finzly.FXTrade.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FXTrade.entity.Trade;
import java.util.ArrayList;
import java.util.List;

@Service
public class FxServices {

	private List<Trade> tradeList = new ArrayList<Trade>();
	private double usdToInrRate = 66;
	private long tradeNumber = 100;

	public ResponseEntity<Object> getTrades() {

		if (tradeList.isEmpty()) {
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(tradeList, HttpStatus.FOUND);
		}

	}

	public String addNewTrade(Trade trade) {

		if (!checkValidName(trade.getCustmerName())) {
			return "Name invalid!, Please give valid name";
		} else if (!checkValidCurrencyPair(trade.getCurrencyPair())) {
			return "Currency pair invalid!, Only USDINR is supported";
		} else if (!checkValidAmount(trade.getAmount())) {
			return "Amount invalid!, Please enter valid amount";
		} else {

			trade.setTradeNo(tradeNumber++);
			trade.setRate(usdToInrRate);
			trade.setAmount(trade.getAmount() * usdToInrRate);
			tradeList.add(trade);

			return "Trade for " + trade.getCurrencyPair() + " has been booked with rate " + trade.getRate()
					+ ", The amount of Rs " + trade.getAmount() + " will be transferred in 2 working days to "
					+ trade.getCustmerName() + ".";
		}

	}

	private boolean checkValidName(String name) {
		if ((!name.matches("^[a-zA-Z ]+$")) || name.trim() == null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkValidCurrencyPair(String currencyPair) {
		if (!currencyPair.equalsIgnoreCase("USDINR")) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkValidAmount(double amount) {
		if (!(Double.toString(amount)).matches("^[0-9]+(\\.[0-9]*)?$") || amount <= 0) {
			return false;
		} else {
			return true;
		}

	}

}
