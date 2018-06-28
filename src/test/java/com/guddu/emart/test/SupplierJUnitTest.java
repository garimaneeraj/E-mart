package com.guddu.emart.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guddu.emart.dao.SupplierDAO;
import com.guddu.emart.model.Supplier;


public class SupplierJUnitTest {

	private static AnnotationConfigApplicationContext context=null;
	private static Supplier supplier=null;
	private static SupplierDAO supplierDAO=null;
	
	@BeforeClass
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("com.guddu.emart");
		context.refresh();
		
		supplier=(Supplier)context.getBean("supplier");//user is the original bean of the table
	    supplierDAO=(SupplierDAO)context.getBean("supplierDAO");//bean of DAOimpl
	}
	
	@Ignore
	@Test
	public void testSaveSupplierSuccess()
	{
		supplier.setSupplierName("Mahindra");
		supplier.setSupplierAddr("Delhi");
		assertEquals(true,supplierDAO.addSupplier(supplier));
	}
	
	@Test(expected=Exception.class)
	public void testSupplierSameFailure()
	{
		supplier.setSupplierName("Mahindra");
		supplier.setSupplierAddr("Delhi");
		assertEquals(true,supplierDAO.addSupplier(supplier));
	}
	

}
