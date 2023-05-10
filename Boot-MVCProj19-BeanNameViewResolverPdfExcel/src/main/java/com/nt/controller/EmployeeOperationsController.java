//EmployeeOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}//method
	
	@GetMapping("/report")
	public String generateReport(@RequestParam("type") String type, Map<String,Object> map) {
		//use Service
		Iterable<Employee> empList = empService.getAllEmployeesData();
		//add to Model Attributes
		map.put("empList", empList);
		//return LVN
		if(type.equalsIgnoreCase("pdf"))
			return "pdfReport";
		else
			return "excelReport";
	}//method

}//class
