//MongoRepositoryTestRunner.java
package com.nt.runner;

import java.util.List;
import java.util.Random;

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
		/*Employee emp = new Employee();
		emp.setEno(new Random().nextInt(10000)); emp.setEname("Masur"); emp.setEaddrs("Hyd"); emp.setSalary(5454856.0);
		emp.setVaccinated(true);
		System.out.println(service.saveEmployee(emp));*/
		
		//service.searchBySalaryRange(250000.0, 1000000.0).forEach(System.out::println);
		System.out.println();
		System.out.println(service.searchByEmployeeName("Kamaldeep"));
		
	}// run(-)

}// class
