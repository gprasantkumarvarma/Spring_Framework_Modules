package com.java.springdemo;

public class BaseballCoach implements Coach{
	private FortuneService  fortuneservice;
	public BaseballCoach(FortuneService thFortune) {
		fortuneservice=thFortune;
	}
	
@Override	
 public String getDailyWorkout() {
	 return "Spend 30 minutes on batting practice";
 }

@Override
public String getDailyFortune() {
	return fortuneservice.getFortune();
}

//add an init methods
public void doMyStartupStuff() {
	System.out.println("TrackCoach :: inside init method doMyStartupStuff");
}

//add a destroy method
public void doMyCleanupStuff() {
	System.out.println("TrackCoach :: inside init method doMyCleanupStuff");
}
}
