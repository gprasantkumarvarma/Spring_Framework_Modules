package com.java.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create a arry
	private String[] data = {
			"Beare of the wolf in the sheep's clothing",
			"Diligence in the mother of good luck",
			"The Journey is the reward"
	};
	
	//create a random generator
	private Random myrandom = new Random();
	
	
	@Override
	public String getFortune() {
		int index = myrandom.nextInt(data.length);		
				
		
		return data[index];
	}

}
