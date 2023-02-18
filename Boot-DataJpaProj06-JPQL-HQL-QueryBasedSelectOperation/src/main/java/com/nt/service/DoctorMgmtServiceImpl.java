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
	public List<Doctor> showDoctorsByIncomeRange(double startRange, double endRange) {

		return docRepo.searchDoctorsByIncomeRange(startRange, endRange);
	}//method


}//class
