package com.java.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		
		System.out.println("Calling findAccounts:: \n");
		
		//call method to find the accounts
		List<Account> theAccount = theAccountDAO.findAccounts();
		
		
		//display the accounts
		System.out.println("\n\n Main Program :: AfterReturningDemoApp");
		
		System.out.println(theAccount);
		
		System.out.println("\n");
		
		//close the context
		context.close();
		
		
	}

}
