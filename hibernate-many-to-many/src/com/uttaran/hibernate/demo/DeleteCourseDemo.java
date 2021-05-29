package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Review;
import com.uttaran.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// create session factory for the two classes
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class).buildSessionFactory();		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			//begin transaction
			session.beginTransaction();
				
			//getting a particular course from DB
			Course thisCourse = session.get(Course.class, 10);
			
			//deleting the course, but not the associated students
			System.out.println("Course being deleted: " + thisCourse);
			
			session.delete(thisCourse);
			
			//committing transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





