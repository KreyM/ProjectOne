package com.DaoImpl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.Dao.UserDao;
import com.model.User;

public class UserDaoImpl implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	
	public void insertUser(User user)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	public User findUserByEmail(String email)
	{
		System.out.println("enter find user by email");
		Session session= sessionFactory.openSession();
		User u=null;
		try {
		session.beginTransaction();
		u=session.get(User.class, email);
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		return u;
	}
}
