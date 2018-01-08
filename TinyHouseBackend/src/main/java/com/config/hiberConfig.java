package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
/*import org.apache.commons.dbcp2.BasicDataSource;*/
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*import org.springframework.jdbc.datasource.DriverManagerDataSource;
*/import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.UserDaoImpl;
import com.model.User;
/*import com.model.User;*/


@Configuration
@ComponentScan(basePackages = {"com"})
@EnableTransactionManagement

public class hiberConfig {
	
private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/tested";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";

	@Bean("dataSource")
	public DataSource getDataSource() {
		// providing the database connections
		System.out.println("hibernate initiated........");
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
	
		System.out.println("H2 connected........");

		return datasource;
	}

	/*@Autowired
	@Bean(name="datasource")
	
		public DataSource getH2Data()
		{
		System.out.println("hibernate bean initiated");
		DriverManagerDataSource datasource= new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
	
		datasource.setUrl("jdbc:h2:tcp://localhost/~/BookDb");
		
		System.out.println("welcome........");
		datasource.setUsername("sa");
		datasource.setPassword(" ");
		System.out.println("H2 connected........");
		return datasource;
		}*/
	
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("tables created.......");
		return properties;

	}
	/*private Properties getHiber()
	{
		
		
		Properties p= new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.H2dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql","true");
		System.out.println("Tables created..................");
		return p;
	}*/
	/*	@Bean
		public SessionFactory getSessionFactory(DataSource datasource) {
			System.out.println("welcome 2.......");
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
			builder.addProperties(getHibernateProperties());
			builder.addAnnotatedClass(User.class);
			
			builder.scanPackages("net.bp.onlineshoppingBackend.dto");
			
			return builder.buildSessionFactory();
		}*/
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getHiberSession(DataSource datasource)
	{
		LocalSessionFactoryBuilder lsfb= new LocalSessionFactoryBuilder(datasource);
		lsfb.addProperties(getHibernateProperties());
		lsfb.addAnnotatedClass(User.class);
		//lsfb.scanPackages("com.User");
		System.out.println("SESSION FACTORY BEAN.......");
		return lsfb.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl saveUserData(SessionFactory sf)
	{	System.out.println("UserDaoImpl bean.......");
		return new UserDaoImpl(sf);
		
	}
	
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTrans(SessionFactory sf)
	{
		System.out.println("Transacion bean.......");
		HibernateTransactionManager tm= new HibernateTransactionManager(sf);
		return tm;
		}
}

/*// 08-01-18 to copy hemangi code
 * package com.config;
 

import java.util.Properties;

import javax.sql.DataSource;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
The type org.springframework.context.annotation.AdviceMode cannot be resolved. 
 * It is indirectly referenced from required .class files

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Category;
import com.model.Supplier;
import com.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hiberConfig 
{
	
	@Autowired
	@Bean(name = "datasource")
	public DataSource getH2Data() 
	{
		System.out.println("enter");
		DriverManagerDataSource dsource = new DriverManagerDataSource();
		System.out.println("h2 1 connected");
		dsource.setDriverClassName("org.h2.Driver");
		System.out.println("h2 2 connected");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/tested");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("h2 connected");
		return dsource;
	}
	
	
	private  Properties getHiber() {
		System.out.println("reached");
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true");
		System.out.println("Table is created in h2");
		return prop;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getHiberSession(DataSource datasource) {
		LocalSessionFactoryBuilder locsess = new LocalSessionFactoryBuilder(datasource);
		
		locsess.addProperties(getHiber());
		locsess.addAnnotatedClass(User.class);
		locsess.addAnnotatedClass(Supplier.class);
		locsess.addAnnotatedClass(Category.class);
		
		return locsess.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl saveUserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
		
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTrans(SessionFactory sf)
	{
		HibernateTransactionManager tm= new HibernateTransactionManager(sf);
		return tm;
	}
	

}

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.*;


*/