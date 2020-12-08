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
		
		
		//call the business method
		Account amyAccount= new Account();
		amyAccount.setLevel("Gold");
		amyAccount.setName("Ganesh");
		theAccount.addAccount(amyAccount,true);
		theAccount.doWork();
		
		
		//getter and setter method
		theAccount.setName("prasant");
		theAccount.setServiceCode("silver");
		
		
		String name = theAccount.getName();
		String code= theAccount.getServiceCode();
		
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
