package com.java.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyNewSetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach thCoach = context.getBean("mynewCricketCoach",MYNewCricketCoach.class);
		
		System.out.println(thCoach.getDailyWorkout());
		System.out.println(thCoach.getDailyFortune());

	}

}
