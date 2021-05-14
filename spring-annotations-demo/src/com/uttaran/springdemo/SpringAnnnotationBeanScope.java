package com.uttaran.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnnotationBeanScope {

	public static void main(String[] args) {
		
		//loading config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieving two beans from spring container 
		Teacher teacher1 = context.getBean("scienceTeacher", Teacher.class);
		Teacher teacher2 = context.getBean("scienceTeacher", Teacher.class);
		
		//checking if both are same
		boolean res = teacher1 == teacher2;
		System.out.println(res);

	}

}
