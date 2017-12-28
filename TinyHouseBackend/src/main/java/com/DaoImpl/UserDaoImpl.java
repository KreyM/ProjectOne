package com.DaoImpl;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UserDaoImpl()
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
	public void insertUser(User user)
	{
		Session session= sessionFactory.openSession();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
}
