//Employee.java
package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private Integer eno;
	private String eName;
	private String eAdd;
	private Double basicSalary;
	private Double grossSalary;
	private Double netSalary;

}
