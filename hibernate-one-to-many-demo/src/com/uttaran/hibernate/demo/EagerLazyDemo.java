package com.uttaran.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory for the two classes
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			//begin transaction
			session.beginTransaction();
			
			//getting instructor from DB
			int insId = 1;
			Instructor instructor = session.get(Instructor.class, insId);
			
			System.out.println("uttaran: Instructor details: " + instructor);
			
			//retrieving data
			List<Course> insCourses = instructor.getCourses();
			System.out.println("uttaran: The courses are: " + insCourses);
			
			//committing transaction
			session.getTransaction().commit();
			
			//closing the session
			session.close();
			
			//retrieving the courses for this instructor, this would now usually throw an error
			//because lazy loading requires the session to be open at all times
			
//			List<Course> insCourses = instructor.getCourses();
//			System.out.println("uttaran: The courses are: " + insCourses);
			
			//solution 1: call getter method while session is open
			System.out.println("uttaran: The courses are: " + insCourses);	//data loaded while session is open so works
						
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





