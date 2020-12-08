package com.java.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public String addAccount() {
		
		System.out.println(getClass() + ": Doing my bd work : Adding an account");
	
		return "testing";
	
	}
	
	public boolean goToSleep() {
		
		System.out.println("goToSleep");
		return true;
	}
	
	
	
}
