package com.uttaran.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class ControllerStudent {

	//creating method to go to our form
	@RequestMapping("/viewForm")
	public String viewForm(Model model) {
		
		//create new student object whose fields will be updated automatically
		Student ob = new Student();
		
		//adding the object to model
		model.addAttribute("student",ob);
		
		//redirects to the jsp form where model is used
		return "form-student";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student st) {
		
		//log the input data
		System.out.println("Student: " + st.getFirstName() + " " + st.getLastName());
		
		return "display-student-form";
	}
	
}
