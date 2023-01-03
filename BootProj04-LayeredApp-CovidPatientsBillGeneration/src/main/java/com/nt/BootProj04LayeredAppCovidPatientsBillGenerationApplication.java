//BootProj04LayeredAppCovidPatientsBillGenerationApplication.java
package com.nt;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.PatientController;
import com.nt.model.Patient;

@SpringBootApplication
public class BootProj04LayeredAppCovidPatientsBillGenerationApplication {

	public static void main(String[] args) {
		//create patient class object
		Patient patient = new Patient();
		//Enter patient info and set to patient class object 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Patient Name :: ");
		patient.setPName(sc.nextLine());
		System.out.print("Enter Patient Address :: ");
		patient.setPAdd(sc.next());
		System.out.print("Enter Patient Basic Bill :: ");
		patient.setBillAmt(sc.nextDouble());
		
		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj04LayeredAppCovidPatientsBillGenerationApplication.class, args);
		//get the controller class object
		PatientController pController = ctx.getBean("patientController",PatientController.class);
		//invoke the b.method
		try {
			String resultMesg = pController.getPatientFinalBill(patient);
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
