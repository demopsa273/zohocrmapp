package com.zohocrmapp.services;



import java.util.List;

import com.zohocrmapp.entities.Billing;


public interface BillingService {
	
	public void generateBill(Billing bill);

	public List<Billing> getAllBills();
	

}
