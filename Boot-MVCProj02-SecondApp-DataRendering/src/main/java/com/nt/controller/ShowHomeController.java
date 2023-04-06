//ShowHomeController.java
package com.nt.controller;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShowHomeController {
	@Autowired
	private ServletConfig cg;
	@Autowired
	private ServletContext sc;
	
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
	/*	@RequestMapping("/process")
		public String processRequest(Model model) {
			System.out.println("ShowHomeController.process():: SharedMemory Object Class name :: "+model.getClass());
			
			//add model attributes to shared memory
			model.addAttribute("Name", "MS Dhoni");
			model.addAttribute("SysDateTime", LocalDateTime.now());
			
			//return LVN
			return "show_data";
		}//method
	*/

	//More permutations and combinations on data rendering w.r.to return types
	
	/*@RequestMapping("/process")
	public Model process() {
		//manually create shared memory
		Model model = new BindingAwareModelMap();
		
		//add model attributes to shared memory
		model.addAttribute("Name", "MS Dhoni");
		model.addAttribute("SysDateTime", LocalDateTime.now());
		return model;
	}//method
	*/	
	
	/*@RequestMapping("/process")
	public Map<String,Object> process() {
		//manually create shared memory
		Map<String,Object> map = new HashMap<String, Object>();
		
		//add model attributes to shared memory
		map.put("Name", "MS Dhoni");
		map.put("SysDateTime", LocalDateTime.now());
		return map;
	}//method
	*/	
	
	/*@RequestMapping("/process")
	public ModelAndView process() {
		//manually create shared memory
		ModelAndView mav = new ModelAndView();
		
		//add model attributes to shared memory
		mav.addObject("Name", "MS Dhoni");
		mav.addObject("SysDateTime", LocalDateTime.now());
		//add LVN to mav Object
		mav.setViewName("show_data");
		return mav;
	}//method
	*/	
	
	/*@RequestMapping("/process")
	public void process(Map<String,Object> map) {
		System.out.println("ShowHomeController.process():: SharedMemory Object Class name :: "+map.getClass());
		
		//add model attributes to shared memory
		map.put("Name", "MS Dhoni");
		map.put("SysDateTime", LocalDateTime.now());
	}//method
	*/	
	
	/*@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("ShowHomeController.process():: SharedMemory Object Class name :: "+map.getClass());	
		//add model attributes to shared memory
		map.put("Name", "MS Dhoni");
		map.put("SysDateTime", LocalDateTime.now());
		return null;
	}//method
	*/	
	
	//Handler method chaining for forwarding request
	/*@RequestMapping("/process")
	public String process() {			//source handler method
		System.out.println("ShowHomeController.process()");
		return "forward:report";
	}//method
	
	@RequestMapping("/report")
	public String showReport() {		//destination handler method
		System.out.println("ShowHomeController.showReport()");
		return "show_data";
	}//method
	*/	
	
	//Handler method chaining for redirecting request
	/*@RequestMapping("/process")
	public String process(HttpServletRequest req) {			//source handler method
		System.out.println("ShowHomeController.process()::"+req.hashCode());
		req.setAttribute("attr1", "val1");
		return "redirect:report";
	}//method
	
	@RequestMapping("/report")
	public String showReport(HttpServletRequest req) {		//destination handler method
		System.out.println("ShowHomeController.showReport()");
		System.out.println("req attribute value :: "+req.getAttribute("attr1"));
		return "show_data";
	}//method
	*/	
	
	//Passing request and response object to the handler methods
	/*@RequestMapping("/process")
	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("ShowHomeController.process()::"+req.hashCode());
		req.setAttribute("attr1", "val1");
		return "show_data";
	}//method 
	*/	
	
	//Passing session object to the handler methods
	/*@RequestMapping("/process")
	public String process(HttpSession ses) {
		System.out.println("ShowHomeController.process()::"+ses.hashCode());
		ses.setAttribute("attr1", "val1");
		return "show_data";
	}//method
	*/	
	
	//Passing ServletConfig and ServletContext object to the Controller class and using them in handler methods
	/*@RequestMapping("/process")
	public String process(Map<String,Object> map) {
		System.out.println("web application context path :: "+sc.getContextPath());
		System.out.println("DS Logical Name :: "+cg.getServletName());
		map.put("attr1", "val1");
		//return LVN
		return "show_data";
	}//method
	*/	
	
	//Passing output result directly to the browser with involving viewResolver and view comps
	@RequestMapping("/process")
	public void process(HttpServletResponse res) throws Exception{
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/html");
		//display the output (write data from handler)
		pw.println("<h1><b>Directly from Handler Method</b></h1>");
	}//method
	
	
	
	
}//class
