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
		
		service.searchEmpDataByAddress("Pune").forEach(row->{
			for(Object val:row) {
				System.out.println(val+"  ");
			}//for
		});
		System.out.println("=====(1)=====================================================================================================");
		service.searchAllEmpsDataByAddress("Hyd").forEach(System.out::println);
		
		System.out.println("=====(2)=====================================================================================================");
		service.showAllEmpsDataByAddressAndName("Kolkata", "Shree").forEach(System.out::println);
		
		System.out.println("=====(3)=====================================================================================================");
		service.showAllEmpsDataBySalaryRange(200000.0, 600000.0).forEach(System.out::println);
		
		System.out.println("=====(4)=====================================================================================================");
		service.showAllEmpsDataForSpecificAddresses("Hyd", "Kolkata").forEach(System.out::println);
		
		System.out.println("=====(5)===containing the character=====================================================================================");
		service.showAllEmpsDataByEnameForSpecificChars("h").forEach(System.out::println);
		
		System.out.println("=====(6)===starting with this character=====================================================================================");
		service.showAllEmpsDataByEnameForSpecificChars("^m").forEach(System.out::println);
		
		System.out.println("=====(7)===ending with this character=====================================================================================");
		service.showAllEmpsDataByEnameForSpecificChars("h$").forEach(System.out::println);
	
		System.out.println("=====(8)===counting of all employees=====================================================================================");
		System.out.println(service.showAllEmpsCountBySalaryRange(800000.0, 1000000.0));
		
		System.out.println("=====(9)===sorting of all employees=====================================================================================");
		service.showAllEmpsByEnameSorted().forEach(System.out::println);
		
		System.out.println("=====(10)===deleting employees=====================================================================================");
		System.out.println(service.deleteEmpsWithNoVaccination());
		
		System.out.println("=====(11)===exists operator used for employees=====================================================================================");
		System.out.println(service.showEmpsWithoutAddress());
		
		
		
		
		
		
		
		
		
	}// run(-)

}// class
