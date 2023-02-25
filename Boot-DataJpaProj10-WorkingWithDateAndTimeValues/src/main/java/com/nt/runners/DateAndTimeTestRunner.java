//DateAndTimeTestRunner.java
package com.nt.runners;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee_Date_Time;
import com.nt.service.IEmployeeMgmtService;



@Component
public class DateAndTimeTestRunner implements CommandLineRunner {
	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		// invoke the business method
		try {
			/*Employee_Date_Time emp = new Employee_Date_Time("Gaurav Shah", "Tester", LocalDateTime.of(1990, 6, 25, 11, 28, 16), LocalTime.of(8, 10), LocalDate.of(2022, 05, 8));
			System.out.println(service.saveEmployee(emp));*/
			
			service.getAllEmployees().forEach(System.out::println);
			System.out.println();
			service.showEmployeesAgeByDesignation("Tester").forEach(System.out::println);
			System.out.println();
			
		}//try 
		catch (Exception e) {
			e.printStackTrace();
		}//catch

	}//run(-)
}//class
