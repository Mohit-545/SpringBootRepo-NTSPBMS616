//DoctorMgmtServiceImpl.java
package com.nt.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	@Autowired
	private EntityManager manager;

	@Override
	public List<Doctor> showDoctorsByIncomeRange(double start, double end) {
		// create StoredProcedureQuery object pointing to PL/SQL Procedure
				StoredProcedureQuery query = manager.createStoredProcedureQuery("p_get_doctors_by_income_range", Doctor.class);
				//Register both IN and OUT params by specifying their MODE
				query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
				query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
				//set values to IN params
				query.setParameter(1, start);
				query.setParameter(2, end);
				//call PL/SQL Procedure
				List<Doctor> list = query.getResultList();
				return list;
	}//method

}//class
