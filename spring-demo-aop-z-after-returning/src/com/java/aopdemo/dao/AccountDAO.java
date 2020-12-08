package com.java.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.java.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	//add a new method : findAccount()
	
	public List<Account> findAccounts(){
		
		List<Account> myAccount = new ArrayList<>();
             
		//create sample account
		Account temp1 = new Account("prasant", "Platinum");
		Account temp2 = new Account("ravi", "silver");
		Account temp3 = new Account("prasant", "gold");
		
		//add them to our accounts list
		
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		
		
		System.out.println("findAccounts executed\n");
		return myAccount;
	}
	
	
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
