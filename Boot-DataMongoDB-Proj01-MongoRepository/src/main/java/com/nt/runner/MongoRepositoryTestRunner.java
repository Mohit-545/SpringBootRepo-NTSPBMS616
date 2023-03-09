//MongoRepositoryTestRunner.java
package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		/*		Employee emp = new Employee();
				emp.setEno(101); emp.setEname("Kamaldeep"); emp.setEaddrs("Pune"); emp.setSalary(900000.0);
				Employee emp1 = new Employee();
				emp1.setEno(102); emp1.setEname("Paresh"); emp1.setEaddrs("Delhi");
				//System.out.println(service.saveEmployee(emp));
				System.out.println(service.saveEmployee(emp1));*/
		System.out.println();
		//service.showAllEmployee().forEach(System.out::println);
		System.out.println();
		Employee emp2 = new Employee();
		emp2.setEno(103); emp2.setEname("Akash"); emp2.setSalary(55000.0);
		Employee emp3 = new Employee();
		emp3.setEno(104); emp3.setEname("Mahesh"); 
		Employee emp4 = new Employee();
		emp4.setEno(105); emp4.setEname("Ajay"); emp4.setEaddrs("Mumbai"); emp4.setSalary(82000.0);
		System.out.println(service.saveAllEmployee(List.of(emp2, emp3, emp4)));

	}//run(-)

}//class
