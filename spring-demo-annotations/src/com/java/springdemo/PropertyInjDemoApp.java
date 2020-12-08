package com.java.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyInjDemoApp {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		SwimCoach thCoach = context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(thCoach.getEmail());
		
		System.out.println(thCoach.getTeam());
		
		System.out.println(thCoach.getDailyWorkout());
		
		System.out.println(thCoach.getDailyFortune());
	}

}
