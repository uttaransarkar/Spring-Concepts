package com.uttaran.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//This is the Configuration class

@Configuration
//@ComponentScan("com.uttaran.springdemo")	//not needed when we manually define @Beans
@PropertySource("classpath:teacherinfo.properties")

public class ConfigClassDemo {
	
	//bean for SadRemarksService
	@Bean
	public RemarksService sadRemarksService() {
		
		return new SadRemarksService();
	}
	
	//bean for EnglishTeacherclass and inject dependency
	@Bean
	public Teacher englishTeacher() {
		return new EnglishTeacher(sadRemarksService());
	}
}
