package com.ecomm.backend2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;


public class UserUnitTest 
{
static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();	
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	

	@Ignore
	@Test
	public void registerUserTest()
	{
		UserDetail user=new UserDetail();
		
		user.setUsername("Asna");
		user.setPassword("user");
		user.setEnabled(true);
		user.setRole("USER");
		user.setCustomerName("asna_ra");
		user.setCustomerAddress("Kerala");
		
		assertTrue("Problem in adding User:",userDAO.registerUser(user));
	}


}
