//StudentOperationsController.java
package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentOperationsController {
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam("sno") int no, @RequestParam("sname") String name) {
		System.out.println("Student info -->   sno :: "+no+"     sname :: "+name);
		//return LVN
		return "show_result";
	}//method
	*/
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam int sno, @RequestParam String sname) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/	
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam int sno, @RequestParam String name) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/	
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam int sno, @RequestParam(required=false) String sname) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/	
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam int sno, @RequestParam(defaultValue = "ajay") String sname) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/	
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam int sno, @RequestParam String sname) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam(defaultValue = "1055") int sno, @RequestParam String sname) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/	
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam(required = false) Integer sno, @RequestParam String sname) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname);
		//return LVN
		return "show_result";
	}//method
	*/	
	
	/*@GetMapping("/data")
	public String processStudent(@RequestParam(required = false) Integer sno, 
															@RequestParam String sname,
															@RequestParam("sadd") String[] addrs,
															@RequestParam("sadd") List<String> saddList,
															@RequestParam("sadd") Set<String> saddSet){
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname+"   sadd :: "+Arrays.toString(addrs)+
																																				"   sadd :: "+saddList+"   sadd :: "+saddSet);
		//return LVN
		return "show_result";
	}//method
	*/	

	@GetMapping("/data")
	public String processStudent(@RequestParam(required = false) Integer sno, 
															@RequestParam String sname,
															@RequestParam("sadd") String addrs) {
		System.out.println("Student info -->   sno :: "+sno+"     sname :: "+sname+"   sadd :: "+addrs);
		//return LVN
		return "show_result";
	}//method

	
}//class
