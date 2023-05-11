//ServerOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServerOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "index";
	}//method
				
	@GetMapping("/showpm")
	public String showPm(Map<String, Object> map) {
		String msg = "Current India PM :: Mr. Narendra Damodardas Modi";
		map.put("resultMsg", msg);
		return "result";
	}// method
	
}// class
