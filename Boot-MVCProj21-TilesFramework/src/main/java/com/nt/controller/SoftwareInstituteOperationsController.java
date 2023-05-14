//SoftwareInstituteOperationsController.java
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SoftwareInstituteOperationsController {
	
	@GetMapping("/")
	public String showHome() {
		return "homePageDef";
	}//method
	
	@GetMapping("/faculties")
	public String showFacultiesPage() {
		return "facultiesPageDef";
	}//method
	
	@GetMapping("/courses")
	public String showCoursePage() {
		return "coursesPageDef";
	}//method
	
	@GetMapping("/training_modes")
	public String showTrianingModesPage() {
		return "tmPageDef";
	}//method

}//class
