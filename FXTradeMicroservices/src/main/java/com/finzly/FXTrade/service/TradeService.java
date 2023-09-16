package com.finzly.FXTrade.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FXTrade.dao.TradeDao;
import com.finzly.FXTrade.entity.Trade;
import com.finzly.FXTrade.exception.custom.AmountNotValidException;
import com.finzly.FXTrade.exception.custom.CustomerNameNotFoundException;
import com.finzly.FXTrade.exception.custom.NoCurrencyPairException;

import java.util.List;

@Service
public final class TradeService {

	private final CurrencyService currencyService;
	private final TradeDao tradeDao;

	@Autowired
	public TradeService(TradeDao tradeDao, CurrencyService currencyService) {
		this.currencyService = currencyService;
		this.tradeDao = tradeDao;
	}

	public ResponseEntity<Object> getTrades() {

		List<Trade> trades = tradeDao.getTradeTrasactions();

		if (trades.isEmpty()) {
			return new ResponseEntity<Object>("No Trades found!", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(trades, HttpStatus.FOUND);
		}

	}

	public String addNewTrade(Trade trade) {

		if ((checkValidDetails(trade) && (setTradeDetails(trade)))) {
			if (tradeDao.recordTransaction(trade)) {

				String tradeBookedStatement = "Trade for " + trade.getCurrencyPair() 
						+ "has been booked with rate "
						+ trade.getRate() + ", The amount of " 
						+ trade.getCurrencyPair().substring(3)
						+ trade.getForeignAmount() 
						+ " will be transferred in 2 working days to "
						+ trade.getCustomerName() + ".";

				return tradeBookedStatement;
			}
		}
		return "Trade not confirmed";
	}

	public String getRate(Trade trade) {

		if ((checkValidDetails(trade) && (setTradeDetails(trade)))) {

			String tradeRateStatement = "You are transferring " 
					+ trade.getCurrencyPair().substring(3)
					+ trade.getForeignAmount() 
					+ " to " + trade.getCustomerName() 
					+ ".(current "
					+ trade.getCurrencyPair() 
					+ "rate is " 
					+ trade.getRate() + ")";

			return tradeRateStatement;
		} 
		else {
			return "Input not valid";
		}

	}

	private boolean setTradeDetails(Trade trade) {
		String currencyPairName = trade.getCurrencyPair();
		double currencyPairRate = currencyService.getCurrencyPairRate(currencyPairName);

		trade.setCurrencyPair(currencyPairName);
		trade.setRate(currencyPairRate);
		trade.setForeignAmount(trade.getLocalAmount() * currencyPairRate);

		return true;
	}

	private boolean checkValidDetails(Trade trade) {

		if (trade.getCustomerName() == null) {
			throw new CustomerNameNotFoundException();
		} else if (trade.getCurrencyPair() == null) {
			throw new NoCurrencyPairException();
		} else if (trade.getLocalAmount() <= 0) {
			throw new AmountNotValidException();
		} else {
			return true;
		}

	}

}
