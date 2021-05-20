package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Student;

public class CreateObjectsDemo {

	public static void main(String[] args) {

		// create session factory for the two classes
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			//creating objects
			
//			Instructor ins = new 
//					Instructor("Uttaran", "Sarkar", "usarkar@thapar.edu");
//			
//			InstructorDetail insDetail = new
//					InstructorDetail("https://www.youtube.com/c/TheViralFever", "binge watching");
			
			Instructor ins = new 
					Instructor("Mark", "Goldbridge", "mg@united.com");
			
			InstructorDetail insDetail = new
					InstructorDetail("https://www.youtube.com/channel/UCMmVPVb0BwSIOWVeDwlPocQ", 
							"watching football");

			//associating the objects
			ins.setInstructorDetail(insDetail);
			
			// start a transaction
			session.beginTransaction();
			
			//save to the instructor table
			//this will also save the associated instructor detail object because of cascade

			System.out.println("Saving the instructor: " + ins);
			session.save(ins);					
			
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}





