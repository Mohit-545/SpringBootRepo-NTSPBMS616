//PatientInfo.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pInfo")
@Data
public class PatientInfo {
	@Value("10001")			//direct injection of values
	private Integer pid;
	@Value("${pi.name}")	//data injection by collection data from application.properties file
	private String pname;
	@Value("${pi.mobileNo}")
	private Long mobileNo;
	@Value("${pi.addrs}")
	private String pAddrs;
	@Value("#{dcc.xrayPrice + dcc.ctScanPrice + dcc.mriScanPrice}")		//SPEL based data injection
	private double billAmount;
	@Value("#{dcc.ecgPrice<0}")		//SPELL based logical expression
	private boolean ecgFree;
	@Value("${os.name}")		//Fixed System property names 
	private String osName;
	@Value("${Path}")			//Environment Variable Values
	private String pathData;

}//class
