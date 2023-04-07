//SeasonOperationsController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

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
		//return LVN
		return "display";
	}//method

}//class
