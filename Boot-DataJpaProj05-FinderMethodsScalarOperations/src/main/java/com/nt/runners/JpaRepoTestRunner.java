//JpaRepoTestRunner.java
package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;
import com.nt.service.IDoctorMgmtService;


@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
	System.out.println();
		service.showDoctorsByIncomeRange(80000.0, 300000.0).forEach(System.out::println);
		System.out.println();
		
	}//run()

}//class
