//AssociationMappingRunnerTest.java
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOtoMAssociationServiceMgmt;
@Component
public class AssociationMappingRunnerTest implements CommandLineRunner {
	@Autowired
	private IOtoMAssociationServiceMgmt service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		// invoke the methods
		//service.saveDataUsingParent();
		//service.saveDataUsingChild();
		//service.loadDataUsingParent();
		//System.out.println(service.deleteByPersonId(3));
		//System.out.println(service.deleteAllPhoneNumbersOfAPerson(2));
		service.addNewChildToAPersonById(2);
		System.out.println();
		
		
		
	}//method

}//class
