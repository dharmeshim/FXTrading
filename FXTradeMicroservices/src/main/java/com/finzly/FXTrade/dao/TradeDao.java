package com.finzly.FXTrade.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.FXTrade.entity.Trade;

@Repository
public class TradeDao {

	private final SessionFactory seesionFactory;

	@Autowired
	public TradeDao(SessionFactory sessionFactory) {
		super();
		this.seesionFactory = sessionFactory;
	}

	public List<Trade> getTradeTrasactions() {

		Session session = seesionFactory.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		List<Trade> trades = criteria.list();
		session.close();
		return trades;

	}

	public boolean recordTransaction(Trade trade) {
		Session session = seesionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(trade);
		tx.commit();
		session.close();
		return true;

	}

}
