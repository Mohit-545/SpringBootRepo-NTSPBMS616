//Employee.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer empId;
	private String ename;
	private Double salary;
	private String vaccinated;

}//class
