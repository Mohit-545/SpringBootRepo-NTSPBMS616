//ElectricEngine.java
package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEngg")
public class ElectricEngine implements Engine {
	
	public ElectricEngine() {
		System.out.println("ElectricEngine:: 0-param constructor");
	}

	@Override
	public void start() {
		System.out.println("ElectricEngine is started");

	}

	@Override
	public void stop() {
		System.out.println("ElectricEngine is stopped");

	}

}//class
