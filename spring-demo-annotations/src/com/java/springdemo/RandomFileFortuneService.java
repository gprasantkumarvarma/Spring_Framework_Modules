package com.java.springdemo;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFileFortuneService implements FortuneService {

	//create a arry
	@Value("${foo.fortunearray}")
	private String data;
	
	//create a random generator
		private Random myrandom = new Random();
	
	//@PostConstruct
	public String setRemdomFrotune() {
		String[] input =data.split(",");
		int index = myrandom.nextInt(input.length);		
		
		return input[index];
		
	}
	
	
	
	
	@Override
	public String getFortune() {	
				
		return setRemdomFrotune();
	}

}
