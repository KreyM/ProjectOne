/*package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.*;
import com.Dao.*;
import com.DaoImpl.*;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class DBConfig
{		
	@Autowired
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/shopping");
		dataSource.setUsername("bhavana");
		dataSource.setPassword("bha757058");
		System.out.println("Connection Established");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hbm2ddl.auto", "create");
		properties.put("hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties Created");
		return properties;

	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	System.out.println("Transaction");
	return transactionManager;
	}
	
	@Autowired
	@Bean(name="cartItemDao")
	public CartItemDaoImpl getCartData(SessionFactory sessionFac)
	{
		return new  CartItemDaoImpl(sessionFac);
	}
	
	
	@Autowired
	@Bean(name="supplierDao")
	public SupplierDaoImpl getSupplierData(SessionFactory sessionFac)
	{
		return new  SupplierDaoImpl(sessionFac);
		
	}
	
	@Autowired
	@Bean(name="userDao")
	public UserDaoImpl getUserData(SessionFactory sessionFac)
	{
		System.out.println("User Dao object Creation");
		return new UserDaoImpl(sessionFac);
	}
	
	@Autowired
	@Bean(name="categoryDao")
	public CategoryDaoImpl getCategoryData(SessionFactory sessionFac)
	{
		return new CategoryDaoImpl(sessionFac);
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDaoImpl getProductData(SessionFactory sessionFac)
	{
		return new ProductDaoImpl(sessionFac);
	}
	
	@Autowired
	@Bean(name="userOrderDao")
	public UserOrderDaoImpl getUserOrderData(SessionFactory sessionFac)
	{
		System.out.println("UserOrder Dao object Creation");
		return new UserOrderDaoImpl(sessionFac);
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.*");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(UserOrder.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;		
	}

	
}



*/