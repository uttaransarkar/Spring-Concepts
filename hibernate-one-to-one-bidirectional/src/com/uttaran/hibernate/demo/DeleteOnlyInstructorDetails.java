package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Student;

public class DeleteOnlyInstructorDetails {

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
			
			//getting the instructor detail object
			int insId = 2;
			
			InstructorDetail insDetail = session.get(InstructorDetail.class, insId);
			
			//printing the instructor detail object
			System.out.println("The instructor detail object deleted is: " + insDetail);
			
			//printing the corresponding instructor object
			System.out.println("The corresponding instructor object deleted is: " + insDetail.getInstructor());
			
			//deleting the InstructorDetail object and its corresponding Instructor object
			session.delete(insDetail);
			
			
			// commit transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {	//for null pointer exceptions
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}





