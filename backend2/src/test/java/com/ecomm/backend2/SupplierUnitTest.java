package com.ecomm.backend2;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Supplier;

public class SupplierUnitTest {

	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void exeuteFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	
	@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("kiran");
		assertTrue("Problem in adding Supplier",supplierDAO.addSupplier(supplier));
			
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		assertTrue("Problem in Deleting Supplier:",supplierDAO.deleteSupplier(supplier));
	}
	
/*	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(3);
		supplier.setSupplierName("kiran");
		
		assertTrue("Problem in Updating the Supplier",supplierDAO.updateSupplier(supplier));
	}*/
	@Ignore
	@Test
	public void listSupplieresTest()
	{
		List<Supplier> listSupplieres=supplierDAO.listSuppliers();
		assertTrue("Problem in Listing Supplieres:",listSupplieres.size()>0);
		
		for(Supplier supplier:listSupplieres)
		{
			System.out.println("Supplier ID:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
		
		}
	}

}
