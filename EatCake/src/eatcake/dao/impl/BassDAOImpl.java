package eatcake.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BassDAOImpl {
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
		
}
