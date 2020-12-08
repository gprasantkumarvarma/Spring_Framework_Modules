package com.java.springdemo;

public class MYNewCricketCoach implements Coach{
	private MyNewFortuneService myfortuneservice;

	public void setMyfortuneservice(MyNewFortuneService myfortuneservice) {
		this.myfortuneservice = myfortuneservice;
	}

	@Override
	public String getDailyWorkout() {
		System.out.println("MYCricketCoach : inside daily workout");
		return "Today to 1 hour workout!!!";
	}

	@Override
	public String getDailyFortune() {
		System.out.println("MYCricketCoach : inside daily fortune");
		return myfortuneservice.getFortune();
	}

}
