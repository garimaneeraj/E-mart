package com.guddu.emart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.model.Category;

public class CategoryTest {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		Category category=(Category)context.getBean("category");
		System.out.println("Bean Working");
		context.close();
	}
}
