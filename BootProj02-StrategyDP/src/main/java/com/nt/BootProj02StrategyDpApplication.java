//BootProj02StrategyDpApplication.java (main class)
package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj02StrategyDpApplication {

	public static void main(String[] args) {
		//get the IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj02StrategyDpApplication.class, args);
		//get the target class spring bean obj ref
		Vehicle vehicle = ctx.getBean("veh", Vehicle.class);
		//invoke the b.method
		vehicle.move("Pune", "Goa"); 
		//close the container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main

}//class
