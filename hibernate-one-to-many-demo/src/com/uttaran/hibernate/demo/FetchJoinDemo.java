package com.uttaran.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
//			Instructor instructor = session.get(Instructor.class, insId);
//			
//			System.out.println("uttaran: Instructor details: " + instructor);
			
			//retrieving data via solution 2 (HQL)
			Query<Instructor> query = session.
					createQuery("select i from Instructor i JOIN FETCH i.courses"
							+ " where i.id=:theInstructorId", Instructor.class);
			
			//setting parameter 
			query.setParameter("theInstructorId", insId);
			
			//execute query and get instructor
			Instructor thisInstructor = query.getSingleResult();
			
			System.out.println("uttaran: Instructor details: " + thisInstructor);
			
			//committing transaction
			session.getTransaction().commit();
			
			//closing the session
			session.close();
			
			System.out.println("uttaran: The courses are: " + thisInstructor.getCourses());
			
			//retrieving the courses for this instructor, this would now usually throw an error
			//because lazy loading requires the session to be open at all times
			
//			List<Course> insCourses = instructor.getCourses();
//			System.out.println("uttaran: The courses are: " + insCourses);
			
			//solution 1: call getter method while session is open
//			System.out.println("uttaran: The courses are: " + insCourses);	//data loaded while session is open so works
						
			//solution 2: Hibernate query with HQL
			
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





