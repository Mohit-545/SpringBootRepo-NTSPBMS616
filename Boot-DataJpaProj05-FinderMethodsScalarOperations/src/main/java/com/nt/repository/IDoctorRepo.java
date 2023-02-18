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

	
}//interface
