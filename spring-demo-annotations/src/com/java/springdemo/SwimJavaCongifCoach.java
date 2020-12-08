package com.java.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimJavaCongifCoach implements Coach {
	FortuneService fortuneService;
	
	//inject data from property files.
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public SwimJavaCongifCoach(FortuneService fortuneService){
		this.fortuneService=fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
