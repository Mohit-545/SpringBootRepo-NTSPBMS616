//SeasonOperationsController.java
package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Employee;
import com.nt.service.ISeasonFinderService;

//@RequestMapping("/season-operations")
@Controller
public class SeasonOperationsController {
	@Autowired
	private ISeasonFinderService service;
	
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}//method
	
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> map) {
		//invoke the business method using service
		String msg = service.findSeason();
		//keep the result in model attribute
		map.put("season", msg);
		
		//adding simple values to model attributes
		map.put("cname", "MS DHONI");
		map.put("speciality", "WicketKeeper-Batsman");
		
		//adding simple values to model attributes
		map.put("favColor", new String[] {"purple","maroon", "orange"});
		map.put("nickNames", List.of("ajay", "ajju", "ramu"));
		map.put("phoneNumbers", Set.of(9887755543L, 8877125644L));
		map.put("idDetails", Map.of("Aadhaar Card", 8547952384758471L, "Pan Card", 895645879L));
		
		//create collection of model class object
		List<Employee> empList = List.of(new Employee(1001, "Virat", 50000.0, "true"), 
																	new Employee(1002, "Dhoni", 80000.0, "true"),
																	new Employee(1003, "KL", 45000.0, "true"));
		//add model class collection object to model attributes
		map.put("empListInfo", empList);
		//return LVN
		return "display";
	}//method
	
	/*@GetMapping("/report")
	public String showAllReport() {
		System.out.println("SeasonOperationsController.showAllReport()");
		return "forward:demo-operations/all";
	}//method
	*/	
	
	
	
	
}//class
