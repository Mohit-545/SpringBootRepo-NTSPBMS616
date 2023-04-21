//EmployeeOperationsController.java
package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService empService;
	@Autowired
	private EmployeeValidator validator;
	
	@RequestMapping("/")
	public String showHomePage() {
		//return LVN
		return "show_home";
	}//method
	
	@GetMapping("/emp_report")
	public String showAllEmpData(Map<String, Object> map) {
		//use service to get emp data
		List<Employee> empList = empService.getAllEmployeeData();
		//add result to model attributes
		map.put("resultList", empList);
		//return LVN
		return "show_emp_report";
	}//method
	
	@GetMapping("/emp_add")
	public String showAddEmpForm(@ModelAttribute("emp") Employee emp) {
		//return LVN
		return "register_emp";
	}//method
	
	@PostMapping("/emp_add")
	public String registerEmployeeData(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs,
																																BindingResult errors) {
		//use validator
		if(validator.supports(Employee.class)) {
			validator.validate(emp, errors);
			
				if(errors.hasErrors()) {
					return "register_emp";
				}//if
		}//if
		
		//use service to register emp data
		String msg = empService.registerEmployee(emp);
		//add the results to flash attributes
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:emp_report";
	}//method
	
	@GetMapping("/emp_edit")
	public String showEmployeeUpdateFormPage(@RequestParam("no") int eno, @ModelAttribute("emp") Employee emp) {
		//use Service and get emp data by id
		Employee emp1 = empService.getEmployeeById(eno);
		//copy data source to dest emp object
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "update_emp";
	}//method
	
	@PostMapping("/emp_edit")
	public String updateEmployeeData(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs,
																																	BindingResult errors) {
		//use validator
				if(validator.supports(Employee.class)) {
					validator.validate(emp, errors);
					
						if(errors.hasErrors()) {
							return "update_emp";
						}//if
				}//if
		//use Service to send new emp data to DB
		String msg = empService.updateEmployee(emp);
		// add result to flash attributes
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:emp_report";
	}//method
	
	@GetMapping("emp_delete")
	public String deleteEmployee(@RequestParam int no, RedirectAttributes attrs) {
		//use Service
		String msg = empService.deleteEmployeeById(no);
		//add result to flash attributes
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:emp_report";
	}//method
	
	@ModelAttribute("deptNoInfo")
	public List<Integer> refDataForDeptnoSelectBox(){
		//use service
		List<Integer> deptnoList = empService.fetchAllDeptno();
		return deptnoList;
	}//method

}//class
