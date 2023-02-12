//JpaRepoTestRunner.java
package com.nt.runners;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepo;


@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.findBydocNameEquals("Modi").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameIs("Paresh Shah").forEach(System.out::println);
		System.out.println();
		repo.findBydocName("Amit Shah").forEach(System.out::println);
		System.out.println();
		
		repo.findBydocNameStartingWith("A").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameEndingWith("h").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameContaining("Ch").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameContainingIgnoreCase("ra").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameEqualsIgnoreCase("modi").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameLike("A%").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameLike("%i").forEach(System.out::println);
		System.out.println();
		repo.findBydocNameLike("%ar%").forEach(System.out::println);
		System.out.println();
		repo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(5000.0, 300000.0).forEach(System.out::println);
		System.out.println();
		repo.findBySpecializationInOrIncomeBetween(List.of("Ortho", "Cardio"), 150000.0, 15000000.0).forEach(System.out::println);
	}//run()

}//class
