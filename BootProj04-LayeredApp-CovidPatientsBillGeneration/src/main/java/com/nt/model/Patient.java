//Patient.java
package com.nt.model;

import lombok.Data;

@Data
public class Patient {
	private Integer pId;
	private String pName;
	private String pAdd;
	private Double billAmt;
	private Double finalBillAmt;

}//class
