package com.my.spring.Thymeleaf.Thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.spring.Thymeleaf.Thymeleafdemo.entity.Employee;
import com.my.spring.Thymeleaf.Thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployee(Model theModel) {
		List<Employee> theemployees = employeeService.findAll();

		theModel.addAttribute("employees", theemployees);

		return "list-employees";
	}

}
