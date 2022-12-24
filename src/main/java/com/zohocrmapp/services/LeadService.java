package com.zohocrmapp.services;

import java.util.List;

import com.zohocrmapp.entities.Lead;

public interface LeadService {

	
	
	public void saveoneLead(Lead lead);
	public Lead getById(long id);
	public void deleteLeadByid(long id);
	public List<Lead> getAllLeads();
	
	
}
