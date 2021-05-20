package com.uttaran.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Course;
import com.uttaran.hibernate.demo.entity.Instructor;
import com.uttaran.hibernate.demo.entity.InstructorDetail;
import com.uttaran.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

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
			
			//getting course from DB
			Course thisCourse = session.get(Course.class, 10);
			
			//deleting this course
			System.out.println("The course being deleted: " + thisCourse);
			
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





