package com.java.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.springdemo.mv.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//add an initbnder ..to convert trim input string 
	//remove leading and trailing whitespace
	//resolve issue for our validation
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor =
				new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		model.addAttribute("customer",new Customer());
		
		return "customer-form";
		
		
	}
	
	@RequestMapping("/processFrom")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer thCustomer,
			BindingResult theBindingresult) {
		
		System.out.println("last name : |"+thCustomer.getLastName()+"|");
		
		System.out.println("Binding result :"+theBindingresult);
		
		System.out.println("\n\n\n\n");
		
		if(theBindingresult.hasErrors()) {
			return "customer-form";
		}else {
			return "customer-configuration";		
		}
		
	}
	
	

}
