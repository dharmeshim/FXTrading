package com.finzly.FXTrade.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.FXTrade.beans.TradeBean;
import com.finzly.FXTrade.services.FxTradeService;
import com.finzly.FXTrade.utility.ValidateUtility;

import java.util.ArrayList;
import java.util.List;


@Service
public final class FxTradeServiceImpl implements FxTradeService{
	
	@Autowired
	private ValidateUtility validater;
	
	private List<TradeBean> tradeList = new ArrayList<TradeBean>();
	private double usdToInrRate = 66;
	
	private long tradeNumberGenerater = 100;

	private FxTradeServiceImpl() {

	}

	@Override
	public ResponseEntity<Object> getTrades() {

		if (tradeList.isEmpty()) {
			return new ResponseEntity<Object>("No Trades",HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Object>(tradeList, HttpStatus.FOUND);
		}

	}

	@Override
	public String addNewTrade(TradeBean trade) {

		String validityStatus = validater.checkValid(trade);
		
		if (!validityStatus.equals("valid")) {
			return validityStatus;	
		} 
		
		else {

			trade.setTradeNumber(tradeNumberGenerater++);
			trade.setRate(usdToInrRate);
			trade.setAmount(trade.getAmount() * usdToInrRate);

			tradeList.add(trade);
			
			String tradeBookedStatement = "Trade for " + trade.getCurrencyPair() 
			+ " has been booked with rate " + trade.getRate()
			+ ", The amount of Rs " + trade.getAmount() 
			+ " will be transferred in 2 working days to "
			+ trade.getCustmerName() + ".";

			return tradeBookedStatement;
		}

	}

	@Override
	public String getRate(TradeBean trade) {

		String validitySatus = validater.checkValid(trade);
		if (!validitySatus.equals("valid")) {
			return validitySatus;
		}

		else {
			trade.setRate(usdToInrRate);
			trade.setAmount(trade.getAmount() * usdToInrRate);
			
			String tradeRateStatement ="You are transferring INR " 
					+ trade.getAmount() + " to " 
					+ trade.getCustmerName() 
					+ ".(Rate is "+ trade.getRate() + ")";

			return tradeRateStatement;
		}

	}

}
