package com.java.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.AccountDAO;
import com.java.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger =
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theTraffic = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("Calling fortune Service");
		
		String data = theTraffic.getFortune();
		
		
		myLogger.info("\nmy fortune ::"+data);

		// close the context
		context.close();

	}

}
