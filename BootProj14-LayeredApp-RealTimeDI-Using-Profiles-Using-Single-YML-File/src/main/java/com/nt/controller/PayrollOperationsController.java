//PayrollOperationsController.java
package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("payrollController")
public class PayrollOperationsController {
	
	public PayrollOperationsController() {
		System.out.println();
		System.out.println("PayrollOperationsController::0-param Constructor");
	}
	@Autowired
	private IEmployeeMgmtService empService;
	
	public String processEmployee(Employee emp) throws Exception{
		//use Service 
		String result = empService.registerEmployee(emp);
		return result;
	}//method

}//class
