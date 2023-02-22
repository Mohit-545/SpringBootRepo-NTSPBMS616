//JpaRepoTestRunner.java
package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;
import com.nt.service.IDoctorMgmtService;


@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(service.insertDoctor("Hemant Ojha", "Surgeon", 1985650.0));
		System.out.println();
		
		System.out.println("Current System Date and Time :: "+service.showSysDate());
		
		System.out.println(service.createTempDBTable());
		System.out.println();
		
	}//run(-)

}//class
