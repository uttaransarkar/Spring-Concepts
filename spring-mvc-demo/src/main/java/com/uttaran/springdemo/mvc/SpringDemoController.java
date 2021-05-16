package com.uttaran.springdemo.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class SpringDemoController {
	
	//controller method to show initial HTML form
	@RequestMapping("/viewForm")
	public String viewForm() {
		
		return "mvc-demo-form";		//filename of html form
	}
	
	//controller method to process form data
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "mvc-form-display";		//filename of jsp display page
	}
	
	//controller method that reads form data and adds it to model via request object
	@RequestMapping("/processFormModel")
	public String callName(HttpServletRequest request, Model model) {
		
		//read form data from html form
		String fullName = request.getParameter("studentName");
		
		//perform any data manipulation
		fullName = fullName.toUpperCase();
		
		String greet = "Welcome, " + fullName + "!";
		
		//add this to model
		model.addAttribute("studentName", greet);
		
		return "mvc-form-display";
		
	}
	
	//controller method that adds form data to model via @RequestParam
	@RequestMapping("/processFormRequestParam")
	public String requestParamProcessForm(@RequestParam("studentName") String fullName, 
			Model model) {
		
		//perform any data manipulation
		fullName = fullName.toUpperCase();
		
		String greet = "Hi there, " + fullName + "!";
		
		//add this to model
		model.addAttribute("studentName", greet);
		
		return "mvc-form-display";
		
	}
	
}
