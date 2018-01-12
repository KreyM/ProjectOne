package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.*;
import com.model.Supplier;

@Repository
@Service
public class SupplierDaoImpl implements SupplierDao
{

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
	public void insertSupplier(Supplier supplier)
	{
		System.out.println("supplier");
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(supplier);
		session.getTransaction().commit();
	}
	
	public List<Supplier> retrieve()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> li= session.createQuery("from Supplier").list();
		session.getTransaction().commit();
		return li;
	}
	
	public Supplier findBySupplierId(int sid)
	{
		Session session= sessionFactory.openSession();
		Supplier s=null;
		try
		{
		session.beginTransaction();
		s=session.get(Supplier.class, sid);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return s;
	}
	

}
