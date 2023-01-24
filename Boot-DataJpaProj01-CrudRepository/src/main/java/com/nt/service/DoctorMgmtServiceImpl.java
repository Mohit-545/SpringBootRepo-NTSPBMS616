//DoctorMgmtServiceImpl.java
package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
	}//method

	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
		if(doctors!=null) {
			Iterable<Doctor> savedDoctors = docRepo.saveAll(doctors);		//saveAll(-) called for batch saving of objects
			int size = ((Collection)savedDoctors).size();		// for getting size of batch
			// using java 8 stream api and lambda exp to get the generated ids of the saved objects
			List<Integer> ids =(List<Integer>) ((Collection)savedDoctors).stream().map(d->((Doctor)d).getDocId()).collect(Collectors.toList());
			return size+" No .of Doctors are saved with Id Values :: "+ids.toString();
		}//if
		else {
			throw new IllegalArgumentException("Invalid Doctor Info......!!!!!");
		}//else
		
	}//method

}//class
