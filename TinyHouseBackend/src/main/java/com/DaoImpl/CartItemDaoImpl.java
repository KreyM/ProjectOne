	package com.DaoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Dao.CartItemDao;
import com.model.*;

//import org.springframework.transaction.annotation.Transactional; @Transactional
@Repository
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertCartItem(CartItem cartItem) {
	
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(cartItem);
		session.getTransaction().commit();
		System.out.println(" insertCartItem complete");
		
			/*Session session= sessionFactory.openSession();
			session.beginTransaction();
			session.persist(cartItem);
			session.getTransaction().commit();*/
	}
	@Autowired
	public CartItemDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory=sessionFactory;
	}
	public CartItem get(int id) {
		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));
	}
	
	public List<CartItem> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM CartItem", CartItem.class).getResultList();
	}

	public boolean add(CartItem cartItem) {
		try {
			// adding category to database
			sessionFactory.getCurrentSession().save(cartItem);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*public boolean update(CartItem cartItem) {
		try {
			// adding category to database
			sessionFactory.getCurrentSession().update(cartItem);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
*/
	public void update(CartItem cartItem)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.update(cartItem);
		session.getTransaction().commit();
	}
	public void delete(int id) {
		
	
		Query q=sessionFactory.getCurrentSession().createQuery("Delete from CartItem where id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		

	}

	public CartItem getCartByUserId(int userId) {
		return (CartItem) sessionFactory.getCurrentSession().createQuery("from CartItem where userid =: userId").setParameter("user", userId).getSingleResult();
	}

	public CartItem getCartByUserIdAndProduct(int userId, int productId) {

		return (CartItem) sessionFactory.getCurrentSession().createQuery("FROM CartItem  WHERE userid=: userId and productid=: productId").getResultList();
	}

	public void delete(int cartid, int productid) {
		
		Query q=sessionFactory.getCurrentSession().createQuery("delete CartItem where cart_id=:cartid and product_id=:proid");
		q.setParameter("cartid", cartid);
		q.setParameter("proid", productid);
		q.executeUpdate();
	}

	public CartItem getCartItemByCartIdAndProductId(int cartId, int pid) {
	System.out.println("entering getCartItemByCartIdAndProductId ");
	String selectQuery = "From CartItem where id=:cartId  and pid=:pid";
	
	Query query = sessionFactory.openSession().createQuery(selectQuery);
	
	query.setParameter("cartId",cartId);
	System.out.println("setting acart id and pid");
	query.setParameter("pid", pid);
	System.out.print("18/2 cartid=="+cartId+" pid "+pid+"\n");
	List<CartItem> cartItems = query.getResultList();
	System.out.println(query.getResultList());
	if(cartItems != null && !cartItems.isEmpty()){
		System.out.println("enteriny if");
		return cartItems.get(0);
	}
	System.out.println("entering null in cartitem");
	return null;
	/*try{
			System.out.println("18/02 entering try");
			Query q=sessionFactory.openSession().createQuery("From CartItem where id=:cartId  and pid=:pid")
			return (CartItem) sessionFactory.getCurrentSession().createQuery("From CartItem where id=:cartId  and pid=:pid").getSingleResult();
		System.out.print("18/2 cartid==");
		q.setParameter("cartId", cartId);
		System.out.println(cartId);
		q.setParameter("pid", pid);
		System.out.println("pid ="+pid);
		return (CartItem) sessionFactory.getCurrentSession().createQuery("FROM CartItem  WHERE userid=: userId and productid=: productId").getResultList();
 		return (CartItem) sessionFactory.getCurrentSession().createQuery("from CartItem where userid =: userId").setParameter("user", userId).getSingleResult();
	
		CartItem carti=(CartItem) q.getSingleResult();
		System.out.println("18/2 cartitem= "+carti);
		return (CartItem)q.getSingleResult();
		}catch(Exception e)
		{
			System.out.println("18/02 entering exception");
			return null;
		}*/
	}

	public boolean deleteAllCartItems(int cartid) {
		
		try{
			Query q=sessionFactory.getCurrentSession().createQuery("delete From CartItem where cart_id=:cartid");
			q.setParameter("cartid", cartid);
			
		int i=	q.executeUpdate();
		System.out.println("number of rows effected"+i);
			
			return true;
			}catch(Exception e)
			{
				System.out.println(e);
				return false;
			}
		
	}
	
}
