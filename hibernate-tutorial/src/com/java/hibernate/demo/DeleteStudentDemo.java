package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int studentId = 3;
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student on the id :: primary key
			System.out.println("getting student id " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("delete student .....");
			session.delete(myStudent);
			

			// commit the transaction
			session.getTransaction().commit();

			//
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//delete student id 2
			System.out.println("delte id 2");
			session.createQuery("delete from Student where id='2'").executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
