package com.java.springdemo.mvc;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.springdemo.mv.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		//create a student object
		Student student = new Student();
		
		//add student object to the model
		theModel.addAttribute("student",student);
		
		return "studen-from";
		
	}
	
	@RequestMapping("/processFrom")
	public String showForm(@ModelAttribute("student") Student theSudent) {
		
		//log the input data
		
		String[] checkboxval = theSudent.getOperatingSystem();
		
		System.out.println("checkboxval ::"+Arrays.toString(checkboxval));
		
		System.out.println("TheStudent: "+theSudent.getFirstName()
		                             +" "+theSudent.getLastName());
		
		return "student-configuration";
		
	}

}
