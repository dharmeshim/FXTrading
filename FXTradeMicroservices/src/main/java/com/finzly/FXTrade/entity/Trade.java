package com.finzly.FXTrade.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade_trasactions")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long tradeNumber;
	private String customerName;
	private String currencyPair;
	private double rate;
	private double localAmount;
	private double foreignAmount;

	public Trade() {

	}

	public Trade(long tradeNumber, 
			String customerName, 
			String currencyPair, 
			double rate, 
			double localAmount,
			double foreignAmount) {
		
		super();
		this.tradeNumber = tradeNumber;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.rate = rate;
		this.localAmount = localAmount;
		this.foreignAmount = foreignAmount;
	}

	public long getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(long tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustmerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getLocalAmount() {
		return localAmount;
	}

	public void setLocalAmount(double localAmount) {
		this.localAmount = localAmount;
	}

	public double getForeignAmount() {
		return foreignAmount;
	}

	public void setForeignAmount(double foreignAmount) {
		this.foreignAmount = foreignAmount;
	}

	@Override
	public String toString() {
		return "TradeEntity [tradeNumber=" + tradeNumber + ", customerName=" + customerName + ", currencyPair="
				+ currencyPair + ", rate=" + rate + ", localAmount=" + localAmount + ", foreignAmount=" + foreignAmount
				+ "]";
	}

	

}