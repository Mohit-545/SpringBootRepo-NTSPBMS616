//Employee.java
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "boot_emp")
public class Employee {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_id_seq15", allocationSize = 1,initialValue = 100)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job="CLERK";
	@Column
	private Float sal;
	@Column
	private String deptno;

}//class
