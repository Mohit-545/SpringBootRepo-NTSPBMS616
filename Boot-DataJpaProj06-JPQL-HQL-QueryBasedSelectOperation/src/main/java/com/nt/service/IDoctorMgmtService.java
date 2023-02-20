//IDoctorMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	
	public List<Doctor> showDoctorsByIncomeRange(double startRange, double endRange);
	public List<Doctor> showDoctorsBySpecialization(String sp1, String sp2);
	public List<Object[]> showDoctorsDataByIncome(double start,double end);
	public List<String> showDoctorsNameByIncomeRange(double min, double max);
	
}//interface
