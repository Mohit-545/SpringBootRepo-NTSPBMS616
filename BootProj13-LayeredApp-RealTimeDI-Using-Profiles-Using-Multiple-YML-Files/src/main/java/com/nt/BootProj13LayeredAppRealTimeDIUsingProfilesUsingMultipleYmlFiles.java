//BootProj06LayeredAppRealTimeDIForMultipleDBApplication.java
package com.nt;

import java.io.Closeable;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj13LayeredAppRealTimeDIUsingProfilesUsingMultipleYmlFiles {

	@Autowired
	private Environment env;
	
	@Bean("c3p0DS")
	@Profile("test")
	public ComboPooledDataSource createC3P0DS() throws Exception{
		ComboPooledDataSource cdps = new ComboPooledDataSource();
		System.out.println("BootProj06LayeredAppRealTimeDIForMultipleDBApplication.createC3P0DS()");
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		cpds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		cpds.setUser(env.getRequiredProperty("spring.datasource.username")); 
		cpds.setPassword(env.getRequiredProperty("spring.datasource.password"));
		cpds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.minSize")));
		cpds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.maxSize")));
		return cpds;
	}
	
	
	public static void main(String[] args) {
		//get employee data from client
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Employee Name : ");
		String eName = scn.nextLine();
		System.out.print("Enter Employee Address : ");
		String eAddress = scn.next();
		System.out.print("Enter Employee Salary : ");
		double basicSalary = scn.nextDouble();
		
		//create Employee class object and set values gathered from client
		Employee emp = new Employee();
		
		//set the values
		emp.setEName(eName); emp.setEAdd(eAddress); emp.setBasicSalary(basicSalary);
		System.out.println();

		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj13LayeredAppRealTimeDIUsingProfilesUsingMultipleYmlFiles.class, args);
		
		//get the Controller class obj
		PayrollOperationsController proll = ctx.getBean("payrollController", PayrollOperationsController.class);
		
		//invoke the b.method
		try {
			System.out.println();
			String resMesg = proll.processEmployee(emp);
			System.out.println(resMesg);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Error --- Please try again!!!!!    "+e.getMessage());
		}
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class
