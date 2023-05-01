//TradingOperationsController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TradingOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		System.out.println("TradingOperationsController.showHome()");
		//return LVN
		return "welcome";
	}//method
	
	@GetMapping("/trading")
	public String showTradingPage() {
		System.out.println("TradingOperationsController.showTradingPage()");
		//return LVN
		return "trading";
	}//method

}//class
