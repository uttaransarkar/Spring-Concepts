package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Review;
import com.uttaran.hibernate.demo.entity.Student;

public class AddCoursesForAStudent {

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
			
			//getting a particular student from DB
			int studId = 2;
			Student thisStudent = session.get(Student.class, studId);
			System.out.println("Courses for the student are: " + thisStudent.getCourses());
			
			//adding courses to this student
			Course c1 = new Course("Learn Java");
			Course c2= new Course("How to improve vocabulary?");
			
			c1.addStudent(thisStudent);
			c2.addStudent(thisStudent);
			
			//saving the courses
			session.save(c1);
			session.save(c2);			
			
			//committing transaction
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			
			factory.close();
		}
	}

}





