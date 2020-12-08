package com.java.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query student
			List<Student> theStudent = session.createQuery("from Student").getResultList();

			// display the student
			displayMethod(theStudent);

			// query student : lastName='Kumar'
			theStudent = session.createQuery("from Student s where s.lastName='Kumar'").getResultList();

			System.out.println("\nStudent who have last name of kumar");

			displayMethod(theStudent);

			// query student : lastName="Kumar or firstName="Ravi"

			theStudent = session.createQuery("from Student s where s.lastName='Kumar' or s.firstName='Ravi'")
					.getResultList();

			System.out.println("\nStudent who have last name of kumar or Ravi");

			displayMethod(theStudent);
			
			//query student like query
			
			theStudent =session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();

			
			System.out.println("\nStudent like gmail.com");

			displayMethod(theStudent);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private static void displayMethod(List<Student> theStudent) {
		for (Student temstudent : theStudent) {
			System.out.println(temstudent);
		}
	}

}
