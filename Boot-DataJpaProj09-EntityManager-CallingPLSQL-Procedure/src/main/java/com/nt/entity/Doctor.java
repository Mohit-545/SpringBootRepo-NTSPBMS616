//Doctor.java 
package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
@Table(name = "JPA_DOCTOR_INFO")
public class Doctor {
	@Id
	@Column(name = "DOC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer docId;
	
	@Column(name = "DOC_NAME", length = 25)
	private String docName;
	
	@Column(name = "SPECIALIZATION", length = 20)
	private String specialization;
	
	//@Transient   //used for making this particular column not participating in any persistance operation
	@Column(name = "INCOME")
	private Double income;

}//class
