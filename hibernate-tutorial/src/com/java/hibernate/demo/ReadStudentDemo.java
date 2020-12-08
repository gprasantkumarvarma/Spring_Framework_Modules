package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// create a student object
			System.out.println("creating a new student object");
			Student tempStudent = new Student("Vicky", "Kumar", "vicky@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Reading the student....");
			System.out.println("sudent object ::"+tempStudent);
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();
			
			//My new Code
			
			System.out.println("Save student ::"+tempStudent.getEmail());
			
			//now ger a new session and start trsansaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student on the id :: primary key
			System.out.println("getting student id "+tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete : "+myStudent);
			
			//commit the transaction
session.getTransaction().commit();
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
