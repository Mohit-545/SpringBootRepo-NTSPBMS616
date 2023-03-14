//IEmployeeRepository.java
package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {
	//finder methods used
	public List<Employee> findBySalaryBetween(double start, double end);
	public Employee findByEname(String empName);

}//interface
