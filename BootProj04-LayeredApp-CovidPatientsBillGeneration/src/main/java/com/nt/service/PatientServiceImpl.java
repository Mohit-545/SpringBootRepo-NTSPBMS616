//PatientServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IPatientDAO;
import com.nt.model.Patient;

@Service("patientService")
public class PatientServiceImpl implements IPatientService {
	//injecting DAO class obj
	@Autowired
	private IPatientDAO patienDAO;

	@Override
	public String registerPatient(Patient patient) throws Exception {
		// calculate final bill amount of the patient (b.method)
		double finalBill = patient.getBillAmt()+(patient.getBillAmt()*0.16f);
		//set final bill amount to patient obj
		patient.setFinalBillAmt(finalBill);
		//use DAO to get final count
		int count = patienDAO.insertPatientInfo(patient);
		//return the final result
		return count==0?"Patient's bill not Generated":"Patient's bill Generated with\n"
				+ "Gross bill = "+patient.getBillAmt()+"\nFinal Bill with GST = "+patient.getFinalBillAmt();
	}//method

}//class
