package com.uttaran.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
}
