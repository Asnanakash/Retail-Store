package com.ecomm.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.dao.InvoiceDAO;
import com.ecomm.model.Invoice;

@Repository("invoiceDAO")
@Transactional
public class InvoiceDAOImpl implements InvoiceDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	
	LocalDate todayLocalDate = LocalDate.now();
	DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String date1 = sdf.format(todayLocalDate);
    String date2 = "select orderDate from Invoice where username=:uname";
 
     //compareTo()
    int dateDifference = date1.compareTo(date2);
	
    int percent=TotalAmount/100;

    
    if(productId!="Gr00")
	{
	if(userId==employeeId)
	{
		discountRate=percent*30;
	}
	else if(userId==storeMemberId)
	{
		discountRate=percent*10;
	}
	else if(dateDiffernce>=2)
	{
		discountRate=percent*5;
		
	}
	else if(Total>=100)
	{
		discountRate=Total-((TotalAmount%100)*5);
	}

	}
    
	
	public boolean saveOrder(Invoice invoice) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(invoice);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCart(String username) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set PaymentStatuse='paid' where username=:uname");
		query.setParameter("uname", username);
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
			return false;
		
	}
	
	
	
	
}
