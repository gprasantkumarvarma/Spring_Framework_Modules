package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Student;

import javassist.bytecode.InstructionPrinter;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// create the objects
			/*-
			   Instructor temIns = new Instructor("Prasant", "Varma",
			    "g.prasant.gamil.com");
			  
			   InstructorDetail temInsDetail = new InstructorDetail("hhtp://google.com",
			   "luv 2 code");
			 */

			// create the objects
			Instructor temIns = new Instructor("Ganesh", "Varma", "Ganesh@gamil.com");

			InstructorDetail temInsDetail = new InstructorDetail("hhtp://google.com", "luv 2 code android");

			// associate the object
			temIns.setInstructionDetailID(temInsDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			//
			// Note: this will also save the details object
			// because of Cascade.All
			//
			System.out.println("Saving instuctot :: " + temIns);
			session.save(temIns);

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
