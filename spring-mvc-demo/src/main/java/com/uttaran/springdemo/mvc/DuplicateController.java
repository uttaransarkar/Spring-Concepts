package com.uttaran.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DuplicateController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "duplicate-form";
	}
	
}
