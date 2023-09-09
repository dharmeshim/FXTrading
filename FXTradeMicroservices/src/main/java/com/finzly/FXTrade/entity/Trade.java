package com.finzly.FXTrade.entity;

public class Trade {

	private long tradeNumber;

	private String custmerName;

	private String currencyPair;

	private double amount;

	private double rate;

	public Trade() {

	}

	public Trade(long tradeNumber, String custmerName, String currencyPair, double amount, double rate) {
		super();
		this.tradeNumber = tradeNumber;
		this.custmerName = custmerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
		this.rate = rate;
	}

	public long getTradeNo() {
		return tradeNumber;
	}

	public void setTradeNo(long tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public String getCustmerName() {
		return custmerName;
	}

	public void setCustmerName(String custmerName) {
		this.custmerName = custmerName;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double usdToInr) {
		this.rate = usdToInr;
	}

	@Override
	public String toString() {
		return "Trade [tradeNo=" + tradeNumber + ", custmerName=" + custmerName + ", currencyPair=" + currencyPair
				+ ", amount=" + amount + ", rate=" + rate + "]";
	}

}