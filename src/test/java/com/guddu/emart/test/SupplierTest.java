package com.guddu.emart.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.model.Supplier;

public class SupplierTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		Supplier supplier=(Supplier)context.getBean("supplier");
		System.out.println("Bean Working");
		context.close();
	}

}
