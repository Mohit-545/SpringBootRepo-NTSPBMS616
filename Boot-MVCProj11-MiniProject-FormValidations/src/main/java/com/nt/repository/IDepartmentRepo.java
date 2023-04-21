//IDepartmentRepo.java
package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Department;

public interface IDepartmentRepo extends JpaRepository<Department, Integer> {
	
	@Query("select deptno from Department")
	public List<Integer> getAllDeptNo();

}//interface
