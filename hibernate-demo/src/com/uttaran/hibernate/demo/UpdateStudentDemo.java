package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {		
			int sId = 1;
			 
			//start transaction
			session.beginTransaction();
			
			//reading the object from DB based on his id(primary key)
			System.out.println("Student read from db  with id: " + sId);
			
			Student thisStudent = session.get(Student.class, sId);
			
			//updating one student
			System.out.println("Updating the student details: ");
			thisStudent.setLastName("Stark");			
				
			//committing the transaction
			session.getTransaction().commit();
			
			//updating list of students
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Updating all student details: ");
			
			session.createQuery("update Student set email='xyz@abc.com'").executeUpdate();
			
			//committing the transaction
			session.getTransaction().commit();
				
		}
		finally {
			factory.close();
		}
	}

}





