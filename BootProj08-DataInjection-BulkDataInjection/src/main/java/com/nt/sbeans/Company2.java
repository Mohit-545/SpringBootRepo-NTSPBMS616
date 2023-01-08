//Company2.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("comp2")
@ConfigurationProperties(prefix = "org.info")	// for bulk data injection
@Data
@PropertySource("com/nt/commons/Info.properties")
public class Company2 {
	
	private String name;
	private String addrs;
//	@Value("${tcs.size}")
	private Integer size;
	private String cType;
	private Long contactNo;

}//class
