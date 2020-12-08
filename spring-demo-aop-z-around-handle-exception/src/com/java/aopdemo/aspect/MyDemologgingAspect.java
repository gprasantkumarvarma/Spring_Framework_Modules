package com.java.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.java.aopdemo.Account;
import com.java.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(3)
public class MyDemologgingAspect {
	private static Logger mylogger =
			Logger.getLogger(MyDemologgingAspect.class.getName());

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
	
	
	@Around("execution(* com.java.aopdemo.service.TrafficFortuneService.getFortune(..))"
			)
	public Object aroundFortune(ProceedingJoinPoint theProceeding) throws Throwable {
		
		//print out method we are advising on
		String method = theProceeding.getSignature().toShortString();
		
		mylogger.info("method ::"+method);
		
		//get begin timstamp
		long begin=System.currentTimeMillis();
		
		//now lets extcute the method
		Object result = null;
		
		//exception handling by using try and catch in @around advice
		try {
			result= theProceeding.proceed();
		}catch(Exception e) {
			mylogger.info("Exception ::"+e.getMessage());
			
			//result="Exception got handled ";
			
			throw e;
		}
		
		//get the timestapm
		long end=System.currentTimeMillis();
		
		//compute duration
		long duration = end-begin;
		
		mylogger.info("Duration od execution ::"+duration/1000 + " seconds");
		
		
		
		return result;
		
	}
	
	
	
	
	@After("execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))"
			)
	public void afterFinallyFineAccountAdvice(JoinPoint theJoinpoint) {
		
		//print out which method we are advising on
		mylogger.info("@@@After :: afterFinallyFineAccountAdvice");
				
				String method = theJoinpoint.getSignature().toShortString();
				mylogger.info("@@@After finally Method Name ::"+method);
		
		
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinpoint, Throwable theExc) {
		
		//print out which method we are advising on
mylogger.info("@@AfterThrowing :: afterThrowingFindAccountAdvice");
		
		String method = theJoinpoint.getSignature().toShortString();
		mylogger.info("@@AfterThrowing Method Name ::"+method);
		
		//log the exception
		theExc.printStackTrace();
		mylogger.info("login the exception in aspect:: "+theExc);
		
		
	}
	
	
	
	//add a new advice for @AfterReturn on the findAccounts method
	
	@AfterReturning(
			pointcut ="execution(* com.java.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturnFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		mylogger.info("@AfterReturn :: afterReturnFindAccountsAdvice");
		
		String method = theJoinPoint.getSignature().toShortString();
		mylogger.info("@AfterReturn Method Name ::"+method);
		
		mylogger.info("Result ::"+result);
		
		//lets post-process the data ...lets modify it
		convertAccountNameToUpperCase(result);
		
		mylogger.info("Upper case version Result ::"+result);
		
		
		
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
		mylogger.info("\n==========>> Excetuting @Before advice on addAccount()");

		// display the method signature
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

		mylogger.info("Method Signature :: " + signature);

		// display the method argument
		Object[] arg = theJoinPoint.getArgs();

		for (Object tempArg : arg) {
			mylogger.info("Method Argument :: " + tempArg);

			if (tempArg instanceof Account) {

				Account theAccount = (Account) tempArg;
				mylogger.info("Account Name :: " + theAccount.getName());
				mylogger.info("Account Level :: " + theAccount.getLevel());

			}

		}

	}

}
