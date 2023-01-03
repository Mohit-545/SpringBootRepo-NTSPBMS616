//BootProj03LayeredAppApplication.java
package com.nt;

import java.io.Closeable;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03LayeredAppApplication {

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

		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj03LayeredAppApplication.class, args);
		
		//get the Controller class obj
		PayrollOperationsController proll = ctx.getBean("payrollController", PayrollOperationsController.class);
		
		//invoke the b.method
		try {
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
