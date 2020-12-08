package com.java.springdemo;

import java.util.Random;

public class MyNewFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		 Random rendom = new Random();
		 
		 String [] mylistFortune= {"Today is you can play well!!",
				 "Today is you best day!!",
				 "Today not good for you, Be careful !!!"};
		 
		return mylistFortune[rendom.nextInt(3)] +"RN ::"+rendom.nextInt(3);
	}

}
