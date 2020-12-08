package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {


		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// create a 3 student object
			System.out.println("creating a new student object");
			Student tempStudent1 = new Student("Ganesh", "Singh", "Singht@gmail.com");
			Student tempStudent2 = new Student("Ravi", "Bangalore", "Bangalore@gmail.com");
			Student tempStudent3 = new Student("Vinod", "Raddy", "Raddy@gmail.com");
			

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	

	}

}
