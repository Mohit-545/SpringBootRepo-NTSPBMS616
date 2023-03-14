//EmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String saveEmployee(Employee e) {
		return "MongoDb doc is saved with id values :: "+empRepo.insert(e).getEno();
	}//method

	@Override
	public List<Employee> searchBySalaryRange(double start, double end) {
		
		return empRepo.findBySalaryBetween(start, end);
	}//method

	@Override
	public Employee searchByEmployeeName(String name) {
		
		return empRepo.findByEname(name);
	}//method


}//class
