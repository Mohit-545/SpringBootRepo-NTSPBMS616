//Student.java
package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private Integer sno;
	private String sname;
	private String address = "pune";
	private Float avg;

	public Student() {
		System.out.println("Student.Student():: 0-param constructor");
	}//constructor
	
}//class
