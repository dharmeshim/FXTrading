package com.finzly.FXTrade.services;

import org.springframework.http.ResponseEntity;
import com.finzly.FXTrade.beans.TradeBean;

public interface FxTradeService {
	
	public ResponseEntity<Object> getTrades();
	public String addNewTrade(TradeBean trade);
	public String getRate(TradeBean trade);

}
