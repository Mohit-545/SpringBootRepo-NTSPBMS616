//CustomerOperationsController.java
package com.nt.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		//return LVN
		return "welcome";
	}//method
	
	@GetMapping("/customer_register")
	public String showCustomerRegistration(@ModelAttribute("cust")Customer cust) {
		System.out.println("CustomerOperationsController.showCustomerRegistration()");
		// return LVN
		return "customer_form";
	}//method
	
	@PostMapping("/customer_register")
	public String registerCustomer(@ModelAttribute("cust")Customer cust, Map<String, Object> map) {
		System.out.println("CustomerOperationsController.registerCustomer()");
		System.out.println("Customer model obj :: "+cust);
		// add result to model attribute
		map.put("custResult", cust);
		//return LVN
		return "show_result";
	}//method
	
	@InitBinder
	public void myDataBinder(WebDataBinder binder) {
		System.out.println("CustomerOperationsController.myDataBinder()");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf1, true));
	}//method

}//class
