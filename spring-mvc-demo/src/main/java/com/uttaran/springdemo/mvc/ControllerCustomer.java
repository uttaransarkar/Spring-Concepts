package com.uttaran.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class ControllerCustomer {
	
	@RequestMapping("viewForm")
	public String viewForm(Model model) {
		
		Customer cust = new Customer();
		model.addAttribute("customer", cust);
		
		return "form-customer";		
	}
	
	@RequestMapping("processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer cust,
			BindingResult bindingResult) {
		
		System.out.println("First Name: =" + cust.getFirstName() + "=");
		if(bindingResult.hasErrors())
			return "form-customer";		
		else
			return "display-customer-form";
	}
	
}
