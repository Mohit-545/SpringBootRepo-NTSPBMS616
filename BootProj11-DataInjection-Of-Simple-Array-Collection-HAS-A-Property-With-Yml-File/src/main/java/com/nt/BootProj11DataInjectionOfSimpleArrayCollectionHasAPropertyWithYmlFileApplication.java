//BootProj11DataInjectionOfSimpleArrayCollectionHasAPropertyWithYmlFileApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj11DataInjectionOfSimpleArrayCollectionHasAPropertyWithYmlFileApplication {

	public static void main(String[] args) {
		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj11DataInjectionOfSimpleArrayCollectionHasAPropertyWithYmlFileApplication.class, args);
		// get the Employee spring bean class object
		System.out.println();
		Employee emp = ctx.getBean("emp",Employee.class);
		System.out.println(emp);
		//close the Container
		((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
