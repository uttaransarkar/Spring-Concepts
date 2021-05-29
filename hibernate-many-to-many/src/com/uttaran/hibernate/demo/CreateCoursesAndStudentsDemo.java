package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Review;
import com.uttaran.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			//creating a course
			Course myCourse = new Course("How to invest in crpto?");
			
//			//adding reviews for this course
//			myCourse.addReviews(new Review("A great course!"));
//			myCourse.addReviews(new Review("Too advanced!"));
//			myCourse.addReviews(new Review("Very well explained!"));
			
			//saving the course, which will automatically save all the reviews with it
			System.out.println("Saving the course: " + myCourse);
//			System.out.println("Reviews for the course are: " + myCourse.getReviews());
			
			session.save(myCourse);
			
			//creating students
			Student st1 = new Student("Uttaran", "Sarkar", "sarkaruttaran@xyz.com");
			Student st2 = new Student("Sheldon", "Cooper", "shelcoop@xyz.com");
			
			//adding students to the course
			myCourse.addStudent(st1);
			myCourse.addStudent(st2);
			
			//saving the students
			session.save(st1);
			session.save(st2);
			System.out.println("Saved the students: " + myCourse.getStudents());
			
			//committing transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





