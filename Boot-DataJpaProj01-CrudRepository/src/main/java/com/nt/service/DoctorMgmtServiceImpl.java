//DoctorMgmtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepo;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo docRepo;

	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("Doc id value before save(-) is invoked :: "+doctor.getDocId());
		Doctor doc = docRepo.save(doctor);
		return "Doctor id is saved with id value :: "+doc.getDocId();
	}

}//class
