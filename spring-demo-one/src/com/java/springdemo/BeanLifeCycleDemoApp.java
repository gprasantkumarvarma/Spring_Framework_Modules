package com.java.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
	
		//load the spring configuration file
		ClassPathXmlApplicationContext context=
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		//retrieve bean from spring container
		
		Coach thCoach = context.getBean("myCoach",Coach.class);
		
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		// check if they are same
		
		boolean result = (thCoach== alphaCoach);
		
		//print out the result
		System.out.println("\nPointing to same object : "+result);
		
		System.out.println("\n Memory loctaion fo the theCoach : "+thCoach);
		
		
		System.out.println("\n Memory loctaion fo the theCoach : "+alphaCoach);
		
		context.close();
		
	}

}
