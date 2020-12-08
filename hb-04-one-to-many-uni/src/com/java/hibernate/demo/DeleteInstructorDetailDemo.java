package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Student;

import javassist.bytecode.InstructionPrinter;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
            
			//get the instructor details object
			int theId=6;
             
			InstructorDetail thDetail=
					session.get(InstructorDetail.class, theId);
			
			//print the instructordetail
			System.out.println("Instructor details ::"+thDetail);
			
			//print the associated instructor
			System.out.println("the associated instructor :: "+thDetail.getInstructor());
			
			//no lets delete the instructor details
			System.out.println("Deleting instructorDetails"+thDetail);
			
			//removing the association
			//breaking bi-directional link
			thDetail.getInstructor().setInstructionDetailID(null);
			session.delete(thDetail);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
