package com.uttaran.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//adding annotation from which Spring will generate the bean

@Component()
//@Scope("prototype")

public class ScienceTeacher implements Teacher {
	
	//object of the dependency
	//Field Injection
	
	@Autowired
	//give the bean id to inject the correct implementation class you want to use if there are multiple
	@Qualifier("randomRemarksService")
	private RemarksService remarksService;
	
	public ScienceTeacher() {
		System.out.println("Inside default constructor of ScienceTeacher");
	}
	
	/*//constructor injection
	@Autowired
	public ScienceTeacher(RemarksService remarksService) {
		this.remarksService = remarksService;
	} */
	
	//setter injection
	
	/*@Autowired
	public void setRemarksService(RemarksService remarksService) {
		this.remarksService = remarksService;
	} */

	
	//define init method to be executed after bean construction
	
	@PostConstruct
	public void onStartup() {
		System.out.println("Started ScienceTeacher");
	}
	
	//define the destroy method
	@PreDestroy
	public void cleanUp() {
		System.out.println("Cleaning ScienceTeacher");
	}
	
	@Override
	public String getDailyCourse() {
		
		return "Study Electromagnetic radiation.";
	}

	@Override
	public String getDailyRemarks() {
		
		return remarksService.getRemarks();	
	}

}
