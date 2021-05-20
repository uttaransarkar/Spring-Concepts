package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Review;
import com.uttaran.hibernate.demo.entity.Student;

public class CreateCoursesReviewsDemo {

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
			
			//creating a course
			Course myCourse = new Course("How to invest in crpto?");
			
			//adding reviews for this course
			myCourse.addReviews(new Review("A great course!"));
			myCourse.addReviews(new Review("Too advanced!"));
			myCourse.addReviews(new Review("Very well explained!"));
			
			//saving the course, which will automatically save all the reviews with it
			System.out.println("Saving the course: " + myCourse);
			System.out.println("Reviews for the course are: " + myCourse.getReviews());
			
			session.save(myCourse);
			
			//committing transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





