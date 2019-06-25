package com.ecomm.backend2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryUnitTest 
{
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void exeuteFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Ignore*/
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
	/*	category.setCategoryName("Tablet");
		category.setCategoryDesc("Electronics1");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	*/		
	}
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deleting Category:",categoryDAO.deleteCategory(category));
	}
	@Ignore
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryName("Television1");
		category.setCategoryDesc("Electronics1");
		assertTrue("Problem in Updating the Category",categoryDAO.updateCategory(category));
	}
	

	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertTrue("Problem in Listing Categories:",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.println("Category ID:"+category.getCategoryID());
			System.out.println("Category Name:"+category.getCategoryName());
			System.out.println("Category Desc:"+category.getCategoryDesc());
		}
	}

	
}
