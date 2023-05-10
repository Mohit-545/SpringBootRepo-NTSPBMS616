//Employee.java
package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Employee {
	@Id
	@GeneratedValue
	private Integer empno;
	@Column(length = 25)
	private String ename;
	@Column(length = 25)
	private String job;
	@Column(length = 15)
	private String deptno;
	@Column
	private Double sal;

}//class
