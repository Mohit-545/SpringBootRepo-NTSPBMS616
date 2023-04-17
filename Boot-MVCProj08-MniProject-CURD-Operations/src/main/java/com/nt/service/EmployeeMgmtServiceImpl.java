//IEmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmployeeData() {
		return empRepo.findAll();
	}//method

	@Override
	public String registerEmployee(Employee emp) {
		int no = empRepo.save(emp).getEmpno();
		return "Employee is saved with employee no = "+no;
	}//method

}//class
