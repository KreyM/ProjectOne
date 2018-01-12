package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Dao.*;
import com.model.*;

public class ProductDaoImpl implements ProductDao 
{
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insertProduct(Product product)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.persist(product);
		/*session.saveOrUpdate(product);*/
		session.getTransaction().commit();
	}
	

}
