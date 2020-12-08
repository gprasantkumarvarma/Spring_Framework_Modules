package com.java.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component // default bean id
//@Scope("prototype")
public class TennisCoach implements Coach {

	/*- Field injection */
	//@Autowired
	// @Qualifier("happyFortuneService")
	// @Qualifier("randomFortuneService")
	private FortuneService fortuneservice;

	public TennisCoach() {
		System.out.println("TennisCoach:: Inside default constructor");
	}

	// @Qualifier in case of construction injection
	@Autowired
	TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneservice) {
		this.fortuneservice = fortuneservice;
	}

	/*- Construction injection
	  Spring will scanned the package component and find 
	  a bean that implement FortuneService and inject into TennisCoach
	  
	  @Autowired 
	  TennisCoach(FortuneService fortuneservice){
	  this.fortuneservice=fortuneservice; }
	  
	 */

	/*- setter injection
	 
	   @Autowired public void setFortuneservice(FortuneService fortuneservice) {
	   System.out.println("TennisCoach:: Inside setFortuneservice method");
	   this.fortuneservice = fortuneservice; }
	 
	 */

	/*
	 * You can use any method name.
	 * 
	 * @Autowired public void doFortuneservice(FortuneService fortuneservice) {
	 * System.out.println("TennisCoach:: Inside doFortuneservice method");
	 * this.fortuneservice = fortuneservice; }
	 * 
	 */
	
	//define my init menthod
	@PostConstruct
	public void doMyStartupStaff() {
		System.out.println("TennisCoach :: inside in my doMyStartupStaff");
	}
	
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStaff() {
		System.out.println("TennisCoach :: inside in my doMyCleanupStaff");
		
	}

	@Override
	public String getDailyWorkout() {

		return "Practice your backhard volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneservice.getFortune();
	}

}
