//JpaRepoTestRunner.java
package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println(service.deleteDoctorsByIdsInBatch(Arrays.asList(100,null)));
		System.out.println();
		
		/*Doctor doc = new Doctor();
			doc.setSpecialization("MD-Cardio");  doc.setIncome(250000.0);
			service.showDoctorsByExampleData(doc,true, "income").forEach(System.out::println);*/
		
		System.out.println(service.findDoctorById(102));
	}//run()

}//class
