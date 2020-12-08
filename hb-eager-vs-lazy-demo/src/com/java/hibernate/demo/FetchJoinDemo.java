package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int id = 9;
			Instructor thinstrusctor = session.get(Instructor.class, id);

			System.out.println("EagerLazyDemo :: Instructor ::" + thinstrusctor);
			
			// get the course for the instructor
			System.out.println("EagerLazyDemo :: Course ::" + thinstrusctor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			//Option 1: call the getter method while session is open
			//
			
			
			
			  //breaking the Lazy initialization
			  // close the session 
			   session.close();  
			   
			   System.out.println("we are closing the session\n");
			  // get the course for the instructor
			   System.out.println("EagerLazyDemo :: Course ::" +
			   thinstrusctor.getCourses());
			 

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
			session.close();
		}

	}

}
