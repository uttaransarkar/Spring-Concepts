package com.uttaran.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeProblemConfigDemo {

	public static void main(String[] args) {

		//loading config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(ConfigClassMathsTeacher.class);
		
		//retrieving the beans
		MathsTeacher teacher = context.getBean("mathsTeacher", MathsTeacher.class);
		
		//calling methods on the bean
		System.out.println(teacher.getEmail());
		System.out.println(teacher.getSchool());
		System.out.println(teacher.getDailyCourse());
		System.out.println(teacher.getDailyRemarks());
		
		//closing context
		context.close();

	}

}
