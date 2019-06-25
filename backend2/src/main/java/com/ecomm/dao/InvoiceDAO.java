package com.ecomm.dao;

import com.ecomm.model.Invoice;

public interface InvoiceDAO 
{
	public boolean saveOrder(Invoice invoice);
	public boolean updateCart(String username);

}
