//BootProj10DataInjectionWithYmlFileApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.CustomerInfo;

@SpringBootApplication
public class BootProj10DataInjectionWithYmlFileApplication {

	public static void main(String[] args) {
		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj10DataInjectionWithYmlFileApplication.class, args);
		//get the Customer Spring Bean class object 
		CustomerInfo cinfo = ctx.getBean("custInfo", CustomerInfo.class);
		System.out.println(cinfo);
		//close the Container
		((ConfigurableApplicationContext) ctx).close();
	}//main

}//class
