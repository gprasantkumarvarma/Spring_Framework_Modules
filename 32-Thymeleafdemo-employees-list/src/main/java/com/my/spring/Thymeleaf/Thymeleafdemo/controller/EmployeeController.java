package com.my.spring.Thymeleaf.Thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.management.modelmbean.ModelMBean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.spring.Thymeleaf.Thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	//load employee data
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		//create employee
		Employee emp1 = new Employee(1, "Prasant", "Varma", "p@gmail.com");
		Employee emp2 = new Employee(2, "keerthi", "Varma", "k@gmail.com");
		Employee emp3 = new Employee(3, "Kiran", "Matha", "kM@gmail.com");
		Employee emp4 = new Employee(4, "Jyoti", "D", "j@gmail.com");
		
		//create the list
		theEmployees = new ArrayList<Employee>();
		
		//add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
		theEmployees.add(emp4);
		
		
	}
	
	//add mapping for "/list"
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		
		theModel.addAttribute("employees", theEmployees);
		
		return "list-employees";
	}
	
	

}
