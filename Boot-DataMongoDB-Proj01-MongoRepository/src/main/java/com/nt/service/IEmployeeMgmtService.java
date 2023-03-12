//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {
	
	public String saveEmployee(Employee e);
	public List<Employee> showAllEmployee();
	public String saveAllEmployee(List<Employee> e);
	public String searchEmployeeById(String id);
	public String modifyEmployeeWithNewSalary(String id,double hikePercentage);
	public String removeEmployeeById(String id);
	public List<Employee> searchEmployeesByExampleData(/*Employee emp,*/ boolean asc, String... props);
	public String registerEmployee(Employee emp);

}//interface
