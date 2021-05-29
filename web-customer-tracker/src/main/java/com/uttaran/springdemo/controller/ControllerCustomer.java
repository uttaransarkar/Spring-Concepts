package com.uttaran.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uttaran.springdemo.dao.CustomerDAO;
import com.uttaran.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class ControllerCustomer {
	
	//injecting DAO class
	@Autowired
	private CustomerDAO customerDao;
	
	@RequestMapping("/list-customers")
	public String listCustomers(Model model) {
		
		//getting customers list from DAO 
		List<Customer> customersList = customerDao.getCustomers(); 
		
		//adding this customers list to the model
		model.addAttribute("customers", customersList);
		
		return "list-customers";
	}
}
