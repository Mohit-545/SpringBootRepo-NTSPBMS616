//CustomerInfo.java
package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("custInfo")
@ConfigurationProperties(prefix = "cust.info")
@Data
public class CustomerInfo {
	
	private Integer custNo;
	private String custName;
	private String custAddrs;
	private Double billAmt;

}//class
