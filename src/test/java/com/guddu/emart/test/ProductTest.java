package com.guddu.emart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.model.Product;


public class ProductTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		Product product=(Product)context.getBean("product");
		System.out.println("Bean Working");
		context.close();
	}

}
