package com.uttaran.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTeacherDemo {

	public static void main(String[] args) {
		
		//loading config class
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(ConfigClassDemo.class);

		//read bean from the spring container when @Component name is specified
//		Teacher teacher = context.getBean("thisTeacher", Teacher.class);
		
		//when @Component() is blank i.e default bean-id used
		EnglishTeacher teacher = context.getBean("englishTeacher", EnglishTeacher.class);
		
		//call a method on the bean
		System.out.println(teacher.getDailyCourse());
		
		//call the method of the injected dependency
		System.out.println(teacher.getDailyRemarks());
		
		//call new EnglsihTeacher functions where the fields are injected
		System.out.println("Email: " + teacher.getEmail());
		System.out.println("Team: " + teacher.getSchool());
		
		//close context
		context.close();
	}

}
