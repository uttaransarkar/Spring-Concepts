package com.uttaran.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSetterDemo {

	public static void main(String[] args) {
		
		//loading bean from config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieving bean from container
		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);

		//call methods on the bean to use helper objects
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDailyWorkout());
		
		//call our new methods to get values of class variables
		System.out.println("Email Id: " + coach.getEmailId());
		System.out.println("Team: " + coach.getTeam());
		
		//close context
		context.close();
	}

}
