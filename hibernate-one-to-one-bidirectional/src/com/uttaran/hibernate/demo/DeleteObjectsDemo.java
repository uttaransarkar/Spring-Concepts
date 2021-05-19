package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Student;

public class DeleteObjectsDemo {

	public static void main(String[] args) {

		// create session factory for the two classes
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			//getting instructor by id
			int inId = 1;
			Instructor thisInstructor = session.get(Instructor.class, inId);
			
			//deleting the instructor and corresponding instructor detail object due to cascade
			
			if(thisInstructor != null) {
				
				System.out.println("Deleting the instructor: " + thisInstructor);
				session.delete(thisInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}





