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

	@Override
	public List<Doctor> showDoctorsBySpecialization(String sp1, String sp2) {
		List<Doctor> list = docRepo.searchDoctorsBySpecialization(sp1, sp2);
		return list;
	}//method

	@Override
	public List<Object[]> showDoctorsDataByIncome(double start, double end) {
		List<Object[]> list = docRepo.searchDoctorsDataByIncomeRange(start, end);
		return list;
	}//method

	@Override
	public List<String> showDoctorsNameByIncomeRange(double min, double max) {
		List<String> list = docRepo.searchAllDoctorsNameByIncomeRange(min, max);
		return list;
	}//method

	@Override
	public Doctor showDoctorByName(String name) {
		Doctor doc = docRepo.searchDoctorsInfoByName(name).orElseThrow(()-> new IllegalArgumentException("Doctor not found"));
		return doc;
	}//method

	@Override 	
	public Object showDoctorDataByName(String name) {
		Object obj = docRepo.searchDoctorsDataByName(name);
		return obj;
	}//method

	@Override
	public String showDoctorSpecializationByDoctorName(String name) {
		String result = docRepo.searchDoctorSpecializationByName(name);
		return result;
	}//method

	@Override
	public int showDoctorsNameCount() {
		int count = docRepo.fetchDoctorByCount();
		return count;
	}//method

	@Override
	public Object showDoctorsAggregateData() {
		Object obj = docRepo.fetchAggregateDataOfDoctor();
		return obj;
	}//method


}//class
