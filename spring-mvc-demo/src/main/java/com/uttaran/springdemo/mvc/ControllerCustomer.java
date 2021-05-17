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
		
		//adding student object to the model
		Customer cust = new Customer();
		model.addAttribute("customer", cust);
		
		//calling the form page
		return "form-customer";		
	}
	
	@RequestMapping("processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer cust,
			BindingResult bindingResult) {
		
		System.out.println("First Name: =" + cust.getFirstName() + "=");
		
		//checking for any errors in the form
		if(bindingResult.hasErrors())
			return "form-customer";		
		
		//if none then proceed to display details page
		else
			return "display-customer-form";
	}
	
}
