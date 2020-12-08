package com.java.springdemo;

public class CricketCoach implements Coach{
	private FortuneService fortuneservice;
	private String emailAddess;
	private String team;
	
   //create a no-arg construction
	public CricketCoach(){
		System.out.println("CricketCoach::inside no-arg constraction");
	}
	
	public String getEmailAddess() {
		return emailAddess;
	}

	public void setEmailAddess(String emailAddess) {
		System.out.println("CricketCoach::inside email setter menthod");
		this.emailAddess = emailAddess;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach::inside team setter menthod");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {

		return "Practice fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneservice.getFortune();
	}
// our setter menthod
	public void setFortuneservice(FortuneService fortuneservice) {
		System.out.println("CricketCoach::inside setter menthod Fortune service object");
		this.fortuneservice = fortuneservice;
	}
   
	
}
