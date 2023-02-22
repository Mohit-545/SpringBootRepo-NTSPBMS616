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

@Transactional
public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {

	@Query(value = "INSERT INTO JPA_DOCTOR_INFO VALUES(DOCID_SEQ.NEXTVAL, :name, :income, :specialization)", nativeQuery = true)
	@Modifying
	public int registerDoctor(String name, String specialization, double income);
	
	@Query(value = "SELECT SYSDATE FROM DUAL", nativeQuery = true)
	public String showSystemDate();
	
	@Query(value = "CREATE TABLE TEMP (IdNo Number(5), Name Varchar2(10))",nativeQuery = true)
	@Modifying
	public int createTempTable();
	
}//interface
