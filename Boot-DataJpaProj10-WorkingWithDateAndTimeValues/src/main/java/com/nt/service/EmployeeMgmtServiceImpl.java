//EmployeeMgmtServiceImpl.java
package com.nt.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_Date_Time;
import com.nt.repository.EmployeeDateTimeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("employeeService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private EmployeeDateTimeRepository empRepo;

	@Override
	public String saveEmployee(Employee_Date_Time dateTime) {
		int idNo = empRepo.save(dateTime).getEno();
		return "Employee Object is saved with id no :: "+idNo;
	}//method

	@Override
	public List<Employee_Date_Time> getAllEmployees() {
		return empRepo.findAll();
	}//method

	@Override
	public List<Integer> showEmployeesAgeByDesignation(String designation) {
		return empRepo.getEmployeesAgeByDesg(designation);
	}//method


}//class
