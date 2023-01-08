//BootProj08DataInjectionBulkDataInjectionApplication.java
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Company1;
import com.nt.sbeans.Company2;

@SpringBootApplication
public class BootProj08DataInjectionBulkDataInjectionApplication {

	public static void main(String[] args) {
		//get the IOC Container
	ApplicationContext ctx = SpringApplication.run(BootProj08DataInjectionBulkDataInjectionApplication.class, args);
	System.out.println();
	//get both Company Spring Bean class object
	Company1 c1 = ctx.getBean("comp1", Company1.class);
	System.out.println(c1);
	System.out.println("=======================================================================================");
	Company2 c2 = ctx.getBean("comp2",Company2.class);
	System.out.println(c2);
	}//main

}//class
