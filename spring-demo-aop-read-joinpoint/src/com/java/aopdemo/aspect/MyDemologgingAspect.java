package com.java.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.java.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemologgingAspect {

	// this is where we add all of our related advices for logging

	// lets start with an @Before advice

	// @Before("execution(public void addAccount())")
	// @Before("execution(public void
	// com.java.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(void add*())")
	// @Before("execution(* add*())")
	// @Before("execution(* add*(com.java.aopdemo.Account))")
	// @Before("execution(* add*(com.java.aopdemo.Account,..))")
	// @Before("execution(* add*(..))")//.. means any parameters
	// @Before("execution(* com.java.aopdemo.dao.*.*(..))")// only applied for
	// com.java.aopdemo.dao package, "*" means any class and method.

	/*-
	@Pointcut("execution(* com.java.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}

	// create point cut for getter method
	@Pointcut("execution(* com.java.aopdemo.dao.*.get*(..))")
	private void getter() {

	}

	// create point cut for setter method
	@Pointcut("execution(* com.java.aopdemo.dao.*.set*(..))")
	private void setter() {

	}

	// create point cut : include package ..exclude getter/ setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
		
	}
	*/
	
	//@Before("forDaoPackage()")
	@Before("com.java.aopdemo.aspect.LuvAopPointcutDeclarationUtil.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n==========>> Excetuting @Before advice on addAccount()");
		
		//display the method signature
		MethodSignature signature= (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method Signature :: "+signature);
		
		//display the method argument
		Object [] arg = theJoinPoint.getArgs();
		
		for (Object tempArg : arg) {
			System.out.println("Method Argument :: "+tempArg);
			
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				System.out.println("Account Name :: "+theAccount.getName());
				System.out.println("Account Level :: "+theAccount.getLevel());
				
			}
			
			
			
		}
		
		
		
		
		
		
	}


}
