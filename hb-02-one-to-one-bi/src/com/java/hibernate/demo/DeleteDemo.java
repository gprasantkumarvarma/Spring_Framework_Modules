package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Student;

import javassist.bytecode.InstructionPrinter;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
 
			//get the instructor by primary key
			int theID=1;
			Instructor thInst= session.get(Instructor.class, theID);
			
			System.out.println("found instructor :: "+thInst);
			
			//delete the instructor
			if(thInst !=null) {
				System.out.println("Deleting :: "+thInst);
				
				//Note : will ALSO delete associated "details" object
				//because of CascadeType.ALL
				session.delete(thInst);
			}

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
