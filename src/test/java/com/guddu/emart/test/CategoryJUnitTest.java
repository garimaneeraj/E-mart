package com.guddu.emart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.dao.CategoryDAO;
import com.guddu.emart.model.Category;



public class CategoryJUnitTest {

	private static AnnotationConfigApplicationContext context=null;
	private static Category category=null;
	private static CategoryDAO categoryDAO=null;
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		
		category=(Category)context.getBean("category");//user is the original bean of the table
	    categoryDAO=(CategoryDAO)context.getBean("categoryDAO");//bean of DAOimpl
	}
	
	@Ignore
	@Test
	public void testSaveCategorySuccess()
	{
		category.setCategoryName("Tops");
		category.setCategoryDesc("From zara");
		assertEquals(true,categoryDAO.addCategory(category));
	}
	
	@Test(expected=Exception.class)
	public void testCategorySameFailure()
	{
		category.setCategoryName("Tops");
		category.setCategoryDesc("From zara");
		assertEquals(true,categoryDAO.addCategory(category));
	}
	

}
