package com.luv2code.spingboot.curddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.spingboot.curddemo.dao.EmployeeDAO;
import com.luv2code.spingboot.curddemo.dao.EmployeeDAOHibernateImpl;
import com.luv2code.spingboot.curddemo.entity.Employee;
import com.luv2code.spingboot.curddemo.service.EmployeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// quick nd dirty : inject employee dao (useing construction injection)

	private EmployeServiceImpl employeService;

	@Autowired
	public EmployeeRestController(EmployeServiceImpl themployeService) {
		employeService = themployeService;
	}

	// expose "/employees" and return list of employees

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeService.findAll();
	}

	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID) {

		Employee theEmployee = employeService.findById(employeeID);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id not fround- " + employeeID);
		}

		return theEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// also just in case they pass an id in JSON..set id to 0
		// this is to force a save of new item...insted of update

		theEmployee.setId(0);
		employeService.save(theEmployee);

		return theEmployee;

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		employeService.save(theEmployee);

		return theEmployee;

	}

	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable int employeeID) {

		Employee tempEmployee = employeService.findById(employeeID);

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not fround- " + employeeID);
		}

		employeService.deleteById(employeeID);

		return "Deleted employee id -" + employeeID;
	}

}
