//StudentOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {
	
	@RequestMapping("/")
	public String showHome() {
		//return LVN
		return "welcome";
	}//method
	
	@GetMapping("/register")
	public String showRegistrationForm(@ModelAttribute("st") Student st) {
		//return LVN
		return "student_registration";
	}//method
	
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("stud") Student st, Map<String, Object> map) {
		System.out.println("Student Class Object :: "+st);
		//writing b.logic
		String result = null;
		if(st.getAvg()<=30) 
		result = "Fail";
		else if(st.getAvg()<=50)
			result = "Third Class";
		else if(st.getAvg()<=75)
			result = "Second Class";
		else 
			result = "First Class with Distinction";
		//keep result in model attribute
		map.put("resultMsg", result);
		//return LVN
		return "show_result";
	}//method

}//class
