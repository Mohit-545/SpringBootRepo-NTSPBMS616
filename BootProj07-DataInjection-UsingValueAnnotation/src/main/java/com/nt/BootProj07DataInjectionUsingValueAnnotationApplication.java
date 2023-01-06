//BootProj07DataInjectionUsingValueAnnotationApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.PatientInfo;

@SpringBootApplication
public class BootProj07DataInjectionUsingValueAnnotationApplication {

	public static void main(String[] args) {
	//get the IOC Container
	ApplicationContext ctx = SpringApplication.run(BootProj07DataInjectionUsingValueAnnotationApplication.class, args);
	// get the PatientInfo Spring bean class object 
	PatientInfo pinfo = ctx.getBean("pInfo",PatientInfo.class);
	System.out.println(pinfo);
	//close the container
	((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
