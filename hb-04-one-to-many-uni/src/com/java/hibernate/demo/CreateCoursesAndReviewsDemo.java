package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.demo.entity.Course;
import com.java.hibernate.demo.entity.Instructor;
import com.java.hibernate.demo.entity.InstructorDetail;
import com.java.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// create a cource
			Course theCourse = new Course("Pacman - How to score one Million points");

			// add some review
			theCourse.add(new Review("Grate course...!"));
			theCourse.add(new Review("Cool course...!"));
			theCourse.add(new Review("Bad course...!"));
			theCourse.add(new Review("ok ok course...!"));
			theCourse.add(new Review("not bad course...!"));

			// save the course-- and leverage the cascase all
			System.out.println("save the course");
			System.out.println(theCourse);
			System.out.println(theCourse.getReviews());
			
			session.save(theCourse);

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
