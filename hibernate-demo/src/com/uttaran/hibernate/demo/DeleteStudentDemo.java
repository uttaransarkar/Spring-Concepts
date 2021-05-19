package com.uttaran.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.uttaran.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			int sId = 8;
			
			// start a transaction
			session.beginTransaction();
			
//			//deleting the student with id=8
//			Student st = session.get(Student.class, sId);
//			
//			System.out.println("Student to be deleted: " + st);
//			session.delete(st);
			
			//deleting student with id=2
			
			System.out.println("Student deleted having id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			factory.close();
		}
	}

}





