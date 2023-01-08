//Company1.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("comp1")
@Data
public class Company1 {
	@Value("${org.info.name}")
	private String cName;
	@Value("${org.info.addrs}")
	private String cLocation;
	@Value("${org.info.size}")
//@Value("${tcs.size}")
	private Integer size;
	@Value("${org.info.cType}")
	private String companyType;
	@Value("${org.info.contactNo}")
	private Long mobileNo;

}//class
