package com.java.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.java.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	
	public void addAccount(Account account,boolean flag) {
		
		System.out.println(getClass() + ": Doing my bd work : Adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println("doing my work");
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		
		System.out.println("AccountDAO: inside getter method");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("AccountDAO: inside setter method");
		this.serviceCode = serviceCode;
	}
	
	
	
	
}
