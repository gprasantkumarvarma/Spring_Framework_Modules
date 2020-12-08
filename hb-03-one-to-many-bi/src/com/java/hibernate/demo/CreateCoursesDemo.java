package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			  

			// start a transaction
			session.beginTransaction();
			
			//get the instructor from db
			int id =9;
			Instructor thinstrusctor = session.get(Instructor.class, id);
			
			
			
			//create some courses
			Course course1 = new Course("hip-hop -the Ultimate guide");
			Course course2 = new Course("brack bance -the Ultimate guide");
			Course course3 = new Course("Zumba -the Ultimate guide");
			
			//add courses to instructor
			thinstrusctor.add(course1);
			thinstrusctor.add(course2);
			thinstrusctor.add(course3);
			
			//save the courses
			session.save(course1);
			session.save(course2);
			session.save(course3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
			session.close();
		}

	}

}
