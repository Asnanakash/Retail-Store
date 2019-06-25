package com.ecomm.backend2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartDAO;

import com.ecomm.model.Cart;


public class CartUnitTest 
{
	
	@Autowired
	static CartDAO cartDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Ignore
	@Test
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setProductId(6);
		cart.setProductName("Iphone8S");
		cart.setQuantity(2);
		cart.setPrice(35000);
		cart.setPaymentStatuse("YES");
		cart.setUsername("Asna");
		
		assertTrue("Problem in Adding Cart" , cartDAO.addCart(cart));
	}
	
	@Ignore
	@Test
	public void displayCart()
	{
		List<Cart> listCart=cartDAO.listCart("vamshi");
		assertTrue("Problem in Display the Cart" , listCart.size()>0);
		for(Cart cart:listCart)
		{
			System.out.print("\n"+cart.getProductId()+"\t");
			System.out.print(cart.getProductName()+"\t");
			System.out.print(cart.getPrice()+"\t");
			System.out.print(cart.getPrice()*cart.getQuantity());
		}
		
	}
	

}
