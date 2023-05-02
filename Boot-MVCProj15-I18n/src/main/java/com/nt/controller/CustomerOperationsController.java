//CustomerOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute("cust") Customer cust, Map<String,Object> map) {
		//return LVN
		return "register_customer";
	}//method

	@PostMapping("/register")
	public String registerCustomerData(@ModelAttribute("cust") Customer cust, Map<String,Object> map) {
		//writing b.logic
		if(cust.getBillAmt()<15000)
			map.put("resultMsg", "Customer is an economical person");
		else
			map.put("resultMsg", "Customer is a luxurious person");
		//return LVN
		return "show_result";
	}//method


}//class
