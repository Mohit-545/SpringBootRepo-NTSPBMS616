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

	@Override
	public String searchEmployeeById(String id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isPresent()) {
			return opt.get().toString();
		}//if
		else
		return "Document not found";
	}//method

	@Override
	public String modifyEmployeeWithNewSalary(String id, double hikePercentage) {
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isEmpty()) {
			return "Document not found";
		}//if
		else {
			Employee emp = opt.get();
			emp.setSalary(emp.getSalary()+(emp.getSalary()*hikePercentage/100));
			empRepo.save(emp);
			return "Document is found and updated";		
		}//else
	}//method

	@Override
	public String removeEmployeeById(String id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(opt.isPresent()) {
			empRepo.deleteById(id);
			return "Document is found and removed";
		}//if
		else
		return "Document is not found";
	}//method

	@Override
	public List<Employee> searchEmployeesByExampleData(/*Employee emp,*/ boolean asc, String... props) {
		//Example<Employee> example = Example.of(emp);
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		List<Employee> list = empRepo.findAll(/*example,*/ sort);
		return list;
	}//method

	@Override
	public String registerEmployee(Employee emp) {
		emp.setId(UUID.randomUUID().toString());
		
		return empRepo.insert(emp).getId();
	}//method

}//class
