//CallingPLSQLProcedureTestRunner.java
package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;


@Component
public class CallingPLSQLProcedureTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		// invoke the business method
		service.showDoctorsByIncomeRange(200000.0, 800000.0).forEach(System.out::println);

	}//run(-)
}//class
