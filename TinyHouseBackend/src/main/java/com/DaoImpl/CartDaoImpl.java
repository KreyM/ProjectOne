package com.DaoImpl;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CartDao;
import com.model.Cart;
import com.model.Product;

@Repository("CartDaoImpl")
public class CartDaoImpl implements CartDao
{
	@Autowired
	SessionFactory sessionFactory;

	public void insertCart(Cart cart) 
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> findByCartPID(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr=null;
		try
		{
			session.beginTransaction();
			cr= (List<Cart>)session.createQuery("from Cart where userMailId=: email").setString("email", userId);
		}
		
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
		
	}
	@SuppressWarnings("unchecked")
	public Cart getCartById (int cartId, String userEmail)
	{
		Session session =sessionFactory.openSession();
		Cart cr=null;
		session.beginTransaction();
		cr= (Cart)session.createQuery("from Cart where userMailId=: email and cartProductId=: pid").setString("email", userEmail).setInteger("pid", cartId).uniqueResult();
		session.getTransaction().commit();
		return cr;
	}
	
	public void deleteCart(int cartId)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Cart cr= (Cart)session.get(Cart.class, cartId);
		session.delete(cr);
		session.getTransaction().commit();
		
	}
	
	public void updatecart(Cart cr)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.update(cr);
		session.getTransaction().commit();
	}

}
