//Vehicle.java (target class)
package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("veh")
public class Vehicle {
	@Autowired
	@Qualifier("engineType")
	//HAS-A property
	private Engine engine;

	public Vehicle() {
		System.out.println("Vehicle:: 0-param constructor");
	}
	
	public void move(String sourcePlace, String destPlace) {
		engine.start();
		System.out.println("Journey started from - "+sourcePlace);
		System.out.println("Journey is going on ...........");
		engine.stop();
		System.out.println("Journey stopped at - "+destPlace);
	}

}//class
