package com.java.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.aopdemo.dao.AccountDAO;
import com.java.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		
		//read sping config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccount = context.getBean("accountDAO",AccountDAO.class);
		
		//get the bean from spring container
		MembershipDAO themembership = context.getBean("membershipDAO",MembershipDAO.class);
		
		
		//call the busniness method
		Account amyAccount= new Account();
		theAccount.addAccount(amyAccount,true);
		theAccount.doWork();
		
		
		System.out.println("membersship add account::");
		//call menbership accounts
		themembership.addAccount();
		themembership.goToSleep();
		
		//do again
		theAccount.addAccount(amyAccount,false);
		
		
		//close the context
		context.close();
		
		
	}

}
