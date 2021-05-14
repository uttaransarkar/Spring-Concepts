package com.uttaran.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean_scope_demo {

	public static void main(String[] args) {
		
		//loading spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean-scopes-applicationContext.xml");
		
		//reading beans from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach nextCoach = context.getBean("myCoach", Coach.class);
		
		//checking if the beans are same
		boolean res = coach == nextCoach;
		System.out.println("Are they same? " + res);

	}

}
