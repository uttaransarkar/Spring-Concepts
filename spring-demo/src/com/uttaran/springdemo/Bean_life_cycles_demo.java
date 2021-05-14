package com.uttaran.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean_life_cycles_demo {

	public static void main(String[] args) {
		
		//loading spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("bean-life-cycles-applicationContext.xml");
		
		//reading beans from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());
		
		//closing
		context.close();
	}

}
