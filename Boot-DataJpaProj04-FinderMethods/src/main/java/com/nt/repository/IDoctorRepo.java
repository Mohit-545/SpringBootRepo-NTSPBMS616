//IDoctorRepo.java
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer> {
	//finder methods for Select persistence operations with and without conditions
	public List<Doctor> findBydocNameEquals(String docName);
	public List<Doctor> findBydocNameIs(String name);
	public Iterable<Doctor> findBydocName(String dname);
	
	public Iterable<Doctor> findBydocNameStartingWith(String initChars);
	public Iterable<Doctor> findBydocNameEndingWith(String lastChars);
	
	public Iterable<Doctor> findBydocNameContaining(String chars);
	public Iterable<Doctor> findBydocNameContainingIgnoreCase(String chars);
	public Iterable<Doctor> findBydocNameEqualsIgnoreCase(String name);
	
	public Iterable<Doctor> findBydocNameLike(String chars);
	
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange, double endRange);
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specialization, double start, double end);
 

}//interface
