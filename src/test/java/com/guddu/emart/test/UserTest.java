package com.guddu.emart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.model.User;

public class UserTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		User user=(User)context.getBean("user");
		System.out.println("Bean Working");
		context.close();
	}
}
