//DiagnosticCenterCatalog.java
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dcc")
@Data
public class DiagnosticCenterCatalog {
	@Value("${dc.xrayRate}")	// injecting values to spring bean properties by collecting them from application.properties file
	private double xrayPrice;
	@Value("${dc.ctScanRate}")
	private double ctScanPrice;
	@Value("${dc.mriScanRate}")
	private double mriScanPrice;
	@Value("${dc.ecgRate}")
	private double ecgPrice;

}//class
