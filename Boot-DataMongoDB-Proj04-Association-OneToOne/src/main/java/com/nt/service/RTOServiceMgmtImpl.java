//RTOServiceMgmtImpl.java
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.repository.IDrivingLicenseRepository;
import com.nt.repository.IPersonRepository;

@Service("rtoService")
public class RTOServiceMgmtImpl implements IRTOServiceMgmt {
	@Autowired
	private IPersonRepository perRepo;
	@Autowired
	private IDrivingLicenseRepository dlRepo;

	@Override
	public String registerPersonWithDrivingLicense(Person person) {
		return "Person with driving license is registered with id value :: "+perRepo.save(person).getPid();
	}//method

	@Override
	public String registerDrivingLicenseWithPerson(DrivingLicense license) {
		return "Driving License with Person details is registered with id value :: "+dlRepo.save(license).getLicenseNo();
	}//method

	@Override
	public List<Person> fetchAllPersonDetails() {
		return perRepo.findAll();
	}//method

	@Override
	public List<DrivingLicense> fetchAllLicenseDetails() {
		return dlRepo.findAll();
	}//method

}//classs
