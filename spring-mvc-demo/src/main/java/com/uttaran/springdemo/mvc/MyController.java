package com.uttaran.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping("/")	//request mapping can have any name
	public String viewPage() {
		
		//calling the InternalResourceViewResolver in config file, that contains the location
		return "home-page";		//takes us to home-page.jsp in view folder
	}

}
