//IDoctorMgmtService.java
package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	
	public String insertDoctor(String name, String specialization, double income);
	public String showSysDate();
	public String createTempDBTable();
}//interface
