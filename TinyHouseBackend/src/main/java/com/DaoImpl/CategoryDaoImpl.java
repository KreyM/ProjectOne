package com.DaoImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.*;
import com.model.*;

@Repository
@Service
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insertCategory(Category category)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
	}
	public void deleteCategory(int cid)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Category cat= (Category)session.get(Category.class, cid);
		//Product p= (Product)session.get(Product.class, pid);
		session.delete(cat);
		session.getTransaction().commit();
	}
	public List<Category> retrieve()
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li= session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;
	}
	
	public Category findByCID(int cid)
	{
		Session session= sessionFactory.openSession();
		Category c=null;
		try
		{
		session.beginTransaction();
		c=session.get(Category.class, cid);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}
		return c;
	}

	public void updateCat(Category cat) {
		System.out.println("update enter");
		Session session= sessionFactory.openSession();
		session.beginTransaction();
	
		session.update(cat);
		
		session.getTransaction().commit();
		
	}

	public void updateCategory(Category category) {
		/*try
		{
		sessionFactory.getCurrentSession().update(category);
		System.out.println();

		System.out.println("UPDATE TRUE");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		System.out.println();
		System.out.println("UPDATE FALSE");
		return false;
		}*/
		Session session=sessionFactory.openSession();
		Transaction tran=session.beginTransaction(); 
		session.update(category);
		tran.commit();
	}

}
