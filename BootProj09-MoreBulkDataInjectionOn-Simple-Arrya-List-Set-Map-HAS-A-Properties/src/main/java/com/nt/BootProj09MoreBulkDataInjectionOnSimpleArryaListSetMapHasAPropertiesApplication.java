//BootProj09MoreBulkDataInjectionOnSimpleArryaListSetMapHasAPropertiesApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj09MoreBulkDataInjectionOnSimpleArryaListSetMapHasAPropertiesApplication {

	public static void main(String[] args) {
	//get the IOC Container
	ApplicationContext ctx = SpringApplication.run(BootProj09MoreBulkDataInjectionOnSimpleArryaListSetMapHasAPropertiesApplication.class, args);
	// get the Employee class spring bean object
	Employee emp = ctx.getBean("emp",Employee.class);
	System.out.println(emp);
	//close the Container
	((ConfigurableApplicationContext) ctx).close();
	
	}//main

}//class
