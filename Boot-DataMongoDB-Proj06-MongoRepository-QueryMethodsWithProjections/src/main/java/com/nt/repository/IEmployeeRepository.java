//IEmployeeRepository.java
package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {
	//============Projection Queries=========================== 
	//@Query(value = "{eaddrs:?0}", fields = "{eno:0,ename:1,salary:1}")
	@Query(value = "{eaddrs:?0}", fields = "{ename:1,salary:1,eaddrs:1}")
	public List<Object[]> getEmpDataByAddress(String addrs);
	
	//============Entity Queries=========================== 
	@Query(value = "{eaddrs:?0}")
	public List<Employee> getAllEmpsDataByAddress(String addrs); 
	
	@Query(value = "{eaddrs:?0, ename:?1}")
	public List<Employee> getAllEmpDataByAddressAndName(String addrs, String name);
	
	@Query(value = "{salary:{$gte:?0}, salary:{$lte:?1}}")
	public List<Employee> getAllEmpDataBySalaryRange(double startSalary, double endSalary);
	
	@Query(value = "{$or:[{eaddrs:?0},{eaddrs:?1}]}")
	public List<Employee> getAllEmpDataForSpecificAddresses(String addrs1, String addrs2);
	
	@Query(value = "{ename:{'$regex' : ?0}}")
	public List<Employee> getAllEmpDataByEnameWithSpecificChars(String chars);
	
	
	
	
	
	
	
	
	
}//interface
