//IEmployeeMgmtService.java
package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	
	public List<Employee> getAllEmployeeData();
	public String registerEmployee(Employee emp);
	public Employee getEmployeeById(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int id);
	public List<Integer> fetchAllDeptno();
	public boolean isDesgInRejectedList(String desg);
	public Page<Employee> getEmpDataByPageno(Pageable pageable);
}//interface
