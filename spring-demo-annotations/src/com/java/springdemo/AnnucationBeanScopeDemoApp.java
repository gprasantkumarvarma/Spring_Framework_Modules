package com.java.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnucationBeanScopeDemoApp {
	public static void main(String[] args) {
		
		//loading the config file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the bean from spring container
		Coach thCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach thCoach2 = context.getBean("tennisCoach",Coach.class);
		
		
		boolean result = (thCoach == thCoach2);
		
		System.out.println("pointing to same object :: "+result);
		
		System.out.println("memory location of  thCoach :: "+thCoach);
		
		System.out.println("memory location of  thCoach :: "+thCoach2);
		
		
		context.close();
		
	}

}
