//JobSeekerInfo.java
package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "JOB_SEEKER_INFO")
public class JobSeekerInfo implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer jsId;
	@Column(length = 20)
	private String jsName;
	@Column(length = 20)
	private String jsAddrs;
	@Column(length = 150)
	private String resumePath;
	@Column(length = 150)
	private String photoPath;

}//class
