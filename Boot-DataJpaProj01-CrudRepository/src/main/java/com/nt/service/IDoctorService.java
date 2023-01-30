//IDoctorService.java
package com.nt.service;


import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public String registerDoctor(Doctor doctor);
	
	public String registerGroupOfDoctors(Iterable<Doctor> doctors);
	
	public long fetchCount();
	
	public boolean checkDoctoryAvailability(Integer id);
	
	public Iterable<Doctor> showAllDoctors();
	
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);
	
}//interface
