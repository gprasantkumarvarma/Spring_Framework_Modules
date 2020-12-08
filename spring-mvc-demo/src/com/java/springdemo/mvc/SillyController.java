package com.java.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/funny")
public class SillyController {
	
	//need a controller method to show the initial HTML form
		@RequestMapping("/showForm")
		public String displayTheForm() {
			return "helloword-form";
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
			
			return "silly";
		}
}
