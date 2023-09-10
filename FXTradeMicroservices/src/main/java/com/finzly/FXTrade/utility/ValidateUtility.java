package com.finzly.FXTrade.utility;

import org.springframework.stereotype.Component;

import com.finzly.FXTrade.beans.TradeBean;

@Component
public class ValidateUtility {
	
	public String checkValid(TradeBean trade) {
		if (!checkValidName(trade.getCustmerName())) {
			return "Name invalid!, Please give valid name";
		} else if (!checkValidCurrencyPair(trade.getCurrencyPair())) {
			return "Currency pair invalid!, Only USDINR is supported";
		} else if (!checkValidAmount(trade.getAmount())) {
			return "Amount invalid!, Please enter valid amount";
		} else {
			return "valid";
		}

	}
	
	private boolean checkValidName(String name) {
		if (name == null ||(!name.matches("^[a-zA-Z ]+$")) || name.trim() == null) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkValidCurrencyPair(String currencyPair) {
		if (currencyPair == null ||(!currencyPair.equalsIgnoreCase("USDINR"))) {
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
