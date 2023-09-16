package com.finzly.FXTrade.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_pairs")
public class CurrencyPair {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int currencyId;
	private String currencyName;
	private double currencyRate;

	public CurrencyPair() {
		super();
	}

	public CurrencyPair(int currencyId, 
			String currencyName, 
			double currencyRate) {
		
		super();
		this.currencyId = currencyId;
		this.currencyName = currencyName;
		this.currencyRate = currencyRate;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	@Override
	public String toString() {
		return "CurrencyEntity [currencyId=" + currencyId + ", currencyName=" + currencyName + ", currencyRate="
				+ currencyRate + "]";
	}

}
