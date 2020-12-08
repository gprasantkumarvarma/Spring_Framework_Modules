package com.java.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
	
	@AfterThrowing(
			pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinpoint, Throwable theExc) {
		
		//print out which method we are advising on
System.out.println("@@AfterThrowing :: afterThrowingFindAccountAdvice");
		
		String method = theJoinpoint.getSignature().toShortString();
		System.out.println("@@AfterThrowing Method Name ::"+method);
		
		//log the exception
		theExc.printStackTrace();
		System.out.println("login the exception in aspect:: "+theExc);
		
		
	}
	
	
	
	//add a new advice for @AfterReturn on the findAccounts method
	
	@AfterReturning(
			pointcut ="execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturnFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		System.out.println("@AfterReturn :: afterReturnFindAccountsAdvice");
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("@AfterReturn Method Name ::"+method);
		
		System.out.println("Result ::"+result);
		
		//lets post-process the data ...lets modify it
		convertAccountNameToUpperCase(result);
		
		System.out.println("Upper case version Result ::"+result);
		
		
		
	}
	
	
	
	
	
	

	private void convertAccountNameToUpperCase(List<Account> result) {
		
		for (Account tempAccount : result) {
			
			String theupperNAme=tempAccount.getName().toUpperCase();
			
			//update the name on the account
			tempAccount.setName(theupperNAme);
			
		}
		
		
	}







	// @Before("forDaoPackage()")
	@Before("com.java.aopdemo.aspect.LuvAopPointcutDeclarationUtil.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n==========>> Excetuting @Before advice on addAccount()");

		// display the method signature
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method Signature :: " + signature);

		// display the method argument
		Object[] arg = theJoinPoint.getArgs();

		for (Object tempArg : arg) {
			System.out.println("Method Argument :: " + tempArg);

			if (tempArg instanceof Account) {

				Account theAccount = (Account) tempArg;
				System.out.println("Account Name :: " + theAccount.getName());
				System.out.println("Account Level :: " + theAccount.getLevel());

			}

		}

	}

}
