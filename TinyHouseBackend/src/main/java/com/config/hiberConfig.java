package com.config;

import java.util.Properties;

import javax.sql.DataSource;

/*import org.h2.engine.User;*/
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
/*The type org.springframework.context.annotation.AdviceMode cannot be resolved. 
 * It is indirectly referenced from required .class files
*/
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

//import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.UserDaoImpl;
import com.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hiberConfig 
{
	
	@Autowired
	@Bean(name = "dsource")
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
	
	/*@Autowired
	@Bean(name = "getHiber")*/
	private  Properties getHiber() {
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
		return locsess.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl saveUserData(SessionFactory sf)
	{
		return new UserDaoImpl(sf);
		
	}
	@SuppressWarnings("deprecation")
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTrans(SessionFactory sf)
	{
		HibernateTransactionManager tm= new HibernateTransactionManager();
		return tm;
	}
	

}
