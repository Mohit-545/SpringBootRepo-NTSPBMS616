//PatientController.java
package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Patient;
import com.nt.service.IPatientService;

@Controller("patientController")
public class PatientController {
	//injecting service class obj
	@Autowired
	private IPatientService patientService;
	
	public String getPatientFinalBill(Patient patient) throws Exception{
		//generate patient's final bill using service class obj
		String finalBill = patientService.registerPatient(patient);
		return finalBill;
	}//method

}//class
