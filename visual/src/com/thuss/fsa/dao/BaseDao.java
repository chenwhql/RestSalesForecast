package com.thuss.fsa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface BaseDao {
	public Session getSession();

	void setSessionFactory(SessionFactory sessionFactory);
}
