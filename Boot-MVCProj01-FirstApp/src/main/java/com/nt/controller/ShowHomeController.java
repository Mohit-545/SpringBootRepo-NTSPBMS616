//ShowHomeController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	//@RequestMapping("/home")
	@RequestMapping("/")
	public String showHome() {
		//return LVN
		return "welcome";
	}//method

}//class