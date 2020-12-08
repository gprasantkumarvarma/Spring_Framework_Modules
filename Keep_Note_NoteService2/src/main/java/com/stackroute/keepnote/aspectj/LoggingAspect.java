package com.stackroute.keepnote.aspectj;

/* Annotate this class with @Aspect and @Component */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	/*
	 * Write loggers for each of the methods of Category controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */

	@Pointcut("execution(* com.stackroute.keepnote.controller..*(..))")
	public void allControllerMethods(){

	}
	@Before("allControllerMethods()")
	public void beforeMethod(JoinPoint joinPoint) {
		LOGGER.debug("@Before method is running:" + new Date());
		LOGGER.debug("Method Name: " + joinPoint.getSignature().getName());
		LOGGER.debug("Method Args: " + joinPoint.getArgs());
	}

	@After("allControllerMethods()")
	public void afterMethod(JoinPoint joinPoint) {
		LOGGER.debug("@After method is running:" + new Date());
		LOGGER.debug("Method Name: " + joinPoint.getSignature().getName());
		LOGGER.debug("Method Args: " + joinPoint.getArgs());
	}

	@AfterReturning(pointcut = "allControllerMethods()", returning = "result")
	public void afterMethodReturning(JoinPoint joinPoint, Object result) {
		LOGGER.debug("@AfterReturning method is running: " + new Date());
		LOGGER.debug("Method Name: " + joinPoint.getSignature().getName());
		LOGGER.debug("Method Args: " + joinPoint.getArgs());
		LOGGER.debug("Method return value:" + result);
	}

	@AfterThrowing(pointcut = "allControllerMethods()", throwing = "exception")
	public void afterMethodThrowing(JoinPoint joinPoint, Exception exception) {
		LOGGER.debug("@AfterReturning method is running:" + new Date());
		LOGGER.debug("Method Name: " + joinPoint.getSignature().getName());
		LOGGER.debug("Method Args: " + joinPoint.getArgs());
		LOGGER.debug("Exception caught:" + exception.getMessage());
	}
}
