//BootProj05LayeredAppCustomerBillGenerationApplication.java
package com.nt;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.CustomerController;
import com.nt.model.Customer;

@SpringBootApplication
public class BootProj05LayeredAppCustomerShoppingBillGenerationApplication {

	public static void main(String[] args) {
		//create Customer class object
		Customer customer = new Customer();
		//Enter Customer info and set to Customer class object 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer Name :: ");
		customer.setCName(sc.nextLine());
		System.out.print("Enter Customer Address :: ");
		customer.setCAdd(sc.next());
		System.out.print("Enter Customer Mobile no :: ");
		customer.setMobileNo(sc.nextDouble());
		System.out.print("Enter Customer Basic Bill :: ");
		customer.setBillAmt(sc.nextDouble());
		
		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj05LayeredAppCustomerShoppingBillGenerationApplication.class, args);
		//get the controller class object
		CustomerController custController = ctx.getBean("customerController",CustomerController.class);
		//invoke the b.method
		try {
			String resultMesg = custController.getCustomerFinalBill(customer);
			//display the result
			System.out.println(resultMesg);
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Internal Problem--Please try again!!!!!       "+se.getMessage());
		}//catch
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--Please try again!!!!!!     "+e.getMessage());
		}//catch

	}//main

}//class
