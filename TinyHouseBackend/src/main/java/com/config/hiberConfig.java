package com.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.h2.engine.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
/*The type org.springframework.context.annotation.AdviceMode cannot be resolved. 
 * It is indirectly referenced from required .class files
*/
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
/*import org.springframework.transaction.annotation.EnableTransactionManagement;*/

@Configuration
@Component("com")

public class hiberConfig {
	@Autowired
	@Bean(name="datasourceTable")
	public DataSource getH2Data()
	{ 
		DriverManagerDataSource dsource= new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/demo");
		dsource.setUsername("sa");
		dsource.setPassword("");
		return dsource;
	}
	
	private Properties getHiber()
	{
		Properties prop =new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2dialect");
		prop.put("hibernate.hbm2dl.auto", "update");
		prop.put("hibernate.show_sql", "true");
		System.out.println("Table is created in h2");
		return prop;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	private SessionFactory gitHiberSession(DataSource datasource)
	{
		LocalSessionFactoryBuilder locsess=new LocalSessionFactoryBuilder(datasource);
		locsess.addAnnotatedClass(User.class);
		locsess.addProperties(getHiber());
		return locsess.buildSessionFactory();
	}

}
