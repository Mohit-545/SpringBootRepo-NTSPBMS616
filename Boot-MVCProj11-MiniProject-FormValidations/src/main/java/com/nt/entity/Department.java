//Department.java
package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BOOT_DEPT")
public class Department {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;

}//class
