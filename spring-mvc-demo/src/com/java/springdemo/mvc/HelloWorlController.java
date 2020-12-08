package com.java.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") 
public class HelloWorlController {

	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloword-form";
	}
	
	//need a controller method to process the  HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		
		return "helloworld";
		
	}
	
	//new controller method to read from data and 
	//add data to model
	
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDuse(HttpServletRequest request,Model model) {
		
		//read the request parameter from the html from
		String thname = request.getParameter("studentName");
		
		//convert the data to all upper case
		thname=thname.toUpperCase();
		
		//create the message
		String result = "Yo! " + thname;
		
		//add message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName")String theName,Model model) {
		
		//read the request parameter from the html from
		String thname = theName;
		
		//convert the data to all upper case
		thname=thname.toUpperCase();
		
		//create the message
		String result = "hy my friend from v3 " + thname;
		
		//add message to the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
}
