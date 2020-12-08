package com.java.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declarations
	@Pointcut("execution(* com.java.springdemo.controller.*.*(..))")
	private void forControllerPackage() {

	}

	// do the same for service and dao

	@Pointcut("execution(* com.java.springdemo.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.java.springdemo.dao.*.*(..))")
	private void forDAOPackage() {

	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {

	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// disable method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();

		myLogger.info("==>>@before Advice :: calling method :: " + theMethod);

		// displaythe argument to the method

		// get the argumnrt
		Object[] arg = theJoinPoint.getArgs();

		for (Object temArg : arg) {
			myLogger.info("Arguments:: " + temArg);
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturnning(JoinPoint theJoinPoint, Object theResult) {
		// disable method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();

		myLogger.info("==>>@AfterReturning Advice :: calling method :: " + theMethod);

		//display data returned
		
		myLogger.info("===>> Result :: "+theResult);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
