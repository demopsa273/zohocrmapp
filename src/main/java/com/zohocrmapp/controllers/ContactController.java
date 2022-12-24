package com.zohocrmapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrmapp.entities.Billing;
import com.zohocrmapp.entities.Contact;
import com.zohocrmapp.services.BillingService;
import com.zohocrmapp.services.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	
	//http://localhost:8080/listcontacts
			@RequestMapping("/listcontacts")
			public String Listcontacts(Model model) {
				List<Contact> contacts=	contactService.getAllContacts();
				model.addAttribute("contacts", contacts);
				return"list_contacts";	
			}
		
			@RequestMapping("/createBill")
			public String createBill(@RequestParam("id") long id,Model model) {
				Contact contact=contactService.getContactsByid(id);
				model.addAttribute("contact", contact);
				return"generate_bill";	
			}
			@RequestMapping("/saveBill")
			public String saveBill(Billing bill) {
				billingService.generateBill(bill);
				return"list_bills";	
			}
			@RequestMapping("/listbills")
			public String getBills(Model model) {
			List<Billing> bills=billingService.getAllBills();
			model.addAttribute("bills", bills);
				return"list_bills";	
			}
			
			

}
