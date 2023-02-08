//IDoctorMgmtService.java
package com.nt.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	
	// Pre-Defined methods of Paging and Sorting Repository
	
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String ...props);
	
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String ...props);
	
	
}//interface
