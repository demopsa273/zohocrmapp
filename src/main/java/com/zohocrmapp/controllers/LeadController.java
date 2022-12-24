package com.zohocrmapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.entities.Lead;
import com.zohocrmapp.services.ContactService;
import com.zohocrmapp.services.LeadService;


@Controller
public class LeadController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private LeadService leadService;
	
	
	//http://localhost:8080/createLead
	@RequestMapping(value="/createLead",method=RequestMethod.GET)
	public String viewCreateLeadForm() {
		return"create_lead";
	}

	@RequestMapping(value="/saveLead",method=RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead lead,Model model) {
		leadService.saveoneLead(lead);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.getById(id);
		Contact contact=new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		contactService.saveContact(contact);
		leadService.deleteLeadByid(id);
		List<Contact> contacts=contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return"list_contacts";
	}
	//http://localhost:8080/listleads
	@RequestMapping("/listleads")
	public String ListtLeads(Model model) {
		List<Lead> leads=leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return"list_leads";	
	}
	
	@RequestMapping("/leadinfo")
	public String leadinfo(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.getById(id);
		model.addAttribute("lead", lead);
		return"lead_info";	
	}
	
	
}
