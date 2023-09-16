package com.finzly.FXTrade.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.FXTrade.entity.CurrencyPair;
import com.finzly.FXTrade.exception.custom.CurrencyPairNotFoundException;
import com.finzly.FXTrade.service.CurrencyService;

@Repository
public class CurrencyPairDao {

	private final SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(CurrencyPairDao.class);

	@Autowired
	public CurrencyPairDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public String saveCurrencyPair(CurrencyPair currencyPair) {
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(currencyPair);
			transaction.commit();
		} catch (Exception e) {

			logger.error("Exception : " + e);
			return "Failed to insert currency pair";
		}
		return "Currency pair inserted.";
	}

	public CurrencyPair getCurrencyPairByName(String currencyPairName) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(CurrencyPair.class);
			criteria.add(Restrictions.eq("currencyName", currencyPairName));
			return (CurrencyPair) criteria.uniqueResult();
		} catch (Exception e) {
			throw new CurrencyPairNotFoundException();
		}
	}

	public boolean isCurrencyPairExist(CurrencyPair currencyPair) {
		try (Session session = sessionFactory.openSession()) {
			Criteria criteria = session.createCriteria(CurrencyPair.class);
			criteria.add(Restrictions.eq("currencyName", currencyPair.getCurrencyName()));
			return criteria.uniqueResult() != null;
		} catch (Exception e) {
			return false;
		}
	}

}
