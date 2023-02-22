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
	System.out.println();
	/*service.showDoctorsByIncomeRange(80000.0, 300000.0).forEach(System.out::println);
	System.out.println();
	System.out.println();
	System.out.println();
	
	service.showDoctorsBySpecialization("MD-Cardio", "Ortho").forEach(System.out::println);
	System.out.println();
	
	service.showDoctorsDataByIncome(50000.0, 250000.0).forEach(row->{
		for(Object val:row) {
			System.out.print(val+"   ");
		}
		System.out.println();
	});
	System.out.println();
	
	service.showDoctorsNameByIncomeRange(128000.0, 155000.0).forEach(System.out::println);
	System.out.println();*/
//=======================================================================================================	
	/*Doctor doc = service.showDoctorByName("Modi");
		System.out.println("Doctor Info is :: "+doc);
		System.out.println();
		
		Object obj = service.showDoctorDataByName("Amit Shah");
		Object[] data = (Object[]) obj;
		for(Object val:data) {
			System.out.print(val+"  ");
		}
		System.out.println();
		
		String result = service.showDoctorSpecializationByDoctorName("Paresh Shah");
		System.out.println("Specialization is :: "+result);*/
//=========================================================================================================
	/*int count = service.showDoctorsNameCount();
	System.out.println("Unique Doctor's Count :: "+count);
	System.out.println();
	
	Object obj = service.showDoctorsAggregateData();
	Object[] data = (Object[]) obj;
	System.out.println("Total Doctor's Records Count :: "+data[0]);
	System.out.println("Max Income Value :: "+data[1]);
	System.out.println("Min Income Value :: "+data[2]);
	System.out.println("Avg Income Value :: "+data[3]);
	System.out.println("Sum of Income Value :: "+data[4]);
	System.out.println();*/
//===========================================================================================================
	
	int count = service.appraiseDoctorsIncomeBySpecialization("MD-Ansthesia", 10.0);
	System.out.println("No. of records that are affected :: "+count);
	
	int docCount = service.fireDoctorsByIncomeRange(100000.0, 140000.0);
	System.out.println("Deleted Doctor's count :: "+docCount);
	
	
	}//run()

}//class
