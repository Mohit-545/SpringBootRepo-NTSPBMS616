//RTORunnerTest.java
package com.nt.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IRTOServiceMgmt;

@Component
public class RTORunnerTest implements CommandLineRunner {
	@Autowired
	private IRTOServiceMgmt service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		// (1) Saving Parent to child
		/*	Person per = new Person(new Random().nextInt(10000), "Mahesh", "Chennai");
			//creating child class object
			DrivingLicense license = new DrivingLicense(new Random().nextInt(1000000), "LMV", LocalDate.of(2050, 10, 15));
			//set child to parent 
			per.setLicense(license);
			//saving parent class object
			System.out.println(service.registerPersonWithDrivingLicense(per));
			System.out.println();*/

				// (2) Saving Child to Parent
				/*	Person per1 = new Person(new Random().nextInt(50000), "Akash", "Pune");
					//creating child class object
					DrivingLicense license1 = new DrivingLicense(new Random().nextInt(2000000), "LMV", LocalDate.of(2040, 05, 22));
					//set parent to child
					license1.setPersonDetails(per1);
					//save child class object
					System.out.println(service.registerDrivingLicenseWithPerson(license1));
					System.out.println();*/
		
		//fetching all parent details
		/*List<Person> list = service.fetchAllPersonDetails();
		list.forEach(per->{
			System.out.println("Person Details :: "+per);
			//get child details
			DrivingLicense license = per.getLicense();
			System.out.println("License details :: "+license);
		});
		System.out.println();*/

		//fetching all child details
		List<DrivingLicense> list = service.fetchAllLicenseDetails();
		list.forEach(license->{
			System.out.println("License Details :: "+license);
			//get parent details
			Person per = license.getPersonDetails();
			System.out.println("Person details :: "+per);
		});
		System.out.println();
	}//run(-)

}//class
