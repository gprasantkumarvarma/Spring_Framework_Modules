package com.java.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {

		//read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		//get the bean from the spring container
		//Coach theCoach =context.getBean("thatSillyCoach",Coach.class);
		
		//default bean id, same as class name with first letter in lower case
		//Coach theCoach =context.getBean("swimCoach",Coach.class);
		SwimJavaCongifCoach theCoach =context.getBean("swimCoach",SwimJavaCongifCoach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("Email :: "+theCoach.getEmail());
		
		
		System.out.println("Team :: "+theCoach.getTeam());
		
		
		
		//close the context
		context.close();
		
	}
}
