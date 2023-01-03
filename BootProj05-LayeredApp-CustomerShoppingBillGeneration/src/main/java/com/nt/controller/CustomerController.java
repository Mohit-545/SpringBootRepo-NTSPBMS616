//CustomerController.java
package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Customer;
import com.nt.service.ICustomerService;

@Controller("customerController")
public class CustomerController {
	//injecting service class obj
	@Autowired
	private ICustomerService customerService;
	
	public String getCustomerFinalBill(Customer cust) throws Exception{
		//generate patient's final bill using service class obj
		String finalBill = customerService.registerCustomer(cust);
		return finalBill;
	}//method

}//class
