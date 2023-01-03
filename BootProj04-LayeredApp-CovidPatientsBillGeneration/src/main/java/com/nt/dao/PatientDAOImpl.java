//PatientDAOImpl.java
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Patient;
@Repository
public class PatientDAOImpl implements IPatientDAO {
	//jdbc query declaration
	private static final String Patient_Info_Query = "INSERT INTO COVID_PATIENT_INFO VALUES (PID_SEQ.NEXTVAL,?,?,?,?)";
	
	//injecting dataSource obj 
	@Autowired
	private DataSource ds;

	@Override
	public int insertPatientInfo(Patient patient) throws Exception {
		int count = 0;
		// jdbc code for registering patient's info
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(Patient_Info_Query)){
			//set values to query params
			if(ps!=null)
				ps.setString(1, patient.getPName());
				ps.setString(2, patient.getPAdd());
				ps.setDouble(3, patient.getBillAmt());
				ps.setDouble(4, patient.getFinalBillAmt());
				
				//execute the query
				count = ps.executeUpdate();
		}//try
		catch (SQLException se) {
			// Exception rethrowing
			throw se;
		}
		catch (Exception e) {
			// Exception re-throwing
			throw e;
		}
		return count;
	}//method

}//class
