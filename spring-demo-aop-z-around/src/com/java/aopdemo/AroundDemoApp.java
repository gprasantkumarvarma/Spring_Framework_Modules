package com.java.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.AccountDAO;
import com.java.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theTraffic = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("Calling fortune Service");
		
		String data = theTraffic.getFortune();
		
		
		System.out.println("\nmy fortune ::"+data);

		// close the context
		context.close();

	}

}
