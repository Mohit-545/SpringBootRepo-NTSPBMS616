//IDoctorRepo.java
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	
//@Query("FROM Doctor WHERE income>=?1 AND income<=?2")
//@Query("FROM com.nt.entity.Doctor WHERE income>=?1 AND income<=?2")
//@Query("FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
//@Query("Select doc FROM Doctor doc WHERE doc.income>=?1 AND doc.income<=?2")
	/*@Query("FROM Doctor doc WHERE doc.income>=:start AND doc.income<=:end")
	public List<Doctor> searchDoctorsByIncomeRange(@Param("start") double startRange, @Param("end") double endRange);*/

	@Query("FROM Doctor doc WHERE doc.income>=:start AND doc.income<=:end")
		public List<Doctor> searchDoctorsByIncomeRange(double start, double end);
	
	//---------------------------------Select Entity Query -------------------------------------
	@Query("FROM Doctor WHERE specialization IN(:sp1,:sp2) ORDER BY specialization")
	public List<Doctor> searchDoctorsBySpecialization(String sp1, String sp2);
	
	//--------------------------------Select Projection/Scalar Query for specific multiple col values
	@Query("SELECT docId, docName, income FROM Doctor WHERE income BETWEEN :start AND :end")
	public List<Object[]> searchDoctorsDataByIncomeRange(double start, double end);

	//--------------------------------Select Projection/Scalar Query for specific single col values
	@Query("SELECT docName FROM Doctor WHERE income BETWEEN :min AND :max")
	public List<String> searchAllDoctorsNameByIncomeRange(double min, double max);

	
}//interface
