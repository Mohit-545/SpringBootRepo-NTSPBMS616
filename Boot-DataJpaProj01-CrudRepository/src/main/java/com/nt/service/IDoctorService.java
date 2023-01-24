//IDoctorService.java
package com.nt.service;


import com.nt.entity.Doctor;

public interface IDoctorService {
	
	public String registerDoctor(Doctor doctor);
	
	public String registerGroupOfDoctors(Iterable<Doctor> doctors);
	
}//interface
