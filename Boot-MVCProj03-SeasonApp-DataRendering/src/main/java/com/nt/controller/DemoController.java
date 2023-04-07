//DemoController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping({"/report","/report1","/report2"})
	public String showReport() {
		return "show_report";
	}//method

	@RequestMapping("/REPORT")
	public String showReport1() {
		return "show_report1";
	}//method
}//class
