package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create 3 student objects
			System.out.println("Creating new student object...");
			Student st1 = new Student("Uttaran", "Sarkar", "usarkar@thapar.edu");
			Student st2 = new Student("Charles", "Boyle", "fullboyle@thapar.edu");
			Student st3 = new Student("Ray", "Holt", "rholt@thapar.edu");
				
			// start a transaction
			session.beginTransaction();
			
			// save all the student objects
			System.out.println("Saving the students...");
			session.save(st1);
			session.save(st2);
			session.save(st3);
					
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
	}
}