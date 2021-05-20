package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Review;
import com.uttaran.hibernate.demo.entity.Student;

public class GetCoursesReviewsDemo {

	public static void main(String[] args) {

		// create session factory for the two classes
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {	
			//begin transaction
			session.beginTransaction();
			
			//getting a course
			Course myCourse = new Course("How to invest in crpto?");
			
			//printing both the course and its associated reviews 
			int cId = 11;
			Course course = session.get(Course.class, cId);
			
			System.out.println("Course is: " + course);
			System.out.println("Course reviews are: " + course.getReviews());
				
			//committing transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





