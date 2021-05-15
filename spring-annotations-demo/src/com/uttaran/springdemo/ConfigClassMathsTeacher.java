package com.uttaran.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:teacherinfo.properties")
public class ConfigClassMathsTeacher {

	@Bean
	public RemarksService newRemarksService() {
		
		return new NewRemarksService();
	}
	
	@Bean
	public Teacher mathsTeacher() {
		
		//perform dependency injection
		return new MathsTeacher(newRemarksService());
	}
}
