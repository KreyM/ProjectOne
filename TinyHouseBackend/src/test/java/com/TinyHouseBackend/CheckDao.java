/*package com.TinyHouseBackend;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.model.*;
import com.Dao.*;
import com.DaoImpl.*;
public class CheckDao 
{
	@Autowired static AnnotationConfigApplicationContext context;
	static Supplier suppDao;// change to SupplierDaoImpl
	@BeforeClass
	public static void initialize()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.*");
		context.refresh();
		suppDao=(Supplier)context.getBean("supplier");
		
	}
	
	@Test
	public void suppTest()
	{
		Supplier ss= new Supplier();
		ss.setSid(12);
		ss.setSupplierName("My Heaven");
		
	}

}
*/