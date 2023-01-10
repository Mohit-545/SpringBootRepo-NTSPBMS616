//Employee.java
package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@ConfigurationProperties(prefix = "emp.info")
@Data
public class Employee {
	
	//simple type properties
	private Integer eNo;
	private String eName;
	 
	//Array type properties
	private String[] favColors;
	
	//List type properties
	private List<String> nickNames;
	
	//Set type properties
	private Set<Long> phoneNos;
	
	//Map type properties
	private Map<String, Object> idDetails;
	
	//HAS-A type property
	private Company company;

}//class
