package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
		
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theinstructorID",Instructor.class);
			query.setParameter("theinstructorID", id);
			
			//execute query and get the instructor
			Instructor thinstrusctor = query.getSingleResult();
			
			
			System.out.println("EagerLazyDemo :: Instructor ::" + thinstrusctor);
			

			// commit transaction
			session.getTransaction().commit();

			//Option 1: call the getter method while session is open
			//Option 2: Hibernate query with HQl
			
			
			
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
