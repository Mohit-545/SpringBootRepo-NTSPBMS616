//DoctorMgmtServiceImpl.java
package com.nt.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

	@Override
	public long fetchCount() {
		
		return docRepo.count();
	}

	@Override
	public boolean checkDoctoryAvailability(Integer id) {
		
		return docRepo.existsById(id);
	}

	@Override
	public Iterable<Doctor> showAllDoctors() {
		
		return docRepo.findAll();
	}

	@Override
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) {
		
		return docRepo.findAllById(ids);
	}

	/*@Override	// 1st logic for showDoctorById(-)
	public Doctor showDoctorById(Integer id) {
		Optional<Doctor> opt = docRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else 
			new IllegalArgumentException("Invalid Doctor id entered...!!!!!!");
	}*/

	
	/*@Override	// 2nd logic for showDoctorById(-)   (Best Logic)
	public Doctor showDoctorById(Integer id) {
		Doctor doctor = docRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Doctor id...!!!!"));
		return doctor;
	}*/

	
	@Override	// 3rd logic for showDoctorById(-)   
	public Doctor showDoctorById(Integer id) {
		Doctor dutyDoctor = new Doctor();
		dutyDoctor.setSpecialization("General Physician");
		Doctor doc = docRepo.findById(id).orElse(dutyDoctor);
		return doc;
	}

	@Override
	public String updateDoctorIncomeById(Integer id, float hikePercentage) {
		//load the doctor
		Optional<Doctor> opt = docRepo.findById(id);
		if(opt.isPresent()) {
			Doctor doc = opt.get();
			//hike the income with given percentage
			double newIncome = doc.getIncome()+(doc.getIncome()*(hikePercentage/100.0f));
			//set newIncome to the doc object
			doc.setIncome(newIncome);
			//partially save the entity object
			return docRepo.save(doc).getDocId()+" is updated with new income = "+newIncome;
		}//if
		else {
			return "Doctor not found with given id = "+id;
		}//else
	}

	@Override
	public String registerOrUpdateDoctor(Doctor doctor) {
		//load the entity object
		Optional<Doctor> opt = docRepo.findById(doctor.getDocId());
		if(opt.isPresent()) {
			docRepo.save(doctor);	//for only updating existing doctor
			return doctor.getDocId()+" Doctor is found and updated";
		}//if
		else {
			return "Doctor is registered with Id :: "+docRepo.save(doctor).getDocId();
		}//else
	}

	@Override
	public String deleteDoctorById(Integer id) {
		//load the obj
		Optional<Doctor> opt = docRepo.findById(id);
		if(opt.isPresent()) {
			docRepo.deleteById(id);
			return "Doctor with "+id+" is deleted";
		}//if
		else{
			return "Doctor with given "+id+" not found....!!!!";
		}//else
	}

	@Override
	public String deleteDoctor(Doctor doctor) {
		Optional<Doctor> opt = docRepo.findById(doctor.getDocId());
		if(opt.isEmpty()) {
			return "Doctor with given doctor id "+doctor.getDocId()+" not found";
		}//if
		else {
			 docRepo.delete(opt.get());
			 return "Doctor with id "+doctor.getDocId()+" is found and deleted";
		}//else
	}

}//class
