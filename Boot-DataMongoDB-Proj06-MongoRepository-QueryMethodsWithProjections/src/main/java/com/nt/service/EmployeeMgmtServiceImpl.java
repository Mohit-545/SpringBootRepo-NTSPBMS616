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
	public List<Object[]> searchEmpDataByAddress(String addrs) {
		
		return empRepo.getEmpDataByAddress(addrs);
	}//method

	@Override
	public List<Employee> searchAllEmpsDataByAddress(String addrs) {
		return empRepo.getAllEmpsDataByAddress(addrs);
	}//method

	@Override
	public List<Employee> showAllEmpsDataByAddressAndName(String addrs, String name) {
		return empRepo.getAllEmpDataByAddressAndName(addrs, name);
	}//method

	@Override
	public List<Employee> showAllEmpsDataBySalaryRange(double startSalary, double endSalary) {
		return empRepo.getAllEmpDataBySalaryRange(startSalary, endSalary);
	}//method

	@Override
	public List<Employee> showAllEmpsDataForSpecificAddresses(String addrs1, String addrs2) {
		return empRepo.getAllEmpDataForSpecificAddresses(addrs1, addrs2);
	}//method

	@Override
	public List<Employee> showAllEmpsDataByEnameForSpecificChars(String chars) {
		return empRepo.getAllEmpDataByEnameWithSpecificChars(chars);
	}//method



}//class
