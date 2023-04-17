//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> getAllEmployeeData();
	public String registerEmployee(Employee emp);

}//interface
