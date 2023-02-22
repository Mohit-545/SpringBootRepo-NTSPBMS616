//IDoctorRepo.java
package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
	
	
	//---------------------------------Entity Query giving Single record-----------------------------------
	@Query("FROM Doctor WHERE docName=:name")
	public Optional<Doctor> searchDoctorsInfoByName(String name);

	//---------------------------------Scalar Query giving Single record with specific multiple col values-----------------------------------
	@Query("SELECT docId,docName FROM Doctor WHERE docName=:name")
	public Object searchDoctorsDataByName(String name);
	
	//---------------------------------Scalar Query giving Single record with specific single col values-----------------------------------
	@Query("SELECT specialization FROM Doctor WHERE docName=:name")
	public String searchDoctorSpecializationByName(String name);
	
	//-----------------------------Using Aggregate Functions with HQL/JPQL Queries------------------------------------------
	@Query("SELECT COUNT(DISTINCT docName) FROM Doctor")
	public int fetchDoctorByCount();
	@Query("SELECT COUNT(*),MAX(income),MIN(income),AVG(income),SUM(income) FROM Doctor")
	public Object fetchAggregateDataOfDoctor();
	
	//------------------------Non-Select Operations using HQL/JPQL Queries---------------------------
	@Query("UPDATE Doctor SET income = income+(income * :percentage/100) WHERE specialization = :sp")
	@Modifying
	@Transactional
	public int hikeDoctorsIncomeBySpecialization(String sp, double percentage);
	
	
	@Query("DELETE FROM Doctor WHERE income>=:start AND income<=:end")
	@Modifying
	@Transactional
	public int removeDoctorsByIncomeRange(double start, double end);
	
}//interface
