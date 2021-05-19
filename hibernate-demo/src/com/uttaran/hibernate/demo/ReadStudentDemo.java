package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Student st = new Student("Jake", "Peralta", "jakper@noice.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(st);
			
			// commit transaction
			session.getTransaction().commit();
			
			//NOTE: Every query will have a new transaction
			//new session and stating transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//reading the object from DB based on his id(primary key)
			System.out.println("Student read from db  with id: " + st.getId());
			
			Student thisStudent = session.get(Student.class, st.getId());
			
			System.out.println("Student details: " + thisStudent);
			
			//committing the transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}





