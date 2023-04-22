//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> getAllEmployeeData();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeById(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int id);
	public List<Integer> fetchAllDeptno();
	public boolean isDesgInRejectedList(String desg);
}//interface
