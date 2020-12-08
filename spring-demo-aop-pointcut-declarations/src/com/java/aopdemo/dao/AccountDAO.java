package com.java.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.java.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account,boolean flag) {
		
		System.out.println(getClass() + ": Doing my bd work : Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println("doing my work");
		return true;
	}
	
}
