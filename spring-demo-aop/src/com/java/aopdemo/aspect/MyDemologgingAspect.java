package com.java.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemologgingAspect {
	
	//this is where we add all of our related advices for logging
	
	//lets start with an @Before advice
	
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void com.java.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(void add*())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(com.java.aopdemo.Account))")
	//@Before("execution(* add*(com.java.aopdemo.Account,..))")
	//@Before("execution(* add*(..))")//.. means any parameters
	@Before("execution(* com.java.aopdemo.dao.*.*(..))")// only applied for com.java.aopdemo.dao package, "*" means any class and method.
	
	
	
	public void beforeAddAccountAdvice() {
		System.out.println("\n==========>> Excetuting @Before advice on addAccount()");
	}

	
}
