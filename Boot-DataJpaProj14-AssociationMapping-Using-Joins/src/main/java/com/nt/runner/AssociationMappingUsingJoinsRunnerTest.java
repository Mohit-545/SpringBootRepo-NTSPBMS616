//AssociationMappingUsingJoinsRunnerTest.java
package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOtoMAssociationServiceMgmt;
@Component
public class AssociationMappingUsingJoinsRunnerTest implements CommandLineRunner {
	@Autowired
	private IOtoMAssociationServiceMgmt service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		// invoke the methods
		service.fetchDataByJoinsUsingParent().forEach(row->{
			for(Object val:row) {
				System.out.print(val+"        ");
			}//for
			System.out.println();
		});;
		System.out.println();
		
		
		
	}//method

}//class
