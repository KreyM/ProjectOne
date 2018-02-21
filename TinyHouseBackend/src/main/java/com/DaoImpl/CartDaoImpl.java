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

@Repository/*("CartDaoImpl")*/
public class CartDaoImpl implements CartDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void insertCart(Cart cart) 
	{
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.saveOrUpdate(cart);	
		System.out.println(" insertcart complete");
		session.getTransaction().commit();
		
	}
	@Autowired
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> findByCartID(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr=null;
		try
		{
			session.beginTransaction();
			cr=(List<Cart>)session.createQuery("from Cart where userMailId=:email").setString("email", userId).list();
			session.getTransaction().commit();
		}
		
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
		
	}
	
	public Cart getCartById (int cartProductId, String userEmail)
	{
		System.out.println("cart id");
		Session session =sessionFactory.openSession();
		Cart cr=null;
		session.beginTransaction();
		cr= (Cart)session.createQuery("from Cart where userMailId=:email and cartProductId=:id").setString("email", userEmail).setInteger("id", cartProductId).uniqueResult();
		System.out.println("getCartById");
		session.getTransaction().commit();
		System.out.println("getCartById bye");
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
	
	public void updateCart(Cart cr)
	{
		Session session= sessionFactory.getCurrentSession();
		session.beginTransaction();
		System.out.println("cartdaoimple : update cart: session.beginTransaction();");
		session.update(cr);
		session.getTransaction().commit();
		System.out.println("uppdatecart over");
	}

}
