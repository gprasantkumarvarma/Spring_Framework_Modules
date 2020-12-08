package com.java.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.java.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	//manually we are adding bean not using component scan
	//define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	//define bean for our swim coach and inject dependency.
	@Bean
	public Coach swimCoach() {
		
		//injecting bean dependency
		return new SwimJavaCongifCoach(sadFortuneService());
	}
	

}
