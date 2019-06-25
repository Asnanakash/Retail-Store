package com.ecomm.backend2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;


public class ProductUnitTest 
{
  static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();	
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	
  
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Vaio");
		product.setProductDesc("Sony Laptops");
		product.setPrice(40000);
		product.setStock(155);
		product.setCategoryId(2);
		product.setSupplierId(3);
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
	}

}


