package com.guddu.emart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.dao.ProductDAO;
import com.guddu.emart.model.Product;


public class ProductJUnitTest {

	private static AnnotationConfigApplicationContext context=null;
	private static Product product=null;
	private static ProductDAO productDAO=null;
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		
		product=(Product)context.getBean("product");//user is the original bean of the table
	    productDAO=(ProductDAO)context.getBean("productDAO");//bean of DAOimpl
	}
	
	
	@Test
	public void testSaveProductSuccess()
	{
		product.setProductName("Mobiles");
		product.setProductDesc("Iphones");
		product.setPrice(35000);
		product.setStock(20);
		product.setCategoryId(1);
		product.setSupplierId(1);
		assertEquals(true,productDAO.addProduct(product));
	}
	
	
	

}
