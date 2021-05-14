package com.uttaran.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {

	public static void main(String[] args) {
		
		//loading spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieving bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		//calling methods on the bean
		System.out.println(coach.getDailyWorkout());
		
		//calling new methods from dependencies
		System.out.println(coach.getDailyFortune());
		
		//closing the container
		context.close();

	}

}
