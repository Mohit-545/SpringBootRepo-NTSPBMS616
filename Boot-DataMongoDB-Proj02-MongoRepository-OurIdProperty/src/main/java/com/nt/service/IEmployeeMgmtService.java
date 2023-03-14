//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
	
	public String saveEmployee(Employee e);
	
	public List<Employee> searchBySalaryRange(double start, double end);
	public Employee searchByEmployeeName(String name);
	
}//interface
