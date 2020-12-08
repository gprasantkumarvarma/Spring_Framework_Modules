package com.java.springdemo;

public class HappyFortuneService implements FortuneService{

	@Override
	public String getFortune() {
	
		return "Today is you luckey day!!";
	}

}
