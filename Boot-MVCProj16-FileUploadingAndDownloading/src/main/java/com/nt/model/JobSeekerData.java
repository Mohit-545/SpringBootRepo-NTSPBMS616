//JobSeekerData.java
package com.nt.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeekerData implements Serializable {
	
	private Integer jsdId;
	private String jsdName;
	private String jsdAddrs;
	private MultipartFile resume;
	private MultipartFile photo;

}//class
