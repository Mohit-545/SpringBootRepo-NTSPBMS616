//DemoController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/demo-operations")
@Controller
public class DemoController {
	
	//@RequestMapping({"/report","/report1","/report2"})
	@GetMapping("/all")
	public String showReport() {
		System.out.println("DemoController.showReport()");
		return "show_report";
	}//method

	
	/*//@RequestMapping("/REPORT")
	@PostMapping("/report")
	public String showReport1() {
		System.out.println("DemoController.showReport1()");
		return "show_report1";
	}//method
	*/
	}//class
