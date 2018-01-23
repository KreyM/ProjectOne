package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
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
		session.getTransaction().commit();
	}
	
	public List<Product> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> li =session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;
	}
	
	public Product findByPID(int pid)
	{
		Session session=sessionFactory.openSession();
		Product p=null;
		try
		{
			session.beginTransaction();
			p=session.get(Product.class, pid);
			session.getTransaction().commit();
		}
		
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
		
	}
	
	public List<Product> getProdBycatId(int cid)
	{
		Session session=sessionFactory.openSession();
		List<Product> prod=null;
		try
		{
			session.beginTransaction();
			prod=session.createQuery("from Product where cid=" + cid).list();
			session.getTransaction().commit();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return prod;	
	}
	
	public void update(Product prod)
	{
		System.out.println("update enter");
		Session session= sessionFactory.openSession();
		session.beginTransaction();
	
		session.update(prod);
		System.out.println("update entry 2");System.out.println("somewhat");
		session.getTransaction().commit();
		/*catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}*/
		System.out.println("somewhat");
	}
	
	public void deleteProduct(int pid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Product p= (Product)session.get(Product.class, pid);
		session.delete(p);
		session.getTransaction().commit();
	}
	
}


