//ShowHomeController.java
package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	
	//@RequestMapping("/home")
	@RequestMapping("/")
	public String showHome() {
	
		//return LVN
		return "welcome";
	}//method

	
	//This approach is good as it makes the project non-invasive as Map interface is specific to Java
	/*@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("ShowHomeController.process():: SharedMemory Object Class name :: "+map.getClass());
		
		//add model attributes to shared memory
		map.put("Name", "MS Dhoni");
		map.put("SysDateTime", LocalDateTime.now());
	
		//return LVN
		return "show_data";
	}//method
	*/
	
	//This approach is not good as it makes the project invasive as Model interface is specific to SpringBoot framework
	/*@RequestMapping("/process")
	public String processRequest(Model model) {
		System.out.println("ShowHomeController.process():: SharedMemory Object Class name :: "+model.getClass());
		
		//add model attributes to shared memory
		model.addAttribute("Name", "MS Dhoni");
		model.addAttribute("SysDateTime", LocalDateTime.now());
		
		//return LVN
		return "show_data";
	}//method
	*/

	//This approach is not good as it makes the project invasive as ModelMap class is specific to SpringBoot framework
	@RequestMapping("/process")
	public String processRequest(Model model) {
		System.out.println("ShowHomeController.process():: SharedMemory Object Class name :: "+model.getClass());
		
		//add model attributes to shared memory
		model.addAttribute("Name", "MS Dhoni");
		model.addAttribute("SysDateTime", LocalDateTime.now());
		
		//return LVN
		return "show_data";
	}//method

}//class
