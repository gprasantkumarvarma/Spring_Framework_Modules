package com.my.spring.Thymeleaf.Thymeleafdemo.service;

import java.util.List;

import com.my.spring.Thymeleaf.Thymeleafdemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee>  findAll();
	
	public Employee findById(int theId);
	
	public void save (Employee theEmployee);
	
	public void deleteById(int theId);

}
