//EmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String saveEmployee(Employee e) {
		return "MongoDb doc is saved with id values :: "+empRepo.insert(e).getId();
	}//method

	@Override
	public List<Employee> showAllEmployee() {
		return empRepo.findAll();
	}//method

	@Override
	public String saveAllEmployee(List<Employee> e) {
		return "All employees are saved "+empRepo.saveAll(e);
	}//method

}//class
