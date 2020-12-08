package com.java.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.AccountDAO;
import com.java.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	private static Logger myLogger =
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theTraffic = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("Calling fortune Service");
		
		boolean tripwire = true;
		
		String data = theTraffic.getFortune(tripwire);
		
		
		myLogger.info("\nmy fortune ::"+data);

		// close the context
		context.close();

	}

}
