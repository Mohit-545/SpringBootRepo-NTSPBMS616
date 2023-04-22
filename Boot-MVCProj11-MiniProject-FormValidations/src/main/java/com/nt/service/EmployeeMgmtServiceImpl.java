//IEmployeeMgmtServiceImpl.java
package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.repository.IDepartmentRepo;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepo empRepo;
	@Autowired
	private IDepartmentRepo deptRepo;

	@Override
	public List<Employee> getAllEmployeeData() {
		return empRepo.findAll();
	}//method

	@Override
	public String registerEmployee(Employee emp) {
		int no = empRepo.save(emp).getEmpno();
		return "Employee is saved with employee no = "+no;
	}//method

	@Override
	public Employee getEmployeeById(int eno) {
		
		return empRepo.findById(eno).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id....!!!!!"));
	}//method

	@Override
	public String updateEmployee(Employee emp) {
	Optional<Employee> opt = empRepo.findById(emp.getEmpno());
	if(opt.isPresent()) {
		int idVal = empRepo.save(emp).getEmpno();
		return "Employee details with id no :: "+idVal+" are updated successfully";
	}//if
		return "Employee with id no :: "+emp.getEmpno()+" not found...!!!!!";
	}//method

	@Override
	public String deleteEmployeeById(int id) {
	Optional<Employee> opt = empRepo.findById(id);
	if(opt.isPresent()) {
		empRepo.deleteById(id);
		return "Employee with id no :: "+id+" is permanently deleted";
	}//if
		return "Employee with id no :: "+id+" is not found...!!!!!";
	}//method

	@Override
	public List<Integer> fetchAllDeptno() {
		List<Integer> deptnoList = deptRepo.getAllDeptNo();
				
		return deptnoList;
	}//method

	@Override
	public boolean isDesgInRejectedList(String desg) {
		if(desg.equalsIgnoreCase("TeamLeader")) {
			return true;
		}//if
		else
		return false;
	}//method
	
	

}//class
