//BootDataJpaProj04JpaRepositoryFinderMethodApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootDataJpaProj04JpaRepositoryFinderMethodApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj04JpaRepositoryFinderMethodApplication.class, args);
		
		
	}//main

}//class
