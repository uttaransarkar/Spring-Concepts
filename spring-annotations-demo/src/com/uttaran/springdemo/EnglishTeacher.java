package com.uttaran.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class EnglishTeacher implements Teacher {
	
	private RemarksService remarksService;

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.school}")
	private String school;

	public EnglishTeacher(RemarksService remarksService) {
		
		this.remarksService = remarksService;
	}

	@Override
	public String getDailyCourse() {

		return "Read Arms and the Man";
	}

	@Override
	public String getDailyRemarks() {

		return remarksService.getRemarks();
	}

	public String getEmail() {
		return email;
	}

	public String getSchool() {
		return school;
	}

}
