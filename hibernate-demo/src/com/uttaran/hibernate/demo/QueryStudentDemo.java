package com.uttaran.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.uttaran.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// retrieving list of students
			
			//querying all students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//displaying the students
			displayStudents(students);
			
			//querying students based on a condition
			students = session.createQuery("from Student s where "
					+ "s.email like '%thapar.edu'").getResultList();
			
			//display the students
			System.out.println("Students with a thapar.edu domain: ");
			displayStudents(students) ;
			
			
			//querying students based on a condition
			System.out.println("Showing students with first name Jake and last name Holt");
			students = session.createQuery("from Student s where "
					+ "s.firstName='Jake' or s.lastName='Holt'").getResultList();
			
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		//displaying the students
		for(Student st: students) {
			System.out.println(st);
		}
	}

}





