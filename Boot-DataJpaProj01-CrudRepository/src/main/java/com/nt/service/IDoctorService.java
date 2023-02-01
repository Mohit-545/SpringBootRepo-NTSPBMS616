//IDoctorService.java
package com.nt.service;


import com.nt.entity.Doctor;

public interface IDoctorService {
	
	// Pre-Defined methods of CRUD Repository
	public String registerDoctor(Doctor doctor);
	
	public String registerGroupOfDoctors(Iterable<Doctor> doctors);
	
	public long fetchCount();
	
	public boolean checkDoctoryAvailability(Integer id);
	
	public Iterable<Doctor> showAllDoctors();
	
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);
	
	public Doctor showDoctorById(Integer id);
	
	public String updateDoctorIncomeById(Integer id, float hikePercentage);
	
	public String registerOrUpdateDoctor(Doctor doctor);
	
	public String deleteDoctorById(Integer id);
	
	public String deleteDoctor(Doctor doctor);
	
}//interface
