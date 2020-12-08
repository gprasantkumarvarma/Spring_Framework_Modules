package com.java.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.springdemo.entity.Customer;
import com.java.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	/*-
	  @Autowired 
	  @Qualifier("customerDOAImpl")
	  private CustomerDAO customerDAO;
	 */
	
	//need to inject our service
	@Autowired
	private CustomerService customerService;

	// @RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		// get customer from the service
		List<Customer> theCustomer = customerService.getCustomers();

		// add the customer to the model
		theModel.addAttribute("customers", theCustomer);

		return "list-customer";

	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		
		//create model attribute to bind the data
		Customer thecustomer = new Customer();
		theModel.addAttribute("addcustomer",thecustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("addcustomer") Customer theCustomer) {
		
		//save he customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("addcustomer",theCustomer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	
	
	@GetMapping("/search")
	public String serachCustomer(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		List<Customer> theCustomer = customerService.searchCustomers(theSearchName);
		
		theModel.addAttribute("customers",theCustomer);
		
		return "list-customer";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
