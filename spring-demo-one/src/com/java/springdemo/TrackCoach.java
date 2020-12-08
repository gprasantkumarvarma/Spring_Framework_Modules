package com.java.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneservice;

	public TrackCoach(FortuneService thFortune) {
		fortuneservice = thFortune;
	}

	@Override
	public String getDailyWorkout() {

		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return fortuneservice.getFortune();
	}
	


}
