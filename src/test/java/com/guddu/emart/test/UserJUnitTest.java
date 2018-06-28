package com.guddu.emart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.model.User;
import com.guddu.emart.dao.UserDAO;

public class UserJUnitTest {

	private static AnnotationConfigApplicationContext context=null;
	private static User user=null;
	private static UserDAO UserDAO=null;
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		
		user=(User)context.getBean("user");//user is the original bean of the table
		UserDAO=(UserDAO)context.getBean("userDAO");//bean of DAOimpl
	}
	
	@Ignore
	@Test
	public void testSaveUserSuccess()
	{
		user.setUsername("Shelly");
		user.setAddress("Nirman Vihar");
		user.setAge(21);
		user.setEmailId("jellyShelly.99@gmail.com");
		user.setPassword("HI123");
		user.setPhone(123789450);
		assertEquals(true,UserDAO.saveUser(user));
	}
	
	@Test(expected=Exception.class)
	public void testUserSameFailure()
	{
		user.setUsername("Shelly");
		user.setAddress("Nirman Vihar");
		user.setAge(21);
		user.setEmailId("jellyShelly.99@gmail.com");
		user.setPassword("HI123");
		user.setPhone(123789450);
		assertEquals(true,UserDAO.saveUser(user));
	}
	

}
