//DoctorMgmtServiceImpl.java
package com.nt.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepo docRepo;

	@Override
	public String insertDoctor(String name, String specialization, double income) {
		int count = docRepo.registerDoctor(name, specialization, income);
		return count==0?"Doctor Data Not Inserted":"Doctor Data Successfully Inserted";
	}//method

	@Override
	public String showSysDate() {
		return docRepo.showSystemDate();
	}//method

	@Override
	public String createTempDBTable() {
		int count = docRepo.createTempTable();
		return count==0?"Temp Table Successfully created":"Temp Table not created";
	}//method

	

}//class
