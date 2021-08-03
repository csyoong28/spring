package com.soonyoong.youtube.spring.datasupport;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public int getCircleCount() {
		String hql = "SELECT COUNT(*) from Circle";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return ((Long) query.uniqueResult()).intValue();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}	
