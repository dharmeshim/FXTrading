package com.finzly.FXTrade.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.FXTrade.dao.CurrencyPairDao;
import com.finzly.FXTrade.entity.CurrencyPair;
import com.finzly.FXTrade.exception.custom.CurrencyNameNotFoundException;
import com.finzly.FXTrade.exception.custom.CurrencyPairAlreadyExistsException;
import com.finzly.FXTrade.exception.custom.CurrencyPairNotFoundException;
import com.finzly.FXTrade.exception.custom.CurrencyRateNotValidException;

@Service
public class CurrencyService {

	private final CurrencyPairDao currencyDao;

	private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);

	@Autowired
	public CurrencyService(CurrencyPairDao currencyDao) {
		this.currencyDao = currencyDao;
	}

	public String addCurrencyPair(CurrencyPair currencyPair) {

		if (isValidDetails(currencyPair)) {
			return currencyDao.saveCurrencyPair(currencyPair);
		} else {
			return " Invalid Currency details";
		}

	}

	public double getCurrencyPairRate(String currencyName) {

		CurrencyPair currency = currencyDao.getCurrencyPairByName(currencyName);
		if (currency != null) {
			double currencyPairRate = currency.getCurrencyRate();
			return currencyPairRate;
		}

		else {
			logger.error("In getCurrencyPairRate -- currency pair not found in table");
			throw new CurrencyPairNotFoundException();
		}

	}

	private boolean isValidDetails(CurrencyPair currencyPair) {
		if (currencyPair.getCurrencyName() == null || currencyPair.getCurrencyName() == "") {

			logger.error("Currency Pair name is null");
			throw new CurrencyNameNotFoundException();
		}

		else if (currencyPair.getCurrencyRate() <= 0) {

			logger.error("Currency rate is not valid : " + currencyPair.getCurrencyRate());
			throw new CurrencyRateNotValidException();
		}

		else if (currencyDao.isCurrencyPairExist(currencyPair)) {

			logger.error("Currency Pair is already exist");
			throw new CurrencyPairAlreadyExistsException();
		}

		else {
			return true;
		}

	}

}
